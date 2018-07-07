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
import test.java.logic.daoTest.Filler.Implementation.PlayerFiller;

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
        Player createdPlayer = new PlayerFiller().fill();
        
        playerDao.save( createdPlayer );
        
        assertEquals( playerDao.findOne( createdPlayer.getId() ) , createdPlayer );
    }
    
}
