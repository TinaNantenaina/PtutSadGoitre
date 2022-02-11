/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SADGoitre.entity;

import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author agathe
 */

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Examen {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idExamen;
    
    @NonNull
    private String nomExamen;
    
    @NonNull
    private boolean estExamenClinique;
    
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateExamen;
    
    @NonNull
    private String[] valeur;
    
    // Mapping
    @ManyToOne(optional = false)
    @JoinColumn(name = "idPatient")
    private Patient patientExamen;
    
    
}