
package main.java.logic.dao;


import java.util.Collection;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.logic.entity.Player;

@Repository
@Transactional
public class PlayerDaoImpl implements PlayerDao{

    @Autowired
    SessionFactory sessionFactory;
    
    public void addPlayer( Player player ){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save( player );
    }

    public Player getPlayer( Integer pid ){
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get( Player.class, pid );
    }

    public Collection<Player> getAllPlayers(){
        Session curSession = sessionFactory.getCurrentSession();
        Criteria criteria = curSession.createCriteria( Player.class );

        return criteria.list();
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory( SessionFactory sessionFactory ){
        this.sessionFactory = sessionFactory;
    }
}
