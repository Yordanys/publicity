package com.publicity.domain;

import java.util.List;

/**
 *
 * @author Yordanys Pupo
 * @version 1.0
 * Esta clase almacena la información de un cliente
 */
public class Cliente {
    
    private Long clienteId;
    
    private String nombres;
    
    private String apellidos;
    
    private String cedula;
    
    private String empresa;
    
    private String rif;
    
    private String telefono;
    
    private Double pago;
    
    private List<Publicidad> publicidadList;

    public Cliente() {
    
    }

    public Cliente(String cedula, String rif) {
        this.cedula = cedula;
        this.rif = rif;
    }
    
    public Cliente(String nombres, String apellidos, String cedula, String empresa, String rif, String telefono, Double pago) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.empresa = empresa;
        this.rif = rif;
        this.pago = pago;
        this.telefono = telefono;  
    }

    public Cliente(Long clienteId, String nombres, String apellidos, String cedula, String empresa, String rif, String telefono, Double pago) {
        this(nombres, apellidos, cedula, empresa, rif, telefono, pago);
        this.clienteId = clienteId;        
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
        
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    public List<Publicidad> getPublicidadList() {
        return publicidadList;
    }

    public void setPublicidadList(List<Publicidad> publicidadList) {
        this.publicidadList = publicidadList;
    }
        
}
