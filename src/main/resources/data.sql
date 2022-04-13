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
INSERT INTO Patient(id_patient,nom,prenom,genre,date_naissance,id_medecin) VALUES
(2,'Bob','Marnie',false,'1987-05-13',3);
INSERT INTO Patient(id_patient,nom,prenom,genre,date_naissance,id_medecin) VALUES
(3,'Kim','Tae',false,'1997-12-30',3);
INSERT INTO Patient(id_patient,nom,prenom,genre,date_naissance,id_medecin) VALUES
(4,'Toto','Berto',false,'2000-03-30',3);
INSERT INTO Patient(id_patient,nom,prenom,genre,date_naissance,id_medecin) VALUES
(5,'Mona','Lisa',true,'1952-08-06',3);

INSERT INTO Anamnese(id_anamnese,signe_De_Compression) VALUES
(1,false);
INSERT INTO Anamnese(id_anamnese,signe_De_Compression) VALUES
(2,false);
INSERT INTO Anamnese(id_anamnese,signe_De_Compression) VALUES
(3,true);
INSERT INTO Anamnese(id_anamnese,signe_De_Compression) VALUES
(4,false);
INSERT INTO Anamnese(id_anamnese,signe_De_Compression) VALUES
(5,true);

INSERT INTO Atcd_Familial_Medical(id_atcd_fam,nem2,cancer_thyroidien) VALUES
(1,false,false);
INSERT INTO Atcd_Familial_Medical(id_atcd_fam,nem2,cancer_thyroidien) VALUES
(2,true,true);
INSERT INTO Atcd_Familial_Medical(id_atcd_fam,nem2,cancer_thyroidien) VALUES
(3,false,true);
INSERT INTO Atcd_Familial_Medical(id_atcd_fam,nem2,cancer_thyroidien) VALUES
(4,true,false);
INSERT INTO Atcd_Familial_Medical(id_atcd_fam,nem2,cancer_thyroidien) VALUES
(5,false,false);


INSERT INTO Atcd_Personnel_Medical(id_atcd_pers,nom_atcd_perso,id_anamnese) VALUES
(1,'Diabete',1);
INSERT INTO Atcd_Personnel_Medical(id_atcd_pers,nom_atcd_perso,id_anamnese) VALUES
(2,'HTA',2);
INSERT INTO Atcd_Personnel_Medical(id_atcd_pers,nom_atcd_perso,id_anamnese) VALUES
(3,'Diabete',3);
INSERT INTO Atcd_Personnel_Medical(id_atcd_pers,nom_atcd_perso,id_anamnese) VALUES
(4,'Cancer',4);
INSERT INTO Atcd_Personnel_Medical(id_atcd_pers,nom_atcd_perso,id_anamnese) VALUES
(5,'Diabete',5);

INSERT INTO Diagnostic(id_diagnostic,nom_diagnostic,pourcentage, id_patient) VALUES
(1,'Goitre Simple',50.0,1);
INSERT INTO Diagnostic(id_diagnostic,nom_diagnostic,pourcentage, id_patient) VALUES
(2,'Maladie de Hashimoto',80.0,2);
INSERT INTO Diagnostic(id_diagnostic,nom_diagnostic,pourcentage, id_patient) VALUES
(3,'Goitre Iatrogénique',20.0,3);
INSERT INTO Diagnostic(id_diagnostic,nom_diagnostic,pourcentage, id_patient) VALUES
(4,'Goitre Simple',30.0,4);
INSERT INTO Diagnostic(id_diagnostic,nom_diagnostic,pourcentage, id_patient) VALUES
(5,'Goitre Simple',70.0,5);

INSERT INTO Examen(id_examen,nom_examen,est_Examen_Clinique,date_Examen, id_patient) VALUES
(1,'Signes généraux',true,'2022-01-12',1);
INSERT INTO Examen(id_examen,nom_examen,est_Examen_Clinique,date_Examen, id_patient) VALUES
(2,'Examen cervicale',true,'2022-01-12',2);
INSERT INTO Examen(id_examen,nom_examen,est_Examen_Clinique,date_Examen, id_patient) VALUES
(3,'Examen cervicale',true,'2022-01-12',3);
INSERT INTO Examen(id_examen,nom_examen,est_Examen_Clinique,date_Examen, id_patient) VALUES
(4,'Examen cervicale',true,'2022-01-12',4);
INSERT INTO Examen(id_examen,nom_examen,est_Examen_Clinique,date_Examen, id_patient) VALUES
(5,'Examen cervicale',true,'2022-01-12',5);


INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(1, 'Fièvre', true, '39°C', 1);
INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(3, 'Fièvre', true, '39°C', 2);
INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(4, 'Fièvre', true, '39°C', 3);
INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(5, 'Fièvre', true, '39°C', 4);
INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(6, 'Fièvre', true, '39°C', 5);

INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(2, 'Prise de poids', false, '', 1);
INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(7, 'Prise de poids', false, '', 2);
INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(8, 'Prise de poids', false, '', 3);
INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(9, 'Prise de poids', false, '', 4);
INSERT INTO VALEUR_examen(id_valeur_examen, nom_valeur, est_valeur, valeur, id_examen) VALUES 
(10, 'Prise de poids', false, '', 5);

INSERT INTO Signe_Fonctionnel(id_Signe_Fonctionnel,date_SF, type_SF, id_anamnese) VALUES 
(1,'2022-01-12','HYPOTHYROIDIE', 1);
INSERT INTO Signe_Fonctionnel(id_Signe_Fonctionnel,date_SF, type_SF, id_anamnese) VALUES 
(2,'2022-01-12','HYPERTHYROIDIE', 2);
INSERT INTO Signe_Fonctionnel(id_Signe_Fonctionnel,date_SF, type_SF, id_anamnese) VALUES 
(3,'2022-01-12','EUTHYROIDIE', 3);
INSERT INTO Signe_Fonctionnel(id_Signe_Fonctionnel,date_SF, type_SF, id_anamnese) VALUES 
(4,'2022-01-12','HYPOTHYROIDIE', 4);
INSERT INTO Signe_Fonctionnel(id_Signe_Fonctionnel,date_SF, type_SF, id_anamnese) VALUES 
(5,'2022-01-12','HYPOTHYROIDIE', 5);

INSERT INTO Symptome(id_Symptome,nom, id_anamnese) VALUES
(1,'Toux',1);
INSERT INTO Symptome(id_Symptome,nom, id_anamnese) VALUES
(2,'Dyspnee',2);
INSERT INTO Symptome(id_Symptome,nom, id_anamnese) VALUES
(3,'Toux',3);
INSERT INTO Symptome(id_Symptome,nom, id_anamnese) VALUES
(4,'Aphasie',4);
INSERT INTO Symptome(id_Symptome,nom, id_anamnese) VALUES
(5,'Toux',5);

