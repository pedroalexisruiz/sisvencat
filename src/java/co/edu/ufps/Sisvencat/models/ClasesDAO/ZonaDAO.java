/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOZona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * gestion de los datos de zona
 *
 * @author estudiante
 */
public class ZonaDAO implements Serializable, IDAOZona {

    private Conexion con;

    public ZonaDAO() throws SQLException {
        this.con = new Conexion();
    }

    /**
     * insersion de una zona a la base de datos
     *
     * @param zona objeto zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un
     * error devolvera un -1
     */
    @Override
    public boolean insertar(Zona zona)throws SQLException {

        PreparedStatement state = null;

        try {

            if (con == null) {
                con = new Conexion();
            }

            String insertar = "INSERT INTO zona(Nombre,estado) VALUES(?,1)";
            state = con.getConexion().prepareStatement(insertar);
            state.setString(1, zona.getNombre());
            state.execute();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {
                if (state != null) {
                    state.close();
                }
                if (con != null) {
                    this.closeConn();
                }

            } catch (SQLException ex) {

                throw ex;
            }
        }

        return true;
    }

    /**
     * modifica una zona de la base de datos
     *
     * @param zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un
     * error devolvera un -1
     */
    @Override
    public boolean modificar(Zona zona) throws SQLException {

        PreparedStatement state = null;

        try {

            if (con == null) {
                con = new Conexion();
            }

            String modificar = "UPDATE zona SET Nombre=? WHERE Codigo_z=?";
            state = con.getConexion().prepareStatement(modificar);
            state.setString(1, zona.getNombre());
            state.setInt(2, zona.getCodigo_z());
            state.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {

                state.close();

                this.closeConn();

            } catch (SQLException ex) {
                throw ex;
            }
        }

        return true;
    }

    /**
     * Elimina una zona de la base de datos
     *
     * @param zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un
     * error devolvera un -1
     */
    @Override
    public boolean cambiarEstado(Zona zona) throws SQLException {

        PreparedStatement state = null;

        try {

            if (con == null) {
                con = new Conexion();
            }

            String modificar = "UPDATE zona SET estado=? WHERE Codigo_z=?";
            state = con.getConexion().prepareStatement(modificar);
            state.setInt(1, zona.getEstado());
            state.setInt(2, zona.getCodigo_z());
            state.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {

                state.close();

                this.closeConn();

            } catch (SQLException ex) {
                throw ex;
            }
        }

        return true;
    }

    /**
     * lista todas las zonas que se encuentren en la base de datos
     *
     * @return
     */
    @Override
    public List<Zona> listar() throws SQLException {

        List<Zona> lista = new ArrayList();

        PreparedStatement state = null;

        try {

            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement("SELECT * FROM zona");
            ResultSet resultado = state.executeQuery();

            while (resultado.next()) {
                lista.add(new Zona(resultado.getInt("Codigo_z"), resultado.getString("Nombre"), resultado.getInt("estado")));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {

                state.close();

                this.closeConn();
            } catch (SQLException ex) {
                throw ex;
            } catch (Exception ex) {
                throw ex;
            }
        }

        return lista;
    }

    /**
     * lista de acuerdo a una condicion sql
     *
     * @param where condicion sql ej: Nombre= toledoplata
     * @return una lista condicionada
     */
    @Override
    public List<Zona> listarPorEstado(int estado) throws SQLException {
        List<Zona> lista = new ArrayList();

        PreparedStatement state = null;

        try {

            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement("SELECT * FROM zona WHERE estado=?");
            state.setInt(1, estado);
            ResultSet resultado = state.executeQuery();

            while (resultado.next()) {
                lista.add(new Zona(resultado.getInt("Codigo_z"), resultado.getString("Nombre"), resultado.getInt("estado")));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            try {

                state.close();

                this.closeConn();
            } catch (SQLException ex) {
                throw ex;
            }
        }

        return lista;
    }

    @Override
    public Zona getZona(Zona zona) throws SQLException {

        String consulta = "SELECT * FROM zona WHERE Codigo_z=?";

        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, zona.getCodigo_z());
        ResultSet rs = state.executeQuery();

        Zona z = null;
        while (rs.next()) {
            z = new Zona(rs.getInt("Codigo_z"), rs.getString("Nombre"), rs.getInt("estado"));
        }

        this.closeConn();
        return z;
    }

    @Override
    public void closeConn() throws SQLException {

        con.close();
        con = null;
    }

    @Override
    public boolean poseeGerente(int Zona_Codigo_Z) throws SQLException {

        String consulta = "SELECT * FROM gerente WHERE Codigo_z=?";
        boolean respuesta = false;

        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        state.setInt(1, Zona_Codigo_Z);
        ResultSet rs = state.executeQuery();

        Zona z = null;

        if (rs.next()) {
            respuesta = true;
        }
        rs.close();
        this.closeConn();

        return respuesta;
    }
}
