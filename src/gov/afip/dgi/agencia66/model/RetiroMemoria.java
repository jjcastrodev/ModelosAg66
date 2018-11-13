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
@Table(name = "retiro_memoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RetiroMemoria.findAll", query = "SELECT r FROM RetiroMemoria r"),
    @NamedQuery(name = "RetiroMemoria.findById", query = "SELECT r FROM RetiroMemoria r WHERE r.id = :id"),
    @NamedQuery(name = "RetiroMemoria.findByIdControladorFiscal", query = "SELECT r FROM RetiroMemoria r WHERE r.idControladorFiscal = :idControladorFiscal"),
    @NamedQuery(name = "RetiroMemoria.findByAgente", query = "SELECT r FROM RetiroMemoria r WHERE r.agente = :agente"),
    @NamedQuery(name = "RetiroMemoria.findByRetira", query = "SELECT r FROM RetiroMemoria r WHERE r.retira = :retira"),
    @NamedQuery(name = "RetiroMemoria.findByCaracter", query = "SELECT r FROM RetiroMemoria r WHERE r.caracter = :caracter"),
    @NamedQuery(name = "RetiroMemoria.findByDni", query = "SELECT r FROM RetiroMemoria r WHERE r.dni = :dni"),
    @NamedQuery(name = "RetiroMemoria.findBylegajo", query = "SELECT r FROM RetiroMemoria r WHERE r.legajo = :legajo"),
    @NamedQuery(name = "RetiroMemoria.findByacta", query = "SELECT r FROM RetiroMemoria r WHERE r.acta = :acta"),
    @NamedQuery(name = "RetiroMemoria.findByFechaProceso", query = "SELECT r FROM RetiroMemoria r WHERE r.fechaProceso = :fechaProceso")})
public class RetiroMemoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_controlador_fiscal")
    private int idControladorFiscal;
    @Column(name = "agente")
    private String agente;
    @Column(name = "retira")
    private String retira;
    @Column(name = "caracter")
    private String caracter;
    @Column(name = "dni")
    private String dni;
    @Column(name = "fecha_proceso")
    private String fechaProceso;
    @Column(name="direccion")
    private String direccion;
    @Column(name="acta")
    private String acta;
    @Column(name="legajo")
    private String legajo;

    public String getActa() {
        return acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    

    public RetiroMemoria() {
    }

    public RetiroMemoria(Integer id) {
        this.id = id;
    }

    public RetiroMemoria(Integer id, int idControladorFiscal) {
        this.id = id;
        this.idControladorFiscal = idControladorFiscal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdControladorFiscal() {
        return idControladorFiscal;
    }

    public void setIdControladorFiscal(int idControladorFiscal) {
        this.idControladorFiscal = idControladorFiscal;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getRetira() {
        return retira;
    }

    public void setRetira(String retira) {
        this.retira = retira;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
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
        if (!(object instanceof RetiroMemoria)) {
            return false;
        }
        RetiroMemoria other = (RetiroMemoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.afip.dgi.agencia66.model.RetiroMemoria[ id=" + id + " ]";
    }
    
}
