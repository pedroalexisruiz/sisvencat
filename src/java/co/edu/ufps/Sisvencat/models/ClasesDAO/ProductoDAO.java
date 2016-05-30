/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOProducto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Color;
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

        String consulta = "SELECT `auto_increment` FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'producto'";
        String consulta2 = "INSERT INTO producto VALUES(?,?,?,?,?,?,?)";
        String consulta3 = "INSERT INTO productosporcampana VALUES(?,?)";
        PreparedStatement state = null;
        PreparedStatement state2 = null;
        PreparedStatement state3 = null;
        ResultSet rs = null;
        try {
            if (con == null) {
                con = new Conexion();
            }

            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);
            rs = state.executeQuery();
            long id = 0;
            state.execute();

            while (rs.next()) {
                id = rs.getLong(1);
            }

            state2 = con.getConexion().prepareStatement(consulta2);
            state2.setLong(1, id);
            state2.setString(2, pro.getNombre());
            state2.setString(3, pro.getDescripcion());
            state2.setInt(4, pro.getValor());
            state2.setInt(5, pro.getCantidad());
            state2.setInt(6, pro.getCategoria().getId());
            state2.setInt(7, pro.getTipoProducto().getId());
            state3 = con.getConexion().prepareStatement(consulta3);
            state3.setLong(1, id);
            state3.setLong(2, cam.getCodigo_cam());

            state2.execute();
            state3.execute();
            con.getConexion().commit();
        } catch (SQLException e) {

            if (con != null) {
                try {
                    System.out.println("Error en la Transacción. Revirtiendo Cambios");
                    con.getConexion().rollback();
                } catch (SQLException ex) {
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
            if (state3 != null) {
                state3.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return true;
    }

    @Override
    public boolean insertarVarios(ArrayList<Producto> productos, Campaña cam) throws SQLException {

        String consulta = "SELECT `auto_increment` FROM INFORMATION_SCHEMA.TABLES WHERE table_name = 'producto' LIMIT 1";
        String consulta2 = "INSERT INTO producto VALUES(?,?,?,?,?,?,?)";
        String consulta3 = "INSERT INTO productosporcampana VALUES(?,?)";
        PreparedStatement state = null;
        PreparedStatement state2 = null;
        PreparedStatement state3 = null;
        ResultSet rs = null;
        try {
            if (con == null) {
                con = new Conexion();
            }

            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);
            rs = state.executeQuery();
            long id = 0;
            state.execute();

            while (rs.next()) {
                id = rs.getLong(1);
            }
            state2 = con.getConexion().prepareStatement(consulta2);
            state3 = con.getConexion().prepareStatement(consulta3);

            for (Producto pro : productos) {
                state2.setLong(1, id);
                state2.setString(2, pro.getNombre());
                state2.setString(3, pro.getDescripcion());
                state2.setInt(4, pro.getValor());
                state2.setInt(5, pro.getCantidad());
                state2.setInt(6, pro.getCategoria().getId());
                state2.setInt(7, pro.getTipoProducto().getId());
                state2.addBatch();
                state3.setLong(1, id);
                state3.setLong(2, cam.getCodigo_cam());
                state3.addBatch();
                id++;
            }

            state2.executeBatch();
            state3.executeBatch();
            con.getConexion().commit();
        } catch (SQLException e) {

            if (con != null) {
                try {
                    System.out.println("Error en la Transacción. Revirtiendo Cambios");
                    con.getConexion().rollback();
                    e.printStackTrace();
                } catch (SQLException ex) {
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
            if (state3 != null) {
                state3.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return true;
    }

    @Override
    public boolean insertarTallas(Producto pro) throws SQLException {

        String consulta = "INSERT INTO tallaporproducto VALUES(?,?)";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pro.getCodigo_p());

            for (String talla : pro.getTalla()) {
                state.setString(2, talla);
                state.addBatch();
            }
            state.executeBatch();
            con.getConexion().commit();
        } catch (SQLException e) {
            if (con != null) {
                System.out.println("Error en la Transacción. Revirtiendo Cambios");
                try {
                    con.getConexion().rollback();
                } catch (SQLException ex) {
                    throw ex;
                }
            }
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return true;
    }

    @Override
    public boolean desasignarTallas(long codigo_p) throws SQLException {
        String consulta = "DELETE FROM tallaporproducto WHERE Codigo_p=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, codigo_p);
            state.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return true;
    }

    @Override
    public boolean insertarColores(Producto pro) throws SQLException {
        String consulta = "INSERT INTO colorporproducto VALUES(?,?)";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pro.getCodigo_p());

            for (Color color : pro.getColor()) {
                state.setLong(2, color.getId());
                state.addBatch();
            }
            state.executeBatch();
            con.getConexion().commit();
        } catch (SQLException e) {
            if (con != null) {
                System.out.println("Error en la Transacción. Revirtiendo Cambios");
                try {
                    con.getConexion().rollback();
                } catch (SQLException ex) {
                    throw ex;
                }
            }
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return true;
    }

    @Override
    public boolean desasignarColores(long codigo_p) throws SQLException {

        String consulta = "DELETE FROM colorporproducto WHERE Codigo_p=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, codigo_p);
            state.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return true;
    }

    @Override
    public boolean modificar(Producto pro) throws SQLException {
        String consulta = "UPDATE producto SET Nombre=?,Descripcion=?,Valor=?,cantidad=?,idCategoria=?,idTipoPrenda=? WHERE Codigo_p=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setString(1, pro.getNombre());
            state.setString(2, pro.getDescripcion());
            state.setInt(3, pro.getValor());
            state.setInt(4, pro.getCantidad());
            state.setInt(5, pro.getCategoria().getId());
            state.setInt(6, pro.getTipoProducto().getId());
            state.setLong(7, pro.getCodigo_p());
            state.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        return true;
    }

    @Override
    public boolean eliminar(Producto pro, Campaña cam) throws SQLException {

        String consulta = "DELETE * FROM productosporcampana WHERE idProducto=? AND idCampana=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pro.getCodigo_p());
            state.setLong(2, cam.getCodigo_cam());
            state.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
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
                        rs.getInt("cantidad"), cat, tipo, null);
                p.setImagenes(new ImagenProductoDAO().getImagenesProducto(p));
                p.setTalla(this.getTallas(p.getCodigo_p()));
                p.setColor(this.getColores(p.getCodigo_p()));
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
                + "productosporcampana.idCampana=? ORDER BY producto.idCategoria";

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
                        rs.getInt("cantidad"), cat, tipo, null);
                p.setImagenes(new ImagenProductoDAO().getImagenesProducto(p));
                p.setTalla(this.getTallas(p.getCodigo_p()));
                p.setColor(this.getColores(p.getCodigo_p()));
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

    private List<Color> getColores(long codP) throws SQLException {

        List<Color> colores = new ArrayList();
        String consulta = "SELECT colores.* FROM colores INNER JOIN colorporproducto ON colores.idColor=colorporproducto.idColor "
                + "WHERE colorporproducto.Codigo_p=?";
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setLong(1, codP);
        ResultSet rs = state.executeQuery();
        Color color = null;

        while (rs.next()) {
            color = new Color(rs.getLong("idColor"), rs.getString("descripcion"));
            colores.add(color);
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
                            rs.getInt("cantidad"), cat, tipo, null);
                    p.setImagenes(new ImagenProductoDAO().getImagenesProducto(p));
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

        String consulta = "SELECT Codigo_p FROM producto WHERE Codigo_p=? LIMIT 1";
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
                        rs.getInt("cantidad"), cat, tipo, null);
                pr.setImagenes(new ImagenProductoDAO().getImagenesProducto(pr));
                pr.setTalla(this.getTallas(pr.getCodigo_p()));
                pr.setColor(this.getColores(pr.getCodigo_p()));
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
    public boolean descontarUnidades(long codigo_pro, int unidades) throws SQLException{
        String consulta = "UPDATE producto SET cantidad= cantidad-? WHERE Codigo_p=?";
        PreparedStatement state = null;
        
        try{
            if(con==null){
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setInt(1, unidades);
            state.setLong(2, codigo_pro);
            state.execute();
        }catch(SQLException e){
            throw e;
        }finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }
        
        return true;
    }
    @Override
    public void closeConn() throws SQLException {
        con.close();
        con = null;
    }
}
