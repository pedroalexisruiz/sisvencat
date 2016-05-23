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
public class Imagen implements Serializable{
       
    private long id;//identificador de imagen
    private String urlImagen;//direccion de la imagen

    public Imagen() {
    }

    public Imagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Imagen(long id, String urlImagen) {
        this.id = id;
        this.urlImagen = urlImagen;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    
}
