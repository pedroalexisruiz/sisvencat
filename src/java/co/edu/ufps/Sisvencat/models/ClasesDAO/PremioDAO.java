/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOPremio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
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
public class PremioDAO implements Serializable, IDAOPremio{
    
    private Conexion con;

    public PremioDAO(){
        this.con = new Conexion();
    }
    
    @Override
    public boolean insertar(Premio pre) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Premio pre) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Premio pre) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Premio> listar() throws SQLException {
        
        String consulta = "SELECT * FROM premio";
        
        List<Premio> premios = new ArrayList();
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        
        ResultSet rs = state.executeQuery();
        
        Premio premio = null;
        
        while(rs.next()){
            premio = new Premio(rs.getLong("Codigo_prem"),rs.getString("Nombre_Premio"),rs.getString("Descripcion"),
                    rs.getInt("Punto_requerido"),rs.getInt("CantDisponible"),null);
            premios.add(premio);
        }
        
        return premios;
    }

    @Override
    public List<Premio> listarDisponiblesoNo(boolean dispon) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Premio getPremio(Premio pre) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
