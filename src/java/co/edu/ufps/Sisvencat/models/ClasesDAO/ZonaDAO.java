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
    
    
    /**
     * insersion de una zona a la base de datos
     * @param zona objeto zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un 
     * error devolvera un -1
     */
    @Override
    public int insertar(Zona zona) {
        Conexion con= new Conexion();
        int cols = -1;
        try{
            con.CargaEnunciado("INSERT INTO `zona`(`Codigo_z`, `Nombre`) VALUES (?,?)");
            con.getEnunciado().setInt(1, zona.getCodigo_z());
            con.getEnunciado().setString(2, zona.getNombre());
            cols=con.getEnunciado().executeUpdate();
            
        }
       catch(SQLException e){
           System.out.println(e.getMessage());
           cols=-1;
       }
       finally{
            con.close();
        }
       return cols;
    }
    /**
     * modifica una zona de la base de datos
     * @param zona 
     * @return retorna la catidad de filas afectadas en caso de que ocurra 
     * un error devolvera un -1 
     */
    @Override
    public int modificar(Zona zona) {
        Conexion con= new Conexion();
        int cols = -1;
        try{
            con.CargaEnunciado("UPDATE `zona` SET `Codigo_z`=?,`Nombre`=?");
            con.getEnunciado().setInt(1, zona.getCodigo_z());
            con.getEnunciado().setString(2, zona.getNombre());
            cols=con.getEnunciado().executeUpdate();
            
        }
       catch(SQLException e){
           System.out.println(e.getMessage());
           cols=-1;
       }
       finally{
            con.close();
        }
       return cols;
    }
    /**
     * Elimina una zona de la base de datos
     * @param zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un 
     * error devolvera un -1
     */
    @Override
    public int eliminar(Zona zona) {
        Conexion con= new Conexion();
        int cols = -1;
        try{
            con.CargaEnunciado("DELETE FROM `zona` WHERE Codigo_z=?");
            con.getEnunciado().setInt(1, zona.getCodigo_z());
            cols=con.getEnunciado().executeUpdate();
        }
        catch(SQLException e){
           System.out.println(e.getMessage());
           cols=-1;
       }
        finally{
            con.close();
        }
       return cols;
    }
    /**
     * lista todas las zonas que se encuentren en la base de datos
     * @return 
     */
    @Override
    public List<Zona> listar() {
        List<Zona> lista= new ArrayList();
        Conexion con=new Conexion();
        ResultSet res= con.select("*", "zona", "");
        try{
            while(res.next()){
                Zona zona=new Zona();
                zona.setCodigo_z(res.getInt(1));
                zona.setNombre(res.getString(2));
                lista.add(zona);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            con.close();
        }
           
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
        Conexion con=new Conexion();
        ResultSet res= con.select("*", "zona",where);
        try{
            while(res.next()){
                Zona zona=new Zona();
                zona.setCodigo_z(res.getInt(1));
                zona.setNombre(res.getString(2));
                lista.add(zona);
            }
            
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        finally{
            con.close();
        }
           
        return lista;
    }

   
    

    
}
