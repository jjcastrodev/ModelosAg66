/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author u84062
 */
@Entity
@Table(name = "par_caracter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParCaracter.findAll", query = "SELECT p FROM ParCaracter p"),
    @NamedQuery(name = "ParCaracter.findById", query = "SELECT p FROM ParCaracter p WHERE p.id = :id"),
    @NamedQuery(name = "ParCaracter.findByCaracter", query = "SELECT p FROM ParCaracter p WHERE p.caracter = :caracter")})
public class ParCaracter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "caracter")
    private String caracter;

    public ParCaracter() {
    }

    public ParCaracter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
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
        if (!(object instanceof ParCaracter)) {
            return false;
        }
        ParCaracter other = (ParCaracter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.afip.dgi.agencia66.model.ParCaracter[ id=" + id + " ]";
    }
    
}
