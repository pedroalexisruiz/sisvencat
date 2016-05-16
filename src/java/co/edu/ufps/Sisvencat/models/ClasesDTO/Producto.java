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
public class Producto implements Serializable {
    private int codigo_p;//codigo del producto
    private String nombre;//nombre distintivo del producto
    private String descripcion;// palabras que describen el producto
    private int valor;//costo del producto
    private int cantidad;//cantidad que hay en el inventario.
    private Categoria categoria;//categoria del producto (mujeres hombre niños);
    private Tipo tipoProducto;//es el tipo de porducto 
    private List<ImagenProductoDTO> imagenes;//imagenes asociadas al producto
    private List<String> talla;
    private List<String> color;
    
    public Producto() {
    }

    public Producto(String nombre, String descripcion, int valor, int cantidad, Categoria categoria, Tipo tipoProducto, List<ImagenProductoDTO> imagenes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.tipoProducto = tipoProducto;
        this.imagenes = imagenes;
    }

    public Producto(int codigo_p, String nombre, String descripcion, int valor, int cantidad, Categoria categoria, Tipo tipoProducto, List<ImagenProductoDTO> imagenes) {
        this.codigo_p = codigo_p;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.tipoProducto = tipoProducto;
        this.imagenes = imagenes;
    }

    public List<String> getTalla() {
        return talla;
    }

    public void setTalla(List<String> talla) {
        this.talla = talla;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }
    
    public int getCodigo_p() {
        return codigo_p;
    }

    public void setCodigo_p(int codigo_p) {
        this.codigo_p = codigo_p;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Tipo getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(Tipo tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public List<ImagenProductoDTO> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenProductoDTO> imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo_p=" + codigo_p + ", nombre=" + nombre + ", descripcion=" + descripcion + ", valor=" + valor + ", cantidad=" + cantidad + ", categoria=" + categoria.getNombre() + ", tipoProducto=" + tipoProducto.getDescripcion() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.codigo_p;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.codigo_p != other.codigo_p) {
            return false;
        }
        return true;
    }
    
}