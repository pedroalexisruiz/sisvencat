/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOPremio;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Premio;
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
public class PremioDAO implements Serializable, IDAOPremio {

    private Conexion con;

    public PremioDAO() throws SQLException {
        this.con = new Conexion();
    }

    @Override
    public boolean insertar(Premio pre) throws SQLException {
        
        String consulta = "INSERT INTO premio(Nombre_Premio,Descripcion,Punto_requerido,CantDisponible) VALUES(?,?,?,?)";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setString(1, pre.getNombre());
            state.setString(2, pre.getDescripcion());
            state.setInt(3, pre.getPuntosRequeridos());
            state.setInt(4, pre.getCantidadDisponible());
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
    public boolean modificar(Premio pre) throws SQLException {

        String consulta = "UPDATE premio SET Nombre_Premio=?, Descripcion=?,Punto_requerido=?, CantDisponible=? WHERE Codigo_prem=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pre.getCodigo_premio());
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
    public boolean eliminar(Premio pre) throws SQLException {

        String consulta = "DELETE FROM imagenesdepremios WHERE Codigo_prem=?";
        String consulta2 = "DELETE FROM premio WHERE Codigo_prem=?";

        PreparedStatement state = null;
        PreparedStatement state2 = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            con.getConexion().setAutoCommit(false);
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pre.getCodigo_premio());
            state2 = con.getConexion().prepareStatement(consulta2);
            state2.setLong(1, pre.getCodigo_premio());
            state.execute();
            state2.execute();
            con.getConexion().commit();
        } catch (SQLException e) {

            if (con != null) {
                try {
                    System.out.println("Error en la transacción revirtiendo cambios");
                    con.getConexion().rollback();
                } catch (SQLException ex) {
                    throw ex;
                }
            }
            throw e;
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

        return true;
    }

    @Override
    public List<Premio> listar() throws SQLException {

        String consulta = "SELECT * FROM premio";

        List<Premio> premios = new ArrayList();

        PreparedStatement state = con.getConexion().prepareStatement(consulta);

        ResultSet rs = state.executeQuery();

        Premio premio = null;

        while (rs.next()) {
            premio = new Premio(rs.getLong("Codigo_prem"), rs.getString("Nombre_Premio"), rs.getString("Descripcion"),
                    rs.getInt("Punto_requerido"), rs.getInt("CantDisponible"), null);
            premio.setImagenes(new ImagenPremioDAO().getImagenesPremio(premio));
            premios.add(premio);
        }

        return premios;
    }

    @Override
    public List<Premio> listarDisponiblesoNo(boolean dispon) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Premio getPremio(Premio pre) throws SQLException {

        String consulta = "SELECT * FROM premio WHERE Codigo_prem=? LIMIT 1";
        PreparedStatement state = null;
        ResultSet rs = null;
        Premio premio = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setLong(1, pre.getCodigo_premio());
            rs = state.executeQuery();

            while (rs.next()) {
                premio = new Premio(rs.getLong("Codigo_prem"), rs.getString("Nombre_Premio"), rs.getString("Descripcion"),
                        rs.getInt("Punto_requerido"), rs.getInt("CantDisponible"), null);
                premio.setImagenes(new ImagenPremioDAO().getImagenesPremio(premio));
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

        return premio;
    }

    
    @Override
    public boolean insertarPorVendedor(Premio pre, String cedula, long codigo_cam) throws SQLException {
        
        String consulta = "INSERT INTO premioporvendedor VALUES(?,?,?)";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setString(1, pre.getNombre());
            state.setString(2, cedula);
            state.setLong(3, codigo_cam);
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
    public Premio getPremioPorVendedor(String cedula, long Codigo_cam) throws SQLException {

        String consulta = "SELECT premio.* FROM premio INNER JOIN premioporvendedor ON "
                + "premio.Codigo_prem=premioporvendedor.Codigo_prem WHERE premioporvendedor.Persona_Cedula=? AND premioporvendedor.Codigo_cam=? LIMIT 1";
        PreparedStatement state = null;
        ResultSet rs = null;
        Premio premio = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            state.setString(1, cedula);
            state.setLong(2, Codigo_cam);
            rs = state.executeQuery();

            while (rs.next()) {
                premio = new Premio(rs.getLong("Codigo_prem"), rs.getString("Nombre_Premio"), rs.getString("Descripcion"),
                        rs.getInt("Punto_requerido"), rs.getInt("CantDisponible"), null);
                premio.setImagenes(new ImagenPremioDAO().getImagenesPremio(premio));
            }

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

        return premio;
    }

    @Override
    public void closeConn() throws SQLException {
        con.close();
        con =null;
    }
}