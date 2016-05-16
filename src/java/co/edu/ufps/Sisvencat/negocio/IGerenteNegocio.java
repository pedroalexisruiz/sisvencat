/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public interface IGerenteNegocio {
    
    public Gerente getGerente();
    
    public void setGerente(Gerente gerente);
    
    public boolean actualizarDatos(Gerente ger)throws SQLException;
    
    public boolean cambiarPassword(String contrasena, String contrasenanueva) throws SQLException;
    
    public boolean registrarVendedor(Vendedor vendedor) throws SQLException;
}
