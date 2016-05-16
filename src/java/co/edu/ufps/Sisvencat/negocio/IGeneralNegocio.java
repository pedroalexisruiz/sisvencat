/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.Sisvencat.negocio;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Campaña;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Persona;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IGeneralNegocio {
    
    public boolean login(Persona p) throws SQLException;
    
    public Campaña getCampañaActiva();
    
    public List<Campaña> getListadoDeCampañas()throws SQLException,ParseException ;
    
    public List<Campaña> getListadoDeCampañasPorEstado(int est) throws SQLException,ParseException;
    
    public List<Producto> getProductosCampañaPorCategoria(int cat) throws SQLException;
    
    public List<Producto> getProductosCampañaPorCategoriaYTipoPrenda(int cat, int tipo) throws SQLException;
}
