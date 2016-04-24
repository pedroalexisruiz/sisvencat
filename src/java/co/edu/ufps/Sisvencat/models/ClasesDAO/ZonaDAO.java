/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO.IDAOZona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Zona;
import co.edu.ufps.Sisvencat.models.util.Conexion;
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
public class ZonaDAO implements IDAOZona {

    private Conexion con;
    private boolean keepOpenConn;

    public ZonaDAO() {
    }

    public ZonaDAO(boolean keepOpenConn) {
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
    public int insertar(Zona zona) {

        int respuesta = 0;

        PreparedStatement state = null;

        try {

            if (!keepOpenConn) {
                con = new Conexion();
                keepOpenConn = true;
            }

            String insertar = "INSERT INTO zona VALUES(?,?,?)";
            state = con.getConexion().prepareStatement(insertar);
            state.setInt(1, zona.getCodigo_z());
            state.setString(2, zona.getNombre());
            state.setInt(3, zona.getEstado());
            state.execute();
        } catch (SQLException ex) {
            ex.getErrorCode();
        } finally {
            try {
                
                state.close();

                if (!keepOpenConn) {
                    if (con != null) {
                        con.close();
                    }
                }
                
            } catch (SQLException ex) {
                respuesta = ex.getErrorCode();
            }
        }

        return respuesta;
    }

    /**
     * modifica una zona de la base de datos
     *
     * @param zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un
     * error devolvera un -1
     */
    @Override
    public int modificar(Zona zona) {
        
        int respuesta = 0;

        PreparedStatement state = null;

        try {

            if (!keepOpenConn) {
                con = new Conexion();
                keepOpenConn = true;
            }

            String modificar = "UPDATE zona SET Nombre=? WHERE Codigo_z=?";
            state = con.getConexion().prepareStatement(modificar);
            state.setString(1, zona.getNombre());
            state.setInt(2, zona.getCodigo_z());
            state.executeUpdate();
        } catch (SQLException ex) {
            ex.getErrorCode();
        } finally {
            try {
                
                state.close();

                if (!keepOpenConn) {
                    if (con != null) {
                        con.close();
                    }
                }
                
            } catch (SQLException ex) {
                respuesta = ex.getErrorCode();
            }
        }

        return respuesta;
    }

    /**
     * Elimina una zona de la base de datos
     *
     * @param zona
     * @return retorna la catidad de filas afectadas en caso de que ocurra un
     * error devolvera un -1
     */
    @Override
    public int cambiarEstado(Zona zona) {
        
        int respuesta = 0;

        PreparedStatement state = null;

        try {

            if (!keepOpenConn) {
                con = new Conexion();
                keepOpenConn = true;
            }

            String modificar = "UPDATE zona SET estado=? WHERE Codigo_z=?";
            state = con.getConexion().prepareStatement(modificar);
            state.setInt(1, zona.getEstado());
            state.setInt(2, zona.getCodigo_z());
            state.executeUpdate();
        } catch (SQLException ex) {
            ex.getErrorCode();
        } finally {
            try {
                
                state.close();

                if (!keepOpenConn) {
                    if (con != null) {
                        con.close();
                    }
                }
                
            } catch (SQLException ex) {
                respuesta = ex.getErrorCode();
            }
        }

        return respuesta;
    }

    /**
     * lista todas las zonas que se encuentren en la base de datos
     *
     * @return
     */
    @Override
    public List<Zona> listar() {
        List<Zona> lista = new ArrayList();
        
        PreparedStatement state = null;

        try {

            if (!keepOpenConn) {
                con = new Conexion();
                keepOpenConn = true;
            }
            state = con.getConexion().prepareStatement("SELECT * FROM zona");
            ResultSet resultado = state.executeQuery();
            
            while(resultado.next()){
                lista.add(new Zona(resultado.getInt("Codigo_z"), resultado.getString("Nombre"), resultado.getInt("estado")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                
                state.close();

                if (!keepOpenConn) {
                    if (con != null) {
                        con.close();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
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
    public List<Zona> listar(String where) {
        List<Zona> lista = new ArrayList();

        PreparedStatement state = null;

        try {

            if (!keepOpenConn) {
                con = new Conexion();
                keepOpenConn = true;
            }
            state = con.getConexion().prepareStatement("SELECT * FROM zona WHERE=?");
            state.setString(1, where);
            ResultSet resultado = state.executeQuery();
            
            while(resultado.next()){
                lista.add(new Zona(resultado.getInt("Codigo_z"), resultado.getString("Nombre"), resultado.getInt("estado")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                
                state.close();

                if (!keepOpenConn) {
                    if (con != null) {
                        con.close();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        return lista;
    }

    @Override
    public boolean closeConn() throws Exception {

        con.close();
        con = null;
        keepOpenConn = false;

        return keepOpenConn;
    }
}
