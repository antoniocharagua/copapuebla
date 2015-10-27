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
public class EquipoCategoriaTorneoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_EQUIPO")
    private int idEquipo;
    @Basic(optional = false)
    @Column(name = "ID_JUGADOR")
    private int idJugador;
    @Basic(optional = false)
    @Column(name = "ID_TORNEO")
    private int idTorneo;

    public EquipoCategoriaTorneoPK() {
    }

    public EquipoCategoriaTorneoPK(int idEquipo, int idJugador, int idTorneo) {
        this.idEquipo = idEquipo;
        this.idJugador = idJugador;
        this.idTorneo = idTorneo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEquipo;
        hash += (int) idJugador;
        hash += (int) idTorneo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoCategoriaTorneoPK)) {
            return false;
        }
        EquipoCategoriaTorneoPK other = (EquipoCategoriaTorneoPK) object;
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        if (this.idJugador != other.idJugador) {
            return false;
        }
        if (this.idTorneo != other.idTorneo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.EquipoCategoriaTorneoPK[ idEquipo=" + idEquipo + ", idJugador=" + idJugador + ", idTorneo=" + idTorneo + " ]";
    }
    
}
