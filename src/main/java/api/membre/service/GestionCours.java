/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.service;

import api.membre.plongee.domain.Cours;
import api.membre.plongee.domain.Creneau;
import api.membre.plongee.domain.Participant;

/**
 *
 * @author Marine
 */
public interface GestionCours {
    
    public Cours creerCours(String nomCours, Integer niveauCible, Creneau creneau, Integer enseignant, Participant[] participants);
}
