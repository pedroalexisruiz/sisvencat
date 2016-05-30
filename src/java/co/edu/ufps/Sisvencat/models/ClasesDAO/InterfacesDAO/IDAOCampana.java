/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.models.ClasesDAO.InterfacesDAO;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author pedroruiz
 */
public interface IDAOCampana {
    
    public boolean iniciarCampaña(Campaña cam) throws SQLException;
    
    public boolean finalizarCampaña(Campaña cam) throws SQLException;
    
    public List<Campaña> listarCampañas()throws SQLException,ParseException ;
    
    public List<Campaña> listarCampañasPorEstado(int estado)throws SQLException,ParseException ;
    
    public Campaña getCampaña(Campaña cam) throws SQLException,ParseException ;
    
    public void closeConn() throws SQLException;
}
