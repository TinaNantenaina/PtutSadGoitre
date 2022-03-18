/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.AnamneseRepository;
import SADGoitre.dao.ExamenRepository;
import SADGoitre.dao.PatientRepository;
import SADGoitre.entity.Examen;
import SADGoitre.entity.Patient;
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
@RequestMapping (path="/examen")
public class ExamenController {
    @Autowired
    private ExamenRepository daoExamen;
    
    @Autowired 
    private PatientRepository daoPatient;
    
    
    /**
     * Affiche toutes les catégories dans la base
     *
     * @param model pour transmettre les informations à la vue
     * @param patient le patient concerné
     * @return le nom de la vue à afficher ('afficheExamens.html')
     */
    
        @GetMapping(path = "show")
    public String afficheTousLesExamens(Model model, Patient patient) {
        model.addAttribute("examens", daoPatient.getOne(patient.getId_patient()).getMes_examens());
        return "afficheExamens";
    }
    
    /**
     * Redirige vers la page d'un examen selon son id
     *
     * @param model pour transmettre les informations à la vue
     * @param idExamen l'id de l'examen
     * @return le nom de la vue à afficher ('detailExamen.html')
     */
    
    @GetMapping(path = "getExamen")
    public String afficheUnExamen (Model model, Integer idExamen){
        model.addAttribute("examen", daoExamen.getOne(idExamen));
        return "detailExamen";
    }
    
    /**
     * Montre le formulaire permettant d'ajouter un examen
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient L'id du patient
     * @return le nom de la vue à afficher ('formulaireExamen.html')
     */
    
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout (Model model, int idPatient){
        model.addAttribute("examen", new Examen());
        model.addAttribute("patient", daoPatient.getOne(idPatient).getMes_examens());    
        return "formulaireExamen";
    }
    /**
     * Appelé par 'formulaireExamen.html', méthode POST
     *
     * @param examen initialisé avec les valeurs saisies dans le formulaire
     * @param redirectInfo pour transmettre des paramètres lors de la redirection
     * @return une redirection vers l'affichage de la liste des examens
     */
    
    @PostMapping(path ="save")
    public String ajouteExamenPuisMontreLaListe(Examen examen, RedirectAttributes redirectInfo){
        String message;
        try {
            daoExamen.save(examen);
            // Le code de la catégorie a été initialisé par la BD au moment de l'insertion
            message = "L'examen '" + examen.getNom_examen() + "' a été correctement enregistrée";
        } catch (DataIntegrityViolationException e) {
            // Les noms sont définis comme 'UNIQUE' 
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : L'examen '" + examen.getNom_examen() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheAnimal.html'
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:/pesee/add?id=" + examen.getId_examen(); // POST-Redirect-GET : on se redirige vers l'affichage de la liste		
    }
    }
    
