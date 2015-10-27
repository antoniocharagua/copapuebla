package com.ficufi.copapuebla.persistence.dao.impl;

import com.ficufi.copapuebla.persistence.dao.EquipoDao;
import com.ficufi.copapuebla.persistence.entities.Equipo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author antonio-lap
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/persistence-config.xml")
public class EquipoDaoImplTest {
    
    @Autowired
    private EquipoDao equipoDao;
    
    public EquipoDaoImplTest() {
    }

    //@Test
    @Transactional
    public void testSomeMethod() {
        for (Equipo equipo : equipoDao.find()) {
            System.out.println("nombre:"+equipo.getNombre());
        }
    }
    
    @Test
    @Transactional
    public void create() {
        Equipo equipo = new Equipo();
        equipo.setNombre("Los Alcones");
        equipoDao.create(equipo);
    }
}
