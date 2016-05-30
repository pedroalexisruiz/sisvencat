/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOTipoPrenda;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
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
public class TipoDAO implements Serializable, IDAOTipoPrenda{

    private Conexion con;

    public TipoDAO() {
    }
    
    @Override
    public ArrayList<Tipo> getTipos() throws SQLException {
        
        String consulta = "SELECT * FROM tipodeprenda";
        ArrayList<Tipo> tipos = new ArrayList();
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            rs = state.executeQuery();
            Tipo tipo = null;

            while (rs.next()) {
                tipo = new Tipo(rs.getInt("id"), rs.getString("descripcion"));
                tipos.add(tipo);
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
        return tipos;
    }

    @Override
    public void closeConn() throws SQLException {
        con.close();
        con = null;
    }
}