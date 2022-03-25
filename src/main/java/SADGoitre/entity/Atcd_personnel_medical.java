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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Atcd_personnel_medical {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_atcd_pers;
     
    @NonNull
    private String nom_atcd_perso;
    
    private String valeur_atcd_perso;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_anamnese")
    private Anamnese anamnese;
    
    
}
