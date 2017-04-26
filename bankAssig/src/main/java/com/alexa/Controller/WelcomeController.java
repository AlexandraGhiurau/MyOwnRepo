package com.alexa.Controller;

import com.alexa.Entity.Account;
import com.alexa.Entity.Client;
import com.alexa.Entity.User;
import com.alexa.Entity.UserRole;
import com.alexa.Service.AccountService;
import com.alexa.Service.ClientService;
import com.alexa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {


    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    /*@Autowired
    private UserController userController;*/

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User(UserRole.EMPLOYEE));
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, Model model, String error1, String error2, String error3) {

        List<User> thisUser = userService.findByUsername(userForm.getUsername());

        if(userForm.getUsername().length() < 6 || userForm.getUsername().length() > 32){
            model.addAttribute("error1", "Username size is invalid.");
            return "registration";
        }
        if(thisUser.size() > 0){
            model.addAttribute("error1", "Username already exists.");
            return "registration";
        }
        if(userForm.getPassword().length() < 8 || userForm.getPassword().length() > 32) {
            model.addAttribute("error2", "Password size is invalid.");
            return "registration";
        }
        if(!userForm.getPasswordConfirm().equals(userForm.getPassword())){
            model.addAttribute("error3", "Wrong password.");
            return "registration";
        }

        userForm.setRole(UserRole.EMPLOYEE);
        userService.saveUser(userForm);

        return "redirect:client/list";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("userForm") User userForm, Model model, String error, String logout) {

        List<User> thisUser = userService.findByUsername(userForm.getUsername());
        System.out.println(thisUser.size());
        if(thisUser.size() == 1) {
            User checkUser = thisUser.get(0);
            if (checkUser.getPassword().equals(userForm.getPassword())) {
                return "redirect:client/list";
            } else {
                model.addAttribute("error", "Your password is invalid.");
            }
        } else {
            model.addAttribute("error", "Your username is invalid andreea.");
        }
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "client/list", method = RequestMethod.GET)
    public ModelAndView clientsListPage(){
        ModelAndView mav = new ModelAndView("clients-list");
        List<Client> clientsList = clientService.findAll();
        mav.addObject("clientsList", clientsList);
        return mav;
    }

    @RequestMapping(value="client/edit/{pKey}", method = RequestMethod.GET)
    public ModelAndView editClientPage(@PathVariable Integer pKey){

        ModelAndView mav = new ModelAndView("clients-edit");
        Client client = clientService.findOne(pKey);

        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping(value="clients/edit/{pKey}", method=RequestMethod.POST)
    public ModelAndView editClient(@ModelAttribute @Valid Client client, BindingResult result,
                                   @PathVariable Integer pKey, final RedirectAttributes redirectAttributes){

        System.out.println("edit client, post method");

        if (result.hasErrors()) {
            return new ModelAndView("clients-edit");
            //return "clients/clientForm";
        }

        Client thisClient = clientService.findOne(pKey);
        System.out.println("this client "+  thisClient.getPersonalNumCode() + " param client " + client.getPersonalNumCode());
        System.out.println("this client name "+  thisClient.getName() + " param client name" + client.getName());
        if((client.getPersonalNumCode() != thisClient.getPersonalNumCode())){

            String message = "You cannot change the personal Numerical Code.";
            redirectAttributes.addFlashAttribute("message", message);
        } else {

            clientService.saveClient(client);

            String message = "Client was successfully updated.";
            redirectAttributes.addFlashAttribute("message", message);

        }
            ModelAndView mav = new ModelAndView("redirect:/client/list");
            return mav; //"redirect:/clients/edit/{pKey}";
    }

    @RequestMapping(value="client/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteClient(@PathVariable Integer id,
                                   final RedirectAttributes redirectAttributes){

        ModelAndView mav = new ModelAndView("redirect:/client/list");

        clientService.delete(id);

        String message = "The client was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="client/create", method=RequestMethod.GET)
    public ModelAndView newClientPage() {
        ModelAndView mav = new ModelAndView("clients-new", "client", new Client());
        return mav;
    }

    @RequestMapping(value="client/create", method=RequestMethod.POST)
    public ModelAndView createNewClient(@ModelAttribute @Valid Client client,
                                      BindingResult result,
                                      final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("clients-new");

        ModelAndView mav = new ModelAndView();
        String message = "New client "+client.getName()+" was successfully created.";

        clientService.saveClient(client);

       // account.setAccountId(client.getpKey());
       // accountService.saveAccount(account);
        //mav.setViewName("redirect:/account/create.html");
        mav.setViewName("redirect:/client/list.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="account/create/{pKey}", method=RequestMethod.GET)
    public ModelAndView newAccountPage( @PathVariable Integer pKey) {
        ModelAndView mav = new ModelAndView("accounts-new", "account", new Account());
        Client client = clientService.findOne(pKey);
        mav.addObject("client", client);
        return mav;

    }

    @RequestMapping(value="account/create/{pKey}", method=RequestMethod.POST)
    public ModelAndView createNewAccount(@ModelAttribute @Valid Account account,
                                         @PathVariable Integer pKey,
                                        BindingResult result,
                                        final RedirectAttributes redirectAttributes) {

        if (result.hasErrors())
            return new ModelAndView("accounts-new");

        ModelAndView mav = new ModelAndView();
        String message = "New account "+account.getType()+" was successfully created.";

        //account.setAccountId(client.getpKey());

        accountService.saveAccount(account);
        Client client = clientService.findOne(pKey);
        client.getAccounts().add(account);

        clientService.saveClient(client);

        mav.setViewName("redirect:/client/list.html");

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value = "account/list/{pKey}", method = RequestMethod.GET)
    public ModelAndView accountsListPage(@PathVariable ("pKey") Integer pKey){
        ModelAndView mav = new ModelAndView("accounts-list");

        Client client = clientService.findOne(pKey);
        List<Account> accountsList = client.getAccounts();

        for (Account a:accountsList) {
            System.out.println("account type: " + a.getType());
        }

        mav.addObject("accountsList", accountsList);
        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping(value="account/edit/{accountId}", method = RequestMethod.GET)
    public ModelAndView editAccountPage(@PathVariable Integer accountId){

        ModelAndView mav = new ModelAndView("accounts-edit");
        Account account = accountService.findOne(accountId);

        mav.addObject("account", account);
        return mav;
    }

    @RequestMapping(value="account/edit/{accountId}", method=RequestMethod.POST)
    public ModelAndView editAccount(@ModelAttribute @Valid Account account,
                                   BindingResult result, @PathVariable Integer accountId,
                                   final RedirectAttributes redirectAttributes){

        System.out.println("edit account, post method");

        if (result.hasErrors()) {
            return new ModelAndView("accounts-edit");
        }

        Account thisAccount = accountService.findOne(accountId);
        accountService.saveAccount(account);

        String message = "Account was successfully updated.";
        redirectAttributes.addFlashAttribute("message", message);

        List<Client> allClients = clientService.findAll();
        int key = -1;
        for (Client c: allClients) {
            for (Account a: c.getAccounts()) {
                if((a.getAccountId() == thisAccount.getAccountId()) && key ==-1) {
                    key = c.getpKey();
                }

            }
        }

        ModelAndView mav = new ModelAndView("redirect:/account/list/" + key);
        return mav;
    }

    @RequestMapping(value="account/delete/{accountId}", method=RequestMethod.GET)
    public ModelAndView deleteAccount(@PathVariable Integer accountId,
                                     final RedirectAttributes redirectAttributes){

        Account thisAccount = accountService.findOne(accountId);

        List<Client> allClients = clientService.findAll();
        int key = -1;
        for (Client c: allClients) {
            for (Account a: c.getAccounts()) {
                if((a.getAccountId() == thisAccount.getAccountId()) && key ==-1) {
                    key = c.getpKey();
                }

            }
        }
        ModelAndView mav = new ModelAndView("redirect:/account/list/" + key);

        accountService.delete(accountId);

        String message = "The account was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="account/transfer/{accountId}", method = RequestMethod.GET)
    public ModelAndView transferAccountPage(@PathVariable Integer accountId){

        ModelAndView mav = new ModelAndView("accounts-transfer");
        Account account = accountService.findOne(accountId);

        List<Client> clients = clientService.findAll();
        //Account thisAccount = accountService.findOne(accountId);

       /* Client myClient = null;
        int key = -1;
        int index = 0;
        int myIndex = 0;
        System.out.println("sizeI:" + allClients2.size());

        for (Client c: allClients2) {

            System.out.println("clients: " + c.getName());
        }
        for (Client c: allClients2) {
            index++;
            for (Account a: c.getAccounts()) {
                if(myClient == null && (a.getAccountId() == thisAccount.getAccountId()) && key ==-1) {
                    myClient = c;
                    key = c.getpKey();
                }
            }
        }

        System.out.println("index: " + key);
        System.out.println("myIndex: " + myIndex);
        System.out.println("sizeF:" + allClients2.size());*/
        System.out.println(clients.size());
        mav.addObject("clients", clients);
        mav.addObject("account", account);

        return mav;
    }

    @RequestMapping(value="account/transfer/{accountId}", method=RequestMethod.POST)
    public ModelAndView transferAccount(@ModelAttribute @Valid Account account, @RequestParam int[] id, @RequestParam double money, @PathVariable Integer accountId, Model model, final RedirectAttributes redirectAttributes){

        /*if (result.hasErrors()) {
            return new ModelAndView("accounts-transfer");
        }
        */
        Account thisAccount = accountService.findOne(accountId);


        int chooseId = -1;
        boolean found = false;
        for(int i = 0; i < id.length; i++){
            if(id[i] != 0 && !found){
                chooseId = id[i];
                found = true;
            }
        }
        if(chooseId != -1){
            double moneySource =  thisAccount.getMoney();
            if(moneySource - money >= 0){
                thisAccount.setMoney(moneySource - money);
                Account destAccount = accountService.findOne(chooseId);
                destAccount.setMoney(destAccount.getMoney() + moneySource);

                accountService.saveAccount(thisAccount);
                accountService.saveAccount(destAccount);
            }
        }

        ModelAndView mav = new ModelAndView("redirect:/client/list");

        return mav;
    }
}
