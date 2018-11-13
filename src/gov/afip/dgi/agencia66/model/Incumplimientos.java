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
@Table(name = "incumplimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incumplimientos.findAll", query = "SELECT i FROM Incumplimientos i"),
    @NamedQuery(name = "Incumplimientos.findById", query = "SELECT i FROM Incumplimientos i WHERE i.id = :id"),
    @NamedQuery(name = "Incumplimientos.findByCuit", query = "SELECT i FROM Incumplimientos i WHERE i.cuit = :cuit"),
    @NamedQuery(name = "Incumplimientos.findByEstablecimiento", query = "SELECT i FROM Incumplimientos i WHERE i.establecimiento = :establecimiento"),
    @NamedQuery(name = "Incumplimientos.findByImpuesto", query = "SELECT i FROM Incumplimientos i WHERE i.impuesto = :impuesto"),
    @NamedQuery(name = "Incumplimientos.findByConcepto", query = "SELECT i FROM Incumplimientos i WHERE i.concepto = :concepto"),
    @NamedQuery(name = "Incumplimientos.findBySubconcepto", query = "SELECT i FROM Incumplimientos i WHERE i.subconcepto = :subconcepto"),
    @NamedQuery(name = "Incumplimientos.findByPeriodo", query = "SELECT i FROM Incumplimientos i WHERE i.periodo = :periodo"),
    @NamedQuery(name = "Incumplimientos.findByCuota", query = "SELECT i FROM Incumplimientos i WHERE i.cuota = :cuota"),
    @NamedQuery(name = "Incumplimientos.findByImporte", query = "SELECT i FROM Incumplimientos i WHERE i.importe = :importe"),
    @NamedQuery(name = "Incumplimientos.findByBoleta", query = "SELECT i FROM Incumplimientos i WHERE i.boleta = :boleta"),
    @NamedQuery(name = "Incumplimientos.findByOrigen", query = "SELECT i FROM Incumplimientos i WHERE i.origen = :origen"),
    @NamedQuery(name = "Incumplimientos.findByVencimiento", query = "SELECT i FROM Incumplimientos i WHERE i.vencimiento = :vencimiento")})
public class Incumplimientos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CUIT")
    private String cuit;
    @Basic(optional = false)
    @Column(name = "ESTABLECIMIENTO")
    private int establecimiento;
    @Basic(optional = false)
    @Column(name = "IMPUESTO")
    private int impuesto;
    @Basic(optional = false)
    @Column(name = "CONCEPTO")
    private int concepto;
    @Column(name = "SUBCONCEPTO")
    private Integer subconcepto;
    @Column(name = "PERIODO")
    private Integer periodo;
    @Column(name = "CUOTA")
    private Integer cuota;
    @Column(name = "IMPORTE")
    private String importe;
    @Column(name = "BOLETA")
    private String boleta;
    @Column(name = "ORIGEN")
    private String origen;
    @Column(name = "VENCIMIENTO")
    private String vencimiento;

    public Incumplimientos() {
    }

    public Incumplimientos(Integer id) {
        this.id = id;
    }

    public Incumplimientos(Integer id, String cuit, int establecimiento, int impuesto, int concepto) {
        this.id = id;
        this.cuit = cuit;
        this.establecimiento = establecimiento;
        this.impuesto = impuesto;
        this.concepto = concepto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public int getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(int establecimiento) {
        this.establecimiento = establecimiento;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public int getConcepto() {
        return concepto;
    }

    public void setConcepto(int concepto) {
        this.concepto = concepto;
    }

    public Integer getSubconcepto() {
        return subconcepto;
    }

    public void setSubconcepto(Integer subconcepto) {
        this.subconcepto = subconcepto;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Integer getCuota() {
        return cuota;
    }

    public void setCuota(Integer cuota) {
        this.cuota = cuota;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
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
        if (!(object instanceof Incumplimientos)) {
            return false;
        }
        Incumplimientos other = (Incumplimientos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.afip.dgi.agencia66.model.Incumplimientos[ id=" + id + " ]";
    }
    
}
