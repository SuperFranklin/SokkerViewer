
package main.java.logic.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import main.java.logic.entity.Player;
import main.java.logic.service.LoginService;
import main.java.logic.service.PlayersParserService;



@Controller
public class LoginController{

    @Autowired
    LoginService loginService;
    
    @Autowired 
    PlayersParserService playersParser;
    
    @GetMapping("/")
    public String showRegistrationForm(){
        return "loginForm";
    }

    @PostMapping("/")
    public String loginProcess( HttpServletRequest request, Model model ){
        String login = request.getParameter( "login" );
        String password = request.getParameter( "password" );
        
        try{
            HtmlPage page = loginService.loginAndUpdateDB( login, password);
            List<Player> players = playersParser.downloadPlayers( page.asXml() );
            
        }catch (Exception e){
            e.printStackTrace();
        }
       
        return "loginSuccess";
    }
}
