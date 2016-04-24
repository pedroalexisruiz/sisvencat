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
    
    private int PuntajeAcumulado;//puntaje acumulado por el vendedor
    private Gerente ger;//gerente asociado al vendedor

    public Vendedor(int PuntajeAcumulado, Gerente ger, int cedula, String nombre, String Apellido, String correo, String Direccion, String telefono, String contraseña) {
        super(cedula, nombre, Apellido, correo, Direccion, telefono, contraseña);
        this.PuntajeAcumulado = PuntajeAcumulado;
        this.ger = ger;
    }
    
    public int getPuntajeAcumulado() {
        return PuntajeAcumulado;
    }

    public void setPuntajeAcumulado(int PuntajeAcumulado) {
        this.PuntajeAcumulado = PuntajeAcumulado;
    }
    
}
