/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficufi.copapuebla.persistence.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author antonio-lap
 */
@Entity
@Table(name = "JUGADOR_EQUIPO_TORNEO")
public class JugadorEquipoTorneo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected JugadorEquipoTorneoPK jugadorEquipoTorneoPK;
    
    @JoinColumn(name = "ID_TORNEO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Torneo torneo;
    
    @JoinColumn(name = "ID_JUGADOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jugador jugador;
    
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;

    public JugadorEquipoTorneo() {
    }

    public JugadorEquipoTorneo(JugadorEquipoTorneoPK jugadorEquipoTorneoPK) {
        this.jugadorEquipoTorneoPK = jugadorEquipoTorneoPK;
    }

    public JugadorEquipoTorneo(int idJugador, int idTorneo, int idEquipo) {
        this.jugadorEquipoTorneoPK = new JugadorEquipoTorneoPK(idJugador, idTorneo, idEquipo);
    }

    public JugadorEquipoTorneoPK getJugadorEquipoTorneoPK() {
        return jugadorEquipoTorneoPK;
    }

    public void setJugadorEquipoTorneoPK(JugadorEquipoTorneoPK jugadorEquipoTorneoPK) {
        this.jugadorEquipoTorneoPK = jugadorEquipoTorneoPK;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugadorEquipoTorneoPK != null ? jugadorEquipoTorneoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorEquipoTorneo)) {
            return false;
        }
        JugadorEquipoTorneo other = (JugadorEquipoTorneo) object;
        if ((this.jugadorEquipoTorneoPK == null && other.jugadorEquipoTorneoPK != null) || (this.jugadorEquipoTorneoPK != null && !this.jugadorEquipoTorneoPK.equals(other.jugadorEquipoTorneoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.JugadorEquipoTorneo[ jugadorEquipoTorneoPK=" + jugadorEquipoTorneoPK + " ]";
    }
    
}
