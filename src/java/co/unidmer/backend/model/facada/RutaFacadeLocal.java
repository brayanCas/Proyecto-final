/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unidmer.backend.model.facada;

import co.unidmer.backend.model.entities.Ruta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAURA
 */
@Local
public interface RutaFacadeLocal {

    void create(Ruta ruta);

    void edit(Ruta ruta);

    void remove(Ruta ruta);

    Ruta find(Object id);

    List<Ruta> findAll();

    List<Ruta> findRange(int[] range);

    int count();
    
}
