
package sokker.core.dao;


import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sokker.core.entity.Player;

@Repository
public class PlayerDao{

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void addPlayer( Player player ){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save( player );
    }
    
    @Transactional
    public Player getPlayer(Integer pid) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get( Player.class, pid );
    }
}
