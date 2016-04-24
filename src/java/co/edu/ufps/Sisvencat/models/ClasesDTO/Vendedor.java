/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

/**
 *
 * @author estudiante
 */
public class Vendedor extends Persona{
    private int tipoPersona;//tipo de persona.
    private int PuntajeAcumulado;//puntaje acumulado por el vendedor

    public int getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public int getPuntajeAcumulado() {
        return PuntajeAcumulado;
    }

    public void setPuntajeAcumulado(int PuntajeAcumulado) {
        this.PuntajeAcumulado = PuntajeAcumulado;
    }
    
}
