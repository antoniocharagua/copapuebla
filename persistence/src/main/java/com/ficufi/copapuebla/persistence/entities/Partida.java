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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author antonio-lap
 */
@Entity
@Table(name = "PARTIDA")
@NamedQueries({
    @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p")})
public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "ID_TORNEO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Torneo idTorneo;
    @JoinColumn(name = "ID_EQUIPO_PRIMERO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Equipo idEquipoPrimero;
    @JoinColumn(name = "ID_EQUIPO_SEGUNDO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Equipo idEquipoSegundo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partida")
    private List<Marcador> marcadorList;

    public Partida() {
    }

    public Partida(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Torneo getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneo idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Equipo getIdEquipoPrimero() {
        return idEquipoPrimero;
    }

    public void setIdEquipoPrimero(Equipo idEquipoPrimero) {
        this.idEquipoPrimero = idEquipoPrimero;
    }

    public Equipo getIdEquipoSegundo() {
        return idEquipoSegundo;
    }

    public void setIdEquipoSegundo(Equipo idEquipoSegundo) {
        this.idEquipoSegundo = idEquipoSegundo;
    }

    public List<Marcador> getMarcadorList() {
        return marcadorList;
    }

    public void setMarcadorList(List<Marcador> marcadorList) {
        this.marcadorList = marcadorList;
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
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.Partida[ id=" + id + " ]";
    }
    
}
