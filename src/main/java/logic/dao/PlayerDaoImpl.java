
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
public class PlayerDaoImpl extends HibernateDaoImpl<Player> implements PlayerDao{

}
