package com.ficufi.copapuebla.persistence.dao.impl;

import com.ficufi.copapuebla.persistence.dao.GeneroDao;
import com.ficufi.copapuebla.persistence.entities.Genero;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author antonio
 */
@Repository
public class GeneroDaoImpl extends GenericDaoImpl<Genero, Integer> implements GeneroDao {

    @Override
    public Genero find(String genero) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("descripcion", genero));
        return (Genero)criteria.uniqueResult();
    }

}
