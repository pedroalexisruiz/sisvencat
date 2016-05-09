
package co.edu.ufps.Sisvencat.facade;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.negocio.IAdminNegocio;
import co.edu.ufps.Sisvencat.negocio.NegocioFactory;
import java.io.Serializable;


public class SisvencatFacade implements Serializable{

    
    NegocioFactory invocador;
    IAdminNegocio adminN = null;
            
    public SisvencatFacade() {
        this.invocador = new NegocioFactory();
    }

    public IAdminNegocio getAdminN() {
        return adminN;
    }

    public void iniciarNegocioAdmin(Persona p){
        Administrador a = new Administrador();
        a.setCedula(p.getCedula());
        a.setNombre(p.getNombre());
        a.setApellido(p.getApellido());
        a.setCorreo(p.getCorreo());
        a.setDireccion(p.getDireccion());
        a.setEstado(p.getEstado());
        a.setContraseña(p.getContraseña());
        a.setTelefono(p.getTelefono());
        a.setTipoUsr(p.getTipoUsr());
        a.setValido(p.isValido());
        this.adminN = invocador.getAdminNegocio(a);
    }
    
    public void iniciarNegocioGerente(Persona p){
        this.adminN = invocador.getAdminNegocio((Administrador)p);
    }
    
    public void iniciarNegocioVendedor(Persona p){
        this.adminN = invocador.getAdminNegocio((Administrador)p);
    }
}
