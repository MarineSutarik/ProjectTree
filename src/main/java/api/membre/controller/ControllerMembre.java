/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.controller;

import api.membre.plongee.domain.Adresse;
import api.membre.plongee.domain.Membre;
import api.membre.enumeration.TypeMembre;
import api.membre.plongee.exception.TypeMembreInvalideException;
import api.membre.service.GestionMembre;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marine
 */
@RestController
@RequestMapping("/api")
public class ControllerMembre {
           
    @Autowired
    private GestionMembre gestionMembre;
    
    /**
     *
     * @param nom
     * @param prenom
     * @param adresseMail
     * @param login
     * @param password
     * @param dateDebutCertificat
     * @param niveauExpertise
     * @param numLicence
     * @param pays
     * @param ville
     * @param type
     * @return
     * @throws api.membre.plongee.exception.TypeMembreInvalideException
     * @throws java.text.ParseException
     */
    @PostMapping("/creation")
    @ResponseBody
    public void creerMembre(@RequestBody String nom,
             @RequestBody String prenom,
             @RequestBody String adresseMail,
            @RequestBody String login,
             @RequestBody String password,
             @RequestBody String dateDebutCertificat,
             @RequestBody Integer niveauExpertise,
             @RequestBody String numLicence,
             @RequestBody String pays,
            @RequestBody String ville,
             @RequestBody String type) throws TypeMembreInvalideException, ParseException{
        TypeMembre t = null;
        switch (type) {
            case "Membre":
                t = TypeMembre.Membre;
                break;
            case "President" :
                t = TypeMembre.President;
                break;
            case "Secretaire" :
                t = TypeMembre.Secretaire;
                break;
            case "Enseignant" :
                t = TypeMembre.Enseignant;
                break;
             default :
                throw new TypeMembreInvalideException();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Date d = sdf.parse(dateDebutCertificat);
         gestionMembre.creerMembre( nom, prenom, adresseMail, login, password, d, niveauExpertise, numLicence, pays, ville, t);
    }
    
    /**
     *
     * @param nom
     * @return
     */
    @PostMapping("/test")  
    @ResponseBody
     public String test (@RequestBody String nom ){
         return "param : "+nom;
     }
       @PostMapping("/test2") 
       @ResponseBody
     public String test2 (@RequestBody String nom ){
         return "param : "+nom;
     }
      @PostMapping("/test3" )
     public @ResponseBody String test3 (@RequestBody Adresse addresse){
         return "param : "+addresse;
     }
      @PostMapping("/test4" )  
     public @ResponseBody String test4 ( @ModelAttribute("Adresse") Adresse addresse){
         return "param : "+addresse.getPays()+addresse.getVille();
     }
     @GetMapping("/test")  
     public Integer test ( ){
         return 1;
     }    
}
