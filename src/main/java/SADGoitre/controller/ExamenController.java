/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.ExamenRepository;
import SADGoitre.dao.PatientRepository;
import SADGoitre.dao.ValeurExamenRepository;
import SADGoitre.entity.Examen;
import SADGoitre.entity.Patient;
import SADGoitre.entity.Valeur_examen;
import java.time.LocalDate;
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

/**
 *
 * @author Tina
 */
@Controller
@RequestMapping(path = "/examen")
public class ExamenController {

    @Autowired
    private ExamenRepository daoExamen;

    @Autowired
    private PatientRepository daoPatient;

    @Autowired
    private ValeurExamenRepository daoValeurExam;

    /**
     * Affiche toutes les catégories dans la base
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient le numéro du patient
     * @return le nom de la vue à afficher ('afficheExamens.html')
     */
    @GetMapping(path = "show")
    public String afficheTousLesExamens(Model model, Integer idPatient) {
        model.addAttribute("examens", daoPatient.getOne(idPatient).getMes_examens());
        model.addAttribute("patient", daoPatient.getOne(idPatient));
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
    public String afficheUnExamen(Model model, Integer idExamen) {
        model.addAttribute("examen", daoExamen.getOne(idExamen));
        return "detailExamen";
    }

    /**
     * Montre le formulaire permettant d'ajouter un examen de signes generaux
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient L'id du patient
     * @return le nom de la vue à afficher ('formulaireExamen.html')
     */
    @GetMapping(path = "addSignesGeneraux")
    public String ajoutSignesGeneraux(Model model, int idPatient) {
        List<Valeur_examen> val_examens;
        val_examens = Arrays.asList(
                new Valeur_examen("Fièvre"),
                new Valeur_examen("Prise de poids"),
                new Valeur_examen("Perte de poids"),
                new Valeur_examen("Tachycardie"),
                new Valeur_examen("Bradychardie"),
                new Valeur_examen("Hypertension artérielle")
        );
        /*for (Valeur_examen v : val_examens) {
            System.out.println(" here" + v.getId_valeur_examen());
        }*/
        Examen exam = new Examen();
        exam.setValeur_examen(val_examens);
        exam.setPatient_examen(daoPatient.getOne(idPatient));
        exam.setEst_examen_clinique(true);
        exam.setDate_examen(LocalDate.now());
        exam.setEst_examen_clinique(true);
        exam.setNom_examen("Signes généraux");
        model.addAttribute("examen", exam);
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "formulaireExamenSignesGeneraux";
    }

    /**
     * Montre le formulaire permettant d'ajouter un examen de la région
     * cervicale
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient L'id du patient
     * @return le nom de la vue à afficher ('formulaireExamen.html')
     */
    @GetMapping(path = "addregioncervicale")
    public String ajoutRegionCervicale(Model model, int idPatient) {
        List<Valeur_examen> val_examens;
        val_examens = Arrays.asList(
                new Valeur_examen("Circulation veineuse collatérale"),
                new Valeur_examen("Turgescence de la veine jugulaire"),
                new Valeur_examen("Coloration de la peau"),
                new Valeur_examen("Tachycardie"),
                new Valeur_examen("Bradychardie"),
                new Valeur_examen("Nature thyroïdienne de la masse : fixe (sinon mobile)"),
                new Valeur_examen("Volume thyroïdien supérieur à 1er phalange"),
                new Valeur_examen("Topographie : normale (sinon plongeant)"),
                new Valeur_examen("Consistance : molle"),
                new Valeur_examen("Consistance : élastique"),
                new Valeur_examen("Consistance : dure"),
                new Valeur_examen("Consistance : ferme"),
                new Valeur_examen("Consistance : souple"),
                new Valeur_examen("Consistance : pierreuse"),
                new Valeur_examen("Caractère symmétrique"),
                new Valeur_examen("Caractère régulier"),
                new Valeur_examen("Caractère douloureux"),
                new Valeur_examen("Signe vasculaire : thrill (sinon goître soufflant)"),
                new Valeur_examen("Adénopathie cervicale : jugulo-carotidienne"),
                new Valeur_examen("Adénopathie cervicale : pré-trachéale"),
                new Valeur_examen("Adénopathie cervicale : sus claviculaire"),
                new Valeur_examen("Goitre non visible mais palpable"),
                new Valeur_examen("Goître visible lors de l'hyper-extention du cou"),
                new Valeur_examen("Goître visible inférieur 5m"),
                new Valeur_examen("Myxoedème prétibial")
        );
        /*for (Valeur_examen v : val_examens) {
            System.out.println(" here" + v.getId_valeur_examen());
        }*/
        Examen exam = new Examen();
        exam.setValeur_examen(val_examens);
        exam.setPatient_examen(daoPatient.getOne(idPatient));
        exam.setEst_examen_clinique(true);
        exam.setDate_examen(LocalDate.now());
        exam.setEst_examen_clinique(true);
        exam.setNom_examen("Région cervicale");
        model.addAttribute("examen", exam);
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "formulaireExamenRegionCervicale";
    }

    /**
     * Montre le formulaire permettant d'ajouter un examen ophtalmologique
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient L'id du patient
     * @return le nom de la vue à afficher ('formulaireExamen.html')
     */
    @GetMapping(path = "addexamenophtalmo")
    public String ajoutExamenOphtalmo(Model model, int idPatient) {
        List<Valeur_examen> val_examens;
        val_examens = Arrays.asList(
                new Valeur_examen("Exophtalmie"),
                new Valeur_examen("Perte de queue")
        );
        Examen exam = new Examen();
        exam.setValeur_examen(val_examens);
        exam.setPatient_examen(daoPatient.getOne(idPatient));
        exam.setEst_examen_clinique(true);
        exam.setDate_examen(LocalDate.now());
        exam.setEst_examen_clinique(true);
        exam.setNom_examen("Examen ophtalmologique");
        model.addAttribute("examen", exam);
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "formulaireExamenOphtalmologique";
    }

    /**
     * Montre le formulaire permettant d'ajouter un examen de la région
     * cervicale
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient L'id du patient
     * @return le nom de la vue à afficher ('formulaireExamen.html')
     */
    @GetMapping(path = "addexamenneuro")
    public String ajoutExamenNeuro(Model model, int idPatient) {
        List<Valeur_examen> val_examens;
        val_examens = Arrays.asList(
                new Valeur_examen("ROT vif"),
                new Valeur_examen("ROT ralenti")
        );
        Examen exam = new Examen();
        exam.setValeur_examen(val_examens);
        exam.setPatient_examen(daoPatient.getOne(idPatient));
        exam.setEst_examen_clinique(true);
        exam.setDate_examen(LocalDate.now());
        exam.setEst_examen_clinique(true);
        exam.setNom_examen("Examen neurologique");
        model.addAttribute("examen", exam);
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "formulaireExamenNeurologique";
    }
    
    /**
     * Montre le formulaire permettant d'ajouter un examen de l'aire ganglionnaire
     *
     * @param model pour transmettre les informations à la vue
     * @param idPatient L'id du patient
     * @return le nom de la vue à afficher ('formulaireExamen.html')
     */
    @GetMapping(path = "addexamenaireganglionnaire")
    public String ajoutExamenAireGanglionnaire(Model model, int idPatient) {
        List<Valeur_examen> val_examens;
        val_examens = Arrays.asList(
                new Valeur_examen("Ganglion cervicale"),
                new Valeur_examen("Ganglion axillaire"),
                new Valeur_examen("Ganglion inguinal"),
                new Valeur_examen("Ganglion généralisé")             
        );
        Examen exam = new Examen();
        exam.setValeur_examen(val_examens);
        exam.setPatient_examen(daoPatient.getOne(idPatient));
        exam.setEst_examen_clinique(true);
        exam.setDate_examen(LocalDate.now());
        exam.setEst_examen_clinique(true);
        exam.setNom_examen("Examen aire ganglionnaire");
        model.addAttribute("examen", exam);
        model.addAttribute("patient", daoPatient.getOne(idPatient));
        return "formulaireExamenAireGanglionnaire";
    }

    /**
     * Appelé par 'formulaireExamen.html', méthode POST
     *
     * @param examen initialisé avec les valeurs saisies dans le formulaire
     * @param redirectInfo pour transmettre des paramètres lors de la
     * redirection
     * @return une redirection vers l'affichage de la liste des examens
     */
    @PostMapping(path = "save")
    public String ajouteExamenPuisMontreLaListe(Examen examen, RedirectAttributes redirectInfo) {
        String message;
        try {
            daoExamen.save(examen);
            //System.out.println("SADGoitre.controller.ExamenController.ajouteExamenPuisMontreLaListe()" + examen.getId_examen());
            for (Valeur_examen v : examen.getValeur_examen()) {
                //System.out.println("nom " + v.getNom_valeur() + " " + v.getValeur() + " " + v.isEst_valeur() + " id " + v.getId_valeur_examen());
                v.setExamen_valeur(examen);
                daoValeurExam.save(v);
            }
            // Le code de la catégorie a été initialisé par la BD au moment de l'insertion
            message = "L'examen '" + examen.getNom_examen() + "' a été correctement enregistré";
        } catch (DataIntegrityViolationException e) {
            // Les noms sont définis comme 'UNIQUE' 
            // En cas de doublon, JPA lève une exception de violation de contrainte d'intégrité
            message = "Erreur : L'examen '" + examen.getNom_examen() + "' existe déjà";
        }
        // RedirectAttributes permet de transmettre des informations lors d'une redirection,
        // Ici on transmet un message de succès ou d'erreur
        // Ce message est accessible et affiché dans la vue 'afficheAnimal.html'
        redirectInfo.addFlashAttribute("message", message);
//        return "redirect:/patient/show?idMedecin=" + examen.getPatient_examen().getMedecin_patient().getId_medecin();
        return "redirect:/examen/show?idPatient=" + examen.getPatient_examen().getId_patient();
        //return "redirect:/patient/get?idPatient=" + examen.getPatient_examen().getId_patient(); // POST-Redirect-GET : on se redirige vers l'affichage de la liste		
    }
}
