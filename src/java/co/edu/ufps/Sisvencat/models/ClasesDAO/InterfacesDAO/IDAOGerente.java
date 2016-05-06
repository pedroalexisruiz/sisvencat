/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import java.util.List;

/**
 *
 * @author oso
 */
public interface IDAOGerente {
    public int insertar(Gerente ger);

    public boolean modificar(Gerente ger) throws Exception;
    
    public boolean cambiarContraseña(Gerente ger) throws Exception;

    public boolean cambiarEstado(Gerente ger) throws Exception;

    public List<Gerente> listar() throws Exception;

    public List<Gerente> listarPorEstado(int estado) throws Exception;

    public Gerente getGerente(Gerente ger) throws Exception;
    
    public List<Vendedor> getVendedoresDeGerente(Gerente ger)throws Exception;
    
    public void closeConn() throws Exception;
}
