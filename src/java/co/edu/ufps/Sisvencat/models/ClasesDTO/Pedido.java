/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author estudiante
 */
public class Pedido implements Serializable {
    private long codigo_pedido;//codigo del pedido.
    private int valorTotal;//valor total del producto.
    private Calendar fecha;//fecha en que se realiza el pedido.
    private String cedulaVendedor;
    private ArrayList<Item> items;
    private byte estado;
    
    public Pedido() {
    }

    public Pedido(String cedulaVendedor,int valorTotal, Calendar fecha) {
        this.valorTotal = valorTotal;
        this.fecha = fecha;
        this.cedulaVendedor = cedulaVendedor;
    }

    public Pedido(long codigo_pedido,String cedulaVendedor, int valorTotal, Calendar fecha) {
        this.codigo_pedido = codigo_pedido;
        this.valorTotal = valorTotal;
        this.fecha = fecha;
        this.cedulaVendedor = cedulaVendedor;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getCedulaVendedor() {
        return cedulaVendedor;
    }

    public void setCedulaVendedor(String cedulaVendedor) {
        this.cedulaVendedor = cedulaVendedor;
    }
    
    public long getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(long codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    
    public void agregarItem(Item item){
        this.items.add(item);
    }
    @Override
    public String toString() {
        return "Pedido{" + "codigo_pedido=" + codigo_pedido + ", valorTotal=" + valorTotal + ", fecha=" + fecha.get(Calendar.YEAR) + '}';
    }
    
}