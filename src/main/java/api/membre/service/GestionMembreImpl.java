/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.service;

import api.membre.plongee.domain.Adresse;
import api.membre.plongee.domain.Enseignant;
import api.membre.plongee.domain.Membre;
import api.membre.plongee.domain.President;
import api.membre.plongee.domain.Secretaire;
import api.membre.enumeration.TypeMembre;
import static api.membre.enumeration.TypeMembre.*;
import api.membre.repo.AdresseRepo;
import api.membre.repo.MembreRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marine
 */
@Service 
public class GestionMembreImpl  implements GestionMembre{
    @Autowired
    private MembreRepo membreRepo;
    
    @Autowired
    private AdresseRepo adresse;
    @Override
    public Membre creerMembre(String nom, String prenom, String adresseMail, String login, String password, Date dateDebutCertificat, Integer niveauExpertise, String numLicence, String pays, String ville, TypeMembre type) {
      Adresse a = new Adresse( pays, ville);
        a = adresse.save(a);
         Membre m = null;
        switch (type){
            case Membre :
                 m = new Membre(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
                 break;
            case Secretaire :
                 m = new Secretaire(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
                 break;
            case President :
                m = new President(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
                 break;
            case Enseignant :
                 m = new Enseignant(nom, prenom, adresseMail, login,password, null, null,  niveauExpertise, numLicence, a);
                 break;
                 
        }
        m  = membreRepo.save(m);
        
        return m;
    }
    
}
