/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.control;

import it.viktor.entity.CityEntity;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class CityStore {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<CityEntity> all (){
       return em.createQuery("select e from CityEntity e", CityEntity.class)
               .getResultList();
    }

    
}
