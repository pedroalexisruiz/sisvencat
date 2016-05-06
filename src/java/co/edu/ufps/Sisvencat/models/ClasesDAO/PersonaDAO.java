package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOPersona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.util.Conexion;
import co.edu.ufps.Sisvencat.models.util.Encriptador;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaDAO implements Serializable, IDAOPersona {

    private Conexion con;
    private boolean conexionAbierta;

    public PersonaDAO(boolean conexionAbierta) {
        this.con = new Conexion();
        this.conexionAbierta = conexionAbierta;
    }

    @Override
    public Persona login(Persona p) throws Exception{

        PreparedStatement stmt = null;
        
        String contrasenaencriptada = new Encriptador().encriptar(p.getContraseña());
        String consulta = "select * from usuario where numDocumento=? AND contrasena=?";
        
        if (!conexionAbierta) {
            con = new Conexion();
            conexionAbierta = true;
        }
        //connect to DB 
        con = new Conexion();
        stmt = con.getConexion().prepareStatement(consulta);
        stmt.setInt(1, p.getCedula());
        stmt.setString(2, contrasenaencriptada);
        ResultSet resultado = stmt.executeQuery(consulta);
        
        boolean more = resultado.next();
        // if user does not exist set the isValid variable to false
        if (!more) {
            p.setValido(false);
        } //if user exists set the isValid variable to true
        else if (more) {
            p.setCedula(resultado.getInt("numDocumento"));
            p.setNombre(resultado.getString("nombre"));
            p.setApellido(resultado.getString("apellido"));
            p.setCorreo(resultado.getString("correo"));
            p.setDireccion(resultado.getString("direccion"));
            p.setEstado(resultado.getInt("estado"));
            p.setTelefono(resultado.getString("telefono"));
            p.setTipoUsr(resultado.getInt("tipoUsuario"));
            p.setEstado(resultado.getInt("estado"));
            p.setValido(true);
        }

        stmt.close();
        resultado.close();

        if (!conexionAbierta) {
            if (con != null) {
                con.close();
            }
        }

        return p;
    }

    @Override
    public boolean modificarDatos(Persona p) throws Exception {

        if (con.getConexion() == null) {
            con = new Conexion();
        }
        PreparedStatement enunciado = con.getConexion().prepareStatement("update persona set "
                + "nombre=?,apellido=?,correo=? WHERE numDocumento=?");

        enunciado.setString(1,p.getNombre());
        enunciado.setString(2,p.getApellido());
        enunciado.setString(3,p.getCorreo());
        enunciado.setInt(4,p.getCedula());
        
        enunciado.execute();

        enunciado.close();
        if (!conexionAbierta) {
            if (con != null) {
                con.close();
            }
        }

        return true;
    }

    @Override
    public boolean cambiarContrasena(Persona p) throws Exception {
        
        if (con.getConexion() == null) {
            con = new Conexion();
        }
        PreparedStatement enunciado = con.getConexion().prepareStatement("update persona set "
                + "contrasena=? WHERE numDocumento=?");
        enunciado.setString(1, p.getContraseña());
        enunciado.setInt(2, p.getCedula());
        enunciado.execute();

        enunciado.close();
        if (!conexionAbierta) {
            if (con != null) {
                con.close();
            }
        }

        return true;
    }
}