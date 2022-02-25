/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.dao;

import SADGoitre.entity.Atcd_personnel_medical;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tina
 */
public interface AtcdPersRepository extends JpaRepository<Atcd_personnel_medical, Integer>{
    
}
