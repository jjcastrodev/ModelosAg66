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
@Table(name = "par_frasesAnio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParfrasesAnio.findAll", query = "SELECT p FROM ParfrasesAnio p"),
    @NamedQuery(name = "ParfrasesAnio.findByAnio", query = "SELECT p FROM ParfrasesAnio p WHERE p.anio = :anio"),
    @NamedQuery(name = "ParfrasesAnio.findByFrase", query = "SELECT p FROM ParfrasesAnio p WHERE p.frase = :frase")})
public class ParfrasesAnio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "anio")
    private Integer anio;
    @Basic(optional = false)
    @Column(name = "frase")
    private String frase;

    public ParfrasesAnio() {
    }

    public ParfrasesAnio(Integer anio) {
        this.anio = anio;
    }

    public ParfrasesAnio(Integer anio, String frase) {
        this.anio = anio;
        this.frase = frase;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anio != null ? anio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParfrasesAnio)) {
            return false;
        }
        ParfrasesAnio other = (ParfrasesAnio) object;
        if ((this.anio == null && other.anio != null) || (this.anio != null && !this.anio.equals(other.anio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.afip.dgi.agencia66.model.ParfrasesAnio[ anio=" + anio + " ]";
    }
    
}
