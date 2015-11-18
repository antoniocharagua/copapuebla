package com.ficufi.copapuebla.back.service.impl;

import com.ficufi.copapuebla.back.service.EquipoService;
import com.ficufi.copapuebla.back.dto.EquipoDto;
import com.ficufi.copapuebla.persistence.dao.EquipoDao;
import com.ficufi.copapuebla.persistence.entities.Equipo;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipoServiceImpl implements EquipoService {

    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private EquipoDao equipoDao;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer crear(EquipoDto equipoDto) {
        log.debug("persistiendo equipo:{}", equipoDto);
        Equipo equipo = new Equipo();
        equipo.setNombre(equipoDto.getNombre());
        Integer id = equipoDao.create(equipo);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EquipoDto> enuentra(String torneo) {
        List<EquipoDto> lista = new ArrayList<>();
        if (torneo == null) {            
            for (Equipo equipo : equipoDao.find()) {
                EquipoDto equipoDto = new EquipoDto(equipo);
                equipoDto.setCategoria("Aun sin Categoría");
                lista.add(equipoDto);
            }
        }
        return lista;
    }
    
}
