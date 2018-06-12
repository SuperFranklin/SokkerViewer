package test.java.logic.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import main.java.logic.service.LoginService;
import test.java.configuration.TestConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= { TestConfiguration.class })
public class LoginServiceTest{

    @Autowired
    LoginService loginService;
    
    @Test
    public void testLogin() {
        //TODO make implementation
    }
}
