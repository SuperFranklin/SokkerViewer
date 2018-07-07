package main.java.logic.service;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public interface LoginService{

    public HtmlPage loginAndUpdateDB(String login, String password) throws IOException;
}
