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
public class Premio {
    private int condigo_premio;//codigo del premio.
    private String nombre;//nombre del producto.
    private String descripcion;//descripcion asociada al producto (medidas, marca, etc.).
    private int puntosRequeridos;//cantidad de productos requeridos para reclamar premio.
    private int cantidadDisponible;//cantidad Disponible en el stock del producto.

    public Premio() {
    }

    public Premio(String nombre, String descripcion, int puntosRequeridos, int cantidadDisponible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntosRequeridos = puntosRequeridos;
        this.cantidadDisponible = cantidadDisponible;
    }

    public Premio(int condigo_premio, String nombre, String descripcion, int puntosRequeridos, int cantidadDisponible) {
        this.condigo_premio = condigo_premio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntosRequeridos = puntosRequeridos;
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCondigo_premio() {
        return condigo_premio;
    }

    public void setCondigo_premio(int condigo_premio) {
        this.condigo_premio = condigo_premio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public void setPuntosRequeridos(int puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }
    
}
