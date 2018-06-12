
package main.java.logic.dao;


import java.io.Serializable;
import java.util.List;

import main.java.logic.Interfaces.Identifiable;

public interface HibernateDao<T extends Identifiable> {

    public T findOne( long id );

    public List<T> findAll();

    public void persist( T entity );

    public void update( T entity );
    
    public void saveOrUpdate(T entity);

    public void delete( T entity );

    public Serializable save( T entity );

    public void deleteById( long entityId );
}
