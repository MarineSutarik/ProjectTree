/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.service;

import api.membre.plongee.domain.Cours;
import java.util.Date;

/**
 *
 * @author Marine
 */
public interface GestionCours {
    
    public Cours creerCours(String nomCours, Integer niveauCible, Date dateDebut, Integer duree, Integer enseignant);
    
}
