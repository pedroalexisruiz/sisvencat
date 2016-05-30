/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Color;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface IAdminNegocio {
    
    //Datos del Admin
    
    public boolean login(Persona p) throws SQLException;
    
    public Administrador getAdmin();
    
    public void setAdmin(Administrador admin);
    
    public Campaña getCampañaActiva();

    public void setCampañaActiva(Campaña campañaActiva);
    
    /**
     * Recibe un Administrador ya con los datos a modificar, y el num de Documento Actual del Administrador 
     * @return un entero con la respuesta que devuelva la DAO: 0 correcto, cualquier
     * otro codigo es el codigo de error de SQL 
     */
    public boolean actualizarDatos(Administrador admin)throws SQLException;
    
    /**
     * Cambia la password del admin
     * @param admin objeto administrador con codigo y password nueva
     * @return codigo de respuesta
     */
    public boolean cambiarPassword(String contrasena, String contrasenanueva)throws SQLException;
    
    //Gestion de campañas
    /**
     * Inicia una campaña
     * @param campaña campaña con todos los datos necesarios
     * @return codigo de respuesta
     */
    public boolean iniciarCampaña(Campaña campaña) throws SQLException, ParseException;
    
    /**
     * Seleccionar Campaña con todos sus datos
     * @param codigoCampaña codigo de la campaña
     * @return campaña seleccionada
     */
    public Campaña getCampaña(String codigoCampaña) throws SQLException;
    
    /**
     * Obtiene el listado de campañas en el sistema
     * @return arraylist de campañas
     */
    public List<Campaña> getListadoDeCampañas()throws SQLException,ParseException ;
    
    public List<Campaña> getListadoDeCampañasPorEstado(int est) throws SQLException,ParseException;
    
    /**
     * Cambia los datos de la campaña, el id NO SE CAMBIA
     * @param campaña recibe la campaña con los datos ya establecidos
     * @return codigo de respuesta
     */
    public int modificarCampaña(Campaña campaña) throws SQLException;
    
    /**
     * Desactiva una campaña cambiando su estado
     * @param campaña campaña con el estado ya modificado
     * @return codigo de respuesta
     */
    public boolean desactivarCampaña() throws SQLException;
    
    //Gestion de Zonas
    /**
     * Inicia una Zona
     * @param zona zona con todos los datos necesarios
     * @return codigo de respuesta
     */
    public boolean registrarZona(Zona zona) throws SQLException;
    
    /**
     * Seleccionar Campaña con todos sus datos
     * @param codigoZona codigo de la zona
     * @return zona seleccionada
     */
    public Zona getZona(int codigoZona) throws SQLException;
    
    /**
     * Obtiene el listado de zonas en el sistema
     * @return arraylist de zonas
     */
    public List<Zona> getListadoDeZonas()throws SQLException;
    
    public List<Zona> getListadoDeZonasPorEstado(int estado)throws SQLException;
    
    /**
     * Cambia los datos de la zona, el id NO SE CAMBIA
     * @param zona recibe la zona con los datos ya establecidos
     * @return codigo de respuesta
     */
    public boolean modificarZona(Zona zona)throws SQLException;
    
    public boolean poseeGerente(int Zona_Codigo_z) throws SQLException;
    
    /**
     * Desactiva una zona cambiando su estado
     * @param zona zona con el estado ya modificado
     * @return codigo de respuesta
     */
    public boolean desactivarZona(Zona zona) throws SQLException;
    
    //Gestion de Gerentes
    /**
     * No recibe nada, me devuelve el listado de todos los Gerentes de zona
     * @return 
     */
    public List<Gerente> getListadoDeGerentes()throws SQLException;
    
    public List<Gerente> getListadoDeGerentesPorEstado(int estado)throws SQLException;
    
    /**
     * Registra un nuevo Gerente 
     * @param gerente
     * @return el codigo de respuesta
     */
    public boolean registrarGerente(Gerente gerente) throws SQLException;
    
    /**
     * Devuelve un Gerente con todos sus datos
     * @param numDocumentoGerente num de Documento del Gerente
     * @return Gerente con todos sus datos
     */
    public Gerente getGerente(String numDocumentoGerente) throws SQLException;
    /**
     * Recibe un Gerente ya con los datos a modificar, y el num de Documento del Gerente Actual
     * @param gerente Gerente con los datos a Modificar ya establecidos
     * @param numDocumento numero Actual de Documento
     * @return un entero con la respuesta que devuelva la DAO: 0 correcto, cualquier
     * otro codigo es el codigo de error de SQL 
     */
    public boolean actualizarGerente(Gerente gerente) throws SQLException;
    
    /**
     * Recibe el Gerente con su estado ya cambiado y retorna en entero la respuesta de la DAO
     * @param gerente
     * @return codigo de respuesta
     */
    public boolean cambiarEstadoGerente(String cedula, int estado) throws SQLException;
    
    
    //Gestion de Vendedors
    /**
     * No recibe nada, me devuelve el listado de todos los Vendedores
     * @return 
     */
    public List<Vendedor> getListadoDeVendedores() throws SQLException;
    
    public List<Vendedor> getListadoDeVendedoresPorEstado(int est) throws SQLException;
    
    /**
     * No recibe nada, me devuelve el listado de todos los Vendedores
     * @return 
     */
    public List<Vendedor> getListadoDeVendedoresPorZona(String codigoZona) throws SQLException;
    /**
     * Registra un nuevo Vendedor 
     * @param vendedor
     * @return el codigo de respuesta
     */
    public int registrarVendedor(Vendedor vendedor) throws SQLException;
    
    /**
     * Devuelve un Vendedor con todos sus datos
     * @param numDocVendedor num de Documento del vendedor
     * @return Vendedor con todos sus datos
     */
    public Vendedor getVendedor(String numDocVendedor) throws SQLException;
    /**
     * Recibe un Vendedor ya con los datos a modificar, y el num de Documento del Vendedor Actual
     * @param vendedor Vendedor con los datos a Modificar ya establecidos
     * @param numDocumento numero Actual de Documento
     * @return un entero con la respuesta que devuelva la DAO: 0 correcto, cualquier
     * otro codigo es el codigo de error de SQL 
     */
    public boolean actualizarVendedor(Vendedor vendedor) throws SQLException;
    
    /**
     * Recibe el Vendedor con su estado ya modificado y retorna en entero la respuesta de la DAO
     * @param vendedor
     * @return codigod e respuesta
     */
    public boolean cambiarEstadoVendedor(String cedula, int estado) throws SQLException;
    
    public List<Premio> getListadoPremios() throws SQLException;

    public Producto getProducto(long codigo_p);

    public List<Categoria> getCategorias()throws SQLException;
    
    public ArrayList<Tipo> getTiposDePrenda()throws SQLException;
    
    public ArrayList<Color> getColores()throws SQLException;
    
    public ArrayList<String> getTallas() throws SQLException;
    
    public boolean modificarProducto(Producto p)throws SQLException;
    
    public boolean insertarImagenDeProducto(ArrayList<String> urls, long codigo_p) throws SQLException;
    
    public boolean modificarPremio(Premio p)throws SQLException;
    
    public boolean insertarImagenDePremio(ArrayList<String> urls, long codigo_p) throws SQLException;
    
    public Premio getPremio(long codig_pre) throws SQLException;
    
    public List<Pedido> getPedidos() throws SQLException, ParseException;
    
    public boolean subirProductos(ArrayList<Producto> productos) throws SQLException;
}
