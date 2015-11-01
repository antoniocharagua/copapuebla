package com.ficufi.copapuebla.persistence.dao;

import com.ficufi.copapuebla.persistence.entities.Torneo;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
public interface TorneoDao extends GenericDao<Torneo, Integer>{
    
    /**
     * Busca un torneo por su nombre
     * @param nombre
     * @return 
     */
    Torneo find(String nombre);
    
}
