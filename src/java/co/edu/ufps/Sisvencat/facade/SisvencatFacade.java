
package co.edu.ufps.Sisvencat.facade;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.util.Encriptador;
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

        this.adminN = invocador.getAdminNegocio(p);
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
        this.vendedorN = null;
    }
    
    public boolean existeNegocioGerente(){
        return this.gerenteN!=null;
    }
    
    public Gerente getGerenteLogeado(){
        return this.gerenteN.getGerente();
    }
    
    public boolean modificarDatosGerente(String nombre,String apellido,String correo,String direccion,String telefono) throws SQLException{
        
        Gerente gerente = this.gerenteN.getGerente();
        gerente.setNombre(nombre);
        gerente.setApellido(apellido);
        gerente.setCorreo(correo);
        gerente.setDireccion(direccion);
        gerente.setTelefono(telefono);
        
        if(this.gerenteN.actualizarDatos(gerente)){
            this.gerenteN.setGerente(gerente);
            return true;
        }
        
        return false;
    }
    
    public boolean cambiarContraseñaGerente(String contrasena, String contrasenanueva) throws SQLException{
        return this.gerenteN.cambiarPassword(contrasena, contrasenanueva);
    }
    
    public void iniciarNegocioVendedor(String cedula) throws SQLException{
        this.vendedorN = invocador.getVendedorNegocio(cedula);
        this.generalN= null;
        this.adminN = null;
        this.gerenteN = null;
    }
    
    public boolean existeNegocioVendedor(){
        return this.vendedorN!=null;
    }
    
    public boolean registrarVendedor(int PuntajeAcumulado, String cedula, String nombre, String Apellido, String correo, String Direccion, String telefono, String contraseña) throws SQLException{
        
        Vendedor vendedor = new Vendedor(PuntajeAcumulado,cedula,nombre,Apellido,correo,Direccion,telefono,Encriptador.encriptar(contraseña),3);
        return this.gerenteN.registrarVendedor(vendedor);
    }
    
    public Vendedor getVendedorLogeado(){
        return this.vendedorN.getVendedor();
    }
    
    public boolean modificarDatosVendedor(String nombre,String apellido,String correo,String direccion,String telefono) throws SQLException{
        
        Vendedor vendedor = this.vendedorN.getVendedor();
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCorreo(correo);
        vendedor.setDireccion(direccion);
        vendedor.setTelefono(telefono);
        
        if(this.vendedorN.actualizarDatos(vendedor)){
            this.vendedorN.setVendedor(vendedor);
            return true;
        }
        
        return false;
    }
    
    public boolean cambiarContraseñaVendedor(String contrasena, String contrasenanueva) throws SQLException{
        return this.vendedorN.cambiarPassword(contrasena, contrasenanueva);
    }
}
