/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOImagenProducto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenProductoDTO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class ImagenProductoDAO implements Serializable, IDAOImagenProducto {

    private Conexion con;

    @Override
    public boolean subirImagenes(Producto pro, ArrayList<ImagenProductoDTO> imagenes) throws SQLException {

        String consulta = "INSERT INTO imagenesdeproductos (Codigo_Producto,UrlImagen) VALUES(?,?)";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pro.getCodigo_p());
            
            for (ImagenProductoDTO imagen : imagenes) {
                
                state.setString(2, imagen.getUrlImagen());
                state.addBatch();
            }
            state.executeBatch();
            con.getConexion().commit();
        } catch (SQLException e) {
            if (con != null) {
                try {
                    System.out.println("Error en la transacción, revirtiendo cambios");
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
    public boolean eliminarImagen(ImagenProductoDTO imagen) throws SQLException {

        String consulta = "DELETE * from imagenesdeproductos WHERE Id=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, imagen.getId());
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
    public boolean eliminarImagenesDeProducto(Producto pro) throws SQLException {

        String consulta = "DELETE from imagenesdeproductos WHERE Codigo_Producto=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pro.getCodigo_p());
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
    public ArrayList<ImagenProductoDTO> getImagenesProducto(Producto pro) throws SQLException {

        ArrayList<ImagenProductoDTO> imagenes = new ArrayList();
        String consulta = "SELECT * from imagenesdeproductos WHERE Codigo_Producto=?";
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pro.getCodigo_p());
            rs = state.executeQuery();
            ImagenProductoDTO imagen = null;

            while (rs.next()) {
                imagen = new ImagenProductoDTO(rs.getLong("Id"), rs.getString("UrlImagen"));
                imagenes.add(imagen);
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

        return imagenes;

    }

    @Override
    public void closeConn() throws SQLException {
        con.close();
        con = null;
    }
}
