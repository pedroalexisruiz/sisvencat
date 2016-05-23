/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOVendedor {

    public boolean registrar(Vendedor ven, Gerente ger) throws SQLException;

    public boolean modificar(Vendedor ven) throws SQLException;
    
    public boolean cambiarContraseña(Vendedor ven) throws SQLException;

    public boolean cambiarEstado(Vendedor ven) throws SQLException;

    public List<Vendedor> listar() throws SQLException;
    
    public List<Vendedor> listarPorEstado(int estado) throws SQLException;

    public Vendedor getVendedor(String cedula) throws SQLException;

    public void closeConn() throws SQLException ;

}