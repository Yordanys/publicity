package com.publicity.domain;

import java.awt.Color;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Yordanys Pupo
 * @version 1.0
 * Esta clase almacena la información de una publicidad.
 */
public class Publicidad {
    
    private Long publicidadId;
    
    private String nombre;
    
    private Date fechaInicio;
    
    private Date fechaFin;
    
    private Integer prioridad;
    
    private Color color;
    
    private Long clienteId;
    
    private List<Horario> horarioList;

    public Publicidad() {
    }

    public Publicidad(String nombre, Date fechaInicio, Date fechaFin, Integer prioridad, Color color, Long clienteId) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.prioridad = prioridad;
        this.color = color;
        this.clienteId = clienteId;
    }

    public Publicidad(Long publicidadId, String nombre, Date fechaInicio, Date fechaFin, Integer prioridad, Color color, Long clienteId) {
        this(nombre, fechaInicio, fechaFin, prioridad, color, clienteId);
        this.publicidadId = publicidadId;
    }
    
    public Long getPublicidadId() {
        return publicidadId;
    }

    public void setPublicidadId(Long publicidadId) {
        this.publicidadId = publicidadId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
        
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }
    
}
