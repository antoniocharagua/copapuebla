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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author antonio-lap
 */
@Entity
@Table(name = "EQUIPO")
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "NOMBRE", length = 50, nullable = false, unique = true)
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoPrimero")
    private List<Partida> partidaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoSegundo")
    private List<Partida> partidaList1;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<EquipoCategoriaTorneo> equipoCategoriaTorneoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private List<JugadorEquipoTorneo> jugadorEquipoTorneoList;

    public Equipo() {
    }

    public Equipo(Integer id) {
        this.id = id;
    }

    public Equipo(Integer id, String nombre) {
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

    public List<Partida> getPartidaList1() {
        return partidaList1;
    }

    public void setPartidaList1(List<Partida> partidaList1) {
        this.partidaList1 = partidaList1;
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
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.Equipo[ id=" + id + " ]";
    }
    
}
