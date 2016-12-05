/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unidmer.backend.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAURA
 */
@Entity
@Table(name = "estadopedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadopedido.findAll", query = "SELECT e FROM Estadopedido e"),
    @NamedQuery(name = "Estadopedido.findByIdestadoPedido", query = "SELECT e FROM Estadopedido e WHERE e.idestadoPedido = :idestadoPedido"),
    @NamedQuery(name = "Estadopedido.findByNombre", query = "SELECT e FROM Estadopedido e WHERE e.nombre = :nombre")})
public class Estadopedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestadoPedido")
    private Integer idestadoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToOne(mappedBy = "estadopedido", fetch = FetchType.LAZY)
    private Pedido pedido;

    public Estadopedido() {
    }

    public Estadopedido(Integer idestadoPedido) {
        this.idestadoPedido = idestadoPedido;
    }

    public Estadopedido(Integer idestadoPedido, String nombre) {
        this.idestadoPedido = idestadoPedido;
        this.nombre = nombre;
    }

    public Integer getIdestadoPedido() {
        return idestadoPedido;
    }

    public void setIdestadoPedido(Integer idestadoPedido) {
        this.idestadoPedido = idestadoPedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoPedido != null ? idestadoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadopedido)) {
            return false;
        }
        Estadopedido other = (Estadopedido) object;
        if ((this.idestadoPedido == null && other.idestadoPedido != null) || (this.idestadoPedido != null && !this.idestadoPedido.equals(other.idestadoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unidmer.backend.model.entities.Estadopedido[ idestadoPedido=" + idestadoPedido + " ]";
    }
    
}
