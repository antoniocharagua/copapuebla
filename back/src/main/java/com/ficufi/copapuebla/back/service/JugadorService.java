package com.ficufi.copapuebla.back.service;

import com.ficufi.copapuebla.back.service.dto.GeneroDto;
import com.ficufi.copapuebla.back.service.dto.JugadorDto;
import java.util.List;

/**
 *
 * @author antonio
 */
public interface JugadorService {

    /**
     * Persiste un juagor
     * @param jugadorDto Juagador a ser persistido
     * @param generoDto Genero del jugador
     * @return Id del jugador persistido
     */
    Integer crear(JugadorDto jugadorDto, GeneroDto generoDto);
     
    /**
      * Recupera una lista de jugadores por torneo, null si deseamos recuperar
      * todos los jugadores
      * @param torneo lista de jugadores por porteneo, null si se requieren todos
      * @return lista de los jugadores recuperados
      */
    List<JugadorDto> encuentra(String torneo);
    
}
