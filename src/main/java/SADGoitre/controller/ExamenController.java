/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.controller;

import SADGoitre.dao.AnamneseRepository;
import SADGoitre.dao.ExamenRepository;
import SADGoitre.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author agath
 */
@Controller
@RequestMapping (path="/examen")
public class ExamenController {
    @Autowired
    private ExamenRepository examenDao;
    
    @Autowired 
    private PatientRepository patientDao;
    
    @Autowired 
    private AnamneseRepository anamneseDao;
    
    
}
