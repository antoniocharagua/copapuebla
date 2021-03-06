package com.ficufi.copapuebla.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author antonio-lap
 */
@Entity
@Table(name = "JUGADOR")
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CURP", nullable = false, length = 18, unique = true)
    private String curp;
    
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 60)
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "APELLIDO_MATERNO", nullable = false, length = 40)
    private String apellidoMaterno;
    
    @Basic(optional = false)
    @Column(name = "APELLIDO_PATERNO", nullable = false, length = 40)
    private String apellidoPaterno;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador")
    private List<EquipoCategoriaTorneo> equipoCategoriaTorneoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador")
    private List<JugadorEquipoTorneo> jugadorEquipoTorneoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugador")
    private List<Marcador> marcadorList;
    
    @JoinColumn(name = "ID_GENERON", referencedColumnName = "ID")
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Genero idGeneron;

    public Jugador() {
    }

    public Jugador(Integer id) {
        this.id = id;
    }

    public Jugador(Integer id, String nombre, String apellidoMaterno, String apellidoPaterno) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
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

    public List<Marcador> getMarcadorList() {
        return marcadorList;
    }

    public void setMarcadorList(List<Marcador> marcadorList) {
        this.marcadorList = marcadorList;
    }

    public Genero getIdGeneron() {
        return idGeneron;
    }

    public void setIdGeneron(Genero idGeneron) {
        this.idGeneron = idGeneron;
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
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ficufi.copapuebla.persistence.entities.Jugador[ id=" + id + " ]";
    }
    
}
