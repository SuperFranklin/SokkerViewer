package test.java.logic.daoTest;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import main.java.logic.dao.PlayerDao;
import main.java.logic.entity.Player;
import test.java.configuration.TestConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= { TestConfiguration.class })
public class PlayerDaoTest {

    @Autowired
    PlayerDao playerDao;
    
    @Test
    @Transactional
    @Rollback(true)
    public void testAddAndGetPlayer()  {
        Player createdPlayer = preparePlayer();
        playerDao.persist( createdPlayer );
        assertEquals( playerDao.findOne( createdPlayer.getId() ) , createdPlayer );
    }
    
    private Player preparePlayer() {
        Player player = new Player();
        player.setCountry( "Polska" );
        player.setHeight( 120 );
        player.setName( "Jaros�aw" );
        player.setSurename( "Araszkiwicz" );
        player.setId( 123997 );
        player.setWeight( 90 );
        
        return player;
    }
    private 
}
