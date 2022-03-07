/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SADGoitre.entity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Tina
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_patient;
    
    @NonNull
    private String nom;
    
    @NonNull
    private String prenom;
    
    private boolean genre;
    
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_naissance;
    
    //Mapping
    @OneToMany(mappedBy="patient_examen")
    @NonNull
    private List<Examen> mes_examens = new LinkedList<>();
    
    @OneToMany(mappedBy="patient_diagnostique")
    private List<Diagnostic> mes_diagnostics = new LinkedList<>();
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_medecin")
    private Medecin medecin_patient;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="anamnese_patient_id", referencedColumnName = "id_anamnese")
    private Anamnese anamnese;
    /*@OneToOne(mappedBy="patient")
    private Anamnese anamnese;*/
    
}
