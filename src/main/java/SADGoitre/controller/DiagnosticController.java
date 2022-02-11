/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.DiagnosticRepository;
import SADGoitre.dao.ExamenRepository;
import SADGoitre.dao.MedecinRepository;
import SADGoitre.dao.PatientRepository;
import SADGoitre.dao.SigneFonctionnelRepository;
import SADGoitre.entity.Medecin;
import SADGoitre.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author agath
 */
@Controller
@RequestMapping(path = "/diagnostic" )
public class DiagnosticController {
    
    @Autowired
    private DiagnosticRepository daoDiagnostic;
    @Autowired
    private PatientRepository daoPatient;
    @Autowired
    private MedecinRepository daoMedecin;
    @Autowired
    private SigneFonctionnelRepository daoSF;
    @Autowired
    private ExamenRepository daoExamen;
    
    /**
     * Affiche toutes les diagnostics
     *
     * @param model pour transmettre les informations à la vue
     * @param idDiagnostic l'id du diagnostic concerné
     * @param patient le patient concerné 
     * @return le nom de la vue à afficher ('afficheDiagnostics.html')
     */
    @GetMapping(path = "show")
    public String afficheLesDiagnostics(Model model, Integer idDiagnostic, Patient patient ){
        model.addAttribute("diagnostics", daoDiagnostic.findAll());
        model.addAttribute("diagnostic", daoDiagnostic.getOne(patient.getIdPatient()));  
        model.addAttribute("patient", daoPatient.getOne(idDiagnostic));
        return "afficheDiagnostics";
    }
}