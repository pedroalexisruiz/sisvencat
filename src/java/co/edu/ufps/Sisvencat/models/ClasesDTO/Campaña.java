
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class Campaña implements Serializable{
    private int codigo_cam;//codigo de la campaña
    //tener cuidado con este tipo de datos en los DAOs
    private Calendar fechaIni;//fecha de inicio de la campaña
    private Calendar fechaFin;//fecha de finalizacion de la campaña
    private String tema;//(este falto colocarlo en la base de datos) es el tema relacionado a lal campaña: san valentin etc.
    private int estado;
    private List<Producto> productos;
    private List<Pedido> pedidos;
    public static final DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    
    public Campaña() {
    }

    public Campaña(Calendar fechaIni, Calendar fechaFin, String tema) {
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.tema = tema;
    }

    public Campaña(int codigo_cam, Calendar fechaIni, Calendar fechaFin, String tema) {
        this.codigo_cam = codigo_cam;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.tema = tema;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
 
    public int getCodigo_cam() {
        return codigo_cam;
    }

    public void setCodigo_cam(int codigo_cam) {
        this.codigo_cam = codigo_cam;
    }

    public Calendar getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Calendar fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public String getFechaFinString(){
        return formater.format(fechaFin.getTime());
    }
    
    public String getFechaInicioString(){
        return formater.format(fechaIni.getTime());
    }
    @Override
    public String toString() {
        String msg= "Campa\u00f1a{" + "codigo_cam=" + codigo_cam + ", fechaIni=" + 
                formater.format(fechaIni.getTime())+", fechaFin=" + formater.format(fechaFin.getTime())
                + ", tema=" + tema + ", estado=" + estado + '}';
        
        for (Producto producto : productos) {
            msg+="\n"+producto.toString();
        }
        return msg;
    }  
}