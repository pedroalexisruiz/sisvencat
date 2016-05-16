/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOProducto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class ProductoDAO implements Serializable, IDAOProducto {

    private Conexion con;

    public ProductoDAO() {
        con = new Conexion();
    }

    @Override
    public int insertar(Producto pro, Campaña cam) throws Exception {
        
        return 0;
    }

    @Override
    public boolean modificar(Producto pro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Producto pro, Campaña cam) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producto> listarPorCampaña(Campaña cam) throws SQLException{
        
        String consulta = "SELECT producto.*,tipodeprenda.descripcion AS descripcionprenda,categorias.nombre AS "
                + "nombrecategoria FROM producto INNER JOIN productosporcampana ON "
                + "producto.Codigo_p=productosporcampana.idProducto INNER JOIN "
                + "tipodeprenda ON producto.idTipoPrenda=tipodeprenda.id INNER JOIN categorias ON "
                + "producto.idCategoria=categorias.id WHERE "
                + "productosporcampana.idCampana=?";
        
        List<Producto> productos = new ArrayList();
        Producto p = null;
        Tipo tipo = null;
        Categoria cat = null;
        
        if(con==null){
            con = new Conexion();
        }
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, cam.getCodigo_cam());
        ResultSet rs = state.executeQuery();

        while(rs.next()){
            tipo = new Tipo(rs.getInt("idTipoPrenda"),rs.getString("descripcionprenda"));
            cat = new Categoria(rs.getInt("idCategoria"),rs.getString("nombrecategoria"));
            
            p = new Producto(rs.getInt("Codigo_p"),rs.getString("Nombre"),rs.getString("Descripcion"),rs.getInt("Valor"),
            rs.getInt("cantidad"),cat,tipo,null);
            p.setTalla(this.getTallas(p.getCodigo_p()));
            p.setColor(this.getColores(p.getCodigo_p()));
            productos.add(p);
        }
        
        state.close();
        
        this.closeConn();
        
        return productos;
    }

    private List<String> getTallas(int codP) throws SQLException{
        
        List<String> tallas = new ArrayList();
        String consulta = "SELECT * FROM tallas INNER JOIN tallaporproducto ON tallas.codigoTalla=tallaporproducto.codigoTalla "
                + "WHERE tallaporproducto.Codigo_p=?";
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, codP);
        ResultSet rs = state.executeQuery();
        
        while(rs.next()){
            tallas.add(rs.getString("codigoTalla"));
        }
        
        return tallas;
        
    }
    
    private List<String> getColores(int codP) throws SQLException{
        
        List<String> colores = new ArrayList();
        String consulta = "SELECT descripcion FROM colores INNER JOIN colorporproducto ON colores.idColor=colorporproducto.idColor "
                + "WHERE colorporproducto.Codigo_p=?";
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, codP);
        ResultSet rs = state.executeQuery();
        
        while(rs.next()){
            colores.add(rs.getString("idColor"));
        }
        
        return colores;
        
    }
    
    @Override
    public List<Producto> listarDisponibleoNo(Campaña cam, boolean disp) throws Exception {
        
        String consulta = "SELECT producto.*,tipodeprenda.descripcion AS descripcionprenda,categorias.nombre AS "
                + "nombrecategoria FROM producto INNER JOIN productosporcampana ON "
                + "producto.Codigo_p=productosporcampana.idProducto INNER JOIN "
                + "tipodeprenda ON producto.idTipoPrenda=tipodeprenda.id INNER JOIN categorias ON "
                + "producto.idCategoria=categorias.id WHERE "
                + "productosporcampana.idCampana=? AND producto.cantidad>0";
        
        String consulta2 = "SELECT producto.*,tipodeprenda.descripcion AS descripcionprenda,categorias.nombre AS "
                + "nombrecategoria FROM producto INNER JOIN productosporcampana ON "
                + "producto.Codigo_p=productosporcampana.idProducto INNER JOIN "
                + "tipodeprenda ON producto.idTipoPrenda=tipodeprenda.id INNER JOIN categorias ON "
                + "producto.idCategoria=categorias.id WHERE "
                + "productosporcampana.idCampana=? AND producto.cantidad=0";
        
        List<Producto> productos = new ArrayList();
        Producto p = null;
        Tipo tipo = null;
        Categoria cat = null;
        
        if(con==null){
            con = new Conexion();
        }
        
        PreparedStatement state = null;
        
        if(disp){
            state = con.getConexion().prepareStatement(consulta);
        }else{
            state = con.getConexion().prepareStatement(consulta2);
        }
        state.setInt(1, cam.getCodigo_cam());
        ResultSet rs = state.executeQuery();

        while(rs.next()){
            tipo = new Tipo(rs.getInt("idTipoPrenda"),rs.getString("descripcionprenda"));
            cat = new Categoria(rs.getInt("idCategoria"),rs.getString("nombrecategoria"));
            
            p = new Producto(rs.getInt("Codigo_p"),rs.getString("Nombre"),rs.getString("Descripcion"),rs.getInt("Valor"),
            rs.getInt("cantidad"),cat,tipo,null);
            productos.add(p);
        }
        
        state.close();
        
        this.closeConn();
        
        return productos;
    }

    @Override
    public boolean existe(Producto p) throws Exception {
        
        String consulta = "SELECT Codigo_p FROM producto";
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        
        ResultSet rs = state.executeQuery();
        
        Producto pr = null;
        
        while(rs.next()){
            pr = new Producto();
        }
        
        state.close();
        rs.close();
        
        this.closeConn();
        
        return (pr!=null);
    }
    
    @Override
    public Producto getProducto(Producto pro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConn(){
        con.close();
        con = null;
    }

}
