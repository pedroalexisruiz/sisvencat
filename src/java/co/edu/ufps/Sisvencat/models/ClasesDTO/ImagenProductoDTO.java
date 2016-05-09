
package co.edu.ufps.Sisvencat.models.ClasesDTO;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class ImagenProductoDTO extends Imagen  implements Serializable{

    public ImagenProductoDTO(String urlImagen) {
        super(urlImagen);
    }

    public ImagenProductoDTO(int id, String urlImagen) {
        super(id, urlImagen);
    }
}