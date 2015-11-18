package com.ficufi.copapuebla.back.service.impl;

import com.ficufi.copapuebla.back.service.TorneoService;
import com.ficufi.copapuebla.back.dto.TorneoDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author antonio
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/back-config.xml")
public class TorneoServiceImplTest {
    
    @Autowired
    private TorneoService torneoService;
    
    public TorneoServiceImplTest() {
    }

    //@Test
    public void testCrearTorneo() {
        TorneoDto torneoDto = new TorneoDto();
        torneoDto.setNombre("Prueba");
    }

    @Test
    @Transactional
    public void testFind() {
        System.out.println("mensaje ---_>");
        for (TorneoDto torneoDto : torneoService.find()) {
            System.out.println("torneo:"+torneoDto.getNombre());
        }
    }
    
}
