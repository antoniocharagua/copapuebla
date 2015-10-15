package com.ficufi.copapuebla.persistence.dao.impl;

import com.ficufi.copapuebla.persistence.dao.GenericDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author Antonio Fancisco Alonso Valerdi
 * @param <T>
 * @param <PK>
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK>{
    
    private Class<T> type;
    
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Class<T> getType() {
        if (type == null) {
            ParameterizedType parameterizedType = (ParameterizedType)getClass().getGenericSuperclass();
            type = (Class<T>)parameterizedType.getActualTypeArguments()[0];
        }
        return type;
    }
    
    Session getCurrent() {
        return sessionFactory.getCurrentSession();
    }
    
    Criteria getCriteria() {
        return getCurrent().createCriteria(getType());
    }

    @Override
    public void create(T t) {
        getCurrent().save(t);
    }

    @Override
    public void delete(T t) {
        getCurrent().delete(t);
    }

    @Override
    public List<T> find() {
        return (List<T>)getCurrent().createCriteria(getType()).list();
    }

    @Override
    public void update(T t) {
        getCurrent().update(t);
    }

    @Override
    public T find(PK primaryKey) {
        return (T)getCurrent().get(getType(), primaryKey);
    }
    
}
