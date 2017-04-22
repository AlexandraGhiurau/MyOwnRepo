package com.alexa.Controller;

import com.alexa.Entity.Client;
import com.alexa.Entity.User;
import com.alexa.Service.ClientService;
import com.alexa.Service.UserService;
import com.alexa.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private UserValidator userValidator;

    @Autowired
    private ClientService clientService;
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
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        //userController.insertStudent(userForm);
        userService.saveUser(userForm);

        //securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "client/list";
    }

    /*@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }*/

    @RequestMapping(value = "client/list", method = RequestMethod.GET)
    public ModelAndView clientsListPage(){
        ModelAndView mav = new ModelAndView("clients-list");
        List<Client> clientsList = clientService.findAll();
        mav.addObject("clientsList", clientsList);
        return mav;
    }

    @RequestMapping(value="client/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editClient(@ModelAttribute @Valid Client client,
                                 BindingResult result,
                                 @PathVariable Integer pKey,
                                 final RedirectAttributes redirectAttributes){

        if (result.hasErrors())
            return new ModelAndView("clients-edit");

        ModelAndView mav = new ModelAndView("redirect:/index.html");
        String message = "Client was successfully updated.";

        clientService.saveClient(client);

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }

    @RequestMapping(value="client/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteClient(@PathVariable Integer id,
                                   final RedirectAttributes redirectAttributes){

        ModelAndView mav = new ModelAndView("redirect:/index.html");

       /* Client client = */clientService.delete(id);

       /* Shop shop = shopService.delete(id);*/
        String message = "The shop was successfully deleted.";

        redirectAttributes.addFlashAttribute("message", message);
        return mav;
    }




}
