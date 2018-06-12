
package main.java.logic.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import main.java.logic.service.LoginService;
import main.java.logic.utils.Result;



@Controller
public class LoginController{

    @Autowired
    LoginService loginService;
    
    @GetMapping("/")
    public String showRegistrationForm(){
        return "loginForm";
    }

    @PostMapping("/")
    public String loginProcess( HttpServletRequest request, Model model ){
        String login = request.getParameter( "login" );
        String password = request.getParameter( "password" );
        
        try{
            loginService.loginAndInitData( login, password);
        }catch (Exception e){
            e.printStackTrace();
        }
       
        return "loginSuccess";
    }
}
