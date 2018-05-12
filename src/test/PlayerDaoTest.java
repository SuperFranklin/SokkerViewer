package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import sokker.core.dao.PlayerDao;
import sokker.core.entity.Player;

@ContextConfiguration(locations = "classpath:spring-config.xml")
public class PlayerDaoTest{

    @Test
    @Transactional
    @Rollback
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
        player.setName( "Jaros³aw" );
        player.setPID( 123 );
        player.setWeight( 90 );
        
        return player;
    }
}
