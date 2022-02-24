/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Tina
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Atcd_familial_medical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_atcd_fam;
    
    @NonNull
    private boolean nem2;
    
    @NonNull
    private boolean cancer_thyroidien;
    
}
