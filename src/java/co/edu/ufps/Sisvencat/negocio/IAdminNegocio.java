/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.util.ArrayList;
import java.util.List;

public interface IAdminNegocio {
    
    //Datos del Admin
    
    /**
     * Recibe un Administrador ya con los datos a modificar, y el num de Documento Actual del Administrador 
     * @return un entero con la respuesta que devuelva la DAO: 0 correcto, cualquier
     * otro codigo es el codigo de error de SQL 
     */
    public int actualizarDatos(Administrador admin, int numDocumento);
    
    /**
     * Cambia la password del admin
     * @param admin objeto administrador con codigo y password nueva
     * @return codigo de respuesta
     */
    public int cambiarPassword(Administrador admin);
    
    //Gestion de campañas
    /**
     * Inicia una campaña
     * @param campaña campaña con todos los datos necesarios
     * @return codigo de respuesta
     */
    public int iniciarCampaña(Campaña campaña);
    
    /**
     * Seleccionar Campaña con todos sus datos
     * @param codigoCampaña codigo de la campaña
     * @return campaña seleccionada
     */
    public Campaña getCampaña(String codigoCampaña);
    
    /**
     * Obtiene el listado de campañas en el sistema
     * @return arraylist de campañas
     */
    public ArrayList<Campaña> getListadoDeCampañas();
    
    /**
     * Cambia los datos de la campaña, el id NO SE CAMBIA
     * @param campaña recibe la campaña con los datos ya establecidos
     * @return codigo de respuesta
     */
    public int modificarCampaña(Campaña campaña);
    
    /**
     * Desactiva una campaña cambiando su estado
     * @param campaña campaña con el estado ya modificado
     * @return codigo de respuesta
     */
    public int desactivarCampaña(Campaña campaña);
    
    //Gestion de Zonas
    /**
     * Inicia una Zona
     * @param zona zona con todos los datos necesarios
     * @return codigo de respuesta
     */
    public int registrarZona(Zona zona);
    
    /**
     * Seleccionar Campaña con todos sus datos
     * @param codigoZona codigo de la zona
     * @return zona seleccionada
     */
    public Zona getZona(String codigoZona);
    
    /**
     * Obtiene el listado de zonas en el sistema
     * @return arraylist de zonas
     */
    public ArrayList<Zona> getListadoDeZonas();
    
    /**
     * Cambia los datos de la zona, el id NO SE CAMBIA
     * @param zona recibe la zona con los datos ya establecidos
     * @return codigo de respuesta
     */
    public int modificarZona(Zona zona);
    
    /**
     * Desactiva una zona cambiando su estado
     * @param zona zona con el estado ya modificado
     * @return codigo de respuesta
     */
    public int desactivarZona(Zona zona);
    
    //Gestion de Gerentes
    /**
     * No recibe nada, me devuelve el listado de todos los Gerentes de zona
     * @return 
     */
    public List<Gerente> getListadoDeGerentes();
    
    /**
     * Registra un nuevo Gerente 
     * @param gerente
     * @return el codigo de respuesta
     */
    public int registrarGerente(Gerente gerente);
    
    /**
     * Devuelve un Gerente con todos sus datos
     * @param numDocumentoGerente num de Documento del Gerente
     * @return Gerente con todos sus datos
     */
    public Gerente getGerente(String numDocumentoGerente);
    /**
     * Recibe un Gerente ya con los datos a modificar, y el num de Documento del Gerente Actual
     * @param gerente Gerente con los datos a Modificar ya establecidos
     * @param numDocumento numero Actual de Documento
     * @return un entero con la respuesta que devuelva la DAO: 0 correcto, cualquier
     * otro codigo es el codigo de error de SQL 
     */
    public int actualizarGerente(Gerente gerente, int numDocumento);
    
    /**
     * Recibe el Gerente con su estado ya cambiado y retorna en entero la respuesta de la DAO
     * @param gerente
     * @return codigo de respuesta
     */
    public int desactivarGerente(Gerente gerente);
    
    
    //Gestion de Vendedors
    /**
     * No recibe nada, me devuelve el listado de todos los Vendedores
     * @return 
     */
    public List<Vendedor> getListadoDeVendedores();
    
    /**
     * No recibe nada, me devuelve el listado de todos los Vendedores
     * @return 
     */
    public List<Vendedor> getListadoDeVendedoresPorZona(String codigoZona);
    /**
     * Registra un nuevo Vendedor 
     * @param vendedor
     * @return el codigo de respuesta
     */
    public int registrarVendedor(Vendedor vendedor);
    
    /**
     * Devuelve un Vendedor con todos sus datos
     * @param numDocVendedor num de Documento del vendedor
     * @return Vendedor con todos sus datos
     */
    public Vendedor getVendedor(String numDocVendedor);
    /**
     * Recibe un Vendedor ya con los datos a modificar, y el num de Documento del Vendedor Actual
     * @param vendedor Vendedor con los datos a Modificar ya establecidos
     * @param numDocumento numero Actual de Documento
     * @return un entero con la respuesta que devuelva la DAO: 0 correcto, cualquier
     * otro codigo es el codigo de error de SQL 
     */
    public int actualizarVendedor(Vendedor vendedor, int numDocumento);
    
    /**
     * Recibe el Vendedor con su estado ya modificado y retorna en entero la respuesta de la DAO
     * @param vendedor
     * @return codigod e respuesta
     */
    public int desactivarVendedor(Vendedor vendedor);
    
    
}
