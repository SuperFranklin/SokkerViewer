package main.java.logic.service;


import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
@Service
public class LoginServiceImpl implements LoginService{

    @Override
    public void login(String login, String password){
        try{
            Response loginPageResponse = 
                    Jsoup.connect("https://mail.rediff.com/cgi-bin/login.cgi")
                    .referrer("http://www.rediff.com/")
                    .userAgent("Mozilla/5.0")
                    .timeout(10 * 1000)
                    .followRedirects(true)
                    .execute();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    
}
