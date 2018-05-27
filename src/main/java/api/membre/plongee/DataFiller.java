/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.membre.plongee;

import api.membre.enumeration.TypeMembre;
import api.membre.plongee.domain.Membre;
import api.membre.service.GestionCours;
import api.membre.service.GestionMembre;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Pour remplir la BD
 * @author marin
 */
@Component
public class DataFiller implements CommandLineRunner{

     @Autowired
     GestionMembre gestionMembre;
     
     @Autowired
     GestionCours gestionCours;
     
     @Override
     @Transactional
    public void run(String... strings) throws Exception {
        gestionMembre.creerMembre("RIGAL", "Anais", "thuglife@gourgandine.fr", "thug", "life", null, 1, "564654AD54", "France", "Sulpice", TypeMembre.President);
         gestionMembre.creerMembre("TOURNIE", "Vivien", "viv@gourgandine.fr", "viv", "life", null, 1, "564654uAD54", "France", "Toulouse", TypeMembre.Membre);
        Membre m =  gestionMembre.creerMembre("SUTARIK", "Marine", "marine@gourgandine.fr", "mar", "life", null, 1, "564u654AD54", "Slovaquie", "Nowhere", TypeMembre.Secretaire);
        gestionMembre.payerCotisation("pihjp", 30, m.getIdMembre());
        gestionMembre.donnerCertificat(m.getIdMembre());
        m = gestionMembre.creerMembre("Z", "Gilles", "z@gil.fr", "gil", "concepts", null, 1, "564654uAD54", "France", "Perché", TypeMembre.Enseignant);
        gestionCours.creerCours("Vidage de masque", 1, Calendar.getInstance().getTime(), 40, m.getIdMembre());
    }
}
