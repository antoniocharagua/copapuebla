/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ficufi.copapuebla.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author antonio-lap
 */
@Entity
@Table(name = "TORNEO")
@NamedQueries({
    @NamedQuery(name = "Torneo.findAll", query = "SELECT t FROM Torneo t")})
public class Torneo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTorneo")
    private List<Partida> partidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torneo")
    private List<EquipoCategoriaTorneo> equipoCategoriaTorneoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torneo")
    private List<JugadorEquipoTorneo> jugadorEquipoTorneoList;

    public Torneo() {
    }

    public Torneo(Integer id) {
        this.id = id;
    }

    public Torneo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    public List<EquipoCategoriaTorneo> getEquipoCategoriaTorneoList() {
        return equipoCategoriaTorneoList;
    }

    public void setEquipoCategoriaTorneoList(List<EquipoCategoriaTorneo> equipoCategoriaTorneoList) {
        this.equipoCategoriaTorneoList = equipoCategoriaTorneoList;
    }

    public List<JugadorEquipoTorneo> getJugadorEquipoTorneoList() {
        return jugadorEquipoTorneoList;
    }

    public void setJugadorEquipoTorneoList(List<JugadorEquipoTorneo> jugadorEquipoTorneoList) {
        this.jugadorEquipoTorneoList = jugadorEquipoTorneoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.Torneo[ id=" + id + " ]";
    }
    
}
