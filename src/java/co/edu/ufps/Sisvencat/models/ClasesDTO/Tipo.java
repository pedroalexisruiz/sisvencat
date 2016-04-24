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
public class Tipo {
    private int id;//identificador del tipo de producto.
    private String descripcion;//descripcion del tipo de producto.

    public Tipo() {
    }

    public Tipo(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
