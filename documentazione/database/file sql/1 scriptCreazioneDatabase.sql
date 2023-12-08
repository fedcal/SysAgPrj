CREATE DATABASE IF NOT EXISTS SistemaSanitario;
USE sistemasanitario;

-- CONTATTO_RIFERIMENTO
CREATE TABLE IF NOT EXISTS contatto_riferimento(id_contatto INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(100),
cognome VARCHAR(100), numero_cellulare VARCHAR(20));

-- OPERAZIONE ACCOUNT
CREATE TABLE IF NOT EXISTS operazione_account(id_operazione INT PRIMARY KEY AUTO_INCREMENT, nome_operazione VARCHAR(30), descrizione VARCHAR(500));

-- PROFILO
CREATE TABLE IF NOT EXISTS profilo(id_profilo INT PRIMARY KEY AUTO_INCREMENT, tipo VARCHAR(30), descrizione VARCHAR(100));

-- OPERAZIONE CONSENTITA
CREATE TABLE IF NOT EXISTS operazione_consentita(id_operazione INT PRIMARY KEY AUTO_INCREMENT, tipo_account INT, operazione INT, 
FOREIGN KEY (tipo_account) REFERENCES profilo(id_profilo) ON DELETE CASCADE,
FOREIGN KEY (operazione) REFERENCES operazione_account(id_operazione) ON DELETE CASCADE);

-- MEDICO
CREATE TABLE IF NOT EXISTS medico(id_medico INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), cognome VARCHAR(30), turno VARCHAR(500), tipo_account INT,
FOREIGN KEY (tipo_account) REFERENCES profilo(id_profilo) ON DELETE CASCADE);

-- INFERIMIERE
CREATE TABLE IF NOT EXISTS infermiere(id_infermiere INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), cognome VARCHAR(30), turno VARCHAR(500), tipo_account INT, 
FOREIGN KEY (tipo_account) REFERENCES profilo(id_profilo) ON DELETE CASCADE);

-- REPARTO
CREATE TABLE IF NOT EXISTS reparto(id_reparto INT PRIMARY KEY AUTO_INCREMENT, capo_reparto INT, nome_reparto VARCHAR(50), descrizione VARCHAR(100), ala_reparto VARCHAR(100),
FOREIGN KEY (capo_reparto) REFERENCES medico(id_medico) ON DELETE CASCADE);

-- REPARTO MEDICO
CREATE TABLE IF NOT EXISTS reparto_medico(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_medico INT, id_reparto INT, FOREIGN KEY (id_medico) REFERENCES medico(id_medico),
FOREIGN KEY(id_reparto) REFERENCES reparto(id_reparto) ON DELETE CASCADE);

-- REPARTO INFERMIERE
CREATE TABLE IF NOT EXISTS reparto_infermiere(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_infermiere INT, id_reparto INT, 
FOREIGN KEY(id_infermiere) REFERENCES infermiere(id_infermiere),
FOREIGN KEY (id_reparto) REFERENCES reparto(id_reparto) ON DELETE CASCADE);

-- PAZIENTE 
CREATE TABLE IF NOT EXISTS paziente (id_paziente INT PRIMARY KEY AUTO_INCREMENT, id_reparto INT, nome VARCHAR(30), cognome VARCHAR(30), data_nascita DATE,
luogoNascita VARCHAR(50),  provinciaNascita VARCHAR(50), contatto_riferimento INT, tipo_account INT,
FOREIGN KEY (id_reparto) REFERENCES reparto(id_reparto) ON DELETE CASCADE,
FOREIGN KEY (contatto_riferimento) REFERENCES contatto_riferimento(id_contatto) ON DELETE CASCADE,
FOREIGN KEY (tipo_account) REFERENCES profilo(id_profilo));

-- CARTELLA CLINICA
CREATE TABLE IF NOT EXISTS cartella_clinica(id_cartella_clinica INT PRIMARY KEY AUTO_INCREMENT, gruppo_sanguigno VARCHAR(3), id_paziente INT,
FOREIGN KEY (id_paziente) REFERENCES paziente(id_paziente) ON DELETE CASCADE);

-- DIAGNOSI
CREATE TABLE IF NOT EXISTS diagnosi(id_diagnosi INT PRIMARY KEY AUTO_INCREMENT, id_cartella_clinica INT, tipo_diagnosi VARCHAR(30), descrizione VARCHAR(100),
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE);

-- REFERTO VISITA MEDICA
CREATE TABLE IF NOT EXISTS referto_visita_medica(id_referto INT PRIMARY KEY AUTO_INCREMENT, tipologia VARCHAR(30), descrizione VARCHAR(100), data_referto DATE);

-- REFERTO OPERAZIONE
CREATE TABLE IF NOT EXISTS referto_operazione (id_referto INT PRIMARY KEY AUTO_INCREMENT, tipologia VARCHAR(30), descrizione VARCHAR(100), data_referto DATE);

-- REFERTO OPERAZIONE SPECIALISTA
CREATE TABLE IF NOT EXISTS referto_operazione_specialista (id_referto INT PRIMARY KEY AUTO_INCREMENT, tipologia VARCHAR(30), descrizione VARCHAR(100), data_referto DATE);

-- MEDICINALE
CREATE TABLE IF NOT EXISTS medicinale (id_medicinale INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), descrizione VARCHAR(100), dosaggio VARCHAR(30));

-- VISITA MEDICA
CREATE TABLE IF NOT EXISTS visita_medica (id_visita_medica INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), tipologia VARCHAR(30), descrizione VARCHAR(100));

-- OPERAZIONE MEDICA
CREATE TABLE IF NOT EXISTS operazione_medica (id_operazione_medica INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), tipologia VARCHAR(30), descrizione VARCHAR(100));

