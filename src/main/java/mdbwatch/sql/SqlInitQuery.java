package mdbwatch.sql;

public class SqlInitQuery {
	public final static String PERSONE = "create table PERSONE ("
		     + "     idPersona int not null auto_increment,"
		     + "     Nome varchar(15) not null,"
		     + "     Cognome varchar(15) not null,"
		     + "     DataDiNascita date not null,"
		     + "     constraint IDPERSONE primary key (idPersona));";
	
	public final static String PRODOTTI_SINGOLI = "create table PRODOTTI_SINGOLI (\n"
		     + "     idProdotto int not null auto_increment,"
		     + "     Titolo varchar(50) not null,"
		     + "     Trama varchar(200) not null,"
		     + "     Anno int not null,"
		     + "     idPersona int not null,"
		     + "     Produzione varchar(50) not null,"
		     + "     idSerie int,"
		     + "     stagione int,"
		     + "     numeroEpisodio int,"
		     + "     constraint IDPRODOTTI_SINGOLI_ID primary key (idProdotto));";
	
	public final static String COLONNE_SONORE =  "create table COLONNE_SONORE ("
		     + "     idColonna int not null auto_increment,"
		     + "     Titolo varchar(50) not null,"
		     + "     constraint IDCOLONNE_SONORA_ID primary key (idColonna));";
	
	public final static String PREMI = "create table PREMI ("
		     + "     Nome varchar(25) not null,"
		     + "     Anno int not null,"
		     + "     constraint IDPREMI_ID primary key (Nome, Anno));";
	
	public final static String COMPOSIZIONI_COLONNA = "create table ComposizioniColonna ("
		     + "     idColonna int not null,"
		     + "     idPersona int not null,"
		     + "     constraint IDComposizioniColonna primary key (idColonna, idPersona));";
	
	public final static String DISPONIBILITA_PRODOTTI = "create table DisponibilitaProdotti ("
		     + "     idProdotto int not null,"
		     + "     NomeServizio varchar(15) not null,"
		     + "     constraint IDDisponibilitaProdotti primary key (idProdotto, NomeServizio));";
	
	public final static String DISPONIBILITA_SERIE = "create table DisponibilitaSerie ("
		     + "	idSerie int not null,"
		     + "    NomeServizio varchar(15) not null,"
		     + "    constraint IDDisponibilitaSerie primary key (idSerie, NomeServizio));";
	
	public final static String INTERPRETAZIONE_COLONNA = "create table InterpretazioniColonna ("
		     + "     idColonna int not null,"
		     + "     idPersona int not null,"
		     + "     constraint IDInterpretazioniColonna primary key (idColonna, idPersona));";
	
	public final static String MIGLIORI = "create table Migliori ("
		     + "     Nome varchar(25) not null,"
		     + "     Anno int not null,"
		     + "     idPersona int not null,"
		     + "     Titolo varchar(15) not null,"
		     + "     Arrivo varchar(15) not null,"
		     + "     constraint IDMiglior primary key (idPersona, Nome, Anno));";
	
	public final static String MIGLIORI_PRODOTTI = "create table MiglioriProdotti (\n"
		     + "     Nome varchar(15) not null,"
		     + "     Anno int not null,"
		     + "     idProdotto int not null,"
		     + "     Titolo varchar(15) not null,"
		     + "     Arrivo varchar(15) not null,"
		     + "     constraint IDMiglioriProdotti primary key (idProdotto, Nome, Anno));";
	
	public final static String MIGLIORI_SERIE = "create table MiglioriSerie (\n"
		     + "     Nome varchar(15) not null,"
		     + "     Anno int not null,"
		     + "     idSerieTv int not null,"
		     + "     Titolo varchar(15) not null,"
		     + "     Arrivo varchar(15) not null,"
		     + "     constraint IDMilgioriSerie primary key (idSerieTv, Nome, Anno));";
	
	public final static String MIGLIORI_COLONNE = "create table MiglioriColonne (\n"
		     + "     Nome varchar(15) not null,"
		     + "     Anno int not null,"
		     + "     idColonna int not null,"
		     + "     Titolo varchar(15) not null,"
		     + "     Arrivo varchar(15) not null,"
		     + "     constraint IDMilglioriColonne primary key (Nome, Anno, idColonna));";
	
