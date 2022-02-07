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
    
    @GetMapping(path = "show")
    public String afficheLesDiagnostics(Model model, Integer id){
        model.addAttribute("diagnostics", daoDiagnostic.findAll());
        model.addAttribute("diagnostic", daoDiagnostic.getOne(id));        
        return "afficheDiagnostics";
    }
}
