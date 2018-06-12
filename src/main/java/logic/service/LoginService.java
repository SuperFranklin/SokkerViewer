package main.java.logic.service;

import java.io.IOException;

import main.java.logic.utils.Result;

public interface LoginService{

    public void loginAndInitData(String login, String password) throws IOException;
}
