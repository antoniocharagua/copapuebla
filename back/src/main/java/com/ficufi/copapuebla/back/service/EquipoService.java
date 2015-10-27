package com.ficufi.copapuebla.back.service;

import com.ficufi.copapuebla.back.service.dto.EquipoDto;
import java.util.List;

/**
 *
 * @author antonio-lap
 */
public interface EquipoService {
    
    /**
     * Crear un equipo
     * @param equipoDto Nombre del equipo a persistir
     * @return Valor delidentificador
     */
    Integer crear(EquipoDto equipoDto);
    
    /**
     * Busca todos los equipos
     * @param torneo Torneo a donde buscar, null si se riqueren todos
     * @return Lista de los equipos encontrados
     */
    List<EquipoDto> enuentra(String torneo);
    
}
