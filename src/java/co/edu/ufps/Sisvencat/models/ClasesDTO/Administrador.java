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
public class Administrador extends Persona{
    //como tal el administrador no tiene nada que lo diferencie de la persona asi que eso es para separarlo de los demás
    private int tipoPersona;

    public Administrador(int tipoPersona, int cedula, String nombre, String Apellido, String correo, String Direccion, String telefono, String contraseña) {
        super(cedula, nombre, Apellido, correo, Direccion, telefono, contraseña);
        this.tipoPersona = tipoPersona;
    }
    
    public int getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}
