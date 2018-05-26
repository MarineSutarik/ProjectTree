/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.controller;

import api.membre.plongee.domain.Cours;
import api.membre.service.GestionCours;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marine
 */
@RestController
@RequestMapping("/api/cours")
public class ControllerCours {
    @Autowired
    private GestionCours gestionCours;
    
    /*
    Requête de test :
    {
    nomCours:"vidage de masque",
    niveauCible :"1",
    dateDebut : "26/05/18",
    duree : "40",
    enseignant:"4"
    }
    */
    @PostMapping("/creation")
    @ResponseBody
    public Cours creerCours(@RequestBody String js
           
    ) throws  ParseException{
        JSONObject jsonObj = new JSONObject(js);
               String nomCours = jsonObj.getString("nomCours");
              Integer niveauCible= Integer.parseInt(jsonObj.getString("niveauCible"));
              String dateDebut= jsonObj.getString("dateDebut");
             Integer duree= Integer.parseInt(jsonObj.getString("duree"));
              Integer enseignant= Integer.parseInt(jsonObj.getString("enseignant"));
        
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Date d = sdf.parse(dateDebut);
        return gestionCours.creerCours(nomCours, niveauCible, d, duree, enseignant);
    }
}
