package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOPersona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import co.edu.ufps.Sisvencat.models.util.Encriptador;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO implements Serializable, IDAOPersona {

    private Conexion con;

    public PersonaDAO() {
        this.con = new Conexion();
    }

    @Override
    public Persona login(Persona p) throws SQLException{

        
        String contrasenaencriptada = new Encriptador().encriptar(p.getContraseña());
        String consulta = "SELECT * FROM persona WHERE Cedula=? AND contrasena=?";
        
        if (con == null) {
            con = new Conexion();
        }

        PreparedStatement state = con.getConexion().prepareStatement(consulta);
        
        state.setString(1, p.getCedula());
        state.setString(2, p.getContraseña());
        
        ResultSet resultado = state.executeQuery();
        
        boolean more = resultado.next();
        // if user does not exist set the isValid variable to false
        if (!more) {
            p.setValido(false);
        } //if user exists set the isValid variable to true
        else if (more) {
            p.setCedula(resultado.getString("Cedula"));
            p.setNombre(resultado.getString("Nombre"));
            p.setApellido(resultado.getString("Apellido"));
            p.setCorreo(resultado.getString("Correo"));
            p.setDireccion(resultado.getString("Direccion"));
            p.setTelefono(resultado.getString("Telefono"));
            p.setTipoUsr(resultado.getInt("TipoUsuario"));
            p.setEstado(resultado.getInt("estado"));
            p.setValido(true);
        }

        state.close();
        resultado.close();

        this.closeConn();

        return p;
    }

    @Override
    public boolean modificarDatos(Persona p, int cedula) throws SQLException {

        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement enunciado = con.getConexion().prepareStatement("update persona set "
                + "Nombre=?,Apellido=?,Correo=?, Cedula=? WHERE Cedula=?");

        enunciado.setString(1,p.getNombre());
        enunciado.setString(2,p.getApellido());
        enunciado.setString(3,p.getCorreo());
        enunciado.setString(4,p.getCedula());
        enunciado.setInt(5, cedula);
        
        enunciado.execute();

        enunciado.close();
        this.closeConn();

        return true;
    }

    @Override
    public boolean cambiarContrasena(Persona p) throws Exception {
        
        if (con == null) {
            con = new Conexion();
        }
        PreparedStatement enunciado = con.getConexion().prepareStatement("update persona set "
                + "contrasena=? WHERE numDocumento=?");
        enunciado.setString(1, p.getContraseña());
        enunciado.setString(2, p.getCedula());
        enunciado.execute();

        enunciado.close();
        
        this.closeConn();

        return true;
    }
    
    @Override
    public void closeConn(){

        con.close();
        con = null;

    }
}