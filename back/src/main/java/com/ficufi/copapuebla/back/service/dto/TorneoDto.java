package com.ficufi.copapuebla.back.service.dto;

import com.ficufi.copapuebla.persistence.entities.Torneo;
import java.util.Objects;

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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(" id:").append(id).append(" nombre:").append(nombre);
        return string.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TorneoDto other = (TorneoDto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
