/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.entity;
<<<<<<< HEAD

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
=======
>>>>>>> 1b57e71636ea011bca92bb4ecfca274bfbe669a7

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
    private Integer idMedecin;
    
    @NonNull
    private String nom;
    
    @NonNull
    private String prenom;
    
    @NonNull
    private String RPPS;
}
