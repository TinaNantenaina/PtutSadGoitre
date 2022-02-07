/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SADGoitre.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class SigneFonctionnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSigneFonctionnel;
    
    @NonNull
    @Enumerated(EnumType.STRING)
    private TypeSF typeSF;
    
    @NonNull
    private List<String> nomSymptome;
    
    //Mapping
    /*@ManyToOne(optional = false)
    @JoinColumn(name = "idAnamnese")
    private Anamnese anamnese;*/
}
