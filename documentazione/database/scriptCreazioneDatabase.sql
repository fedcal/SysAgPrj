CREATE DATABASE IF NOT EXISTS SistemaSanitario;
USE sistemasanitario;

-- CONTATTO_RIFERIMENTO
CREATE TABLE IF NOT EXISTS contatto_riferimento(id_contatto INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(100),
cognome VARCHAR(100), numero_cellulare VARCHAR(20));

-- OPERAZIONE ACCOUNT
CREATE TABLE IF NOT EXISTS operazione_account(id_operazione INT PRIMARY KEY AUTO_INCREMENT, nome_operazione VARCHAR(30), descrizione VARCHAR(30));

-- PROFILO
CREATE TABLE IF NOT EXISTS profilo(id_profilo INT PRIMARY KEY AUTO_INCREMENT, tipo VARCHAR(30), descrizione VARCHAR(100));

-- OPERAZIONE CONSENTITA
CREATE TABLE IF NOT EXISTS operazione_consentita(id_operazione INT PRIMARY KEY AUTO_INCREMENT, tipo_account INT, operazione INT, 
FOREIGN KEY (tipo_account) REFERENCES profilo(id_profilo) ON DELETE CASCADE,
FOREIGN KEY (operazione) REFERENCES operazione_account(id_operazione) ON DELETE CASCADE);

-- MEDICO
CREATE TABLE IF NOT EXISTS medico(id_medico INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), cognome VARCHAR(30), specializzazione VARCHAR(100), tipo_account INT,
FOREIGN KEY (tipo_account) REFERENCES profilo(id_profilo) ON DELETE CASCADE);

-- INFERIMIERE
CREATE TABLE IF NOT EXISTS infermiere(id_infermiere INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), cognome VARCHAR(30), tipo_account INT, 
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
CREATE TABLE IF NOT EXISTS paziente (id_paziente INT PRIMARY KEY AUTO_INCREMENT, id_reparto INT, nome VARCHAR(30), cognome VARCHAR(30), data_nascita date,
luogoNascita VARCHAR(50),  provinciaNascita VARCHAR(50), contatto_riferimento INT, tipo_account INT,
FOREIGN KEY (id_reparto) REFERENCES reparto(id_reparto) ON DELETE CASCADE,
FOREIGN KEY (contatto_riferimento) REFERENCES contatto_riferimento(id_contatto) ON DELETE CASCADE,
FOREIGN KEY (tipo_account) REFERENCES profilo(id_profilo));

-- CARTELLA CLINICA
CREATE TABLE IF NOT EXISTS cartella_clinica(id_cartella_clinica INT PRIMARY KEY AUTO_INCREMENT, gruppo_sanguigno VARCHAR(3), id_paziente INT,
FOREIGN KEY (id_paziente) REFERENCES paziente(id_paziente) ON DELETE CASCADE);

-- DIAGNOSI
CREATE TABLE IF NOT EXISTS diagnosi(id_diagnosi INT PRIMARY KEY AUTO_INCREMENT, id_cartella_clinica INT, tipodiagnosi VARCHAR(30), descrizione VARCHAR(100),
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE);

-- ALLERGIA
CREATE TABLE IF NOT EXISTS allergia(id_allergia INT PRIMARY KEY AUTO_INCREMENT, tipo_allergia VARCHAR(50), descrizione VARCHAR(100));

-- ALLERGIA CARTELLA
CREATE TABLE IF NOT EXISTS allergia_cartella(id_realazione INT PRIMARY KEY AUTO_INCREMENT, id_allergia INT, id_cartella INT,
FOREIGN KEY (id_allergia) REFERENCES allergia(id_allergia) ON DELETE CASCADE, 
FOREIGN KEY (id_cartella)  REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE);

-- REFERTO VISITA MEDICA
CREATE TABLE IF NOT EXISTS referto_visita_medica(id_referto INT PRIMARY KEY AUTO_INCREMENT, tipologia VARCHAR(30), descrizione VARCHAR(100), data_referto date);

-- REFERTO OPERAZIONE
CREATE TABLE IF NOT EXISTS referto_operazione (id_referto INT PRIMARY KEY AUTO_INCREMENT, tipologia VARCHAR(30), descrizione VARCHAR(100), data_referto date);

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
CREATE TABLE IF NOT EXISTS operazione_cartella (id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_operazione INT, id_cartella INT, id_referto INT,
FOREIGN KEY (id_operazione) REFERENCES operazione_medica(id_operazione_medica) ON DELETE CASCADE,
FOREIGN KEY (id_cartella) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY (id_referto) REFERENCES referto_operazione(id_referto) ON DELETE CASCADE); 

