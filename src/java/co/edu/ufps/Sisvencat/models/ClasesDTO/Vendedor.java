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
public class Vendedor extends Persona implements Serializable{
    
    private int PuntajeAcumulado;//puntaje acumulado por el vendedor
    private Pedido pedido;
    private Premio premio;
    
    public Vendedor() {
    }

    public Vendedor(int PuntajeAcumulado, String cedula, String nombre, String Apellido, String correo, String Direccion, String telefono, String contraseña, int tipoUsr) {
        super(cedula, nombre, Apellido, correo, Direccion, telefono, contraseña, tipoUsr);
        this.PuntajeAcumulado = PuntajeAcumulado;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public int getPuntajeAcumulado() {
        return PuntajeAcumulado;
    }

    public void setPuntajeAcumulado(int PuntajeAcumulado) {
        this.PuntajeAcumulado = PuntajeAcumulado;
    }

    @Override
    public String toString() {
        return "Vendedor{"+this.getNombre()+" "+this.getApellido() + "PuntajeAcumulado=" + PuntajeAcumulado + '}';
    }   
}