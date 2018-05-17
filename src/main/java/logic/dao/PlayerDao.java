package main.java.logic.dao;

import java.util.Collection;

import main.java.logic.entity.Player;

public interface PlayerDao{

    public void addPlayer( Player player );

    public Player getPlayer( Integer pid );

    public Collection<Player> getAllPlayers();
}
