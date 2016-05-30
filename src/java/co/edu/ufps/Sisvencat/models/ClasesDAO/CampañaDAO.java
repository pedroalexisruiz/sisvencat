package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOCampana;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Clase DAO de las Campañas, realiza todas las operaciones relacionadas con las
 * campañas en la base de datos
 *
 * @author Administrador
 */
public class CampañaDAO implements Serializable, IDAOCampana {

    private Conexion con;
    public static final DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public CampañaDAO() throws SQLException {
        con = new Conexion();
    }

    @Override
    public boolean iniciarCampaña(Campaña cam) throws SQLException {

        String consulta = "INSERT INTO campana (Fecha_inicio, Fecha_fin,Estado,Tema)VALUES(?,?,1,?)";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }
            state = con.getConexion().prepareStatement(consulta);
            String fechain = formater.format(cam.getFechaIni().getTime());
            String fechafin = formater.format(cam.getFechaFin().getTime());

            state.setString(1, fechain);
            state.setString(2, fechafin);
            state.setString(3, cam.getTema());

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
    public boolean finalizarCampaña(Campaña cam) throws SQLException {

        String consulta = "UPDATE campana set Estado=? WHERE Codigo_cam=?";
        PreparedStatement state = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setInt(1, 2);
            state.setLong(2, cam.getCodigo_cam());
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
    public List<Campaña> listarCampañas() throws SQLException, ParseException {

        List<Campaña> campañas = new ArrayList();

        String consulta = "SELECT * FROM campana";
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);

            rs = state.executeQuery();
            Campaña campaña = null;

            while (rs.next()) {

                Calendar fechain = Calendar.getInstance();
                fechain.setTime(formater.parse(rs.getString("Fecha_inicio")));

                Calendar fechafin = Calendar.getInstance();
                fechafin.setTime(formater.parse(rs.getString("Fecha_fin")));

                campaña = new Campaña(fechain, fechafin, rs.getString("Tema"));
                campaña.setCodigo_cam(rs.getInt("Codigo_cam"));
                campaña.setEstado(rs.getInt("Estado"));
                campaña.setProductos(new ProductoDAO().listarPorCampaña(campaña));

                campañas.add(campaña);
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

        return campañas;
    }

    @Override
    public List<Campaña> listarCampañasPorEstado(int estado) throws SQLException, ParseException {

        List<Campaña> campañas = new ArrayList();

        String consulta = "SELECT * FROM campana WHERE Estado=?";
        PreparedStatement state = null;
        ResultSet rs = null;

        try {
            if (con == null) {
                con = new Conexion();
            }

            state = con.getConexion().prepareStatement(consulta);
            state.setInt(1, estado);

            rs = state.executeQuery();
            Campaña campaña = null;

            while (rs.next()) {

                Calendar fechain = Calendar.getInstance();
                fechain.setTime(formater.parse(rs.getString("Fecha_inicio")));

                Calendar fechafin = Calendar.getInstance();
                fechafin.setTime(formater.parse(rs.getString("Fecha_fin")));

                campaña = new Campaña(fechain, fechafin, rs.getString("Tema"));
                campaña.setCodigo_cam(rs.getInt("Codigo_cam"));
                campaña.setEstado(rs.getInt("Estado"));
                campaña.setProductos(new ProductoDAO().listarPorCampaña(campaña));

                campañas.add(campaña);
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

        return campañas;
    }

    @Override
    public Campaña getCampaña(Campaña cam) throws SQLException, ParseException {

        String consulta = "SELECT * FROM campana WHERE Codigo_cam=?";
        Campaña campaña = null;

        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement state = con.getConexion().prepareStatement(consulta);

        state.setLong(1, cam.getCodigo_cam());
        ResultSet rs = state.executeQuery();

        while (rs.next()) {
            Calendar fechain = Calendar.getInstance();
            fechain.setTime(formater.parse(rs.getString("Fecha_inicio")));

            Calendar fechafin = Calendar.getInstance();
            fechafin.setTime(formater.parse(rs.getString("Fecha_fin")));

            campaña = new Campaña(fechain, fechafin, rs.getString("Tema"));
            campaña.setCodigo_cam(rs.getInt("Codigo_cam"));
            campaña.setEstado(rs.getInt("Estado"));
            campaña.setProductos(new ProductoDAO().listarPorCampaña(cam));
        }

        state.close();
        rs.close();

        this.closeConn();

        return campaña;
    }

    @Override
    public void closeConn() throws SQLException {

        con.close();
        con = null;

    }
}
