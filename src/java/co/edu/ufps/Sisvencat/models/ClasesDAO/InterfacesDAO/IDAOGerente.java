/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import java.util.List;

/**
 *
 * @author oso
 */
public interface IDAOGerente {
    public boolean insertar(Gerente ger) throws Exception;
    public int modificar(Gerente ger) throws Exception;
    public boolean Desactivar(Gerente ger) throws Exception;
    public List<Gerente> listar() throws Exception;
    public List<Gerente> listar(String where) throws Exception;
    public boolean closeConn() throws Exception;
}
