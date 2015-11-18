package com.ficufi.copapuebla.back.service;

import com.ficufi.copapuebla.back.dto.CategoriaDto;
import java.util.List;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
public interface CategoriaService {
    
    Integer create(CategoriaDto categoriaDto);
    
    List<CategoriaDto> encuentra();
    
    void actualizar(CategoriaDto categoriaDto);

}
