/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOVendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class VendedorDAO implements Serializable, IDAOVendedor {

    private Conexion con;

    public VendedorDAO() {
        this.con = new Conexion();
    }
    
    @Override
    public int insertar(Vendedor ven, Gerente ger){
        
        int respuesta = 0;
        
        String consulta1 = "INSERT INTO persona VALUES(?,?,?,?,?,?,?,3,1)";
        String consulta2= "INSERT INTO vendedor VALUES(?,?,0)";
        
        PreparedStatement state = null;
        PreparedStatement state2 = null;
        
        if (con == null) {
            con = new Conexion();
        }
        
        try {
            con.getConexion().setAutoCommit(false);
            
            state = con.getConexion().prepareStatement(consulta1);
            state.setInt(1, ven.getCedula());
            state.setString(2, ven.getNombre());
            state.setString(3, ven.getApellido());
            state.setString(4, ven.getCorreo());
            state.setString(5, ven.getDireccion());
            state.setString(6, ven.getTelefono());
            state.setString(7, ven.getContraseña());
            state.execute();
            
            state2 = con.getConexion().prepareStatement(consulta2);
            state2.setInt(1, ven.getCedula());
            state2.setInt(2, ger.getCedula());
            state2.execute();
            
            con.getConexion().commit();
            
        } catch (SQLException ex) {
            System.out.println("Error Insertando Vendedor. Revirtiendo Cambios");
            System.out.println(ex.getMessage());
            try {
                con.getConexion().rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
        }

        try {
            state.close();
            state2.close();
            this.closeConn();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return respuesta;
        
   }

    @Override
    public boolean modificar(Vendedor ven) throws Exception {
        
        String consulta = "UPDATE persona SET Nombre=?, Apellido=?, Correo=?, Direccion=?, Telefono=? WHERE cedula=?";
        
        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setString(1, ven.getNombre());
        state.setString(2, ven.getApellido());
        state.setString(3, ven.getCorreo());
        state.setString(4, ven.getDireccion());
        state.setString(5, ven.getTelefono());
        state.setInt(6, ven.getCedula());
        state.execute();
        
        state.close();
        
        this.closeConn();
        
        return true;
    }
    
    @Override
    public boolean cambiarContraseña(Vendedor ven) throws Exception {
        
        String consulta = "UPDATE persona SET contrasena=?";
        
        if (con == null) {
            con = new Conexion();
        }
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setString(1, ven.getContraseña());

        state.execute();
        
        state.close();
        
        this.closeConn();
        
        return true;
    }

    @Override
    public boolean cambiarEstado(Vendedor ven) throws Exception {
        
        String consulta = "UPDATE persona SET estado=? WHERE Cedula=?";
        
        
        if (con == null) {
            con = new Conexion();
        }
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, 2);
        state.setInt(2, ven.getCedula());
        state.execute();
        
        state.close();
        
        this.closeConn();
        
        return true;
    }

    @Override
    public List<Vendedor> listar() throws Exception {
        
        List<Vendedor> vendedores = new ArrayList();
        
        String consulta ="SELECT persona.*,vendedor.Puntaje_Acumulado from persona INNER JOIN vendedor ON persona.Cedula=vendedor.Persona_Cedula";
        
        if (con == null) {
            con = new Conexion();
        }
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        ResultSet rs = state.executeQuery();
        Vendedor vendedor = null;
        
        while(rs.next()){
            
            vendedor = new Vendedor(rs.getInt("Puntaje_Acumulado"),rs.getInt("Cedula"),
                    rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Correo"),
                    rs.getString("Direccion"),rs.getString("Telefono"),rs.getString("contrasena"),
                    rs.getInt("TipoUsuario"));
            vendedor.setEstado(rs.getInt("estado"));
            vendedores.add(vendedor);
        }
        
        state.close();
        rs.close();
        
        this.closeConn();
        
        return vendedores;
    }
    
    
    @Override
    public List<Vendedor> listarPorEstado(int estado) throws Exception {
        
        List<Vendedor> vendedores = null;
        
        String consulta ="SELECT persona.*,vendedor.Puntaje_Acumulado from persona INNER JOIN vendedor ON persona.Cedula=vendedor.Persona_Cedula WHERE persona.estado=?";
        
        if (con == null) {
            con = new Conexion();
        }
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, estado);
        ResultSet rs = state.executeQuery();
        Vendedor vendedor = null;
        
        while(rs.next()){
            vendedores = new ArrayList();
            vendedor = new Vendedor(rs.getInt("Puntaje_Acumulado"),rs.getInt("Cedula"),
                    rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Correo"),
                    rs.getString("Direccion"),rs.getString("Telefono"),rs.getString("contrasena"),
                    rs.getInt("TipoUsuario"));
            vendedor.setEstado(rs.getInt("estado"));
            vendedores.add(vendedor);
        }
        
        state.close();
        rs.close();
        
        this.closeConn();
        
        return vendedores;
    }

    @Override
    public Vendedor getVendedor(Vendedor ven) throws Exception {
        
        Vendedor vendedor = new Vendedor();
        
        String consulta = "SELECT persona.*,vendedor.Puntaje_Acumulado FROM persona INNER JOIN vendedor ON persona.Cedula=vendedor.Persona_Cedula WHERE vendedor.Persona_Cedula=?";
        
        if (con == null) {
            con = new Conexion();
        }
        
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, ven.getCedula());
        ResultSet rs = state.executeQuery();
        
        while(rs.next()){
            vendedor = new Vendedor(rs.getInt("Puntaje_Acumulado"),rs.getInt("Cedula"),
                    rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Correo"),
                    rs.getString("Direccion"),rs.getString("Telefono"),rs.getString("contrasena"),
                    rs.getInt("TipoUsuario"));
            vendedor.setEstado(rs.getInt("estado"));
        }
        
        state.close();
        rs.close();
        
        this.closeConn();
        
        return vendedor;
    }

    @Override
    public void closeConn() throws Exception {
        
        con.close();
        con = null;
        
    }
}