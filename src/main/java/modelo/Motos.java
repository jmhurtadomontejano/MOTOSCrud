/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jmhur
 */
@Entity
@Table(name = "motos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motos.findAll", query = "SELECT m FROM Motos m"),
    @NamedQuery(name = "Motos.findById", query = "SELECT m FROM Motos m WHERE m.id = :id"),
    @NamedQuery(name = "Motos.findByMarca", query = "SELECT m FROM Motos m WHERE m.marca = :marca"),
    @NamedQuery(name = "Motos.findByModelo", query = "SELECT m FROM Motos m WHERE m.modelo = :modelo"),
    @NamedQuery(name = "Motos.findByCilindrada", query = "SELECT m FROM Motos m WHERE m.cilindrada = :cilindrada"),
    @NamedQuery(name = "Motos.findByFoto", query = "SELECT m FROM Motos m WHERE m.foto = :foto")})
public class Motos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cilindrada")
    private int cilindrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "foto")
    private String foto;

    public Motos() {
    }

    public Motos(Integer id) {
        this.id = id;
    }

    public Motos(Integer id, String marca, String modelo, int cilindrada, String foto) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
        if (!(object instanceof Motos)) {
            return false;
        }
        Motos other = (Motos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Motos[ id=" + id + " ]";
    }
    
}
