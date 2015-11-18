package com.ficufi.copapuebla.back.dto;

import com.ficufi.copapuebla.persistence.entities.Categoria;
import com.ficufi.copapuebla.persistence.entities.CategoriaDescripcion;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
public class CategoriaDto {

    private Integer id;
    private String clave;
    private String descripcion;

    public CategoriaDto() {
    }

    public CategoriaDto(Categoria categoria) {
        id = categoria.getId();
        clave = categoria.getClave();
        CategoriaDescripcion categoriaDescripcion = categoria.getCategoriaDescripcion();
        if (categoriaDescripcion != null) {
            descripcion = categoriaDescripcion.getDescripcion();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(" id:").append(id).append(" clave:").append(clave).append(" descripcion:").append(descripcion);
        return string.toString();
    }
}
