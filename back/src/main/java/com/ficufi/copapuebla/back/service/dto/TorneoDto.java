package com.ficufi.copapuebla.back.service.dto;

import com.ficufi.copapuebla.persistence.entities.Torneo;

/**
 *
 * @author Antonio Francisco Alonso Valerdi
 */
public class TorneoDto {
    
    private int id;
    private String nombre;

    public TorneoDto() {
    }

    public TorneoDto(Torneo torneo) {
        id = torneo.getId();
        nombre = torneo.getNombre();
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

}
