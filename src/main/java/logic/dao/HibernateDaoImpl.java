
package main.java.logic.dao;


import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.logic.Interfaces.Identifiable;

@Repository
public class HibernateDaoImpl<T extends Identifiable> implements HibernateDao<T>{

    private Class<T> clazz;

    @Autowired
    SessionFactory sessionFactory;

    public final void setClazz( Class<T> clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOne( long id ){
        return ( T ) getCurrentSession().get( clazz, id );
    }

    public List<T> findAll(){
        return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
    }
    
    public void saveOrUpdate(T entity) {
        getCurrentSession().saveOrUpdate( entity );
    }

    public void persist( T entity ){
        getCurrentSession().persist( entity );
    }

    public void update( T entity ){
        getCurrentSession().merge( entity );
    }

    public Serializable save( T entity ){
        return getCurrentSession().save( entity );
    }

    public void delete( T entity ){
        getCurrentSession().delete( entity );
    }

    public void deleteById( long entityId ){
        T entity = findOne( entityId );
        delete( entity );
    }

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
