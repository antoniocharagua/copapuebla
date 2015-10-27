/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficufi.copapuebla.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "MARCADOR")
@NamedQueries({
    @NamedQuery(name = "Marcador.findAll", query = "SELECT m FROM Marcador m")})
public class Marcador implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MarcadorPK marcadorPK;
    @Basic(optional = false)
    @Column(name = "GOL")
    private int gol;
    @JoinColumn(name = "ID_PARTIDA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partida partida;
    @JoinColumn(name = "ID_JUGADOR", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jugador jugador;

    public Marcador() {
    }

    public Marcador(MarcadorPK marcadorPK) {
        this.marcadorPK = marcadorPK;
    }

    public Marcador(MarcadorPK marcadorPK, int gol) {
        this.marcadorPK = marcadorPK;
        this.gol = gol;
    }

    public Marcador(int idPartida, int idJugador) {
        this.marcadorPK = new MarcadorPK(idPartida, idJugador);
    }

    public MarcadorPK getMarcadorPK() {
        return marcadorPK;
    }

    public void setMarcadorPK(MarcadorPK marcadorPK) {
        this.marcadorPK = marcadorPK;
    }

    public int getGol() {
        return gol;
    }

    public void setGol(int gol) {
        this.gol = gol;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marcadorPK != null ? marcadorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marcador)) {
            return false;
        }
        Marcador other = (Marcador) object;
        if ((this.marcadorPK == null && other.marcadorPK != null) || (this.marcadorPK != null && !this.marcadorPK.equals(other.marcadorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.Marcador[ marcadorPK=" + marcadorPK + " ]";
    }
    
}
