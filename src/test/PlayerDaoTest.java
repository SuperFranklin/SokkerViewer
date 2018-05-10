package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import sokker.core.dao.PlayerDao;
import sokker.core.entity.Player;

public class PlayerDaoTest{

    @Test
    public void testAddAndGetPlayer() {
        Player createdPlayer = createPlayer();
        PlayerDao playerDao = mock( PlayerDao.class );
        playerDao.addPlayer( createdPlayer );
        Player playerFromDb = playerDao.getPlayer( createdPlayer.getPID() );
        assertEquals( playerFromDb, createdPlayer );
    }
    
    private Player createPlayer() {
        Player player = new Player();
        player.setCountry( "Polska" );
        player.setHeight( 120 );
        player.setName( "Jaros�aw" );
        player.setPID( 123 );
        player.setWeight( 90 );
        
        return player;
    }
}