package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOGerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Vendedor;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenteDAO implements Serializable, IDAOGerente {

    private Conexion con;

    public GerenteDAO() {
        this.con = new Conexion();
    }

    @Override
    public boolean insertar(Gerente ger) throws SQLException{

        boolean respuesta = false;

        String sentencia = "INSERT INTO persona VALUES(?,?,?,?,?,?,?,2,1)";
        String sentencia2 = "INSERT INTO gerente VALUES (?,?)";
        PreparedStatement state = null;
        PreparedStatement state2 = null;

        if (con == null) {
            con = new Conexion();
        }

        try {
            con.getConexion().setAutoCommit(false);

            state = con.getConexion().prepareStatement(sentencia);
            state2 = con.getConexion().prepareStatement(sentencia2);

            state.setString(1, ger.getCedula());
            state.setString(2, ger.getNombre());
            state.setString(3, ger.getApellido());
            state.setString(4, ger.getCorreo());
            state.setString(5, ger.getDireccion());
            state.setString(6, ger.getTelefono());
            state.setString(7, ger.getContraseña());

            state2.setString(1, ger.getCedula());
            state2.setInt(2, ger.getZona().getCodigo_z());
            state.execute();
            state2.execute();

            con.getConexion().commit();
            con.getConexion().setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error Insertando. Revirtiendo Cambios");
            ex.printStackTrace();
            
            try {
                con.getConexion().rollback();
            } catch (SQLException ex1) {
                System.out.println("Error en el rollback");
                ex1.printStackTrace();
                throw ex1;
            }
            throw ex;
        }
        try {
            state.close();
            state2.close();
            this.closeConn();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return respuesta;
    }

    @Override
    public boolean modificar(Gerente ger) throws SQLException {

        String consulta = "UPDATE persona SET Nombre=?, Apellido=?, Correo=?, Direccion=?, Telefono=? WHERE Cedula=?";

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setString(1, ger.getNombre());
        state.setString(2, ger.getApellido());
        state.setString(3, ger.getCorreo());
        state.setString(4, ger.getDireccion());
        state.setString(5, ger.getTelefono());
        state.setString(6, ger.getCedula());
        state.execute();

        state.close();

        this.closeConn();

        return true;
    }

    @Override
    public boolean cambiarEstado(Gerente ger) throws SQLException {

        String consulta = "UPDATE persona set estado=? WHERE Cedula=?";

        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, ger.getEstado());
        state.setString(2, ger.getCedula());

        state.execute();
        state.close();

        this.closeConn();

        return true;
    }

    @Override
    public List<Gerente> listar() throws SQLException {

        String consulta = "SELECT persona.*,zona.Codigo_z,zona.Nombre AS nombrezona,zona.estado AS estadozona FROM persona INNER JOIN gerente ON "
                + "persona.Cedula=gerente.Cedula INNER JOIN zona ON gerente.Codigo_z=zona.Codigo_z";
        List<Gerente> gerentes = new ArrayList();

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        ResultSet resultado = state.executeQuery();

        while (resultado.next()) {
            Gerente g = new Gerente(null, null, resultado.getString("Cedula"), resultado.getString("Nombre"),
                    resultado.getString("Apellido"), resultado.getString("Correo"),
                    resultado.getString("Direccion"), resultado.getString("Telefono"),
                    resultado.getString("contrasena"), resultado.getInt("TipoUsuario"));

            Zona zona = new Zona(resultado.getInt("Codigo_z"),
                    resultado.getString("nombrezona"), resultado.getInt("estadozona"));
            g.setEstado(resultado.getInt("estado"));
            g.setZona(zona);
            g.setVendedoresAso(this.getVendedoresDeGerente(g));
            gerentes.add(g);
        }

        state.close();
        resultado.close();

        this.closeConn();

        return gerentes;
    }

    @Override
    public List<Vendedor> getVendedoresDeGerente(Gerente ger) throws SQLException {

        List<Vendedor> vendedores = new ArrayList();

        String consulta = "SELECT persona.*,vendedor.Puntaje_Acumulado from persona INNER JOIN vendedor ON persona.Cedula=vendedor.Persona_Cedula WHERE vendedor.Cedula_Gerente=?";

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setString(1, ger.getCedula());
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
        state.closeOnCompletion();

        return vendedores;
    }

    @Override
    public Gerente getGerente(String cedula) throws SQLException {

        String consulta = "SELECT persona.*,zona.Codigo_z,zona.Nombre AS nombrezona,zona.estado AS estadozona FROM persona INNER JOIN gerente ON "
                + "persona.Cedula=gerente.Cedula INNER JOIN zona ON gerente.Codigo_z=zona.Codigo_z WHERE gerente.Cedula=?";

        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setString(1, cedula);

        ResultSet resultado = state.executeQuery();

        Gerente g = null;

        while (resultado.next()) {

            g = new Gerente(null, null, resultado.getString("Cedula"), resultado.getString("Nombre"),
                    resultado.getString("Apellido"), resultado.getString("Correo"),
                    resultado.getString("Direccion"), resultado.getString("Telefono"),
                    resultado.getString("contrasena"), resultado.getInt("TipoUsuario"));
            g.setEstado(resultado.getInt("estado"));
            Zona zona = new Zona(resultado.getInt("Codigo_z"),
                    resultado.getString("nombrezona"), resultado.getInt("estadozona"));
            g.setZona(zona);
            g.setVendedoresAso(this.getVendedoresDeGerente(g));
        }

        state.close();
        resultado.close();

        con.close();

        return g;
    }

    @Override
    public boolean cambiarContraseña(Gerente ger) throws SQLException {

        String consulta = "UPDATE persona SET contrasena=? WHERE cedula=?";

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setString(1, ger.getContraseña());
        state.setString(2, ger.getCedula());
        state.execute();

        state.close();

        con.close();

        return true;
    }

    @Override
    public List<Gerente> listarPorEstado(int estado) throws SQLException {

        List<Gerente> gerentes = new ArrayList();

        String consulta = "SELECT persona.*,zona.Codigo_z,zona.Nombre AS nombrezona,zona.estado AS estadozona FROM persona INNER JOIN gerente ON "
                + "persona.Cedula=gerente.Cedula INNER JOIN zona ON gerente.Codigo_z=zona.Codigo_z WHERE persona.estado=?";

        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, estado);
        ResultSet rs = state.executeQuery();
        Gerente gerente = null;

        while (rs.next()) {

            gerente = new Gerente(null, null, rs.getString("Cedula"),
                    rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Correo"),
                    rs.getString("Direccion"), rs.getString("Telefono"), rs.getString("contrasena"),
                    rs.getInt("TipoUsuario"));
            gerente.setEstado(rs.getInt("estado"));
            Zona zona = new Zona(rs.getInt("Codigo_z"),
                    rs.getString("nombrezona"), rs.getInt("estadozona"));
            gerente.setZona(zona);
            gerente.setVendedoresAso(this.getVendedoresDeGerente(gerente));
            gerentes.add(gerente);
        }

        state.close();
        rs.close();

        con.close();

        return gerentes;
    }

    @Override
    public void closeConn(){
        con.close();
        con = null;
    }
}
