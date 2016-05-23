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

    public ProductoDAO() throws SQLException {
        con = new Conexion();
    }

    @Override
    public boolean insertar(Producto pro, Campaña cam) throws SQLException {

        return true;
    }

    @Override
    public boolean modificar(Producto pro) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Producto pro, Campaña cam) throws SQLException {
        
        String consulta = "DELETE * FROM productosporcampana WHERE idProducto=? AND idCampana=?";
        String consulta2 = "UPDATE producto set estado=2 WHERE Codigo_p=?";
        PreparedStatement state = null;
        PreparedStatement state2 = null;
        
        try{
            if(con ==null){
                con = new Conexion();
            }
            
            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pro.getCodigo_p());
            state.setLong(2, cam.getCodigo_cam());
            state2 = con.getConexion().prepareStatement(consulta2);
            state2.setLong(1, pro.getCodigo_p());
            state.execute();
            state2.execute();
            
            con.getConexion().commit();    
        } catch (SQLException e) {
            
            if(con!=null){   
                try{
                    System.out.println("Error en la Transacción. Revirtiendo Cambios");
                    con.getConexion().rollback();
                }catch(SQLException ex){
                    throw ex;
                }
            }
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (state2 != null) {
                state2.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return true;
    }

    @Override
    public ArrayList<Producto> listar() throws SQLException {

        String consulta = "SELECT producto.*,tipodeprenda.descripcion AS descripcionprenda,categorias.nombre AS "
                + "nombrecategoria FROM producto INNER JOIN productosporcampana ON "
                + "producto.Codigo_p=productosporcampana.idProducto INNER JOIN "
                + "tipodeprenda ON producto.idTipoPrenda=tipodeprenda.id INNER JOIN categorias ON "
                + "producto.idCategoria=categorias.id";

        ArrayList<Producto> productos = new ArrayList();
        PreparedStatement state = null;
        ResultSet rs = null;
        Producto p = null;
        Tipo tipo = null;
        Categoria cat = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            rs = state.executeQuery();

            while (rs.next()) {
                tipo = new Tipo(rs.getInt("idTipoPrenda"), rs.getString("descripcionprenda"));
                cat = new Categoria(rs.getInt("idCategoria"), rs.getString("nombrecategoria"));

                p = new Producto(rs.getInt("Codigo_p"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getInt("Valor"),
                        rs.getInt("cantidad"), cat, tipo, new ImagenProductoDAO().getImagenesProducto(p));
                p.setTalla(this.getTallas(p.getCodigo_p()));
                p.setColor(this.getColores(p.getCodigo_p()));
                p.setEstado(rs.getInt("estado"));
                productos.add(p);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return productos;
    }

    @Override
    public List<Producto> listarPorCampaña(Campaña cam) throws SQLException {

        String consulta = "SELECT producto.*,tipodeprenda.descripcion AS descripcionprenda,categorias.nombre AS "
                + "nombrecategoria FROM producto INNER JOIN productosporcampana ON "
                + "producto.Codigo_p=productosporcampana.idProducto INNER JOIN "
                + "tipodeprenda ON producto.idTipoPrenda=tipodeprenda.id INNER JOIN categorias ON "
                + "producto.idCategoria=categorias.id WHERE "
                + "productosporcampana.idCampana=?";

        List<Producto> productos = new ArrayList();
        PreparedStatement state = null;
        ResultSet rs = null;
        Producto p = null;
        Tipo tipo = null;
        Categoria cat = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, cam.getCodigo_cam());
            rs = state.executeQuery();

            while (rs.next()) {
                tipo = new Tipo(rs.getInt("idTipoPrenda"), rs.getString("descripcionprenda"));
                cat = new Categoria(rs.getInt("idCategoria"), rs.getString("nombrecategoria"));

                p = new Producto(rs.getInt("Codigo_p"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getInt("Valor"),
                        rs.getInt("cantidad"), cat, tipo, new ImagenProductoDAO().getImagenesProducto(p));
                p.setTalla(this.getTallas(p.getCodigo_p()));
                p.setColor(this.getColores(p.getCodigo_p()));
                p.setEstado(rs.getInt("estado"));
                productos.add(p);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return productos;
    }

    private List<String> getTallas(long codP) throws SQLException {

        List<String> tallas = new ArrayList();
        String consulta = "SELECT * FROM tallas INNER JOIN tallaporproducto ON tallas.codigoTalla=tallaporproducto.codigoTalla "
                + "WHERE tallaporproducto.Codigo_p=?";
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setLong(1, codP);
        ResultSet rs = state.executeQuery();

        while (rs.next()) {
            tallas.add(rs.getString("codigoTalla"));
        }

        return tallas;

    }

    private List<String> getColores(long codP) throws SQLException {

        List<String> colores = new ArrayList();
        String consulta = "SELECT descripcion FROM colores INNER JOIN colorporproducto ON colores.idColor=colorporproducto.idColor "
                + "WHERE colorporproducto.Codigo_p=?";
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setLong(1, codP);
        ResultSet rs = state.executeQuery();

        while (rs.next()) {
            colores.add(rs.getString("idColor"));
        }

        return colores;

    }

    @Override
    public List<Producto> listarDisponibleoNo(Campaña cam, boolean disp) throws SQLException {

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
        PreparedStatement state = null;
        Producto p = null;
        Tipo tipo = null;
        Categoria cat = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            if (disp) {
                state = con.getConexion().prepareStatement(consulta);
            } else {
                state = con.getConexion().prepareStatement(consulta2);
            }
            state.setLong(1, cam.getCodigo_cam());
            rs = state.executeQuery();

            while (rs.next()) {
                tipo = new Tipo(rs.getInt("idTipoPrenda"), rs.getString("descripcionprenda"));
                cat = new Categoria(rs.getInt("idCategoria"), rs.getString("nombrecategoria"));

                p = new Producto(rs.getInt("Codigo_p"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getInt("Valor"),
                        rs.getInt("cantidad"), cat, tipo, new ImagenProductoDAO().getImagenesProducto(p));
                p.setTalla(this.getTallas(p.getCodigo_p()));
                p.setColor(this.getColores(p.getCodigo_p()));
                productos.add(p);

                while (rs.next()) {
                    tipo = new Tipo(rs.getInt("idTipoPrenda"), rs.getString("descripcionprenda"));
                    cat = new Categoria(rs.getInt("idCategoria"), rs.getString("nombrecategoria"));

                    p = new Producto(rs.getInt("Codigo_p"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getInt("Valor"),
                            rs.getInt("cantidad"), cat, tipo, new ImagenProductoDAO().getImagenesProducto(p));
                    p.setEstado(rs.getInt("estado"));
                    productos.add(p);
                }
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return productos;
    }

    @Override
    public boolean existe(Producto p) throws SQLException {

        String consulta = "SELECT Codigo_p FROM producto WHERE Codigo_p=?";
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, p.getCodigo_p());
            rs = state.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return false;
    }

    @Override
    public Producto getProducto(Producto pro) throws SQLException {

        String consulta = "SELECT producto.*,tipodeprenda.descripcion AS descripcionprenda,categorias.nombre AS "
                + "nombrecategoria FROM producto INNER JOIN productosporcampana ON "
                + "producto.Codigo_p=productosporcampana.idProducto INNER JOIN "
                + "tipodeprenda ON producto.idTipoPrenda=tipodeprenda.id INNER JOIN categorias ON "
                + "producto.idCategoria=categorias.id WHERE producto.Codigo_p=?";

        PreparedStatement state = null;
        ResultSet rs = null;
        Producto pr = null;
        Categoria cat = null;
        Tipo tipo = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pro.getCodigo_p());
            rs = state.executeQuery();

            while (rs.next()) {
                tipo = new Tipo(rs.getInt("idTipoPrenda"), rs.getString("descripcionprenda"));
                cat = new Categoria(rs.getInt("idCategoria"), rs.getString("nombrecategoria"));

                pr = new Producto(rs.getLong("Codigo_p"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getInt("Valor"),
                        rs.getInt("cantidad"), cat, tipo, new ImagenProductoDAO().getImagenesProducto(pro));
                pr.setTalla(this.getTallas(pr.getCodigo_p()));
                pr.setColor(this.getColores(pr.getCodigo_p()));
                pr.setEstado(rs.getInt("estado"));
            }

        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return pr;
    }

    @Override
    public void closeConn() throws SQLException {
        con.close();
        con = null;
    }
}
