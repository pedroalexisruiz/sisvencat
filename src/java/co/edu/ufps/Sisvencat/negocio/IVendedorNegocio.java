/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public interface IVendedorNegocio {
    
    public Vendedor getVendedor();

    public void setVendedor(Vendedor vendedor);
    
    public boolean actualizarDatos(Vendedor vendedor)throws SQLException;
    
    public boolean cambiarPassword(String contrasena, String contrasenanueva) throws SQLException;
}