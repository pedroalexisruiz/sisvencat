/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class Campaña {
    private int codigo_cam;//codigo de la campaña
    //tener cuidado con este tipo de datos en los DAOs
    private Date fechaIni;//fecha de inicio de la campaña
    private Date fechaFin;//fecha de finalizacion de la campaña
    private String tema;//(este falto colocarlo en la base de datos) es el tema relacionado a lal campaña: san valentin etc.

    public Campaña() {
    }

    public Campaña(Date fechaIni, Date fechaFin, String tema) {
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.tema = tema;
    }

    public Campaña(int codigo_cam, Date fechaIni, Date fechaFin, String tema) {
        this.codigo_cam = codigo_cam;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.tema = tema;
    }
   
    
       
    public int getCodigo_cam() {
        return codigo_cam;
    }

    public void setCodigo_cam(int codigo_cam) {
        this.codigo_cam = codigo_cam;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

      
   
}
