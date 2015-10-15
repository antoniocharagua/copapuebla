package com.ficufi.copapuebla.back.service.impl;

import com.ficufi.copapuebla.back.service.TorneoService;
import com.ficufi.copapuebla.back.service.dto.TorneoDto;
import com.ficufi.copapuebla.persistence.dao.TorneoDao;
import com.ficufi.copapuebla.persistence.entities.Torneo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TorneoServiceImpl implements TorneoService {
    
    @Autowired
    private TorneoDao torneoDao;

    @Transactional
    @Override
    public void crearTorneo(String nombre) {
        Torneo torneo = new Torneo();
        torneo.setNombre(nombre);
        torneoDao.create(torneo);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TorneoDto> find() {
        List<TorneoDto> lista = new ArrayList<>();
        for (Torneo torneo : torneoDao.find()) {
            lista.add(new TorneoDto(torneo));
        }
        return lista;
    }

}
