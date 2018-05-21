/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.repo;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author marin
 */
public class MembreRepoImpl implements MembreRepoCustom{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public String getNombreCotisationsPrevues() {
     String query = "Select count(m) from Membre as m where year(m.aPaye) <> "+Calendar.getInstance().get(Calendar.YEAR);
        String r = "";
        r = this.entityManager
                .createQuery(query)
                .getFirstResult()+"";
        return r;
    }

    @Override
    public String getNombreCotisationsRegles() {
        String query = "Select count(m) from Membre as m where year(m.aPaye) = "+Calendar.getInstance().get(Calendar.YEAR);
        String r = "";
        r = this.entityManager
                .createQuery(query)
                .getFirstResult()+"";
        return r;  
    }
    
}
