/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public interface IDAOAdministrador {
    
    public Administrador login(Administrador a)throws SQLException;
    
    public boolean modificarDatos(Administrador a) throws SQLException;
    
    public boolean cambiarContrasena(Administrador a) throws SQLException;
    
    public void closeConn();
}
