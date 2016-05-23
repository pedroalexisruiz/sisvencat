/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOImagenPremio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.ImagenPremioDTO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
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
public class ImagenPremioDAO implements Serializable, IDAOImagenPremio {

    private Conexion con;

    @Override
    public boolean insertar(Premio pre, ArrayList<ImagenPremioDTO> imagenes) throws SQLException {

        String consulta = "INSERT INTO imagenesdepremios (Codigo_prem,UrlImagen) VALUES(?,?)";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);

            for (ImagenPremioDTO imagen : imagenes) {
                state.setLong(1, pre.getCodigo_premio());
                state.setString(2, imagen.getUrlImagen());
                state.execute();
            }
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
    public boolean eliminarImagenesDePremio(Premio pre) throws SQLException {

        String consulta = "DELETE * from imagenesdepremios WHERE Codigo_prem=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pre.getCodigo_premio());
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
    public boolean eliminarImagen(ImagenPremioDTO imagen) throws SQLException {

        String consulta = "DELETE * from imagenesdepremios WHERE Id=?";
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
    public ArrayList<ImagenPremioDTO> getImagenesPremio(Premio pre) throws SQLException {

        ArrayList<ImagenPremioDTO> imagenes = new ArrayList();
        String consulta = "SELECT * from imagenesdepremios WHERE Codigo_prem=?";
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pre.getCodigo_premio());
            rs = state.executeQuery();
            ImagenPremioDTO imagen = null;

            while (rs.next()) {
                imagen = new ImagenPremioDTO(rs.getLong("Id"), rs.getString("UrlImagen"));
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
