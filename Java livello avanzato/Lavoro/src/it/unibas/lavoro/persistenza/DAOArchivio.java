package it.unibas.lavoro.persistenza;

import it.unibas.lavoro.modello.Archivio;
import it.unibas.lavoro.modello.Candidatura;
import it.unibas.lavoro.modello.Costanti;
import it.unibas.lavoro.modello.Offerta;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        //Eta media = 63.8
        Offerta postino = new Offerta("of01", "Offerta di lavoro per 15 magistrati", 80000, Costanti.FULL_TIME);
        postino.addCandidatura(new Candidatura("456", "SS11JJ", 18));
        postino.addCandidatura(new Candidatura("735", "SS11JJ", 24));
        postino.addCandidatura(new Candidatura("236", "AB00OO", 19));
        postino.addCandidatura(new Candidatura("990", "AS76ER", 21));
        postino.addCandidatura(new Candidatura("118", "AF71MM", 25));
        
        //Eta media = 33
        Offerta salumiere = new Offerta("of02", "Offerta di lavoro per 5 salumieri", 30000, Costanti.PART_TIME);
        salumiere.addCandidatura(new Candidatura("901", "AN09UU", 56));
        salumiere.addCandidatura(new Candidatura("511", "BI43LL", 19));
        salumiere.addCandidatura(new Candidatura("217", "SO545KK", 24));
        
        //Eta media = 23
        Offerta programmatoreWeb = new Offerta("of03", "Offerta di lavoro per 1 programmatore web", 70000, Costanti.SMART_WORKING);
        programmatoreWeb.addCandidatura(new Candidatura("195", "AH98PO", 60));
        programmatoreWeb.addCandidatura(new Candidatura("041", "XY91ZS", 32));
        programmatoreWeb.addCandidatura(new Candidatura("568", "SB09AI", 49));

        
        archivio.addOfferta(postino);
        archivio.addOfferta(salumiere);
        archivio.addOfferta(programmatoreWeb);
        
        return archivio;
    } 
}
