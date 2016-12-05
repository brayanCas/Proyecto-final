/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unidmer.backend.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "estadousuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadousuario.findAll", query = "SELECT e FROM Estadousuario e"),
    @NamedQuery(name = "Estadousuario.findByIdestadoUsuario", query = "SELECT e FROM Estadousuario e WHERE e.idestadoUsuario = :idestadoUsuario"),
    @NamedQuery(name = "Estadousuario.findByNombre", query = "SELECT e FROM Estadousuario e WHERE e.nombre = :nombre")})
public class Estadousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestadoUsuario")
    private Integer idestadoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idEstado", fetch = FetchType.LAZY)
    private List<Rol> rolList;

    public Estadousuario() {
    }

    public Estadousuario(Integer idestadoUsuario) {
        this.idestadoUsuario = idestadoUsuario;
    }

    public Estadousuario(Integer idestadoUsuario, String nombre) {
        this.idestadoUsuario = idestadoUsuario;
        this.nombre = nombre;
    }

    public Integer getIdestadoUsuario() {
        return idestadoUsuario;
    }

    public void setIdestadoUsuario(Integer idestadoUsuario) {
        this.idestadoUsuario = idestadoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoUsuario != null ? idestadoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadousuario)) {
            return false;
        }
        Estadousuario other = (Estadousuario) object;
        if ((this.idestadoUsuario == null && other.idestadoUsuario != null) || (this.idestadoUsuario != null && !this.idestadoUsuario.equals(other.idestadoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unidmer.backend.model.entities.Estadousuario[ idestadoUsuario=" + idestadoUsuario + " ]";
    }
    
}
