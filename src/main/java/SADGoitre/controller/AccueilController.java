/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author agath
 */
@Controller
public class AccueilController {
     @GetMapping({"/"})
    public String welcome(Model model) {
        return "PageAccueil";
    }
    
    @GetMapping({"/error"})
    public String error(Model model) {
        return "error";
    }
}
