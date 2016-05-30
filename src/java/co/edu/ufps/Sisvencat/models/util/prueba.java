/*
 * @author Pedro Ruiz, Manuel Osorio, Yermison Chavez, Hender Guarin
 * @version Sisvencat 1.0 * 
 */
package co.edu.ufps.Sisvencat.models.util;

import co.edu.ufps.Sisvencat.models.ClasesDTO.Categoria;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Producto;
import co.edu.ufps.Sisvencat.models.ClasesDTO.Tipo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Administrator
 */
public class prueba {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList();
        Producto producto = null;
        Categoria cat = null;
        Tipo tipo = null;
        try {

            FileInputStream file = new FileInputStream(new File("C:\\Libro1.xls"));

            //Get the workbook instance for XLS file 
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                cat = new Categoria();
                cat.setId((int)row.getCell(4).getNumericCellValue());
                tipo = new Tipo();
                tipo.setId((int)row.getCell(5).getNumericCellValue());
                producto = new Producto(row.getCell(0).getStringCellValue(),row.getCell(1).getStringCellValue(),(int)row.getCell(2).getNumericCellValue(),(int)row.getCell(3).getNumericCellValue(),cat,tipo,null);
                productos.add(producto);
            }
            file.close();
            FileOutputStream out = new FileOutputStream(new File("C:\\Libro1.xls"));
            workbook.write(out);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (Producto producto1 : productos) {
            System.out.println(producto1.toString());
        }
    }
}
