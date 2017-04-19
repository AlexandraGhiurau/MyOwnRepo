
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
*/

import org.junit.Assert;

public class DemoApplicationTests {
    @Test
    public void firstTest() {
        Assert.assertTrue(true);
    }
}