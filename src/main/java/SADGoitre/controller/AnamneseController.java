package SADGoitre.controller;

import SADGoitre.dao.AnamneseRepository;
import SADGoitre.dao.PatientRepository;
import SADGoitre.dao.SigneFonctionnelRepository;
import SADGoitre.entity.Anamnese;
import SADGoitre.entity.Patient;
import SADGoitre.entity.Signe_fonctionnel;
import SADGoitre.entity.Valeur_signe_compression;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AnamneseRepository daoAnamnese;
    @Autowired
    PatientRepository daoPatient;
    @Autowired
    SigneFonctionnelRepository daoSF;

    /**
     * Affiche l'anamnese du patient sélectionné
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient l'id du patient dont on veut afficher l'anamnese
     * @return le nom de la vue à afficher ('afficheAnamnese.html')
     */
    @GetMapping(path = "show")
    public String afficheAnamnese(Model model, int idPatient) {
        if (daoPatient.getOne(idPatient).getAnamnese()!= null) {
            model.addAttribute("anamnese", daoPatient.getOne(idPatient).getAnamnese());
        } else {
            model.addAttribute("anamnese", new Anamnese());
        }
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "afficheAnamnese";
    }

    /**
     * Affiche le formulaire permettant d'ajouter une anamnese
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient Le patient
     * @return le nom de la vue à afficher ('AfficheAnamnese.html')
     */
    // A MODIF SI BESOIN SF OU ATCD
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model, int idPatient) {
       List<Valeur_signe_compression> valeur_signe_compression;
       valeur_signe_compression = Arrays.asList(
       new Valeur_signe_compression("Disphagie"),
       new Valeur_signe_compression("Dysphonie"),
       new Valeur_signe_compression("Dyspnée"),
       new Valeur_signe_compression("Syndrome cave supérieur")
       );
       
       Anamnese anamneses = new Anamnese();
       anamneses.setValeur_signe_compression(valeur_signe_compression);
       anamneses.setPatient(daoPatient.getOne(idPatient));
      
        model.addAttribute("anamnese", anamneses);
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "afficheAnamnese";
    }

    /**
     * Appelé par 'formulaireAnamnese.html', méthode POST
     *
     * @param anamnese initialisé avec les valeurs saisies dans le formulaire
     * @param redirectInfo pour transmettre des paramètres lors de la
     * redirection
     * @return une redirection vers l'affichage de l'anamnèse
     */
    @PostMapping(path = "save")
    public String ajouteAnamnesePuisMontreLaListe(Anamnese anamnese, RedirectAttributes redirectInfo) {
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
        return "redirect:show?idMedecin=3"; // POST-Redirect-GET : on se redirige vers l'affichage du patient		
    }
}
