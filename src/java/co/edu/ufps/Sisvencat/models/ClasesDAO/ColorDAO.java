/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOColor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Color;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ColorDAO implements Serializable, IDAOColor{
    
    private Conexion con;

    public ColorDAO() throws SQLException {
        con = new Conexion();
    }

    @Override
    public ArrayList<Color> getColores() throws SQLException {
        
        String consulta = "SELECT * FROM colores";
        ArrayList<Color> colors = new ArrayList();
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            rs = state.executeQuery();
            Color color = null;

            while (rs.next()) {
                color = new Color(rs.getInt("idColor"), rs.getString("descripcion"));
                colors.add(color);
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
        return colors;
    }

    @Override
    public void closeConn() throws SQLException {
        con.close();
        con = null;
    }
    
    
}
