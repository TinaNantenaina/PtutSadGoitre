/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.AnamneseRepository;
import SADGoitre.dao.SymptomeRepository;
import SADGoitre.entity.Anamnese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tina
 */
@Controller
@RequestMapping (path="/symptome")
public class SymptomeController {
    
   @Autowired
   private SymptomeRepository daoSymptome;
   @Autowired
   private AnamneseRepository daoAnamnese;
    
   /**
     * Affiche toutes les catégories dans la base
     *
     * @param model pour transmettre les informations à la vue
     * @param anamnese 
     * @return le nom de la vue à afficher ('afficheSymptomes.html')
     */
    
        @GetMapping(path = "show")
    public String afficheTousLesExamens(Model model, Anamnese anamnese) {
        model.addAttribute("symptomes", daoAnamnese.getOne(anamnese.getIdAnamnese()).getMesSymptomes());
        return "afficheSymptomes";
    }
    
    
}
