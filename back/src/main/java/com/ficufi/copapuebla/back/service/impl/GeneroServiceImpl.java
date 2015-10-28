package com.ficufi.copapuebla.back.service.impl;

import com.ficufi.copapuebla.back.service.GeneroService;
import com.ficufi.copapuebla.back.service.dto.GeneroDto;
import com.ficufi.copapuebla.persistence.dao.GeneroDao;
import com.ficufi.copapuebla.persistence.entities.Genero;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneroServiceImpl implements GeneroService {

    private final Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private GeneroDao generoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<GeneroDto> encuentra(boolean jugador) {
        List<GeneroDto> list = new ArrayList<>();
        for (Genero genero : generoDao.find()) {
            list.add(new GeneroDto(genero));
        }
        list.remove(list.size() - 1);
        log.debug("Generos totales encontrado:{}",list);
        return list;
    }
    
}
