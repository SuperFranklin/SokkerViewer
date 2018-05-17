package main.java.logic.service;


import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import main.java.logic.utils.Result;
@Service
public class LoginServiceImpl implements LoginService{

    private final String URL = "https://sokker.org";
    //private final String referrer = ""
    
    @Override
    public Result login(String login, String password){
        Result result = new Result<>();
        
        try{
            Response loginPageResponse = 
                    Jsoup.connect("https://mail.rediff.com/cgi-bin/login.cgi")
                    .referrer("http://www.rediff.com/")
                    .userAgent("Mozilla/5.0")
                    .timeout(10 * 1000)
                    .followRedirects(true)
                    .execute();
        }catch (IOException e){
            result.addError( e.getMessage() );
            e.printStackTrace();
        }
        
        return result;
    }

    
}
