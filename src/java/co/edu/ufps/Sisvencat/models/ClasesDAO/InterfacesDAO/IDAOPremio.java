/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOPremio {
    
    public boolean insertar(Premio pre) throws Exception;

    public int modificar(Premio pre) throws Exception;

    public boolean eliminar(Premio pre) throws Exception;

    public List<Premio> listar() throws Exception;

    public List<Premio> listarDisponiblesoNo(boolean dispon) throws Exception;

    public Premio getPremio(Premio pre) throws Exception;

    public void closeConn() throws Exception;
}
