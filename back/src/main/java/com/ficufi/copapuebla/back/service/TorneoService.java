package com.ficufi.copapuebla.back.service;

import com.ficufi.copapuebla.back.service.dto.TorneoDto;
import java.util.List;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
public interface TorneoService {

    void crearTorneo(String nombre);
    
    List<TorneoDto> find();
}