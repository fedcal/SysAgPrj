


INSERT INTO operazione_account(id_operazione,nome_operazione,descrizione) VALUES
(1,'Aggiungi','Aggiungi');

INSERT INTO profilo(id_profilo,tipo,descrizione) VALUES
(1,'Medico','Medico della struttura');

INSERT INTO operazione_consentita(id_operazione_consentita,tipo_account,operazione) VALUES
(1,1,1);

insert into medico(id_medico,nome,cognome,turno,tipo_account) VALUES
(1,'Francesco','De Ceglie', 'Lun. 9-18',1);

