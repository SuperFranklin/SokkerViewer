package main.java.logic.service;

import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

import main.java.logic.entity.Player;

public interface PlayersParserService{


    public List<Player> downloadPlayers(HtmlPage page);
}
