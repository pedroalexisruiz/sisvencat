/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOVendedor;
import co.edu.ufps.Sisvencat.models.ClasesDAO.VendedorDAO;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class VendedorNegocio implements Serializable, IVendedorNegocio{
    
    private Vendedor vendedor;

    public VendedorNegocio() {
    }
    
    public VendedorNegocio(String cedula) throws SQLException {
        this.vendedor = new VendedorDAO().getVendedor(cedula);
    }

    @Override
    public Vendedor getVendedor() {
        return vendedor;
    }

    @Override
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public boolean actualizarDatos(Vendedor vendedor) throws SQLException {
        
        IDAOVendedor vDAO = new VendedorDAO();
        
        return vDAO.modificar(vendedor);
    }

    @Override
    public boolean cambiarPassword(String contrasena, String contrasenanueva) throws SQLException {
        
        if (this.vendedor.getContraseña().equals(contrasena)) {

            IDAOVendedor vDAO = new VendedorDAO();
            this.vendedor.setContraseña(contrasenanueva);

            return vDAO.cambiarContraseña(vendedor);

        } else {
            return false;
        }
    }

}
