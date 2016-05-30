/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOTallas;
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
public class TallasDAO implements Serializable, IDAOTallas {

    private Conexion con;

    public TallasDAO() {
    }

    @Override
    public ArrayList<String> getTallas() throws SQLException {

        ArrayList<String> tallas = new ArrayList();
        String consulta = "SELECT * FROM tallas";
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            rs = state.executeQuery();

            String talla = "";
            while (rs.next()) {
                talla = rs.getString("codigoTalla");
                tallas.add(talla);
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

        return tallas;
    }

    @Override
    public void closeConn() throws SQLException {
        con.close();
        con = null;
    }

}
