/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.dao;

import SADGoitre.entity.Anamnese;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tina
 */
public interface AnamneseRepository extends JpaRepository <Anamnese, Integer>{
    
}
