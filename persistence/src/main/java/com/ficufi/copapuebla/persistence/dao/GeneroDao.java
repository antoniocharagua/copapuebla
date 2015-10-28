package com.ficufi.copapuebla.persistence.dao;

import com.ficufi.copapuebla.persistence.entities.Genero;

/**
 *
 * @author antonio
 */
public interface GeneroDao extends GenericDao<Genero, Integer>{
    
    /**
     * Busca un genero por genero
     * @param genero
     * @return 
     */
    Genero find(String genero);
    
}
