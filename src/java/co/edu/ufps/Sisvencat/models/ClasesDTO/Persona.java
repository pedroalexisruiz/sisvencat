/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

/**
 *
 * @author oso
 */
public class Persona {
    private int cedula;//pedula de la persona.
    private String nombre;//nombres de la persona.
    private String Apellido;//apellidos de la persona.
    private String correo;//correo asociado a la persona.
    private String Direccion;//direccion de la persona.
    private String telefono;//telefono de la persona.
    private String contraseña;//contraseña de acceso al sistema de la persona.
    private int tipoUsr;//tipo de usurio de la persona.
    private int estado;// es in valor para indicar si se encuentra eliminado.

    public Persona() {
    }
    
    public Persona(int cedula, String nombre, String Apellido, String correo, String Direccion, String telefono, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.correo = correo;
        this.Direccion = Direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipoUsr() {
        return tipoUsr;
    }

    public void setTipoUsr(int tipoUsr) {
        this.tipoUsr = tipoUsr;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
