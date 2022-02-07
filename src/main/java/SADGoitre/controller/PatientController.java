/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.MedecinRepository;
import SADGoitre.entity.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author agath
 */
@Controller
@RequestMapping(path = "/patient")
public class PatientController {
    @Autowired
    private MedecinRepository daoMedecin;
    
    /**
     * Affiche toutes les patients du médecin
     *
     * @param model pour transmettre les informations à la vue
     * @param user l'utilisateur connecté (un propriétaire)
     * @return le nom de la vue à afficher ('afficheGTableaux.html')
     */
    @GetMapping(path = "show")
    public String afficheTousLesPatients(Model model, @AuthenticationPrincipal Medecin medecin) {
        model.addAttribute("patients", daoMedecin.getOne(medecin.getIdMedecin()));
        return "affichePatients";
    }
    
}
