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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAURA
 */
@Entity
@Table(name = "detallepedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallepedido.findAll", query = "SELECT d FROM Detallepedido d"),
    @NamedQuery(name = "Detallepedido.findByIddetallePedido", query = "SELECT d FROM Detallepedido d WHERE d.iddetallePedido = :iddetallePedido"),
    @NamedQuery(name = "Detallepedido.findByPrecioUnitario", query = "SELECT d FROM Detallepedido d WHERE d.precioUnitario = :precioUnitario")})
public class Detallepedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallePedido")
    private Integer iddetallePedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnitario")
    private int precioUnitario;
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido idpedido;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idproducto;

    public Detallepedido() {
    }

    public Detallepedido(Integer iddetallePedido) {
        this.iddetallePedido = iddetallePedido;
    }

    public Detallepedido(Integer iddetallePedido, int precioUnitario) {
        this.iddetallePedido = iddetallePedido;
        this.precioUnitario = precioUnitario;
    }

    public Integer getIddetallePedido() {
        return iddetallePedido;
    }

    public void setIddetallePedido(Integer iddetallePedido) {
        this.iddetallePedido = iddetallePedido;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
        this.idpedido = idpedido;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallePedido != null ? iddetallePedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallepedido)) {
            return false;
        }
        Detallepedido other = (Detallepedido) object;
        if ((this.iddetallePedido == null && other.iddetallePedido != null) || (this.iddetallePedido != null && !this.iddetallePedido.equals(other.iddetallePedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.unidmer.backend.model.entities.Detallepedido[ iddetallePedido=" + iddetallePedido + " ]";
    }
    
}
