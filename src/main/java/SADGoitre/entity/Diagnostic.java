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
import lombok.ToString;

/**
 *
 * @author agath
 */

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Diagnostic {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id_diagnostic;
    
    @NonNull
    private String nom_diagnostic;
    
    @NonNull
    private float pourcentage;
    
    // Mapping
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_patient")
    private Patient patient_diagnostique;
    
}
