
package sokker.core.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sokker.core.dao.PlayerDao;
import sokker.core.entity.Player;

@Controller
public class LoginController{

    //@Autowired
    PlayerDao playerDao;
    @GetMapping("/")
    public String showRegistrationForm(){
        return "loginForm";
    }

    @PostMapping("/")
    public String loginProcess( HttpServletRequest request, Model model ){
        String login = request.getParameter( "login" );
        Player p = new Player();
        p.setCountry( "sda" );
        p.setHeight( 123 );
        p.setName( "sada" );
        p.setPID( 21 );
        p.setWeight( 12 );
        p.setSurename( "szczuru" );
        playerDao.addPlayer( p );
        model.addAttribute( "login", login );
        return "loginSuccess";
    }
}
