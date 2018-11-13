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

/**
 *
 * @author u84062
 */
@Entity
@Table(name = "padron")
@NamedQueries({
    @NamedQuery(name = "Padron.findAll", query = "SELECT p FROM Padron p")})
public class Padron implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cuit")
    private Double cuit;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "activa")
    private String activa;
    @Column(name = "actividad")
    private Integer actividad;
    @Column(name = "tiene_impuesto")
    private String tieneImpuesto;
    @Column(name = "sct")
    private String sct;
    @Column(name = "sustituto")
    private String sustituto;
    @Column(name = "domicilio_electronico")
    private String domicilioElectronico;
    @Column(name = "fallecido")
    private String fallecido;
    @Column(name = "monotributo")
    private String monotributo;
    @Column(name = "mono_autonomo")
    private String monoAutonomo;
    @Column(name = "sucesion")
    private String sucesion;
    @Column(name = "categoria_autonomo")
    private String categoriaAutonomo;
    @Column(name = "categoria_monotributo")
    private String categoriaMonotributo;
    @Column(name = "segmento")
    private Integer segmento;
    @Column(name = "PERSONA_SUB_TIPO")
    private String personaSubTipo;
    @Column(name = "PERSONA_TIPO")
    private String personaTipo;
    @Column(name = "CODIGO_POSTAL")
    private Integer codigoPostal;
    @Column(name = "CALLE")
    private String calle;
    @Column(name = "MANZANA")
    private String manzana;
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "OFICINA_DEPTO_LOCAL")
    private String oficinaDeptoLocal;
    @Column(name = "PISO")
    private String piso;
    @Column(name = "SECTOR")
    private String sector;
    @Column(name = "TORRE")
    private String torre;
    @Column(name = "LOCALIDAD")
    private String localidad;

    public Padron() {
    }

    public Padron(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCuit() {
        return cuit;
    }

    public void setCuit(Double cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public Integer getActividad() {
        return actividad;
    }

    public void setActividad(Integer actividad) {
        this.actividad = actividad;
    }

    public String getTieneImpuesto() {
        return tieneImpuesto;
    }

    public void setTieneImpuesto(String tieneImpuesto) {
        this.tieneImpuesto = tieneImpuesto;
    }

    public String getSct() {
        return sct;
    }

    public void setSct(String sct) {
        this.sct = sct;
    }

    public String getSustituto() {
        return sustituto;
    }

    public void setSustituto(String sustituto) {
        this.sustituto = sustituto;
    }

    public String getDomicilioElectronico() {
        return domicilioElectronico;
    }

    public void setDomicilioElectronico(String domicilioElectronico) {
        this.domicilioElectronico = domicilioElectronico;
    }

    public String getFallecido() {
        return fallecido;
    }

    public void setFallecido(String fallecido) {
        this.fallecido = fallecido;
    }

    public String getMonotributo() {
        return monotributo;
    }

    public void setMonotributo(String monotributo) {
        this.monotributo = monotributo;
    }

    public String getMonoAutonomo() {
        return monoAutonomo;
    }

    public void setMonoAutonomo(String monoAutonomo) {
        this.monoAutonomo = monoAutonomo;
    }

    public String getSucesion() {
        return sucesion;
    }

    public void setSucesion(String sucesion) {
        this.sucesion = sucesion;
    }

    public String getCategoriaAutonomo() {
        return categoriaAutonomo;
    }

    public void setCategoriaAutonomo(String categoriaAutonomo) {
        this.categoriaAutonomo = categoriaAutonomo;
    }

    public String getCategoriaMonotributo() {
        return categoriaMonotributo;
    }

    public void setCategoriaMonotributo(String categoriaMonotributo) {
        this.categoriaMonotributo = categoriaMonotributo;
    }

    public Integer getSegmento() {
        return segmento;
    }

    public void setSegmento(Integer segmento) {
        this.segmento = segmento;
    }

    public String getPersonaSubTipo() {
        return personaSubTipo;
    }

    public void setPersonaSubTipo(String personaSubTipo) {
        this.personaSubTipo = personaSubTipo;
    }

    public String getPersonaTipo() {
        return personaTipo;
    }

    public void setPersonaTipo(String personaTipo) {
        this.personaTipo = personaTipo;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getOficinaDeptoLocal() {
        return oficinaDeptoLocal;
    }

    public void setOficinaDeptoLocal(String oficinaDeptoLocal) {
        this.oficinaDeptoLocal = oficinaDeptoLocal;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
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
        if (!(object instanceof Padron)) {
            return false;
        }
        Padron other = (Padron) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.afip.dgi.agencia66.model.Padron[ id=" + id + " ]";
    }
    
}