	public final static String RECITAZIONI = "create table Recitazioni ("
		     + "     idPersona int not null,"
		     + "     idProdotto int not null,"
		     + "     constraint IDRecitazioni primary key (idProdotto, idPersona));";
	
	public final static String REPARTI_AUDIO = "create table RepartiAudio (\n"
		     + "	idProdotto int not null,\n"
		     + "    idColonna int not null,\n"
		     + "    constraint IDReapartiAudio primary key(idProdotto, idColonna));\n";
	
	public final static String SCELTE = "create table Scelte (\n"
		     + "     Username varchar(20) not null,\n"
		     + "     NomeServizio varchar(15) not null,\n"
		     + "     constraint IDScelte primary key (Username, NomeServizio));\n";
	
	public final static String SCENEGGIATURE = "create table Sceneggiature (\n"
		     + "     idProdotto int not null,\n"
		     + "     idPersona int not null,\n"
		     + "     constraint IDSceneggiature primary key (idProdotto, idPersona));\n";
	
	public final static String SERIE_TV = "create table SERIE_TV (\n"
		     + "     idSerie int not null auto_increment,\n"
		     + "     Titolo varchar(50) not null,\n"
		     + "     Trama varchar(200) not null,\n"
		     + "     constraint IDSERIE_TV_ID primary key (idSerie));\n";
	
	public final static String UTENTI = "create table UTENTI (\n"
		     + "     Username varchar(20) not null,\n"
		     + "     Pass_word varchar(25) not null,\n"
		     + "     constraint IDUTENTI primary key (Username));\n";
	
	public final static String SERVIZI_STREAMING = "create table SERVIZI_STREAMING (\n"
		     + "     NomeServizio varchar(15) not null,\n"
		     + "     SitoWeb varchar(50) not null unique,\n"
		     + "     constraint IDSERVIZI_STREAMING primary key (NomeServizio));\n";
	
	public final static String VALUTAZIONI = "create table Valutazioni (\n"
		     + "     idProdotto int not null,\n"
		     + "     Username varchar(20) not null,\n"
		     + "     Voto int not null,\n"
		     + "     constraint IDValutazioniProdotto primary key (idProdotto, Username));\n";
	
	public final static String WATCHLIST_PRODOTTI = "create table WatchlistProdotti (\n"
		     + "     idProdotto int not null,\n"
		     + "     Username varchar(20) not null,\n"
		     + "     constraint IDWatchlistProdotti primary key (idProdotto, Username));\n";
	
	public final static String WATCHLIST_SERIE = "create table WatchlistSerie (\n"
		     + "     idSerie int not null,\n"
		     + "     Username varchar(20) not null,\n"
		     + "     constraint IDWatchlistSerieTv primary key (idSerie, Username));\n";
	
	public final static String FKREGIA = "alter table PRODOTTI_SINGOLI add constraint FKRegia\n"
		     + "     foreign key (idPersona)\n"
		     + "     references PERSONE (idPersona);\n";
	
	public final static String FKSERIE = "alter table PRODOTTI_SINGOLI add constraint FKSerie\n"
		     + "     foreign key (idSerie)\n"
		     + "     references SERIE_TV (idSerie);\n";
	
	public final static String FKCOMPOSIZIONE_PERSONA = "alter table ComposizioniColonna add constraint FKComposizionePersona\n"
		     + "     foreign key (idPersona)\n"
		     + "     references PERSONE (idPersona);\n";
	
	public final static String FKCOMPOSIZIONE_COLONNA = "alter table ComposizioniColonna add constraint FKComposizioneColonna"
		     + "     foreign key (idColonna)\n"
		     + "     references COLONNE_SONORE (idColonna);\n";
		     
	public final static String FKDISPONIBILITA_SERVIZIO = "alter table DisponibilitaProdotti add constraint FKDisponibiltaServizio"
		     + "     foreign key (NomeServizio)\n"
		     + "     references SERVIZI_STREAMING (NomeServizio);\n";
	
	public final static String FKDISPONIBLITA_PRODOTTO = "alter table DisponibilitaProdotti add constraint FKDisponibilitaProdotto\n"
		     + "     foreign key (idProdotto)\n"
		     + "     references PRODOTTI_SINGOLI (idProdotto);\n";
	
