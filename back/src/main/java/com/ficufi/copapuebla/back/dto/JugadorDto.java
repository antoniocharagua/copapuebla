package com.ficufi.copapuebla.back.dto;

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
    private String genero;

    public JugadorDto() {
    }

    public JugadorDto(Jugador jugador) {
        id = jugador.getId();
        curp = jugador.getCurp();
        nombre = jugador.getNombre();
        apellidoMaterno = jugador.getApellidoMaterno();
        apellidoPaterno = jugador.getApellidoPaterno();
        genero = jugador.getIdGeneron().getDescripcion();
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(" id:").append(id).append(" curp:").append(curp).append(" nombre:").append(nombre)
                .append(" apellidoPaterno:").append(apellidoPaterno).append(" apellidoMaterno:")
                .append(apellidoMaterno).append(" genero:").append(genero);
        return string.toString();
    }
}
