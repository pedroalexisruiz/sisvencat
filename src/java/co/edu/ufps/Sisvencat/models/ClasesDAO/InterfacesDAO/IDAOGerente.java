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
    public int insertar(Gerente ger);
    public int modificar(Gerente ger);
    public int Desactivar(Gerente ger);
    public List<Gerente> listar();
    public List<Gerente> listar(String where);
    public boolean closeConn() throws Exception;
}
