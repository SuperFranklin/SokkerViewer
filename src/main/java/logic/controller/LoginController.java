
package main.java.logic.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import main.java.logic.dao.PlayerDao;
import main.java.logic.entity.Player;
import main.java.logic.service.LoginService;



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

        
        model.addAttribute( "login", login );
        return "loginSuccess";
    }
}
