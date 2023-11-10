CREATE DATABASE IF NOT EXISTS SistemaSanitario;
USE sistemasanitario;

-- ContattoRiferimento
CREATE TABLE IF NOT EXISTS ContattoRiferimento(idContatto INT PRIMARY KEY, nome VARCHAR(100),
cognome VARCHAR(100), numeroCellulare VARCHAR(20));

-- Operazione Account
CREATE TABLE IF NOT EXISTS OperazioneAccount(idOperazione INT PRIMARY KEY, nomeOperazione VARCHAR(30), descrizione VARCHAR(30));

-- Account
CREATE TABLE IF NOT EXISTS Profilo(idProfilo INT PRIMARY KEY, tipo VARCHAR(30), descrizione VARCHAR(100));

-- OPERAZIONE CONSENTITA
CREATE TABLE IF NOT EXISTS OperazioneConsentita(idOperazione INT PRIMARY KEY, tipoAccount INT, operazione INT, 
FOREIGN KEY (tipoAccount) REFERENCES Profilo(idProfilo), FOREIGN KEY (operazione) REFERENCES operazioneAccount(idOperazione));

-- MEDICO
CREATE TABLE IF NOT EXISTS Medico(idMedico INT PRIMARY KEY, nome varchar(30), cognome varchar(30), specializzazione varchar(100),
tipoAccount int, foreign key (tipoAccount) references Profilo(idProfilo));

-- INFERIMIERE
create table if not exists Infermiere(idInfermiere int primary key, nome varchar(30), cognome varchar(30), tipoAccount int, foreign key (tipoAccount)
references Profilo(idProfilo));

-- REPARTO
create table if not exists Reparto(idReparto int primary key, capoReparto int, nomeReparto varchar(50), descrizione varchar(100), alaReparto varchar(100),
foreign key (capoReparto) references Medico(idMedico));

-- REPARTO MEDICO
create table if not exists RepartoMedico(idRelazione int primary key, idMedico int, idReparto int, foreign key (idMedico) references Medico(idMedico),
foreign key(idReparto) references Reparto(idReparto));

-- REPARTO INFERMIERE
create table if not exists RepartoInfermiere(idRelazione int primary key, idInfermiere int, idReparto int, 
foreign key(idInfermiere) references Infermiere(idInfermiere), foreign key (idReparto) references Reparto(idReparto));

-- PAZIENTE 

