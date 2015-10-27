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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author antonio-lap
 */
@Entity
@Table(name = "EQUIPO_CATEGORIA_TORNEO")
@NamedQueries({
    @NamedQuery(name = "EquipoCategoriaTorneo.findAll", query = "SELECT e FROM EquipoCategoriaTorneo e")})
public class EquipoCategoriaTorneo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipoCategoriaTorneoPK equipoCategoriaTorneoPK;
    @JoinColumn(name = "ID_TORNEO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Torneo torneo;
    @JoinColumn(name = "ID_JUGADOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jugador jugador;
    @JoinColumn(name = "ID_EQUIPO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;

    public EquipoCategoriaTorneo() {
    }

    public EquipoCategoriaTorneo(EquipoCategoriaTorneoPK equipoCategoriaTorneoPK) {
        this.equipoCategoriaTorneoPK = equipoCategoriaTorneoPK;
    }

    public EquipoCategoriaTorneo(int idEquipo, int idJugador, int idTorneo) {
        this.equipoCategoriaTorneoPK = new EquipoCategoriaTorneoPK(idEquipo, idJugador, idTorneo);
    }

    public EquipoCategoriaTorneoPK getEquipoCategoriaTorneoPK() {
        return equipoCategoriaTorneoPK;
    }

    public void setEquipoCategoriaTorneoPK(EquipoCategoriaTorneoPK equipoCategoriaTorneoPK) {
        this.equipoCategoriaTorneoPK = equipoCategoriaTorneoPK;
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
        hash += (equipoCategoriaTorneoPK != null ? equipoCategoriaTorneoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoCategoriaTorneo)) {
            return false;
        }
        EquipoCategoriaTorneo other = (EquipoCategoriaTorneo) object;
        if ((this.equipoCategoriaTorneoPK == null && other.equipoCategoriaTorneoPK != null) || (this.equipoCategoriaTorneoPK != null && !this.equipoCategoriaTorneoPK.equals(other.equipoCategoriaTorneoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.EquipoCategoriaTorneo[ equipoCategoriaTorneoPK=" + equipoCategoriaTorneoPK + " ]";
    }
    
}
