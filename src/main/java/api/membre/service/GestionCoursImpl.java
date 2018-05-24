/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.service;

import api.membre.plongee.domain.Cours;
import api.membre.plongee.domain.Creneau;
import api.membre.plongee.domain.Participant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.membre.repo.CreneauRepository;
import api.membre.repo.CoursRepository;

/**
 *
 * @author Marine
 */
@Service 
public class GestionCoursImpl implements GestionCours{

    @Autowired
    CoursRepository coursRepo;
    
    @Autowired
    CreneauRepository creneauRepo;
    
    /**
     *
     * @param nomCours
     * @param niveauCible
     * @param dateDebut
     * @param duree
     * @param enseignant
     * @return
     */
    @Override
    public Cours creerCours(String nomCours, Integer niveauCible, Date dateDebut, Integer duree,  Integer enseignant) {
        Creneau creneau = new Creneau(dateDebut, duree);
        creneauRepo.save(creneau);
        Cours c = new Cours (nomCours, niveauCible,creneau, enseignant, new Participant[10]);
        coursRepo.save(c);
        return c;
    }
    
}