	public final static String FKINTERPRETAZIONE_PERSONA = "alter table InterpretazioniColonna add constraint FKInterpretazionePersona\n"
		     + "     foreign key (idPersona)\n"
		     + "     references PERSONE (idPersona);\n";
	
	public final static String FKINTERPRETAZIONE_COLONNA = "alter table InterpretazioniColonna add constraint FKInterpretazioneColonna\n"
		     + "     foreign key (idColonna)\n"
		     + "     references COLONNE_SONORE (idColonna);\n";
	
	public final static String FKMIGLIORI_PERSONE = "alter table Migliori add constraint FKMigliorPersona\n"
		     + "     foreign key (idPersona)\n"
		     + "     references PERSONE (idPersona);\n";
	
	public final static String FKMIGLIOR_PREMIO_PERSONA = "alter table Migliori add constraint FKMigliorPremioPersona\n"
		     + "     foreign key (Nome, Anno)\n"
		     + "     references PREMI (Nome, Anno);\n";
	
	public final static String FKMIGLIOR_PRODOTTO = "alter table MiglioriProdotti add constraint FKMigliorProdotto\n"
		     + "     foreign key (idProdotto)\n"
		     + "     references PRODOTTI_SINGOLI (idProdotto);\n";
	
	public final static String FKMIGLIOR_PRODOTTO_PREMIO = "alter table MiglioriProdotti add constraint FKMigliorProdottoPremio\n"
		     + "     foreign key (Nome, Anno)\n"
		     + "     references PREMI (Nome, Anno);\n";
	
	public final static String FKMIGLIOR_SERIE = "alter table MiglioriSerie add constraint FKMigliorSerie\n"
		     + "     foreign key (idSerieTv)\n"
		     + "     references SERIE_TV (idSerie);\n";
	
	public final static String FKMGILIOR_SERIE_PREMIO = "alter table MiglioriSerie add constraint FKMigliorSeriePremio\n"
		     + "     foreign key (Nome, Anno)\n"
		     + "     references PREMI (Nome, Anno);\n";
	
	public final static String MIGLIOR_COLONNA = "alter table MiglioriColonne add constraint FKMigliorColonna\n"
		     + "     foreign key (idColonna)\n"
		     + "     references COLONNE_SONORE (idColonna);\n";
	
	public final static String FKRECITAZIONE_PRODOTTO = "alter table Recitazioni add constraint FKRecitazioneProdotto\n"
		     + "     foreign key (idProdotto)\n"
		     + "     references PRODOTTI_SINGOLI (idProdotto);\n";

	public final static String FKRECITAZIONE_PERSONA = "alter table Recitazioni add constraint FKRecitrazionePersona\n"
		     + "     foreign key (idPersona)\n"
		     + "     references PERSONE (idPersona);\n";
	
	public final static String FKSCELTA_SERVIZIO = "alter table Scelte add constraint FKSceltaServizio\n"
		     + "     foreign key (NomeServizio)\n"
		     + "     references SERVIZI_STREAMING (NomeServizio);\n";
	
	public final static String FKSCELAT_UTENTE = "alter table Scelte add constraint FKSceltaUtente\n"
		     + "     foreign key (Username)\n"
		     + "     references UTENTI (Username);\n";
	
	public final static String FKSCENEGGIATURA_PERSONA = "alter table Sceneggiature add constraint FKSceneggiaturaPersona\n"
		     + "     foreign key (idPersona)\n"
		     + "     references PERSONE (idPersona);\n";
	
	public final static String FKSCENEGGIATURA_PRODOTTO = "alter table Sceneggiature add constraint FKSceneggiaturaProdotto\n"
		     + "     foreign key (idProdotto)\n"
		     + "     references PRODOTTI_SINGOLI (idProdotto);\n";
	
	public final static String FKVALUTAZIONE_UTENTE = "alter table Valutazioni add constraint FKValutazioneUtente\n"
		     + "     foreign key (Username)\n"
		     + "     references UTENTI (Username);\n";
	
	public final static String FKVALUTAZIONE_PRODOTTO = "alter table Valutazioni add constraint FKValutazioneProdotto\n"
		     + "     foreign key (idProdotto)\n"
		     + "     references PRODOTTI_SINGOLI (idProdotto);\n";
	
