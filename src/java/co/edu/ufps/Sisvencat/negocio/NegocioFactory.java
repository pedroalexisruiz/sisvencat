/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author salaas402
 */
public class NegocioFactory implements Serializable{

    public NegocioFactory() {
    }

    public IAdminNegocio getAdminNegocio(Persona p){
        return new AdminNegocio(p);
    }
    
    public IGerenteNegocio getGerenteNegocio(String cedula) throws SQLException{
        return new GerenteNegocio(cedula);
    }
    
    public IGeneralNegocio getGeneralNegocio() throws SQLException, ParseException{
        return new GeneralNegocio();
    }
    
    public IVendedorNegocio getVendedorNegocio(String cedula) throws SQLException, ParseException{
        return new VendedorNegocio(cedula);
    }
}
