/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

/**
 *zona que administra cada cliente y a la que tambien pertenecen los vendedores
 * @author estudiante
 */
public class Zona{
    private int codigo_z;//codigo que identifica la zona
    private String nombre;//nombre de la zona

    public int getCodigo_z() {
        return codigo_z;
    }

    public void setCodigo_z(int codigo_z) {
        this.codigo_z = codigo_z;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
