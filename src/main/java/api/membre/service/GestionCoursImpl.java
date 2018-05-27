/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.service;

import api.membre.plongee.domain.Cours;
import api.membre.plongee.domain.Creneau;
import api.membre.plongee.domain.Membre;
import api.membre.plongee.domain.Participant;
import api.membre.plongee.exception.CoursIntrouvableException;
import api.membre.plongee.exception.MembreIntrouvableException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.membre.repo.CreneauRepository;
import api.membre.repo.CoursRepo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marine
 */
@Service 
public class GestionCoursImpl implements GestionCours{

    @Autowired
    CoursRepo coursRepo;
    
    @Autowired
    CreneauRepository creneauRepo;
    
    @Autowired
    GestionMembre gestionMembre;
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
        Cours c = new Cours (nomCours, niveauCible,creneau, enseignant, new ArrayList<Participant>() );
        Cours insert = coursRepo.save(c);
        return insert;
    }

    @Override
    public Cours participerCours(Integer idCours, Integer idMembre) throws MembreIntrouvableException,CoursIntrouvableException {
       Membre m = gestionMembre.afficherMembre(idMembre);
       Cours c = coursRepo.findOne(idCours);
       if (c==null) throw new CoursIntrouvableException();
       Participant p = new Participant(m.getIdMembre(), m.getNom(), m.getPrenom());
       c.addParticipant(p);
       coursRepo.save(c);
       return c;
    }
    
}
