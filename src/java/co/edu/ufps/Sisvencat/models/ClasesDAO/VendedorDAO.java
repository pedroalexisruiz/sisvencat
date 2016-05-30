/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOVendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Pedido;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import co.edu.ufps.Sisvencat.models.util.Encriptador;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class VendedorDAO implements Serializable, IDAOVendedor {

    private Conexion con;

    public VendedorDAO() throws SQLException {
        this.con = new Conexion();
    }

    @Override
    public boolean registrar(Vendedor ven, Gerente ger) throws SQLException {

        String consulta1 = "INSERT INTO persona VALUES(?,?,?,?,?,?,?,3,1)";
        String consulta2 = "INSERT INTO vendedor VALUES(?,?,?)";

        PreparedStatement state = null;
        PreparedStatement state2 = null;

        if (con == null) {
            con = new Conexion();
        }

        try {
            con.getConexion().setAutoCommit(false);

            state = con.getConexion().prepareStatement(consulta1);
            state.setString(1, ven.getCedula());
            state.setString(2, ven.getNombre());
            state.setString(3, ven.getApellido());
            state.setString(4, ven.getCorreo());
            state.setString(5, ven.getDireccion());
            state.setString(6, ven.getTelefono());
            state.setString(7, ven.getContraseña());
            state.execute();

            state2 = con.getConexion().prepareStatement(consulta2);
            state2.setString(1, ven.getCedula());
            state2.setString(2, ger.getCedula());
            state2.setInt(3, ven.getPuntajeAcumulado());
            state2.execute();

            con.getConexion().commit();

        } catch (SQLException ex) {
            System.out.println("Error Insertando Vendedor. Revirtiendo Cambios");
            System.out.println(ex.getMessage());
            try {
                con.getConexion().rollback();
            } catch (SQLException ex1) {
                System.out.println("Error Durante el Rollback");
                ex1.printStackTrace();
                throw ex1;
            }
            ex.printStackTrace();
            throw ex;
        } finally {
            if (state != null) {
                state.close();
            }
            if (state2 != null) {
                state2.close();
            }
            if (con != null) {
                this.closeConn();
            }

        }

        System.out.println("esto es una prueba");

        return true;

    }

    @Override
    public boolean modificar(Vendedor ven) throws SQLException {

        String consulta = "UPDATE persona SET Nombre=?, Apellido=?, Correo=?, Direccion=?, Telefono=? WHERE cedula=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setString(1, ven.getNombre());
            state.setString(2, ven.getApellido());
            state.setString(3, ven.getCorreo());
            state.setString(4, ven.getDireccion());
            state.setString(5, ven.getTelefono());
            state.setString(6, ven.getCedula());
            state.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return true;
    }

    @Override
    public boolean descontarPuntos(String cedula, int puntos) throws SQLException {

        String consulta = "UPDATE vendedor SET Puntaje_Acumulado=? WHERE Persona_Cedula=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setInt(1, puntos);
            state.setString(2, cedula);
            state.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return true;
    }

    @Override
    public boolean cambiarContraseña(Vendedor ven) throws SQLException {

        String consulta = "UPDATE persona SET contrasena=? WHERE Cedula=?";
        PreparedStatement state = null;

        try {

            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setString(1, new Encriptador().encriptar(ven.getContraseña()));
            state.setString(2, ven.getCedula());

            state.execute();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return true;
    }

    @Override
    public boolean cambiarEstado(Vendedor ven) throws SQLException {

        String consulta = "UPDATE persona SET estado=? WHERE Cedula=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setInt(1, ven.getEstado());
            state.setString(2, ven.getCedula());
            state.execute();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return true;
    }

    @Override
    public List<Vendedor> listar() throws SQLException {

        List<Vendedor> vendedores = new ArrayList();

        String consulta = "SELECT persona.*,vendedor.Puntaje_Acumulado from persona INNER JOIN vendedor ON persona.Cedula=vendedor.Persona_Cedula";
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            rs = state.executeQuery();
            Vendedor vendedor = null;

            while (rs.next()) {

                vendedor = new Vendedor(rs.getInt("Puntaje_Acumulado"), rs.getString("Cedula"),
                        rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"),
                        rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("contrasena"),
                        rs.getInt("TipoUsuario"));
                vendedor.setEstado(rs.getInt("estado"));
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (state != null) {
                state.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                this.closeConn();
            }
        }

        return vendedores;
    }

    @Override
    public List<Vendedor> listarPorEstado(int estado) throws SQLException {

        List<Vendedor> vendedores = new ArrayList();

        String consulta = "SELECT persona.*,vendedor.Puntaje_Acumulado from persona INNER JOIN vendedor ON persona.Cedula=vendedor.Persona_Cedula WHERE persona.estado=?";

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, estado);
        ResultSet rs = state.executeQuery();
        Vendedor vendedor = null;

        while (rs.next()) {
            vendedor = new Vendedor(rs.getInt("Puntaje_Acumulado"), rs.getString("Cedula"),
                    rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"),
                    rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("contrasena"),
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
    public Vendedor getVendedor(String cedula) throws SQLException {

        Vendedor vendedor = new Vendedor();

        String consulta = "SELECT persona.*,vendedor.Puntaje_Acumulado FROM persona INNER JOIN vendedor ON persona.Cedula=vendedor.Persona_Cedula WHERE vendedor.Persona_Cedula=?";

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setString(1, cedula);
        ResultSet rs = state.executeQuery();

        while (rs.next()) {
            vendedor = new Vendedor(rs.getInt("Puntaje_Acumulado"), rs.getString("Cedula"),
                    rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"),
                    rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("contrasena"),
                    rs.getInt("TipoUsuario"));
            vendedor.setEstado(rs.getInt("estado"));
        }

        state.close();
        rs.close();

        this.closeConn();

        return vendedor;
    }

    @Override
    public Vendedor getVendedorCompleto(String cedula, long codigo_cam) throws SQLException, ParseException {

        Vendedor vendedor = new Vendedor();

        String consulta = "SELECT persona.*,vendedor.Puntaje_Acumulado FROM persona INNER JOIN vendedor ON persona.Cedula=vendedor.Persona_Cedula WHERE vendedor.Persona_Cedula=?";

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setString(1, cedula);
        ResultSet rs = state.executeQuery();

        while (rs.next()) {
            vendedor = new Vendedor(rs.getInt("Puntaje_Acumulado"), rs.getString("Cedula"),
                    rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"),
                    rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("contrasena"),
                    rs.getInt("TipoUsuario"));
            vendedor.setEstado(rs.getInt("estado"));
            if (codigo_cam != 0) {
                vendedor.setPremio(new PremioDAO().getPremioPorVendedor(cedula, codigo_cam));
                vendedor.setPedido(new PedidoDAO().getPedidoDelVendedor(cedula, codigo_cam));
            }

        }

        state.close();
        rs.close();

        this.closeConn();

        return vendedor;
    }

    @Override
    public void closeConn() throws SQLException {

        con.close();
        con = null;

    }
}
