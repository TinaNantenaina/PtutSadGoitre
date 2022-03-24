/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.dao;

import SADGoitre.entity.Valeur_examen;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author agath
 */
public interface ValeurExamenRepository extends JpaRepository <Valeur_examen, Integer>{
    
}
