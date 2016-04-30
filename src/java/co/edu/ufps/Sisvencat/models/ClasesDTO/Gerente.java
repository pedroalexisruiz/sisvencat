/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.util.List;


public class Gerente extends Persona{
    ////como tal el administrador no tiene nada que lo diferencie de la persona asi que eso es para separarlo de los demás
    private int tipoPersona;//tipo de persona es 
    private List<Vendedor> vendedoresAso;//son lo vendedores asociados al gerente
    private Zona zona;//zona que adminstra el vendedor

    public Gerente() {
    }

    public Gerente(int tipoPersona, List<Vendedor> vendedoresAso, Zona zona, int cedula, String nombre, String Apellido, String correo, String Direccion, String telefono, String contraseña, int tipoUsr) {
        super(cedula, nombre, Apellido, correo, Direccion, telefono, contraseña, tipoUsr);
        this.tipoPersona = tipoPersona;
        this.vendedoresAso = vendedoresAso;
        this.zona = zona;
    }

    public int getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public List<Vendedor> getVendedoresAso() {
        return vendedoresAso;
    }

    public void setVendedoresAso(List<Vendedor> vendedoresAso) {
        this.vendedoresAso = vendedoresAso;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
}
