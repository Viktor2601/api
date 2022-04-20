/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.control;

import it.viktor.entity.Etichetta;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional(Transactional.TxType.REQUIRED)
@RequestScoped
public class EtichettaStore {

    @PersistenceContext
    EntityManager em;

    public Etichetta salvaSeNonEsiste(String etichetta) {
        Optional<Etichetta> found = byName(etichetta);
        if (found.isPresent()){
            return found.get();
        }
        return this.save(new Etichetta(etichetta));
    }

    private Optional<Etichetta> byName(String etichetta) {
        try {
            return Optional.of(em.createQuery("select e from Etichetta e where TRIM(LOWER(e.name)) = :etichetta", Etichetta.class)
                                .setParameter("etichetta", etichetta.trim().toLowerCase())
                                .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    private Etichetta save(Etichetta entity) {
        return em.merge(entity);
    }


}
