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
public class Item {
    private int codigo_item;//codigo que identifica al item.
    private Producto producto;//producto al cual esta asociado el item.
    private int cantidad;//cantidad del iten.
    private int valorTotal;//valor total del item;

    public Item() {
    }

    public Item(Producto producto, int cantidad, int valorTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
    }

    public Item(int codigo_item, Producto producto, int cantidad, int valorTotal) {
        this.codigo_item = codigo_item;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
    }
    
    public int getCodigo_item() {
        return codigo_item;
    }

    public void setCodigo_item(int codigo_item) {
        this.codigo_item = codigo_item;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
