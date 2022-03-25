/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.AnamneseRepository;
import SADGoitre.dao.AtcdPersRepository;
import SADGoitre.dao.PatientRepository;
import SADGoitre.entity.Anamnese;
import SADGoitre.entity.Atcd_personnel_medical;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Tina
 */
@Controller
@RequestMapping(path = "/atcdperso")
public class AtcdpersoController {
    
    @Autowired
    private AnamneseRepository daoAnamnese;
    
    @Autowired
    private AtcdPersRepository daoAtcdperso;
    
    @Autowired
    private PatientRepository daoPatient;
    
    @GetMapping(path = "add")
    public String montreFormulairePourAjoutAtcdperso (Model model, int idPatient){
        List<Atcd_personnel_medical> atcd_personnel;
        atcd_personnel = Arrays.asList(
        new Atcd_personnel_medical("Radiothérapie cervicale de l'enfance"),
             new Atcd_personnel_medical("Traitement suivi"),
             new Atcd_personnel_medical("Infection ORL"),
             new Atcd_personnel_medical("Toxique"),
             new Atcd_personnel_medical("Aliment goitrogène"),
             new Atcd_personnel_medical("Maladie auto-immune"),
             new Atcd_personnel_medical("Gynécologie obstétrique")
        );
        
        
        model.addAttribute("atcdperso",atcd_personnel );
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "formulaireAtcdPerso";
    }
    
    @PostMapping(path = "save")
    public String ajouteAtcdPersoPuisMontreLaListe(Atcd_personnel_medical atcdPerso, RedirectAttributes redirectInfo) {
        String message;
        try {
            daoAtcdperso.save(atcdPerso);
            message = "L'antécedent personnel" + atcdPerso.getNom_atcd_perso() + "' a été correctement enregistré";
        } catch (DataIntegrityViolationException e) {
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : L'antécedent " + atcdPerso.getNom_atcd_perso() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheAnamnese.html'
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:show?idMedecin=3"; // POST-Redirect-GET : on se redirige vers l'affichage du patient		
    }
}
