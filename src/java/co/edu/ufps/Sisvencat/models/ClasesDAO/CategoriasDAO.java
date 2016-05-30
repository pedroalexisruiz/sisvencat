/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOCategorias;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
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
public class CategoriasDAO implements Serializable, IDAOCategorias {

    private Conexion con;

    public CategoriasDAO() throws SQLException {
        con = new Conexion();
    }

    @Override
    public List<Categoria> getCategorias() throws SQLException {

        String consulta = "SELECT * FROM categorias";
        List<Categoria> categorias = new ArrayList();
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            rs = state.executeQuery();
            Categoria categoria = null;

            while (rs.next()) {
                categoria = new Categoria(rs.getInt("id"), rs.getString("nombre"));
                categorias.add(categoria);
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
        return categorias;
    }
    
    @Override
    public Categoria getCategoria(int id) throws SQLException {
        
        String consulta = "SELECT * FROM categorias WHERE id=? LIMIT 1";
        Categoria categoria = null;
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setInt(1, id);
            rs = state.executeQuery();

            while (rs.next()) {
                categoria = new Categoria(rs.getInt("id"), rs.getString("nombre"));
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
        return categoria;
    }
    @Override
    public void closeConn() throws SQLException {

        con.close();
        con = null;

    }

    

}
