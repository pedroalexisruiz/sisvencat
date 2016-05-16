
package co.edu.ufps.Sisvencat.facade;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.negocio.IAdminNegocio;
import co.edu.ufps.Sisvencat.negocio.IGeneralNegocio;
import co.edu.ufps.Sisvencat.negocio.IGerenteNegocio;
import co.edu.ufps.Sisvencat.negocio.IVendedorNegocio;
import co.edu.ufps.Sisvencat.negocio.NegocioFactory;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;


public class SisvencatFacade implements Serializable{

    
    NegocioFactory invocador;
    IAdminNegocio adminN;
    IGeneralNegocio generalN;
    IGerenteNegocio gerenteN;
    IVendedorNegocio vendedorN;
    
    public SisvencatFacade() {
        this.invocador = new NegocioFactory();
    }

    public IAdminNegocio getAdminN() {
        return adminN;
    }

    public void iniciarNegocioAdmin(Persona p){

        this.adminN = invocador.getAdminNegocio((Administrador)p);
        this.generalN = null;
        this.gerenteN = null;
        this.vendedorN = null;
        
    }
    
    public void iniciarNegocioGeneral() throws SQLException, ParseException{
        this.generalN= invocador.getGeneralNegocio();
        this.adminN = null;
        this.gerenteN = null;
        this.vendedorN = null;
    }
    
    public void iniciarNegocioGerente(String cedula) throws SQLException{

        this.gerenteN = invocador.getGerenteNegocio(cedula);
        this.generalN= null;
        this.adminN = null;
        this.gerenteN = null;
        this.vendedorN = null;
    }
    
    public void iniciarNegocioVendedor(Persona p){
        this.adminN = invocador.getAdminNegocio((Administrador)p);
    }
}
