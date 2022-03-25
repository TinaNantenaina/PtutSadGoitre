/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SADGoitre.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private Integer id_examen;
    
    @NonNull
    private String nom_examen;
    
    private boolean est_examen_clinique;
    
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_examen;
    
    // Mapping
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_patient")
    private Patient patient_examen;
    
    @OneToMany(mappedBy = "examen_valeur")
    private List<Valeur_examen> valeur_examen;
    
}