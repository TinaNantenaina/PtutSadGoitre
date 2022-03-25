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

INSERT INTO Atcd_Familial_Medical(id_atcd_fam,nem2,cancer_thyroidien) VALUES
(1,false,false);

INSERT INTO Atcd_Personnel_Medical(id_atcd_pers,nom_atcd_perso,id_anamnese) VALUES
(1,'Diabete',1);

INSERT INTO Diagnostic(id_diagnostic,nom_diagnostic,pourcentage, id_patient) VALUES
(1,'Goitre Simple',50.0,1);

INSERT INTO Examen(id_examen,nom_examen,est_Examen_Clinique,date_Examen, id_patient) VALUES
(1,'Examen cervicale',true,'2022-01-12',1);

INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(1, 'Fièvre', true, '39°C', 1);

INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(2, 'Prise de poids', false, '', 1);

INSERT INTO Signe_Fonctionnel(id_Signe_Fonctionnel,date_SF, type_SF, id_anamnese) VALUES 
(1,'2022-01-12','HYPOTHYROIDIE', 1);

INSERT INTO Symptome(id_Symptome,nom, id_anamnese) VALUES
(1,'Toux',1);

