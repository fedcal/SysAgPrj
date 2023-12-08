INSERT INTO operazione_account(id_operazione,nome_operazione,descrizione) VALUES 
(1,"Visualizza pazienti","Visualizza tutti i pazienti presenti nella struttura"),
(2,"Visualizza paziente","Visualizza tutte le informazioni di un dato paziente nella struttura"),
(3,"Prescrivere visita","Prescrive la visita a un paziente"),
(4,"Prescrivere farmaco","Prescrive un farmaco a un paziente"),
(5,"Prescrivere operazione","Prescrive un'operazione a un paziente"),
(6,"Effettuare operazione","Effettuare un'operazione a un paziente"),
(7,"Effettuare visita","Effettuare una visita a un paziente"),
(8,"Somministrare farmaco","Somministrare farmaco a un paziente"),
(9,"Vedere cartella clinica","Vedere la cartella clinica"),
(10,"Chiamare medico","Chiamare medico"),
(11,"Chiamare infermiere","Chiamare infermiere"),
(12,"Chiamare specialista","Chiamare specialista");

INSERT INTO profilo(id_profilo,tipo,descrizione) VALUES
(1,"Medico","Medico presente nella struttura"),
(2,"Infermiere","Infermiere presente nella struttura"),
(3,"Specialista","Specialista presente nella struttura"),
(4,"Paziente","Paziente preso in cura nella struttura");

INSERT INTO operazione_consentita(id_operazione,tipo_account,operazione) VALUES
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,5),
(6,1,6),
(7,1,7),
(8,1,8),
(9,1,9),
(10,1,10),
(11,1,11),
(12,1,12),

(13,2,1),
(14,2,2),
(15,2,3),
(16,2,4),
(17,2,5),
(18,2,6),
(19,2,7),
(20,2,8),
(21,2,9),
(22,2,10),
(23,2,11),
(24,2,12),

(25,3,1),
(26,3,2),
(27,3,3),
(28,3,4),
(29,3,5),
(30,3,6),
(31,3,7),
(32,3,8),
(33,3,9),
(34,3,10),
(35,3,11),
(36,3,12),

(37,4,9),
(38,4,10),
(39,4,11),
(40,4,12);
