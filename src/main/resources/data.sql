/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Tina
 * Created: 23 févr. 2022
 */

INSERT INTO Medecin(id_medecin,nom,prenom,RPPS) VALUES
(3,'Grey','Meredith','124569852');

INSERT INTO Patient(id_patient,nom,prenom,genre,date_naissance,id_medecin) VALUES
(1,'Leroy','Julie',true,'1999-01-06',3);


INSERT INTO Anamnese(id_anamnese,signe_De_Compression) VALUES
(1,false);

INSERT INTO AtcdFamilialMedical(id_atcd_fam,nem2,cancer_thyroidien) VALUES
(1,false,false);

INSERT INTO AtcdPersonnelMedical(id_atcd_pers,nom) VALUES
(1,'Diabete');

INSERT INTO Diagnostic(id_diagnostic,nom_diagnostic,pourcentage) VALUES
(1,'Goitre Simple',50.0);

INSERT INTO Examen(id_examen,nom_examen,est_Examen_Clinique,date_Examen,valeur) VALUES
(1,'Examen cervicale',true,'2022-01-12','augmentation volume');

INSERT INTO SigneFonctionnel(id_Signe_Fonctionnel,date_SF,type_SF) VALUES 
(1,'2022-01-12','HYPOTHYROIDIE');

INSERT INTO Symptome(id_Symptome,nom) VALUES
(1,'Toux');

