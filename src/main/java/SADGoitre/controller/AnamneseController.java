package SADGoitre.controller;

import SADGoitre.dao.PatientRepository;
import SADGoitre.entity.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agath
 */
@Controller
@RequestMapping(path = "/anamnese")
public class AnamneseController {
    
    PatientRepository daoPatient;
    
    
    /**
     * Affiche l'anamnese du patient sélectionné 
     *
     * @param model pour transmettre les informations à la vue
     * @param patient le patient dont on veut afficher l'anamnese
     * @return le nom de la vue à afficher ('afficheGTableaux.html')
     */
    @GetMapping(path = "show")
    public String afficheAnamnese(Model model, Patient patient) {
        model.addAttribute("anamnese", daoPatient.getOne(patient.getIdPatient()).getAnamnese());
        return "afficheAnamnese";
    }
    
}
