package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOGerente;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Gerente;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.List;

public class GerenteDAO implements Serializable, IDAOGerente {

    private Conexion con;
    private boolean keepOpenConn;

    public GerenteDAO() {
    }

    public GerenteDAO(boolean keepOpenConn) {
        this.con = new Conexion();
        this.keepOpenConn = keepOpenConn;
    }

    @Override
    public boolean insertar(Gerente ger) throws Exception {
        String sentencia = "INSERT INTO usuario VALUES(?,?,?,?,?,?,?,2,1)";
        String sentencia2 = "INSERT INTO gerente VALUES (?,?)";
        
        if (!keepOpenConn) {
            this.con = new Conexion();
            keepOpenConn = true;
        }

        con.getConexion().setAutoCommit(false);
        
        PreparedStatement state = con.getConexion().prepareStatement(sentencia);
        PreparedStatement state2 = con.getConexion().prepareStatement(sentencia2);
        
        state.setInt(1, ger.getCedula());
        state.setString(2, ger.getNombre());
        state.setString(2, ger.getApellido());
        state.setString(2, ger.getCorreo());
        state.setString(2, ger.getDireccion());
        state.setString(2, ger.getTelefono());
        state.setString(2, ger.getContraseña());
        
        state2.setInt(1, ger.getCedula());
        state2.setInt(2, ger.getZona().getCodigo_z());
        boolean resp = state.execute() && state2.execute();
        
        con.getConexion().commit();
        con.getConexion().setAutoCommit(true);
        
        state.close();
        state2.close();
        
        keepOpenConn = false;
        
        
        if (!keepOpenConn) {
            if (con != null) {
                con.close();
            }
        }

        return resp;
    }

    @Override
    public int modificar(Gerente ger) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Desactivar(Gerente ger) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gerente> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gerente> listar(String where) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean closeConn() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
