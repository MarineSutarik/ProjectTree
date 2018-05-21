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
import api.membre.plongee.domain.Paiement;
import api.membre.plongee.exception.MembreIntrouvableException;
import api.membre.repo.AdresseRepo;
import api.membre.repo.MembreRepo;
import api.membre.repo.PaiementRepo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    @Autowired
    private PaiementRepo paiement;
    
    
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

    @Override
    public Membre updateMembre(Integer idMembre, Membre m)  throws MembreIntrouvableException {
        System.out.println("id = "+idMembre);
        Membre membreActuel = this.membreRepo.getOne(idMembre);
        if (membreActuel==null) throw new MembreIntrouvableException();
        
        membreActuel.setAdresse(m.getAdresse());
        membreActuel.setAdresseMail(m.getAdresseMail());
        membreActuel.setDateDebutCertificat(m.getDateDebutCertificat());
        membreActuel.setLogin(m.getLogin());
        membreActuel.setNiveauExpertise(m.getNiveauExpertise());
        membreActuel.setNom(m.getNom());
        membreActuel.setNumLicence(m.getNumLicence());
        membreActuel.setPassword(m.getPassword());
        membreActuel.setPrenom(m.getPrenom());
        membreActuel.setaPaye(m.getAPaye()); 
        return this.membreRepo.save(membreActuel);
    }

    @Override
    public void deleteMembre(Integer idMembre) throws MembreIntrouvableException {
        Membre membreActuel = this.membreRepo.getOne(idMembre);
        if (membreActuel==null) throw new MembreIntrouvableException();
        else this.membreRepo.delete(idMembre);
    }

    @Override
    public Membre seconnecter(String login, String password) throws MembreIntrouvableException {
        Membre m =  membreRepo.findMembreByLogin(login);
        if (!m.getPassword().equals(password.trim()) || m ==null )
            throw new MembreIntrouvableException();
        
        return m;
    }

    @Override
    public void payerCotisation(String IBAN, float somme,Integer idMembre) throws MembreIntrouvableException {
         Membre m = this.membreRepo.getOne(idMembre);
        if (m==null) throw new MembreIntrouvableException();
        Paiement p = new Paiement(IBAN,somme, m);
        paiement.save(p);
        m.setaPaye(new Date());
        membreRepo.save(m);
    }

    @Override
    public List<Membre> consulterCotisation() {
        ArrayList<Membre> r = new   ArrayList<Membre> ();
        for( Membre m : membreRepo.findAll()){
            r.add(m);
        }
        return r;
    }
    
    
    
}
