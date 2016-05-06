/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IDAOVendedor {

    public int insertar(Vendedor ven, Gerente ger);

    public boolean modificar(Vendedor ven) throws Exception;
    
    public boolean cambiarContraseña(Vendedor ven) throws Exception;

    public boolean cambiarEstado(Vendedor ven) throws Exception;

    public List<Vendedor> listar() throws Exception;
    
    public List<Vendedor> listarPorEstado(int estado) throws Exception;

    public Vendedor getVendedor(Vendedor ven) throws Exception;

    public void closeConn() throws Exception;

}