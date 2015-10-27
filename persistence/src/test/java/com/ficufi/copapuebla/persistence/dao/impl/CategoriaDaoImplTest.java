package com.ficufi.copapuebla.persistence.dao.impl;

import com.ficufi.copapuebla.persistence.dao.CategoriaDao;
import com.ficufi.copapuebla.persistence.entities.Categoria;
import com.ficufi.copapuebla.persistence.entities.CategoriaDescripcion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/persistence-config.xml")
public class CategoriaDaoImplTest {
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    public CategoriaDaoImplTest() {
    }

    //@Test
    @Transactional
    public void testSomeMethod() {
        Categoria categoria = new Categoria();
        categoria.setClave("clave");
        Integer i = categoriaDao.create(categoria);
        System.out.println("i:"+i);
    }
    
    @Test
    @Transactional
    public void saveDescripcion() {
        Categoria categoria = new Categoria();
        categoria.setClave("clave");
        categoria.setId(5);
        CategoriaDescripcion categoriaDescripcion = new CategoriaDescripcion(5, "DEscripcion");
        categoriaDescripcion.setCategoria(categoria);
        categoriaDao.update(categoria);
    }
    
}
