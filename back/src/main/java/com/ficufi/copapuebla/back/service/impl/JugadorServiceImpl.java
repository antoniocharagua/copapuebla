package com.ficufi.copapuebla.back.service.impl;

import com.ficufi.copapuebla.back.service.JugadorService;
import com.ficufi.copapuebla.back.service.dto.GeneroDto;
import com.ficufi.copapuebla.back.service.dto.JugadorDto;
import com.ficufi.copapuebla.persistence.dao.JugadorDao;
import com.ficufi.copapuebla.persistence.entities.Genero;
import com.ficufi.copapuebla.persistence.entities.Jugador;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JugadorServiceImpl implements JugadorService {

    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private JugadorDao jugadorDao;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer crear(JugadorDto jugadorDto, GeneroDto generoDto) {
        log.debug("Persisitiendo el jugador:{}", jugadorDto);
        Jugador jugador = new Jugador(jugadorDto.getId(), jugadorDto.getNombre(),
                jugadorDto.getApellidoMaterno(), jugadorDto.getApellidoPaterno());
        jugador.setCurp(jugadorDto.getCurp());
        Genero genero = new Genero(generoDto.getId(), generoDto.getDescripcion());
        jugador.setIdGeneron(genero);
        Integer id = jugadorDao.create(jugador);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JugadorDto> encuentra(String torneo) {
        List<JugadorDto> list = new ArrayList<>();
        if (torneo == null) {
            for (Jugador jugador : jugadorDao.find()) {
                list.add(new JugadorDto(jugador));
            }
        }
        return list;
    }

    @Override
    @Transactional
    public boolean exist(String curp) {
        return jugadorDao.exist(curp);
    }
    
}
