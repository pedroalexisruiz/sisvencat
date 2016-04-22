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

public class Conexion {

    private Statement consulta;
    private ResultSet resultado;
    private PreparedStatement enunciado;
    private Connection conexion;
    private final String db_url = "jdbc:mysql://sandbox2.ufps.edu.co/ufps_";
    private final String db_driver = "com.mysql.jdbc.Driver";
    private final String db_username = "ufps_";
    private final String db_password = "ufps_";

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

    public void CargaEnunciado(String sentencia) {
        try {
            enunciado = conexion.prepareStatement(sentencia);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public Statement getConsulta() {
        return consulta;
    }

    public Connection getConexion() {
        return conexion;
    }
}
