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
public class JugadorEquipoTorneoPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "ID_JUGADOR")
    private int idJugador;
    
    @Basic(optional = false)
    @Column(name = "ID_TORNEO")
    private int idTorneo;
    
    @Basic(optional = false)
    @Column(name = "ID_EQUIPO")
    private int idEquipo;

    public JugadorEquipoTorneoPK() {
    }

    public JugadorEquipoTorneoPK(int idJugador, int idTorneo, int idEquipo) {
        this.idJugador = idJugador;
        this.idTorneo = idTorneo;
        this.idEquipo = idEquipo;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idJugador;
        hash += (int) idTorneo;
        hash += (int) idEquipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorEquipoTorneoPK)) {
            return false;
        }
        JugadorEquipoTorneoPK other = (JugadorEquipoTorneoPK) object;
        if (this.idJugador != other.idJugador) {
            return false;
        }
        if (this.idTorneo != other.idTorneo) {
            return false;
        }
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.JugadorEquipoTorneoPK[ idJugador=" + idJugador + ", idTorneo=" + idTorneo + ", idEquipo=" + idEquipo + " ]";
    }
    
}
