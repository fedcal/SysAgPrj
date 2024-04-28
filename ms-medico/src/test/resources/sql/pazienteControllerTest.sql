
INSERT INTO profilo(id_profilo,tipo,descrizione) VALUES
(1,'Paziente','Paziente'),
(2,'Medico','Medico');

INSERT INTO medico(id_medico,nome,cognome,turno,tipo_account) VALUES
(1,'Medico','Medico','Turno',2);

INSERT INTO reparto(id_reparto,nome_reparto,descrizione,ala_reparto,capo_reparto) VALUES
(1,'Medicina','Medicina generale','2 a',1);

INSERT INTO contatto_riferimento(id_contatto,nome,cognome,numero_cellulare) VALUES
(1,'ContattoRiferimento','Riferimento','+39123456789'),
(2,'ContattoRiferimento','Riferimento','+39123456789');

INSERT INTO cartella_clinica(id_cartella_clinica,gruppo_sanguigno) VALUES
(1,'A+'),
(2,'A+');

INSERT INTO paziente(id_paziente,nome,cognome,data_nascita,luogo_nascita,provincia_nascita,contatto_riferimento,id_reparto
,tipo_account,id_cartella_clinica) VALUES
(1,'Giuseppe','Garibaldi','07-05-2005','Galatina','LE',1,1,1,1),
(2,'Pippo','Garibaldi','07-05-2005','Galatina','LE',2,1,1,2);

INSERT INTO diagnosi(id_diagnosi,tipo_diagnosi,descrizione,id_cartella_clinica) VALUES
(1,'Diagnosi 1','Descrizione',2);
