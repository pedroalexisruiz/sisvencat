package co.edu.ufps.Sisvencat.models.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clase para conectar, cerrar y gestionar las bases de datos
 * @author oso
 */
public class Conexion implements Serializable{

    private Statement consulta;
    private Connection conexion;
    private final String db_url = "jdbc:mysql://sandbox2.ufps.edu.co/ufps_98";
    private final String db_driver = "com.mysql.jdbc.Driver";
    private final String db_username = "ufps_98";
    private final String db_password = "ufps_uy";
    /**
     * además de crear el objeto se genera la conexion y se crea la consulta
     */
    public Conexion() {
        try {
            Class.forName(db_driver).newInstance();
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

        if (consulta != null) {
           
            try {
                consulta.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            consulta = null;
        }

        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            conexion = null;
        }

    }
    /**
     * se obtine la consulta ya cargada en el constructor
     * @return una consulta Statement
     */
    public Statement getConsulta() {
        return consulta;
    }
    /**
     * se obtine un el objeto connection y aintanciado en el
     * @return 
     */
    public Connection getConexion() {
        return conexion;
    }
}