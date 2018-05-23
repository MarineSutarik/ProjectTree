/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.service;

import api.membre.plongee.domain.Cours;
import api.membre.plongee.domain.Creneau;
import api.membre.plongee.domain.Participant;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marine
 */
@Service 
public class GestionCoursImpl implements GestionCours{

    @Override
    public Cours creerCours(String nomCours, Integer niveauCible, Creneau creneau, Integer enseignant, Participant[] participants) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
