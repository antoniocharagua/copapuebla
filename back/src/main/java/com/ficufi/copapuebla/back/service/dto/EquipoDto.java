package com.ficufi.copapuebla.back.service.dto;

import com.ficufi.copapuebla.persistence.entities.Equipo;

/**
 * Data Transfer Object para un equipo
 * @author Antonio Francisco Alonso Valerdi
 */
public class EquipoDto {
    
    private int id;
    private String nombre;
    private String categoria;

    public EquipoDto() {
    }

    public EquipoDto(Equipo equipo) {
        id = equipo.getId();
        nombre = equipo.getNombre();        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(" id:").append(id).append(" nombre:").append(nombre).append(" categoria:").append(categoria);
        return string.toString();
    }

}
