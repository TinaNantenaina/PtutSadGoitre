/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.AnamneseRepository;
import SADGoitre.dao.ExamenRepository;
import SADGoitre.dao.MedecinRepository;
import SADGoitre.dao.PatientRepository;
import SADGoitre.dao.SymptomeRepository;
import SADGoitre.entity.Medecin;
import SADGoitre.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author agath
 */
@Controller
@RequestMapping(path = "/patient")
public class PatientController {
    @Autowired
    private PatientRepository daoPatient;
    
    @Autowired
    private MedecinRepository daoMedecin;
    
    @Autowired
    private ExamenRepository daoExamen;
    
    @Autowired
    private AnamneseRepository daoAnamnese;
    
    @Autowired
    private SymptomeRepository daoSymptome;
    
    
    /**
     * Affiche toutes les patients du médecin
     *
     * @param model pour transmettre les informations à la vue
     * @param idMedecin le medecin connecté 
     * @return le nom de la vue à afficher ('affichePatients.html')
     */
    @GetMapping(path = "show")
    public String afficheTousLesPatients(Model model, @RequestParam("idMedecin") int idMedecin) {
        model.addAttribute("patients", daoMedecin.getOne(idMedecin));
        model.addAttribute("patients", daoPatient.findAll());
        return "affichePatients";
    }
    
    /**
     * Redirige vers la page d'un patient selon son id
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient l'id du patient
     * @return le nom de la vue à afficher ('detailPatient.html')
     */
    @GetMapping(path = "getPatient")
    public String afficheUnPatient(Model model, Integer idPatient) {
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "detailPatient";
    }
    
    /**
     * Montre le formulaire permettant d'ajouter un patient
     *
     * @param model pour transmettre les informations à la vue
     * @param medecin Le medecin du patient
     * @return le nom de la vue à afficher ('formulairePatient.html')
     */
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model,Medecin medecin) {
        model.addAttribute("patient", new Patient());
        return "formulairePatient";
    }
    
    /**
     * Appelé par 'formulairePatient.html', méthode POST
     *
     * @param patient le patient initialisé avec les valeurs saisies dans le formulaire (nom, prénom, genre et dtn)
     * @param redirectInfo pour transmettre des paramètres lors de la redirection
     * @return une redirection vers l'affichage de la liste des patients
     */
    @PostMapping(path = "save")
    public String ajouteAnimalPuisMontreLaListe(Patient patient, RedirectAttributes redirectInfo) {
        String message;
        try {
            daoPatient.save(patient);
            // Le code de la catégorie a été initialisé par la BD au moment de l'insertion
            message = "Le patient '" + patient.getNom() + patient.getPrenom() + "' a été correctement enregistrée";
        } catch (DataIntegrityViolationException e) {
            // Les noms sont définis comme 'UNIQUE' 
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : Le patient '" + patient.getNom() + patient.getPrenom() + "' existe déjà";
        }
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:show";
    }
    
    
}
