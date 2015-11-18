package com.ficufi.copapuebla.back.service;

import com.ficufi.copapuebla.back.dto.GeneroDto;
import java.util.List;

/**
 *
 * @author Antonio francisco Alonso Valerdi
 */
public interface GeneroService {
    
    /**
     * Recupera una lista con los generos completa o para los jugadores
     * @param jugador Recueperar los generos para jugador o completo, true solo jugador
     * false para lista completa
     * @return Lista con los generos
     */
    List<GeneroDto> encuentra(boolean jugador);
}
