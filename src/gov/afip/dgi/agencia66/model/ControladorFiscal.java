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
@Table(name = "controlador_fiscal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControladorFiscal.findAll", query = "SELECT c FROM ControladorFiscal c"),
    @NamedQuery(name = "ControladorFiscal.findById", query = "SELECT c FROM ControladorFiscal c WHERE c.id = :id"),
    @NamedQuery(name = "ControladorFiscal.findByCuit", query = "SELECT c FROM ControladorFiscal c WHERE c.cuit = :cuit"),
    @NamedQuery(name = "ControladorFiscal.findByAgente", query = "SELECT c FROM ControladorFiscal c WHERE c.agente = :agente"),
    @NamedQuery(name = "ControladorFiscal.findByLegajo", query = "SELECT c FROM ControladorFiscal c WHERE c.legajo = :legajo"),
    @NamedQuery(name = "ControladorFiscal.findBySolicitud", query = "SELECT c FROM ControladorFiscal c WHERE c.solicitud = :solicitud"),
    @NamedQuery(name = "ControladorFiscal.findByActa", query = "SELECT c FROM ControladorFiscal c WHERE c.acta = :acta"),
    @NamedQuery(name = "ControladorFiscal.findByRazonSocial", query = "SELECT c FROM ControladorFiscal c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "ControladorFiscal.findByNombre", query = "SELECT c FROM ControladorFiscal c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "ControladorFiscal.findByDocumento", query = "SELECT c FROM ControladorFiscal c WHERE c.documento = :documento"),
    @NamedQuery(name = "ControladorFiscal.findByTelefono", query = "SELECT c FROM ControladorFiscal c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "ControladorFiscal.findByCaracter", query = "SELECT c FROM ControladorFiscal c WHERE c.caracter = :caracter"),
    @NamedQuery(name = "ControladorFiscal.findByDireccion", query = "SELECT c FROM ControladorFiscal c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "ControladorFiscal.findByMarca", query = "SELECT c FROM ControladorFiscal c WHERE c.marca = :marca"),
    @NamedQuery(name = "ControladorFiscal.findByModelo", query = "SELECT c FROM ControladorFiscal c WHERE c.modelo = :modelo"),
    @NamedQuery(name = "ControladorFiscal.findByCodigo", query = "SELECT c FROM ControladorFiscal c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "ControladorFiscal.findByNumeroCodigo", query = "SELECT c FROM ControladorFiscal c WHERE c.numeroCodigo = :numeroCodigo"),
    @NamedQuery(name = "ControladorFiscal.findByPuestoVenta", query = "SELECT c FROM ControladorFiscal c WHERE c.puestoVenta = :puestoVenta"),
    @NamedQuery(name = "ControladorFiscal.findByBloqueos", query = "SELECT c FROM ControladorFiscal c WHERE c.bloqueos = :bloqueos"),
    @NamedQuery(name = "ControladorFiscal.findByTramite", query = "SELECT c FROM ControladorFiscal c WHERE c.tramite = :tramite"),
    @NamedQuery(name = "ControladorFiscal.findByTecnico", query = "SELECT c FROM ControladorFiscal c WHERE c.tecnico = :tecnico"),
    @NamedQuery(name = "ControladorFiscal.findByCredencial", query = "SELECT c FROM ControladorFiscal c WHERE c.credencial = :credencial"),
    @NamedQuery(name = "ControladorFiscal.findByFechaPoceso", query = "SELECT c FROM ControladorFiscal c WHERE c.fechaPoceso = :fechaPoceso"),
    @NamedQuery(name = "ControladorFiscal.findByCompZ", query = "SELECT c FROM ControladorFiscal c WHERE c.compZ = :compZ"),
    @NamedQuery(name = "ControladorFiscal.findByTotalDiaria", query = "SELECT c FROM ControladorFiscal c WHERE c.totalDiaria = :totalDiaria"),
    @NamedQuery(name = "ControladorFiscal.findByTotalIvaDiario", query = "SELECT c FROM ControladorFiscal c WHERE c.totalIvaDiario = :totalIvaDiario"),
    @NamedQuery(name = "ControladorFiscal.findByNoGravados", query = "SELECT c FROM ControladorFiscal c WHERE c.noGravados = :noGravados"),
    @NamedQuery(name = "ControladorFiscal.findByZDesde", query = "SELECT c FROM ControladorFiscal c WHERE c.zDesde = :zDesde"),
    @NamedQuery(name = "ControladorFiscal.findByZHasta", query = "SELECT c FROM ControladorFiscal c WHERE c.zHasta = :zHasta"),
    @NamedQuery(name = "ControladorFiscal.findByFechaInicial", query = "SELECT c FROM ControladorFiscal c WHERE c.fechaInicial = :fechaInicial"),
    @NamedQuery(name = "ControladorFiscal.findByFechaFinal", query = "SELECT c FROM ControladorFiscal c WHERE c.fechaFinal = :fechaFinal"),
    @NamedQuery(name = "ControladorFiscal.findByIntervenTecnico", query = "SELECT c FROM ControladorFiscal c WHERE c.intervenTecnico = :intervenTecnico"),
    @NamedQuery(name = "ControladorFiscal.findByPaginaTecnico", query = "SELECT c FROM ControladorFiscal c WHERE c.paginaTecnico = :paginaTecnico"),
    @NamedQuery(name = "ControladorFiscal.findByIntervenAfip", query = "SELECT c FROM ControladorFiscal c WHERE c.intervenAfip = :intervenAfip"),
    @NamedQuery(name = "ControladorFiscal.findByPaginaAfip", query = "SELECT c FROM ControladorFiscal c WHERE c.paginaAfip = :paginaAfip"),
    @NamedQuery(name = "ControladorFiscal.findByPrecinto", query = "SELECT c FROM ControladorFiscal c WHERE c.precinto = :precinto"),
    @NamedQuery(name = "ControladorFiscal.findByPrecinto445", query = "SELECT c FROM ControladorFiscal c WHERE c.precinto445 = :precinto445"),
    @NamedQuery(name = "ControladorFiscal.findByPrecintolur", query = "SELECT c FROM ControladorFiscal c WHERE c.precintolur = :precintolur"),
    @NamedQuery(name = "ControladorFiscal.findByEstado", query = "SELECT c FROM ControladorFiscal c WHERE c.estado = :estado"),
    @NamedQuery(name = "ControladorFiscal.findByOperativo", query = "SELECT c FROM ControladorFiscal c WHERE c.operativo = :operativo"),
    @NamedQuery(name = "ControladorFiscal.findByLogo", query = "SELECT c FROM ControladorFiscal c WHERE c.logo = :logo"),
    @NamedQuery(name = "ControladorFiscal.findBySerie", query = "SELECT c FROM ControladorFiscal c WHERE c.serie = :serie"),
    @NamedQuery(name = "ControladorFiscal.findByFecha", query = "SELECT c FROM ControladorFiscal c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "ControladorFiscal.findByCompaudit", query = "SELECT c FROM ControladorFiscal c WHERE c.compaudit = :compaudit"),
    //@NamedQuery(name = "ControladorFiscal.findByRecibiocarcaza", query = "SELECT c FROM ControladorFiscal c WHERE c.recibiocarcaza = :recibiocarcaza"),
    @NamedQuery(name = "ControladorFiscal.findByBloqueo", query = "SELECT c FROM ControladorFiscal c WHERE c.bloqueo = :bloqueo"),
    @NamedQuery(name = "ControladorFiscal.findByCompbloq", query = "SELECT c FROM ControladorFiscal c WHERE c.compbloq = :compbloq"),
    @NamedQuery(name = "ControladorFiscal.findByInterlur", query = "SELECT c FROM ControladorFiscal c WHERE c.interlur = :interlur"),
    @NamedQuery(name = "ControladorFiscal.findByCoincidebloqueo", query = "SELECT c FROM ControladorFiscal c WHERE c.coincidebloqueo = :coincidebloqueo"),
    @NamedQuery(name = "ControladorFiscal.findByObservaciones1", query = "SELECT c FROM ControladorFiscal c WHERE c.observaciones1 = :observaciones1"),
    @NamedQuery(name = "ControladorFiscal.findByObservaciones2", query = "SELECT c FROM ControladorFiscal c WHERE c.observaciones2 = :observaciones2"),
    @NamedQuery(name = "ControladorFiscal.findByZingresado", query = "SELECT c FROM ControladorFiscal c WHERE c.zingresado = :zingresado"),
    @NamedQuery(name = "ControladorFiscal.findByVentaingresado", query = "SELECT c FROM ControladorFiscal c WHERE c.ventaingresado = :ventaingresado"),
    @NamedQuery(name = "ControladorFiscal.findByIvaingresado", query = "SELECT c FROM ControladorFiscal c WHERE c.ivaingresado = :ivaingresado"),
    @NamedQuery(name = "ControladorFiscal.findByNogravadoingresado", query = "SELECT c FROM ControladorFiscal c WHERE c.nogravadoingresado = :nogravadoingresado"),
    @NamedQuery(name = "ControladorFiscal.findByUltimocingresado", query = "SELECT c FROM ControladorFiscal c WHERE c.ultimocingresado = :ultimocingresado"),
    @NamedQuery(name = "ControladorFiscal.findByUltimoaingresado", query = "SELECT c FROM ControladorFiscal c WHERE c.ultimoaingresado = :ultimoaingresado"),
    @NamedQuery(name = "ControladorFiscal.findByCuitYRetiroMemoria", query = "SELECT c FROM ControladorFiscal c WHERE c.cuit = :cuit and c.credencial is not null"),
    @NamedQuery(name = "ControladorFiscal.findByRetiroMemoria", query = "SELECT c FROM ControladorFiscal c WHERE c.credencial is not null"),
    @NamedQuery(name = "ControladorFiscal.findByTieneultimoZ", query = "SELECT c FROM ControladorFiscal c WHERE c.tieneultimoZ = :tieneultimoZ")})
public class ControladorFiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cuit")
    private double cuit;
    @Column(name = "agente")
    private String agente;
    @Column(name = "legajo")
    private String legajo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "solicitud")
    private Double solicitud;
    @Column(name = "acta")
    private String acta;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "documento")
    private String documento;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "caracter")
    private String caracter;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "numero_codigo")
    private String numeroCodigo;
    @Column(name = "puesto_venta")
    private Integer puestoVenta;
    @Column(name = "bloqueos")
    private Integer bloqueos;
    @Column(name = "tramite")
    private String tramite;
    @Column(name = "tecnico")
    private String tecnico;
    @Column(name = "credencial")
    private String credencial;
    @Column(name = "fecha_poceso")
    private String fechaPoceso;
    @Column(name = "comp_z")
    private Integer compZ;
    @Column(name = "total_diaria")
    private Double totalDiaria;
    @Column(name = "total_iva_diario")
    private Double totalIvaDiario;
    @Column(name = "no_gravados")
    private Double noGravados;
    @Column(name = "z_desde")
    private Integer zDesde;
    @Column(name = "z_hasta")
    private Integer zHasta;
    @Column(name = "fecha_inicial")
    private String fechaInicial;
    @Column(name = "fecha_final")
    private String fechaFinal;
    @Column(name = "interven_tecnico")
    private Integer intervenTecnico;
    @Column(name = "pagina_tecnico")
    private String paginaTecnico;
    @Column(name = "interven_afip")
    private Integer intervenAfip;
    @Column(name = "pagina_afip")
    private String paginaAfip;
    @Column(name = "precinto")
    private String precinto;
    @Column(name = "precinto445")
    private String precinto445;
    @Column(name = "precintolur")
    private String precintolur;
    @Column(name = "estado")
    private String estado;
    @Column(name = "operativo")
    private Integer operativo;
    @Column(name = "logo")
    private Integer logo;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "fecha")
    private Integer fecha;
    @Column(name = "compaudit")
    private Integer compaudit;
  //  @Column(name = "recibiocarcaza")
  //  private Integer recibiocarcaza;
    @Column(name = "bloqueo")
    private Integer bloqueo;
    @Column(name = "compbloq")
    private Integer compbloq;
    @Column(name = "interlur")
    private Integer interlur;
    @Column(name = "coincidebloqueo")
    private Integer coincidebloqueo;
    @Column(name = "observaciones1")
    private String observaciones1;
    @Column(name = "observaciones2")
    private String observaciones2;
    @Column(name = "zingresado")
    private Integer zingresado;
    @Column(name = "ventaingresado")
    private Double ventaingresado;
    @Column(name = "ivaingresado")
    private Double ivaingresado;
    @Column(name = "nogravadoingresado")
    private Double nogravadoingresado;
    @Column(name = "ultimocingresado")
    private Integer ultimocingresado;
    @Column(name = "ultimoaingresado")
    private Integer ultimoaingresado;
    @Column(name = "tiene_ultimo_Z")
    private Integer tieneultimoZ;

    public ControladorFiscal() {
    }

    public ControladorFiscal(Integer id) {
        this.id = id;
    }

    public ControladorFiscal(Integer id, double cuit) {
        this.id = id;
        this.cuit = cuit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCuit() {
        return cuit;
    }

    public void setCuit(double cuit) {
        this.cuit = cuit;
        System.out.println("En model con Cuit: " +Double.toString(this.cuit) );
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public Double getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Double solicitud) {
        this.solicitud = solicitud;
    }

    public String getActa() {
        return acta;
    }

    public void setActa(String acta) {
        this.acta = acta;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumeroCodigo() {
        return numeroCodigo;
    }

    public void setNumeroCodigo(String numeroCodigo) {
        this.numeroCodigo = numeroCodigo;
    }

    public Integer getPuestoVenta() {
        return puestoVenta;
    }

    public void setPuestoVenta(Integer puestoVenta) {
        this.puestoVenta = puestoVenta;
    }

    public Integer getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(Integer bloqueos) {
        this.bloqueos = bloqueos;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getCredencial() {
        return credencial;
    }

    public void setCredencial(String credencial) {
        this.credencial = credencial;
    }

    public String getFechaPoceso() {
        return fechaPoceso;
    }

    public void setFechaPoceso(String fechaPoceso) {
        this.fechaPoceso = fechaPoceso;
    }

    public Integer getCompZ() {
        return compZ;
    }

    public void setCompZ(Integer compZ) {
        this.compZ = compZ;
    }

    public Double getTotalDiaria() {
        return totalDiaria;
    }

    public void setTotalDiaria(Double totalDiaria) {
        this.totalDiaria = totalDiaria;
    }

    public Double getTotalIvaDiario() {
        return totalIvaDiario;
    }

    public void setTotalIvaDiario(Double totalIvaDiario) {
        this.totalIvaDiario = totalIvaDiario;
    }

    public Double getNoGravados() {
        return noGravados;
    }

    public void setNoGravados(Double noGravados) {
        this.noGravados = noGravados;
    }

    public Integer getZDesde() {
        return zDesde;
    }

    public void setZDesde(Integer zDesde) {
        this.zDesde = zDesde;
    }

    public Integer getZHasta() {
        return zHasta;
    }

    public void setZHasta(Integer zHasta) {
        this.zHasta = zHasta;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        
        this.fechaFinal = fechaFinal;
    }

    public Integer getIntervenTecnico() {
        return intervenTecnico;
    }

    public void setIntervenTecnico(Integer intervenTecnico) {
        this.intervenTecnico = intervenTecnico;
    }

    public String getPaginaTecnico() {
        return paginaTecnico;
    }

    public void setPaginaTecnico(String paginaTecnico) {
        this.paginaTecnico = paginaTecnico;
    }

    public Integer getIntervenAfip() {
        return intervenAfip;
    }

    public void setIntervenAfip(Integer intervenAfip) {
        this.intervenAfip = intervenAfip;
    }

    public String getPaginaAfip() {
        return paginaAfip;
    }

    public void setPaginaAfip(String paginaAfip) {
        this.paginaAfip = paginaAfip;
    }

    public String getPrecinto() {
        return precinto;
    }

    public void setPrecinto(String precinto) {
        this.precinto = precinto;
    }

    public String getPrecinto445() {
        return precinto445;
    }

    public void setPrecinto445(String precinto445) {
        this.precinto445 = precinto445;
    }

    public String getPrecintolur() {
        return precintolur;
    }

    public void setPrecintolur(String precintolur) {
        this.precintolur = precintolur;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getOperativo() {
        return operativo;
    }

    public void setOperativo(Integer operativo) {
        this.operativo = operativo;
    }

    public Integer getLogo() {
        return logo;
    }

    public void setLogo(Integer logo) {
        this.logo = logo;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }

    public Integer getCompaudit() {
        return compaudit;
    }

    public void setCompaudit(Integer compaudit) {
        this.compaudit = compaudit;
    }
/*
    public Integer getRecibiocarcaza() {
        return recibiocarcaza;
    }

    public void setRecibiocarcaza(Integer recibiocarcaza) {
        this.recibiocarcaza = recibiocarcaza;
    }
*/
    public Integer getBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(Integer bloqueo) {
        this.bloqueo = bloqueo;
    }

    public Integer getCompbloq() {
        return compbloq;
    }

    public void setCompbloq(Integer compbloq) {
        this.compbloq = compbloq;
    }

    public Integer getInterlur() {
        return interlur;
    }

    public void setInterlur(Integer interlur) {
        this.interlur = interlur;
    }

    public Integer getCoincidebloqueo() {
        return coincidebloqueo;
    }

    public void setCoincidebloqueo(Integer coincidebloqueo) {
        this.coincidebloqueo = coincidebloqueo;
    }

    public String getObservaciones1() {
        return observaciones1;
    }

    public void setObservaciones1(String observaciones1) {
        this.observaciones1 = observaciones1;
    }

    public String getObservaciones2() {
        return observaciones2;
    }

    public void setObservaciones2(String observaciones2) {
        this.observaciones2 = observaciones2;
    }

    public Integer getZingresado() {
        return zingresado;
    }

    public void setZingresado(Integer zingresado) {
        this.zingresado = zingresado;
    }

    public Double getVentaingresado() {
        return ventaingresado;
    }

    public void setVentaingresado(Double ventaingresado) {
        this.ventaingresado = ventaingresado;
    }

    public Double getIvaingresado() {
        return ivaingresado;
    }

    public void setIvaingresado(Double ivaingresado) {
        this.ivaingresado = ivaingresado;
    }

    public Double getNogravadoingresado() {
        return nogravadoingresado;
    }

    public void setNogravadoingresado(Double nogravadoingresado) {
        this.nogravadoingresado = nogravadoingresado;
    }

    public Integer getUltimocingresado() {
        return ultimocingresado;
    }

    public void setUltimocingresado(Integer ultimocingresado) {
        this.ultimocingresado = ultimocingresado;
    }

    public Integer getUltimoaingresado() {
        return ultimoaingresado;
    }

    public void setUltimoaingresado(Integer ultimoaingresado) {
        this.ultimoaingresado = ultimoaingresado;
    }

    public Integer getTieneultimoZ() {
        return tieneultimoZ;
    }

    public void setTieneultimoZ(Integer tieneultimoZ) {
        this.tieneultimoZ = tieneultimoZ;
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
        if (!(object instanceof ControladorFiscal)) {
            return false;
        }
        ControladorFiscal other = (ControladorFiscal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gov.afip.dgi.agencia66.model.ControladorFiscal[ id=" + id + " ]";
    }
    
}
