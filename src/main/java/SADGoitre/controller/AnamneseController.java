package SADGoitre.controller;

import SADGoitre.dao.AnamneseRepository;
import SADGoitre.dao.PatientRepository;
import SADGoitre.entity.Anamnese;
import SADGoitre.entity.Patient;
import SADGoitre.entity.Signe_fonctionnel;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    AnamneseRepository daoAnamnese;
    PatientRepository daoPatient;
    Signe_fonctionnel daoSF;
    
    /**
     * Affiche l'anamnese du patient sélectionné 
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient le patient dont on veut afficher l'anamnese
     * @return le nom de la vue à afficher ('afficheGTableaux.html')
     */
    @GetMapping(path = "show")
    public String afficheAnamnese(Model model, int idPatient) {
        model.addAttribute("anamnese", daoPatient.getOne(idPatient).getAnamnese());
        return "afficheAnamnese";
    }
  
    /**
     * Affiche le formulaire permettant d'ajouter une anamnese
     *
     * @param model pour transmettre les informations à la vue
     * @param patient Le patient
     * @return le nom de la vue à afficher ('formulaireAnamnese.html')
     */
    // A MODIF SI BESOIN SF OU ATCD
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model, Patient patient) {
        model.addAttribute("anamnese", new Anamnese());
        return "formulaireAnamnese";
    }

    /**
     * Appelé par 'formulaireAnamnese.html', méthode POST
     *
     * @param anamnese initialisé avec les valeurs saisies dans le formulaire
     * @param redirectInfo pour transmettre des paramètres lors de la redirection
     * @return une redirection vers l'affichage de l'anamnèse
     */
    @PostMapping(path = "save")
    public String ajouteAnimalPuisMontreLaListe(Anamnese anamnese, RedirectAttributes redirectInfo) {
        String message;
        try {
            daoAnamnese.save(anamnese);
            message = "L'anamnese du patient'" + anamnese.getPatient().getNom() + "' a été correctement enregistré";
        } catch (DataIntegrityViolationException e) {
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : L'anamnese du patient'" + anamnese.getPatient().getNom() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheAnamnese.html'
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:/anamnese/show"; // POST-Redirect-GET : on se redirige vers l'affichage de l'anamnese		
    }
    
    
    
}
