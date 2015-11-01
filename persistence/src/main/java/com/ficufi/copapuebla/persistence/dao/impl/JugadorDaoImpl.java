package com.ficufi.copapuebla.persistence.dao.impl;

import com.ficufi.copapuebla.persistence.dao.JugadorDao;
import com.ficufi.copapuebla.persistence.entities.Jugador;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class JugadorDaoImpl extends GenericDaoImpl<Jugador, Integer> implements JugadorDao {

    @Override
    public boolean exist(String curp) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("curp", curp));
        return criteria.uniqueResult() != null;
    }
    
}
