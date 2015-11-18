package com.ficufi.copapuebla.back.service.impl;

import com.ficufi.copapuebla.back.service.CategoriaService;
import com.ficufi.copapuebla.back.dto.CategoriaDto;
import com.ficufi.copapuebla.persistence.dao.CategoriaDao;
import com.ficufi.copapuebla.persistence.dao.CategoriaDescripcionDao;
import com.ficufi.copapuebla.persistence.entities.Categoria;
import com.ficufi.copapuebla.persistence.entities.CategoriaDescripcion;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Autowired
    private CategoriaDescripcionDao categoriaDescripcionDao;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer create(CategoriaDto categoriaDto) {
        Integer idCategoria = null;
        Categoria categoria = new Categoria();
        categoria.setClave(categoriaDto.getClave());        
        idCategoria = categoriaDao.create(categoria);
        categoria.setId(idCategoria);
        if (categoriaDto.getDescripcion() != null) {
            CategoriaDescripcion categoriaDescripcion = new CategoriaDescripcion(idCategoria, categoriaDto.getDescripcion());
            categoriaDescripcion.setCategoria(categoria);
            categoriaDescripcionDao.create(categoriaDescripcion);
        }
        return idCategoria;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaDto> encuentra() {
        List<CategoriaDto> list = new ArrayList<>();
        for (Categoria find : categoriaDao.find()) {
            list.add(new CategoriaDto(find));
        }
        return list;
    }

    @Override
    @Transactional
    public void actualizar(CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria(categoriaDto.getId(), categoriaDto.getClave());
        if (categoriaDto.getDescripcion() != null && !categoriaDto.getDescripcion().trim().isEmpty()) {
            log.debug("Persistiendo la Categoria:{}", categoriaDto);
            CategoriaDescripcion categoriaDescripcion = new CategoriaDescripcion(categoriaDto.getId(), categoriaDto.getDescripcion());
            categoriaDescripcion.setCategoria(categoria);
            categoriaDescripcionDao.saveOrUpdate(categoriaDescripcion);
        }
        categoriaDao.update(categoria);
    }
    
}
