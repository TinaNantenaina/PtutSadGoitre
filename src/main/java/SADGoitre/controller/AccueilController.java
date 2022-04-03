/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.MedecinRepository;
import SADGoitre.entity.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author agath
 */
@Controller
public class AccueilController {
    @Autowired
    private MedecinRepository daoMedecin;
    
     @GetMapping({"/"})
    public String welcome(Model model) {
        Medecin medecin = daoMedecin.getOne(3);
        model.addAttribute("medecin", medecin);
        return "PageAccueil";
    }
    
    @GetMapping({"/error"})
    public String error(Model model) {
        return "error";
    }
}
