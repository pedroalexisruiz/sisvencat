/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class Administrador extends Persona implements Serializable{

    public Administrador() {
    }

    public Administrador(String cedula, String nombre, String Apellido, String correo, String Direccion, String telefono, String contraseña, int tipoUsr) {
        super(cedula, nombre, Apellido, correo, Direccion, telefono, contraseña, tipoUsr);
    }
}