-- MEDICINALE CARTELLA
CREATE TABLE IF NOT EXISTS medicinale_cartella(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_medicinale INT, id_cartella_clinica INT,
FOREIGN KEY (id_medicinale) REFERENCES medicinale(id_medicinale) ON DELETE CASCADE,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE);

-- VISITA MEDICA CARTELLA
CREATE TABLE IF NOT EXISTS visita_medicaCartella (id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_visita_medica INT, id_cartella INT, id_referto INT, 
FOREIGN KEY (id_visita_medica) REFERENCES visita_medica(id_visita_medica) ON DELETE CASCADE, 
FOREIGN KEY (id_cartella) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY (id_referto) REFERENCES referto_visita_medica(id_referto) ON DELETE CASCADE);

-- OPERAZIONE CARTELLA
CREATE TABLE IF NOT EXISTS operazione_cartella (id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_operazione INT, id_cartella INT, id_referto INT, id_medico INT,
FOREIGN KEY (id_operazione) REFERENCES operazione_medica(id_operazione_medica) ON DELETE CASCADE,
FOREIGN KEY (id_cartella) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY (id_referto) REFERENCES referto_operazione(id_referto) ON DELETE CASCADE,
FOREIGN KEY (id_medico) REFERENCES medico(id_medico) ON DELETE CASCADE); 

-- VISITA SOTTOMINISTRAZIONE INFERMIERE
CREATE TABLE IF NOT EXISTS visita_sottoministrazione_infermiere (id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_infermiere INT, id_visita INT, id_cartella_clinica INT,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY(id_infermiere) REFERENCES infermiere(id_infermiere) ON DELETE CASCADE,
FOREIGN KEY(id_visita) REFERENCES visita_medica(id_visita_medica) ON DELETE CASCADE);

-- VISITA PRESCRIZIONE 
CREATE TABLE IF NOT EXISTS visita_prescrizione (id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_medico INT, id_visita INT, id_cartella_clinica INT,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY(id_medico) REFERENCES medico(id_medico) ON DELETE CASCADE,
FOREIGN KEY(id_visita) REFERENCES visita_medica(id_visita_medica)ON DELETE CASCADE);

-- MEDICINALE PRESCRIZIONE
CREATE TABLE IF NOT EXISTS medicinale_prescrizione (id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_medico INT, id_medicinale INT, id_cartella_clinica INT,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY(id_medico) REFERENCES medico(id_medico) ON DELETE CASCADE,
FOREIGN KEY(id_medicinale) REFERENCES medicinale(id_medicinale)ON DELETE CASCADE);

-- MEDICINALE SOTTOMINNISTRAZIONE
CREATE TABLE IF NOT EXISTS medicinale_sottoministrazione (id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_infermiere INT, id_medicinale INT, id_cartella_clinica INT,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY(id_infermiere) REFERENCES infermiere(id_infermiere) ON DELETE CASCADE,
FOREIGN KEY(id_medicinale) REFERENCES medicinale(id_medicinale) ON DELETE CASCADE);

-- SPECIALISTA
CREATE TABLE IF NOT EXISTS specialista(id_specialista INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), cognome VARCHAR(30), specializzazione VARCHAR(50),turno VARCHAR(500), tipo_account INT, 
FOREIGN KEY(tipo_account) REFERENCES profilo(id_profilo) ON DELETE CASCADE);

-- VISITA SOTTOMINISTRAZIONE SPECIALISTA
CREATE TABLE IF NOT EXISTS visita_sottoministrazione_specialista(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_specialista INT, id_cartella_clinica INT, id_visita INT,
FOREIGN KEY (id_specialista) REFERENCES specialista(id_specialista) ON DELETE CASCADE,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY (id_visita) REFERENCES visita_medica(id_visita_medica) ON DELETE CASCADE);

-- VISITA SOTTOMINISTRAZIONE MEDICO
CREATE TABLE IF NOT EXISTS visita_sottoministrazione_medico(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_medico INT, id_cartella_clinica INT, id_visita INT,
FOREIGN KEY (id_medico) REFERENCES medico(id_medico) ON DELETE CASCADE,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY (id_visita) REFERENCES visita_medica(id_visita_medica) ON DELETE CASCADE);

-- OPERAZIONE SPECIALISTA
CREATE TABLE IF NOT EXISTS Operazionespecialista(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_specialista INT, id_operazione INT, id_cartella_clinica INT, id_referto_operazione_specialista INT,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY (id_specialista) REFERENCES specialista(id_specialista) ON DELETE CASCADE,
FOREIGN KEY (id_operazione) REFERENCES operazione_medica(id_operazione_medica) ON DELETE CASCADE,
FOREIGN KEY (id_referto_operazione_specialistaid_referto_operazione_specialista) REFERENCES referto_operazione_specialista(id_referto) ON DELETE CASCADE);

-- SINTOMO
CREATE TABLE IF NOT EXISTS sintomo(id_sintomo INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(100), descrizione VARCHAR(5000));

-- MALATTIA
CREATE TABLE IF NOT EXISTS malattia(id_malattia INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(50), descrizione VARCHAR(5000));

-- SINTOMO MALATTIA
CREATE TABLE IF NOT EXISTS sintomo_malattia(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_malattia INT, id_sintomo INT,
FOREIGN KEY (id_malattia) REFERENCES malattia(id_malattia), 
FOREIGN KEY (id_sintomo)  REFERENCES sintomo(id_sintomo));

-- MALATTIA CARTELLA
CREATE TABLE IF NOT EXISTS malattia_cartella(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_malattia INT, id_cartella INT,
FOREIGN KEY (id_malattia) REFERENCES malattia(id_malattia), 
FOREIGN KEY (id_cartella) REFERENCES cartella_clinica(id_cartella_clinica));
