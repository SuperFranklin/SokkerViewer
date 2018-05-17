package main.java.logic.service;

import org.springframework.web.reactive.function.client.WebClient;

public interface LoginService{

    public void login(String login, String password);
}
