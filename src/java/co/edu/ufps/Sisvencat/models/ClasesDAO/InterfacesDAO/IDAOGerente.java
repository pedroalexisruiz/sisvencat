/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author oso
 */
public interface IDAOGerente {
    public boolean insertar(Gerente ger) throws SQLException;

    public boolean modificar(Gerente ger) throws SQLException;
    
    public boolean cambiarContraseña(Gerente ger) throws SQLException;

    public boolean cambiarEstado(Gerente ger) throws SQLException;

    public List<Gerente> listar() throws SQLException;

    public List<Gerente> listarPorEstado(int estado) throws SQLException;

    public Gerente getGerente(String cedula) throws SQLException;
    
    public List<Vendedor> getVendedoresDeGerente(Gerente ger)throws SQLException;
    
    public void closeConn();
}
