/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOAdministrador;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Administrador;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author estudiante
 */
public class AdministradorDAO implements Serializable, IDAOAdministrador{

    private Conexion con;

    public AdministradorDAO() {
        this.con = new Conexion();
    }
    
    @Override
    public Administrador login(Administrador a) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarDatos(Administrador a) throws SQLException {
        
        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement enunciado = con.getConexion().prepareStatement("UPDATE persona SET "
                + "Nombre=?,Apellido=?,Correo=?, Direccion=?, Telefono=? WHERE Cedula=?");

        enunciado.setString(1,a.getNombre());
        enunciado.setString(2,a.getApellido());
        enunciado.setString(3,a.getCorreo());
        enunciado.setString(4,a.getDireccion());
        enunciado.setString(5,a.getTelefono());
        enunciado.setString(6,a.getCedula());
        
        enunciado.execute();

        enunciado.close();
        this.closeConn();

        return true;
    }

    @Override
    public boolean cambiarContrasena(Administrador a) throws SQLException {
        
        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement enunciado = con.getConexion().prepareStatement("UPDATE persona SET "
                + "contrasena=? WHERE Cedula=?");

        enunciado.setString(1,a.getContraseña());
        enunciado.setString(2,a.getCedula());
        
        enunciado.execute();

        enunciado.close();
        this.closeConn();

        return true;
    }

    @Override
    public void closeConn() {
        con.close();
        con = null;
    }
    
}
