package com.ficufi.copapuebla.persistence.dao;

import com.ficufi.copapuebla.persistence.entities.Jugador;

/**
 *
 * @author antonio
 */
public interface JugadorDao extends GenericDao<Jugador, Integer>{
    
    /**
     * Pregunta si existe un jugador con dicha CURP
     * @param curp clave del jugador
     * @return true en caso de existir
     */
    boolean exist(String curp);
}
