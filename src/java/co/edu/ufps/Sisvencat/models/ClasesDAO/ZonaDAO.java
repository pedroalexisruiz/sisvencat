/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOZona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *gestion de los datos de zona
 * @author estudiante
 */
public class ZonaDAO implements IDAOZona{
    
    private Conexion con;
    private boolean keepOpenConn;

    public ZonaDAO() {
    }
    
    public ZonaDAO(boolean keepOpenConn) {
        this.con = new Conexion();
    }

    /**
     * insersion de una zona a la base de datos
     * @param zona objeto zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un 
     * error devolvera un -1
     */
    @Override
    public int insertar(Zona zona) {

       return 0;
    }
    /**
     * modifica una zona de la base de datos
     * @param zona 
     * @return retorna la catidad de filas afectadas en caso de que ocurra 
     * un error devolvera un -1 
     */
    @Override
    public int modificar(Zona zona) {

       return 0;
    }
    /**
     * Elimina una zona de la base de datos
     * @param zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un 
     * error devolvera un -1
     */
    @Override
    public int Desactivar(Zona zona) {
        
       return 0;
    }
    /**
     * lista todas las zonas que se encuentren en la base de datos
     * @return 
     */
    @Override
    public List<Zona> listar() {
        List<Zona> lista= new ArrayList();
           
        return lista;
    }
    /**
     * lista de acuerdo a una condicion sql
     * @param where condicion sql ej: Nombre= toledoplata
     * @return una lista condicionada
     */
    @Override
    public List<Zona> listar(String where) {
        List<Zona> lista= new ArrayList();

           
        return lista;
    }
    
    @Override
    public boolean closeConn() throws Exception {
        
        con.close();
        con = null;
        keepOpenConn = false;

        return keepOpenConn;
    }
}