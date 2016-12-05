/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unidmer.backend.model.facada;

import co.unidmer.backend.model.entities.Estadousuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author LAURA
 */
@Local
public interface EstadousuarioFacadeLocal {

    void create(Estadousuario estadousuario);

    void edit(Estadousuario estadousuario);

    void remove(Estadousuario estadousuario);

    Estadousuario find(Object id);

    List<Estadousuario> findAll();

    List<Estadousuario> findRange(int[] range);

    int count();
    
}