-- OPERAZIONE DOTTORE
CREATE TABLE IF NOT EXISTS operazione_dottore(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_medico INT, id_operazione INT, id_cartella_clinica INT,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY (id_medico) REFERENCES medico(id_medico) ON DELETE CASCADE,
FOREIGN KEY (id_operazione) REFERENCES operazione_medica(id_operazione_medica) ON DELETE CASCADE);

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
CREATE TABLE IF NOT EXISTS specialista(id_specialista INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(30), cognome VARCHAR(30), specializzazione VARCHAR(50), tipo_account INT, 
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
CREATE TABLE IF NOT EXISTS Operazionespecialista(id_relazione INT PRIMARY KEY AUTO_INCREMENT, id_specialista INT, id_operazione INT, id_cartella_clinica INT,
FOREIGN KEY (id_cartella_clinica) REFERENCES cartella_clinica(id_cartella_clinica) ON DELETE CASCADE,
FOREIGN KEY (id_specialista) REFERENCES specialista(id_specialista) ON DELETE CASCADE,
FOREIGN KEY (id_operazione) REFERENCES operazione_medica(id_operazione_medica) ON DELETE CASCADE);

-- SINTOMO
CREATE TABLE IF NOT EXISTS sintomo(id_sintomo INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(50), descrizione VARCHAR(250));

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

-- INSERIMENTO VALORI

-- MALATTIE

INSERT INTO malattia(id_malattia,nome,descrizione) VALUES 
(1,'Acalasia','L''acalasia è un disturbo della motilità dell''esofago. Questa condizione è caratterizzata 
da un''alterata peristalsi esofagea e dal mancato rilasciamento dello sfintere esofageo inferiore 
(valvola muscolare situata tra l''esofago e lo stomaco) durante la deglutizione. Di conseguenza, l''acalasia 
rende difficile il transito del cibo lungo l''esofago.L''acalasia è dovuta ad un''alterazione dei nervi che 
controllano la muscolatura liscia esofagea. Si è osservato, infatti, che le persone affette da tale disturbo 
presentano una diminuzione delle fibre e delle cellule nervose che circondano l''esofago. Questo fenomeno 
determina un insufficiente invio di stimoli. Per questo motivo, l''esofago rimane contratto, impedendo la 
deglutizione. L''esatta eziologia dell''acalasia non è ancora nota. Talvolta, il disturbo si può riscontrare 
in associazione a tumori esofagei e ad alcune infezioni, come nel caso della malattia di Chagas. L''acalasia 
si può manifestare a qualunque età, ma solitamente esordisce tra i 20 ed i 60 anni. L''esordio dell''acalasia 
esofagea è insidioso e la progressione si verifica gradualmente nell''arco di mesi o anni. I primi sintomi 
sono rappresentati da una crescente difficoltà nel deglutire cibi solidi e liquidi (disfagia) e dal 
rigurgito di materiale alimentare non digerito. Ne derivano scialorrea (eccessiva salivazione), alitosi, 
pirosi (bruciore retrosternale), frequenti eruttazioni e senso di soffocamento. Il rigurgito di cibo non 
digerito può causare attacchi di tosse ed aspirazione nell''albero broncopolmonare (polmonite ab ingestis). 
Il dolore toracico è meno frequente, ma si può presentare al momento della deglutizione oppure 
spontaneamente. Nel corso degli anni, l''acalasia comporta perdita di peso, anemia e malnutrizione.
Con la progressione della malattia, l''esofago si può deformare, allungandosi o dilatandosi. Possibili 
complicazioni dell''acalasia comprendono malattia da reflusso gastroesofageo ed esofagite.
La diagnosi viene definita generalmente mediante studi radiografici con il bario, endoscopia e manometria 
esofagea. Le iniezioni di tossina botulinica ed alcuni farmaci (come nitroderivati e calcio antagonisti) 
possono essere utilizzati temporaneamente per i casi di acalasia esofagea lievi o moderati. In alternativa, 
può essere indicata la terapia endoscopica (dilatazione esofagea con palloncino) ed alcune procedure 
chirurgiche (come la miotomia di Heller, intervento che prevede il sezionamento dello strato muscolare alla 
base dell''esofago). I pazienti con acalasia presentano anche un lieve aumento del rischio di sviluppare 
processi neoplastici a livello dell''esofago. Pertanto, il medico può raccomandare periodicamente controlli 
endoscopici per la prevenzione e la diagnosi precoce del carcinoma esofageo.'),

(2,'Acetonemia','L''acetone è una chetosi transitoria, un momentaneo disturbo del metabolismo. Si verifica 
quando nell''organismo vengono a mancare gli zuccheri, la prima fonte da cui il corpo trae energia.
L''acetone è frequente soprattutto nei bambini e può rappresentare la conseguenza di diverse condizioni, come 
una dieta ricca di grassi e povera di zuccheri, l''inappetenza o il digiuno prolungato (dovuto, per esempio, a 
febbre alta o disturbi intestinali). L''organismo, non avendo più disposizione gli zuccheri per ricavare l''energia 
necessaria al suo funzionamento, è costretto a bruciare i grassi come fonte alternativa. Durante questa 
''combustione'' (se avviene in carenza di zuccheri), si ha la produzione a livello epatico di alcune sostanze di
scarto: i corpi chetonici (acetone, acido acetoacetico e 3-idrossi-butirrico).
I corpi chetonici possono raggiungere livelli più o meno tossici. Nel tentativo di ridurne la concentrazione 
plasmatica, l''organismo tenta di eliminarli con le urine e attraverso la respirazione. Il primo campanello 
d''allarme, infatti, è rappresentato dall''alito che assume un particolare odore di frutta marcia. Poi, 
l''organismo reagisce con attacchi ripetuti di vomito, mal di pancia, mal di testa, pallore e disidratazione.
In genere, l''acetone si risolve nel giro di un paio di giorni con una dieta priva di grassi e la 
reintegrazione dei liquidi persi con il vomito. Sono indicate soprattutto le bevande zuccherate, come tè, 
spremute e succhi di frutta, affinché l''organismo possa riprendere ad utilizzare gli zuccheri come 
combustibile.'),
(3,'Acidosi metabolica','L''acidosi metabolica è un accumulo di acidi nell''organismo, non adeguatamente compensato da
altrettante sostanze basiche. Il risultato di questo squilibrio acido-base è una diminuzione marcata o lieve del valore
di pH che, a lungo andare, può creare importanti problemi di salute (pH arterioso <7,35). L''acidosi metabolica può
verificarsi a causa di un''aumentata produzione o ingestione di sostanze acide, di una loro ridotta escrezione o di una
perdita di bicarbonati (HCO3) dal tratto gastrointestinale o dal rene. Le cause che possono portare a questo scompenso
metabolico sono svariate. Alcune sono legate a malattie che interferiscono con l''equilibrio biochimico o metabolico,
altre dipendono dallo stile di vita (es. quando ci si alimenta in modo sbilanciato con una dieta ricca di alimenti
animali e povera di vegetali). Possibili cause di acidosi sono: accumulo di chetoni e di acido lattico, insufficienza
renale, diabete non controllato, vomito o diarrea profusa, utilizzo di diuretici, alcolismo cronico, denutrizione,
ingestione di particolari farmaci o tossine. Inoltre, tra le cause ci possono essere anche epatopatie e malattie dei
reni, cardiopatie e disturbi respiratori. I sintomi dell''acidosi metabolica dipendono principalmente dalla causa che
l''ha provocata. I casi lievi possono essere asintomatici, mentre un''acidosi più grave (pH < 7,10) può causare nausea e
vomito associati a mal di testa, stanchezza, sonnolenza e malessere. Il segno più caratteristico è l''iperpnea (respiri
profondi e lunghi a una normale frequenza). L''acidosi metabolica può provocare anche crampi muscolari, dolori
articolari, inappetenza e ritenzione idrica. Un''acidosi grave e acuta predispone alla disfunzione cardiaca con
ipotensione e aritmie ventricolari. Nelle forme non curate si può arrivare addirittura al coma. Un''acidosi cronica,
invece, provoca disturbi di demineralizzazione ossea (es. osteoporosi). La terapia solitamente consigliata prevede la
risoluzione della causa sottostante e, se il pH è molto basso, può essere indicato infondere per via endovenosa
soluzioni alcalinizzanti allo scopo di ripristinare l''equilibrio acido-base.'),
(4,'Acne','L''acne (acne vulgaris) è una patologia cutanea che colpisce molti adolescenti e giovani adulti. La sua
insorgenza è legata anzitutto ad un''eccessiva produzione di sebo; questa sostanza oleosa, che forma un sottile strato
protettivo sulla superficie della pelle, viene prodotta dalle ghiandole sebacee situate nel derma alla base del
follicolo pilifero (da cui nasce il pelo). Inoltre, l''acne è legata alla contemporanea ed esagerata cheratinizzazione
dello sbocco del follicolo stesso (il ''poro'' da cui spuntano i peli); in pratica, il sebo in eccesso si accumula attorno
al fusto del pelo e, per colpa della ipercheratinizzazione, si crea una sorta di ''tappo'' (detto comedone) che impedisce
al sebo stesso di defluire all''esterno. Nel tempo, la presenza del sebo ristagnante può favorire un processo
infiammatorio a carico dell''unità pilosebacea. Inoltre, questo ambiente diventa terreno fertile per l''attacco di batteri,
come il Propionibacterium acnes. Questo microrganismo vive normalmente alla base del pelo, ma, quando si sviluppa troppo
a causa degli ammassi di sebo, stimola l''infiammazione del follicolo. Predispongono all''acne le modificazioni ormonali
che si riscontrano durante la pubertà, in gravidanza o durante il ciclo mestruale, i cosmetici occlusivi e la sudorazione.
L''acne può manifestarsi in diversi modi. In generale, è caratterizzata dalla formazione di comedoni, papule, pustole,
noduli e cisti, che insorgono nell''ordine elencato in una scala di gravità crescente. La loro comparsa è la conseguenza
dell''ostruzione e dell''infiammazione delle unità pilosebacee (follicoli piliferi e rispettive ghiandole sebacee). I
comedoni sono tappi di sebo (non infetti) bloccati all''interno dei follicoli, e rappresentano il segno caratteristico
dell''acne non infiammatoria. Appaiono in forma di punti bianchi o neri: i punti bianchi (comedoni chiusi alla superficie
cutanea) sono lesioni palpabili, colorate o biancastre, di 1-3 mm di diametro; i punti neri (comedoni aperti) hanno un
aspetto simile, ma con una zona centrale dilatata e scura. L''acne infiammatoria, invece, è costituita da papule, pustole,
noduli e cisti (lesioni dolenti di colorito rosso-violaceo conseguenti alla flogosi dei tessuti molli che circondano i
follicoli). Papule e pustole sono rilievi cutanei solidi e rossi provocati dall''irritazione all''interno del follicolo e
dall''infezione del P. acnes. Quando l''epitelio si rompe, il contenuto del comedone provoca un''intensa reazione
infiammatoria nel derma. Le pustole sono più superficiali rispetto alle papule e sono ripiene di pus (segno
dell''infezione in atto). Noduli e cisti, invece, sono lesioni dolenti di colorito rosso-violaceo conseguenti alla
flogosi dei tessuti molli che circondano i follicoli. I noduli sono più ampi, profondi e duri rispetto alle papule e
possono lasciare cicatrici permanenti. Il trattamento dell''acne si avvale di vari agenti topici e sistemici, volti a
ridurre la produzione di sebo, la formazione di comedoni, l''infezione e l''infiammazione. In genere, la scelta terapeutica
dipende dalla gravità della malattia e dal soggetto (alcuni prodotti sono controindicati in gravidanza).');

-- SINTOMI
INSERT INTO sintomo(id_sintomo,nome, descrizione) VALUES 
(1,'Addome Acuto',''),
(2,'Afagia',''),
(3,'Alitosi',''),
(4,'Anemia',''),
(5,'Anoressia',''),
(6,'Aritmia',''),
(7,'Arrossamento del volto',''),
(8,'Astenia',''),
(9,'Bolle',''),
(10,'Bruciore retrosternale',''),
(11,'Bruciori di stomaco',''),
(12,'Coma',''),
(13,'Conati',''),
(14,'Crampi muscolari',''),
(15,'Difficoltà di concentrazione',''),
(16,'Discromie cutanee',''),
(165,'Disfagia',''),
(17,'Disidratazione',''),
(18,'Dispnea',''),
(19,'Disturbi d''Umore',''),
(20,'Dolore Addominale',''),
(21,'Dolori Articolari',''),
(22,'Dolore al petto',''),
(23,'Dolore alla parte alta dell''addome',''),
(24,'Dolori Muscolari',''),
(25,'Eruttazione',''),
(26,'Fiato corto',''),
(27,'Formazione di pus',''),
(28,'Iperkaliemia',''),
(29,'Iperpnea',''),
(295,'Iperventilazione',''),
(30,'Ipotensione',''),
(31,'Letargia',''),
(32,'Mal di testa',''),
(33,'Meningismo',''),
(34,'Nausea',''),
(35,'Nervosismo',''),
(36,'Nodo alla gola',''),
(37,'Nodulo',''),
(38,'Odinofagia',''),
(39,'Osteoporosi',''),
(40,'Pallore',''),
(41,'Papule',''),
(42,'Pelle grassa',''),
(43,'Perdita di peso',''),
(44,'Pesantezza allo stomaco',''),
(45,'Prurito in testa',''),
(46,'Pustole',''),
(47,'Rabdomiolisi',''),
(48,'Raucedine',''),
(49,'Rigurgito acido',''),
(50,'Ritenzione idrica',''),
(51,'Salivazione intensa',''),
(52,'Senso di soffocamento',''),
(53,'Stridore',''),
(54,'Sonnolenza',''),
(55,'Tachipnea',''),
(56,'Tosse',''),
(57,'Tricodinia',''),
(58,'Vomito','');

-- MALATTIA SINTOMO
INSERT INTO sintomo_malattia(id_relazione, id_malattia, id_sintomo) VALUES
(1,1,165),
(2,1,2),
(3,1,3),
(4,1,4),
(5,1,5),
(6,2,58),
(7,2,1),
(8,2,3);
