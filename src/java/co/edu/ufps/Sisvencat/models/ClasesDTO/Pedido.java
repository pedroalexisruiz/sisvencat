/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author estudiante
 */
public class Pedido implements Serializable {
    private int codigo_pedido;//codigo del pedido.
    private Premio premio;//premio asociado al pedido.
    private int valorTotal;//valor total del producto.
    private Calendar fecha;//fecha en que se realiza el pedido.
    private String cedulaVendedor;
    
    public Pedido() {
    }

    public Pedido(Premio premio,String cedulaVendedor,int valorTotal, Calendar fecha) {
        this.premio = premio;
        this.valorTotal = valorTotal;
        this.fecha = fecha;
        this.cedulaVendedor = cedulaVendedor;
    }

    public Pedido(int codigo_pedido, Premio premio,String cedulaVendedor, int valorTotal, Calendar fecha) {
        this.codigo_pedido = codigo_pedido;
        this.premio = premio;
        this.valorTotal = valorTotal;
        this.fecha = fecha;
        this.cedulaVendedor = cedulaVendedor;
    }

    public String getCedulaVendedor() {
        return cedulaVendedor;
    }

    public void setCedulaVendedor(String cedulaVendedor) {
        this.cedulaVendedor = cedulaVendedor;
    }
    
    public int getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(int codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
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

    @Override
    public String toString() {
        return "Pedido{" + "codigo_pedido=" + codigo_pedido + ", premio=" + premio.getNombre() + ", valorTotal=" + valorTotal + ", fecha=" + fecha.get(Calendar.YEAR) + '}';
    }
    
}