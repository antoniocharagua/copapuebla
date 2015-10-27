/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficufi.copapuebla.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author antonio-lap
 */
@Embeddable
public class MarcadorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_PARTIDA")
    private int idPartida;
    @Basic(optional = false)
    @Column(name = "ID_JUGADOR")
    private int idJugador;

    public MarcadorPK() {
    }

    public MarcadorPK(int idPartida, int idJugador) {
        this.idPartida = idPartida;
        this.idJugador = idJugador;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPartida;
        hash += (int) idJugador;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarcadorPK)) {
            return false;
        }
        MarcadorPK other = (MarcadorPK) object;
        if (this.idPartida != other.idPartida) {
            return false;
        }
        if (this.idJugador != other.idJugador) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.MarcadorPK[ idPartida=" + idPartida + ", idJugador=" + idJugador + " ]";
    }
    
}
