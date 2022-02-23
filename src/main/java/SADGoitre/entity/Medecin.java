/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author Tina
 */
@Entity
    @Getter
    @Setter
    @RequiredArgsConstructor
    @NoArgsConstructor
    @ToString
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_medecin;
    
    @NonNull
    private String nom;
    
    @NonNull
    private String prenom;
    
    @NonNull
    private String RPPS;
    
    //Mapping
    @OneToMany(mappedBy="medecin_patient")
    private List<Patient> mes_patients = new LinkedList<>();
}
