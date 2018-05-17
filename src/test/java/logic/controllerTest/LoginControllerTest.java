
package test.java.logic.controllerTest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import main.java.logic.controller.LoginController;

public class LoginControllerTest{

    @Test
    public void testShowRegistrationForm() throws Exception{
        LoginController controller = new LoginController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup( controller ).build();
        mockMvc.perform( get( "/" ) ).andExpect( view().name( "loginForm" ) );
    }
}
