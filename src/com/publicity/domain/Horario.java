package com.publicity.domain;

import com.publicity.dao.SESSION;
import java.util.List;

/**
 *
 * @author Yordanys Pupo
 * @version 1.0
 * Esta clase almacena la información de un horario.
 */

public class Horario {
    
    private Long horarioId;
    
    private String horaInicio;
    
    private String horaFin;
    
    private SESSION session; 
    
    private boolean activo;

    private List<Publicidad> publicidadList;
    
    public Horario() {
        
    }

    public Horario(String horaInicio, String horaFin, SESSION session, boolean activo) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.session = session;
        this.activo = activo;
    }

    public Horario(Long horarioId, String horaInicio, String horaFin, SESSION session, boolean activo) {
        this.horarioId = horarioId;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.session = session;
        this.activo = activo;
    }

    public Long getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Long horarioId) {
        this.horarioId = horarioId;
    }
   
    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public SESSION getSession() {
        return session;
    }

    public void setSession(SESSION session) {
        this.session = session;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Publicidad> getPublicidadList() {
        return publicidadList;
    }

    public void setPublicidadList(List<Publicidad> publicidadList) {
        this.publicidadList = publicidadList;
    }

}
