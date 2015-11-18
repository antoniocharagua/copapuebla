package com.ficufi.copapuebla.back.dto;

import com.ficufi.copapuebla.persistence.entities.Equipo;
import java.util.Objects;

/**
 * Data Transfer Object para un equipo
 * @author Antonio Francisco Alonso Valerdi
 */
public class EquipoDto implements Comparable<EquipoDto>{
    
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

    @Override
    public int compareTo(EquipoDto equipoDto) {
        return id - equipoDto.id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.categoria);
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
        final EquipoDto other = (EquipoDto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

}
