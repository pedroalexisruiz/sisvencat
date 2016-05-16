/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class Premio implements Serializable {
    private long codigo_premio;//codigo del premio.
    private String nombre;//nombre del producto.
    private String descripcion;//descripcion asociada al producto (medidas, marca, etc.).
    private int puntosRequeridos;//cantidad de productos requeridos para reclamar premio.
    private int cantidadDisponible;//cantidad Disponible en el stock del producto.
    private List<ImagenPremioDTO> imagenes;//imagenes asociadas al premio.

    public Premio() {
    }

    public Premio(String nombre, String descripcion, int puntosRequeridos, int cantidadDisponible, List<ImagenPremioDTO> imagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntosRequeridos = puntosRequeridos;
        this.cantidadDisponible = cantidadDisponible;
        this.imagenes = imagenes;
    }

    public Premio(long codigo_premio, String nombre, String descripcion, int puntosRequeridos, int cantidadDisponible, List<ImagenPremioDTO> imagenes) {
        this.codigo_premio = codigo_premio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntosRequeridos = puntosRequeridos;
        this.cantidadDisponible = cantidadDisponible;
        this.imagenes = imagenes;
    }

    public long getCodigo_premio() {
        return codigo_premio;
    }

    public void setCodigo_premio(long codigo_premio) {
        this.codigo_premio = codigo_premio;
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

    public List<ImagenPremioDTO> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenPremioDTO> imagenes) {
        this.imagenes = imagenes;
    }
}
