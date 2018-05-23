/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.plongee.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Marine
 */
@Entity
@Document
public class Cours implements Serializable {
    @Id
    @GeneratedValue
    private Integer idCours;
    private String nomCours ;
    private Integer niveauCible ;
    private Creneau creneau;
    private Integer enseignant;
    private Participant[] participants ;

    public Cours(String nomCours, Integer niveauCible, Creneau creneau, Integer enseignant, Participant[] participants) {
        this.nomCours = nomCours;
        this.niveauCible = niveauCible;
        this.creneau = creneau;
        this.enseignant = enseignant;
        this.participants = participants;
    }

    protected Cours() {
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Integer getNiveauCible() {
        return niveauCible;
    }

    public void setNiveauCible(Integer niveauCible) {
        this.niveauCible = niveauCible;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

    public Integer getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Integer enseignant) {
        this.enseignant = enseignant;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }
       
}
