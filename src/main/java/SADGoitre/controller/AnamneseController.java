package SADGoitre.controller;

import SADGoitre.dao.AnamneseRepository;
import SADGoitre.dao.PatientRepository;
import SADGoitre.dao.SigneFonctionnelRepository;
import SADGoitre.dao.ValeurSigneCompressionRepository;
import SADGoitre.entity.Anamnese;
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
    @Autowired
    ValeurSigneCompressionRepository daoSigneCompression;

    /**
     * Affiche l'anamneses du patient sélectionné
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient l'id du patient dont on veut afficher l'anamneses
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
     * Affiche le formulaire permettant d'ajouter une anamneses
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient Le patient
     * @return le nom de la vue à afficher ('AfficheAnamnese.html')
     */
    // A MODIF SI BESOIN SF OU ATCD
    @GetMapping(path = "add")
    public String montreLeFormulairePourAjout(Model model, int idPatient) {
       List<Valeur_signe_compression> valeur_sc;
       valeur_sc = Arrays.asList(
       new Valeur_signe_compression(0,"Dysphagie"),
       new Valeur_signe_compression(1,"Dysphonie"),
       new Valeur_signe_compression(2,"Dyspnée"),
       new Valeur_signe_compression(3,"Syndrome cave supérieur")
       );
       
       Anamnese anamneses = new Anamnese();
       anamneses.setValeur_signe_compression(valeur_sc);
       anamneses.setPatient(daoPatient.getOne(idPatient));
       
   
      
        model.addAttribute("anamnese", anamneses);
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        //model.addAttribute("sf", daoSF.findAll());
       
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
            for(Valeur_signe_compression vc : anamnese.getValeur_signe_compression()){
                vc.setSigne_compression_valeur(anamnese);
                daoSigneCompression.save(vc);
                
            }
            message = "L'anamnese du patient'" + anamnese.getPatient().getAnamnese() + "' a été correctement enregistré";
        } catch (DataIntegrityViolationException e) {
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : L'anamnese du patient'" + anamnese.getPatient().getAnamnese() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheAnamnese.html'
        redirectInfo.addFlashAttribute("message", message);
        return "redirect:/anamnese/show?idPatient=" + anamnese.getPatient().getId_patient(); // POST-Redirect-GET : on se redirige vers l'affichage du patient		
    }
}
