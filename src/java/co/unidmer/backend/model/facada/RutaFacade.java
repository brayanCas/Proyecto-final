/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unidmer.backend.model.facada;

import co.unidmer.backend.model.entities.Ruta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author LAURA
 */
@Stateless
public class RutaFacade extends AbstractFacade<Ruta> implements RutaFacadeLocal {

    @PersistenceContext(unitName = "uniidmerProyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutaFacade() {
        super(Ruta.class);
    }
    
}
