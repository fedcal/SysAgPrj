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
create table if not exists Paziente (idPaziente int primary key, idReparto int, nome varchar(30), cognome varchar(30), dataNascita date,
luogoNascita varchar(50),  provinciaNascita varchar(50), contattoRiferimento int, tipoAccount int, foreign key (idReparto) 
references Reparto(idReparto), foreign key (contattoRiferimento) references ContattoRiferimento(idContatto), foreign key (tipoAccount) 
references Profilo(idProfilo) );

-- CARTELLA CLINICA
create table if not exists CartellaClinica(idCartellaClinica int primary key, gruppoSanguigno varchar(3), idPaziente int, foreign key (idPAziente) 
references Paziente(idPaziente));

-- DIAGNOSI
create table if not exists Diagnosi(idDiagnosi int primary key, idCartellaClinica int, tipoDiagnosi varchar(30), descrizione varchar(100), foreign key 
(idCartellaClinica) references CartellaClinica(idCartellaClinica));

-- ALLERGIA
create table if not exists Allergia( idAllergia int primary key, idCartellaClinica int, tipoAllergia varchar(50), descrizione varchar(100), foreign key 
(idCartellaClinica) references CartellaClinica(idCartellaClinica));

-- REFERTO VISITA MEDICA
create table if not exists RefertoVisitaMedica(idReferto int primary key, tipologia varchar(30), descrizione varchar(100), dataReferto date);

-- REFERTO OPERAZIONE
create table if not exists RefertoOperazione (idReferto int primary key, tipologia varchar(30), descrizione varchar(100), dataReferto date);

-- MEDICINALE
create table if not exists Medicinale (idMedicinale int primary key, nome varchar(30), descrizione varchar(100), dosaggio varchar(30));

-- VISITA MEDICA
create table if not exists VisitaMedica (idVisitaMedica int primary key, nome varchar(30), tipologia varchar(30), descrizione varchar(100));

-- OPERAZIONE MEDICA
create table if not exists OperazioneMedica (idOperazioneMedica int primary key, nome varchar(30), tipologia varchar(30), descrizione varchar(100));

-- MEDICINALE CARTELLA
create table if not exists MedicinaleCartella(idRelazione int primary key, idMedicinale int, idCartellaClinica int, foreign key (idMedicinale)
references Medicinale(idMedicinale), foreign key (idCartellaClinica) references CartellaClinica(idCartellaClinica));

-- VISITA MEDICA CARTELLA
create table if not exists VisitaMedicaCartella (idRelazione int primary key, idVisitaMedica int, idCartella int, idReferto int, 
foreign key (idVisitaMedica) references VisitaMedica(idVisitaMedica), 
foreign key (idCartella) references CartellaClinica(idCartellaClinica),
foreign key (idReferto) references RefertoVisitaMedica(idReferto));

-- OPERAZIONE CARTELLA
create table if not exists OperazioneCartella (idRelazione int primary key, idOperazione int, idCartella int, idReferto int,
foreign key (idOperazione) references OperazioneMedica(idOperazioneMedica),
foreign key (idCartella) references CartellaClinica(idCartellaClinica),
foreign key (idReferto) references RefertoOperazione(idReferto)); 

-- OPERAZIONE DOTTORE
create table if not exists OperazioneDottore(idRelazione int primary key, idMedico int, idOperazione int, 
foreign key (idMedico) references Medico(idMedico),
foreign key (idOperazione) references OperazioneMedica(idOperazioneMedica));
