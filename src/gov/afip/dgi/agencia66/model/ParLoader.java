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
@Table(name = "par_loader")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParLoader.findAll", query = "SELECT p FROM ParLoader p"),
    @NamedQuery(name = "ParLoader.findById", query = "SELECT p FROM ParLoader p WHERE p.id = :id"),
    @NamedQuery(name = "ParLoader.findByLoader", query = "SELECT p FROM ParLoader p WHERE p.loader = :loader")})
public class ParLoader implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "loader")
    private String loader;

    public ParLoader() {
    }

    public ParLoader(Integer id) {
        this.id = id;
    }

    public ParLoader(Integer id, String loader) {
        this.id = id;
        this.loader = loader;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoader() {
        return loader;
    }

    public void setLoader(String loader) {
        this.loader = loader;
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
        if (!(object instanceof ParLoader)) {
            return false;
        }
        ParLoader other = (ParLoader) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.afip.dgi.agencia66.model.ParLoader[ id=" + id + " ]";
    }
    
}
