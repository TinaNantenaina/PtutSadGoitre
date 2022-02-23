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
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author agath
 **/
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class Anamnese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_anamnese;
    
    @NonNull
    private boolean signeDeCompression;
    
    //Mapping
    @OneToMany(mappedBy="id_signe_fonctionnel")
    @NonNull
    private List<SigneFonctionnel> signes_fonctionnels = new LinkedList<>();
    
    @OneToMany(mappedBy="id_atcd_fam")
    private List<AtcdFamilialMedical> atcd_familial = new LinkedList<>();
    
    @OneToMany(mappedBy="id_atcd_pers")
    private List<AtcdPersonnelMedical> atcd_personnel = new LinkedList<>();
    
    @OneToOne(mappedBy="anamnese")
    private Patient patient;
    
    @OneToMany(mappedBy="anamnese")
    @NonNull
    private List<Symptome> mes_symptomes = new LinkedList<>();
}
