package com.ficufi.copapuebla.persistence.dao.impl;

import com.ficufi.copapuebla.persistence.dao.TorneoDao;
import com.ficufi.copapuebla.persistence.entities.Torneo;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class TorneoDaoImpl extends GenericDaoImpl<Torneo, Integer> implements TorneoDao {

    @Override
    public Torneo find(String nombre) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("nombre", nombre));
        return (Torneo)criteria.uniqueResult();
    }
    
}
