package com.ficufi.copapuebla.persistence.dao.impl;

import com.ficufi.copapuebla.persistence.dao.GeneroDao;
import com.ficufi.copapuebla.persistence.entities.Genero;
import java.util.List;
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
@ContextConfiguration(locations = "classpath:spring/persistence-config.xml")
public class GeneroDaoImplTest {
    
    @Autowired
    private GeneroDao generoDao;
    
    @Test
    @Transactional
    public void find() {
        System.out.println("se buscan los generos ----------------->");
        List<Genero> find = generoDao.find();
        System.out.println("size:"+find.size());
        for (Genero genero : find) {
            System.out.println("genero:"+genero.getDescripcion());
        }
    }
    
}
