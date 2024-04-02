
INSERT INTO profilo(id_profilo, tipo, descrizione) VALUES
(4,'paziente','paziente'), (1,'Medico','');

INSERT INTO contatto_riferimento(id_contatto, nome,cognome, numero_cellulare) VALUES
(1,'Federico','Ferdinando','+39 123456789');

INSERT INTO cartella_clinica(id_cartella_clinica, gruppo_sanguigno) VALUES
(1,'0+');

INSERT INTO medico(id_medico, nome, cognome, turno, tipo_account) VALUES
(1,'Gianni','Franco','Lunedì 20:15 - 8:00',1);
INSERT INTO reparto(id_reparto, capo_reparto, nome_reparto, descrizione, ala_reparto) VALUES
    (1,1,'Medicina generale','Med gen','2');

INSERT INTO paziente (id_paziente, id_reparto, nome, cognome, data_nascita,
                                       luogo_nascita,  provincia_nascita, contatto_riferimento,
                                       tipo_account, id_cartella_clinica) VALUES
(1,1,'Petro','Del Giudice','01-01-2005','Galatina','LE',1,4,1);










