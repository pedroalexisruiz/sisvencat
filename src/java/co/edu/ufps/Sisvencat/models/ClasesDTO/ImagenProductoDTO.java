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
public class ImagenProductoDTO extends Imagen {
    private Producto producto;//producto asociado a la imagen;

    public ImagenProductoDTO(Producto producto, String urlImagen) {
        super(urlImagen);
        this.producto = producto;
    }

    public ImagenProductoDTO(Producto producto, int id, String urlImagen) {
        super(id, urlImagen);
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}
