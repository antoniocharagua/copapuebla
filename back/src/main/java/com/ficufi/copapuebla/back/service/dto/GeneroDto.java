package com.ficufi.copapuebla.back.service.dto;

import com.ficufi.copapuebla.persistence.entities.Genero;

/**
 * Data Transfer object para la tabla Genero
 * @author antonio
 */
public class GeneroDto {
    
    private int id;
    private String descripcion;

    public GeneroDto() {
    }

    public GeneroDto(Genero genero) {
        id = genero.getId();
        descripcion = genero.getDescripcion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        string.append(" id:").append(id).append(" descripcion:").append(descripcion);
        return string.toString();
    }
    
}
