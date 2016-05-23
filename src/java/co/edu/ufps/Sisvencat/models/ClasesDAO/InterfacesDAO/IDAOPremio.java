/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOPremio {
    
    public boolean insertar(Premio pre) throws SQLException;

    public int modificar(Premio pre) throws SQLException;

    public boolean eliminar(Premio pre) throws SQLException;

    public List<Premio> listar() throws SQLException;

    public List<Premio> listarDisponiblesoNo(boolean dispon) throws SQLException;

    public Premio getPremio(Premio pre) throws SQLException;

    public void closeConn() throws SQLException;
}
