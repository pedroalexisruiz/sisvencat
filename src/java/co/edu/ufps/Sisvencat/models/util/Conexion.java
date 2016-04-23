package co.edu.ufps.Sisvencat.models.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clase para conectar, cerrar y gestionar las bases de datos
 * @author oso
 */
public class Conexion {

    private Statement consulta;
    private ResultSet resultado;
    private PreparedStatement enunciado;
    private Connection conexion;
    private final String db_url = "jdbc:mysql://sandbox2.ufps.edu.co/ufps_98";
    private final String db_driver = "com.mysql.jdbc.Driver";
    private final String db_username = "ufps_98";
    private final String db_password = "ufps_98";
    /**
     * además de crear el objeto sde genera la conexion y se crea la consulta
     */
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(db_url, db_username, db_password);
            consulta = conexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * cierra la conexion a la base de datos.
     */
    public void close() {
        if (resultado != null) {
            try {
                resultado.close();
            } catch (Exception e) {
            }
            resultado = null;
        }

        if (consulta != null) {
            try {
                consulta.close();
            } catch (Exception e) {
            }
            consulta = null;
        }

        if (enunciado != null) {
            try {
                enunciado.close();
            } catch (Exception e) {
            }
            enunciado = null;
        }

        if (conexion != null) {
            try {
                conexion.close();
            } catch (Exception e) {
            }

            conexion = null;
        }

    }
    /**
     * carga un enunciado de tipo preparedStatement
     * @param sentencia es la sentencia sql a utilizar, puede ser parametrizada
     * y además se deber usar para insersiones, actualizaciones y eliminaciones. 
     */
    public void CargaEnunciado(String sentencia) {
        try {
            enunciado = conexion.prepareStatement(sentencia);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * obtiene el enunciado preparedStatemet que se habia cargado antes.
     * @return un enunciado PreparedStetement
     */
    public PreparedStatement getEnunciado() {
        return enunciado;
    }

    public ResultSet select(String atributos, String tabla, String where) {

        try {
            if (!where.isEmpty()) {
                where = "WHERE" + where;
            }

            resultado = consulta.executeQuery("SELECT " + atributos + "FROM " + tabla + "" + where + ";");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    /**
     * se obtine la consulta ya cargada en el constructor
     * @return una consulta Statement
     */
    public Statement getConsulta() {
        return consulta;
    }
    /**
     * se obtine un el objeto connection y aintanciado en el contructor
     * @return 
     */
    public Connection getConexion() {
        return conexion;
    }
}
