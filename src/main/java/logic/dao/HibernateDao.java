package main.java.logic.dao;

import java.util.List;

import org.hibernate.Session;

import main.java.logic.Interfaces.Identifiable;

public interface HibernateDao<T extends Identifiable>{

    public T findOne( long id );

    public List<T> findAll();

    public void create( T entity );

    public void update( T entity );

    public void delete( T entity );

    public void deleteById( long entityId );
}
