/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Tina
 * Created: 23 févr. 2022
 */
INSERT INTO Medecin(idMedecin,nom,prenom,RPPS) VALUES
(1,'Grey','Meredith','124569852');

INSERT INTO Patient(idPatient,nom,prenom,genre,dateNaissance) VALUES
(1,'Leroy','Julie',true,'1999-01-06'),
(2,'Kim','Taehyung',false,'1995-12-30');

INSERT INTO Anamnese(idAnamnese,signeDeCompression) VALUES
(1,false);

INSERT INTO AtcdFamialMedical(idAtcdFam,NEM2,cancerThyroidien) VALUES
(1,false,false);

INSERT INTO AtcdPersonnelMedical(idAtcdPers,nom) VALUES
(1,'Diabete');

INSERT INTO Diagnostic(idDiagnostic,nomDiagnostic,pourcentage) VALUES
(1,'Goitre Simple',50.0);

INSERT INTO Examen(idExamen,nomExamen,estExamenClinique,dateExamen,valeur) VALUES
(1,'Examen cervicale',true,'2022-01-12','augmentation volume');

INSERT INTO SigneFonctionnel(idSigneFonctionnel,dateSF,typeSF) VALUES 
(1,'2022-01-12','HYPOTHYROIDIE');

INSERT INTO Symptome(idSymptome,nom) VALUES
(1,'Toux');