	public final static String FKWATCHLIST_UTENTE = "alter table WatchlistProdotti add constraint FKWatchlistUtente\n"
		     + "     foreign key (Username)\n"
		     + "     references UTENTI (Username);\n";
	
	public final static String WATCHLIST_PRODOTTO = "alter table WatchlistProdotti add constraint FKWatchlistProdotto\n"
		     + "     foreign key (idProdotto)\n"
		     + "     references PRODOTTI_SINGOLI (idProdotto);\n";
	
	public final static String  FKWATCHLIST_SERIE_UTENTE = "alter table WatchListSerie add constraint FKWatchlistSerieUtente\n"
		     + "     foreign key (Username)\n"
		     + "     references UTENTI (Username);\n";
	
	public final static String FKWATCHLIST_SERIE = "alter table WatchListSerie add constraint FKWatchlistSerie\n"
		     + "     foreign key (idSerie)\n"
		     + "     references SERIE_TV (idSerie);\n";
	
	public final static String FKPRODOTTO = "alter table RepartiAudio add constraint FKProdotto\n"
		     + "	foreign key (idProdotto)\n"
		     + "    references PRODOTTI_SINGOLI (idProdotto);\n";
	
	public final static String FKCOLONNA = "alter table RepartiAudio add constraint FKColonna\n"
		     + "	foreign key (idColonna)\n"
		     + "    references COLONNE_SONORE (idColonna);\n";
	
	public final static String FKSERIE_DISPONIBILE = "alter table DisponibilitaSerie add constraint FKSerieDisponibile\n"
		     + "	foreign key (idSerie)\n"
		     + "    references SERIE_TV (idSerie);\n";
	public final static String FKSERVIZIO = "alter table DisponibilitaSerie add constraint FKServizio\n"
		     + "	foreign key (NomeServizio)\n"
		     + "    references SERVIZI_STREAMING (NomeServizio);\n";
	
	
	public final static String [] VALUES = new String [] {PERSONE, PRODOTTI_SINGOLI, COLONNE_SONORE, PREMI, COMPOSIZIONI_COLONNA, 
	                                                   DISPONIBILITA_PRODOTTI, DISPONIBILITA_SERIE, INTERPRETAZIONE_COLONNA, MIGLIORI,
	                                                   MIGLIORI_PRODOTTI, MIGLIORI_SERIE, MIGLIORI_COLONNE, RECITAZIONI, REPARTI_AUDIO,
	                                                   SCELTE, SCENEGGIATURE, SERIE_TV, UTENTI, SERVIZI_STREAMING, VALUTAZIONI,
	                                                   WATCHLIST_PRODOTTI, WATCHLIST_SERIE, FKREGIA, FKSERIE, FKCOMPOSIZIONE_PERSONA,
	                                                   FKCOMPOSIZIONE_COLONNA, FKDISPONIBILITA_SERVIZIO, FKDISPONIBLITA_PRODOTTO,
	                                                   FKINTERPRETAZIONE_PERSONA, FKINTERPRETAZIONE_COLONNA, FKMIGLIORI_PERSONE,
	                                                   FKMIGLIOR_PREMIO_PERSONA, FKMIGLIOR_PRODOTTO, FKMIGLIOR_PRODOTTO_PREMIO,
	                                                   FKMIGLIOR_SERIE, FKMGILIOR_SERIE_PREMIO, MIGLIOR_COLONNA, FKRECITAZIONE_PRODOTTO,
	                                                   FKRECITAZIONE_PERSONA, FKSCELTA_SERVIZIO, FKSCELAT_UTENTE, FKSCENEGGIATURA_PERSONA,
	                                                   FKSCENEGGIATURA_PRODOTTO, FKVALUTAZIONE_UTENTE, FKVALUTAZIONE_PRODOTTO,
	                                                   FKWATCHLIST_UTENTE, WATCHLIST_PRODOTTO, FKWATCHLIST_SERIE_UTENTE,
	                                                   FKWATCHLIST_SERIE, FKPRODOTTO, FKCOLONNA, FKSERIE_DISPONIBILE, FKSERVIZIO}; 
}
