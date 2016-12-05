/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unidmer.backend.model.entities;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAURA
 */
@Entity
@Table(name = "ubicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicaciones.findAll", query = "SELECT u FROM Ubicaciones u"),
    @NamedQuery(name = "Ubicaciones.findByIdubicaciones", query = "SELECT u FROM Ubicaciones u WHERE u.idubicaciones = :idubicaciones"),
    @NamedQuery(name = "Ubicaciones.findByNombreDrogueria", query = "SELECT u FROM Ubicaciones u WHERE u.nombreDrogueria = :nombreDrogueria"),
    @NamedQuery(name = "Ubicaciones.findByDireccion", query = "SELECT u FROM Ubicaciones u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Ubicaciones.findByBarrio", query = "SELECT u FROM Ubicaciones u WHERE u.barrio = :barrio")})
public class Ubicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idubicaciones")
    private Integer idubicaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreDrogueria")
    private String nombreDrogueria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "barrio")
    private String barrio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idubicacion", fetch = FetchType.LAZY)
    private List<Ruta> rutaList;
    @JoinColumn(name = "idLocalidad", referencedColumnName = "idlocalidad")
    @ManyToOne(fetch = FetchType.LAZY)
    private Localidad idLocalidad;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idusuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public Ubicaciones() {
    }

    public Ubicaciones(Integer idubicaciones) {
        this.idubicaciones = idubicaciones;
    }

    public Ubicaciones(Integer idubicaciones, String nombreDrogueria, String direccion, String barrio) {
        this.idubicaciones = idubicaciones;
        this.nombreDrogueria = nombreDrogueria;
        this.direccion = direccion;
        this.barrio = barrio;
    }

    public Integer getIdubicaciones() {
        return idubicaciones;
    }

    public void setIdubicaciones(Integer idubicaciones) {
        this.idubicaciones = idubicaciones;
    }

    public String getNombreDrogueria() {
        return nombreDrogueria;
    }

    public void setNombreDrogueria(String nombreDrogueria) {
        this.nombreDrogueria = nombreDrogueria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    @XmlTransient
    public List<Ruta> getRutaList() {
        return rutaList;
    }

    public void setRutaList(List<Ruta> rutaList) {
        this.rutaList = rutaList;
    }

    public Localidad getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Localidad idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idubicaciones != null ? idubicaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicaciones)) {
            return false;
        }
        Ubicaciones other = (Ubicaciones) object;
        if ((this.idubicaciones == null && other.idubicaciones != null) || (this.idubicaciones != null && !this.idubicaciones.equals(other.idubicaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unidmer.backend.model.entities.Ubicaciones[ idubicaciones=" + idubicaciones + " ]";
    }
    
}
