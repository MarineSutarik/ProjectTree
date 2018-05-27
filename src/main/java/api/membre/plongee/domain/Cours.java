/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.plongee.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Marine
 */
@Entity
@Document(collection="cours")
public class Cours implements Serializable {
    @Id
    @GeneratedValue
    private Integer idCours;
    private String nomCours ;
    private Integer niveauCible ;
    @OneToOne
    private Creneau creneau;
    private Integer enseignant;
    
    private List<Participant> participants ;
    
    public Cours(String nomCours, Integer niveauCible, Creneau creneau, Integer enseignant, List<Participant>  participants) {
        this.nomCours = nomCours;
        this.niveauCible = niveauCible;
        this.creneau = creneau;
        this.enseignant = enseignant;
        this.participants = participants;
    }

    public Cours() {
    }

    public Integer getIdCours() {
        return idCours;
    }

    public void setIdCours(Integer idCours) {
        this.idCours = idCours;
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

    public List<Participant>  getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant>  participants) {
        this.participants = participants;
    }
    
     public void addParticipant(Participant  participant) {
        if(participants.contains(participant)){/* Ne rien faire pour éviter d'avoir des doublons*/}
        this.participants.add(participant);
    }
       
}
