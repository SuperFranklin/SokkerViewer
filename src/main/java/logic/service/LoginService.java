package main.java.logic.service;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public interface LoginService{

    public HtmlPage getPage(String login, String password, String url) throws IOException;
}
