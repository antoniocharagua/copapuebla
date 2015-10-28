package com.ficufi.copapuebla.back.service.dto;

import com.ficufi.copapuebla.persistence.entities.Jugador;

/**
 *
 * @author antonio
 */
public class JugadorDto {

    private int id;
    private String curp;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public JugadorDto() {
    }

    public JugadorDto(Jugador jugador) {
        id = jugador.getId();
        curp = jugador.getCurp();
        nombre = jugador.getNombre();
        apellidoMaterno = jugador.getApellidoMaterno();
        apellidoPaterno = jugador.getApellidoPaterno();
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(" id:").append(id).append(" curp:").append(curp).append(" nombre:").append(nombre)
                .append(" apellidoPaterno:").append(apellidoPaterno).append(" apellidoMaterno:")
                .append(apellidoMaterno);
        return string.toString();
    }
}
