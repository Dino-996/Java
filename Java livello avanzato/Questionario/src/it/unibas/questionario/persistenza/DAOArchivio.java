package it.unibas.questionario.persistenza;

import it.unibas.questionario.modello.Archivio;
import it.unibas.questionario.modello.Compilazione;
import it.unibas.questionario.modello.Costanti;
import it.unibas.questionario.modello.Questionario;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {
        Archivio archivio = new Archivio();
        
        Questionario italiano = new Questionario("IT01", "Questionario di italiano", 3, Costanti.ITALIANO);
        Questionario geografia = new Questionario("GR01", "Questionario di geografia", 5, Costanti.GEOGRAFIA);
        Questionario storia = new Questionario("ST01", "Questionario di storia", 2, Costanti.STORIA);
        Questionario geografia1 = new Questionario("GR02", "Questionario di geografia", 4, Costanti.GEOGRAFIA);
        
        italiano.addCompilazione(new Compilazione(122, true, 120));
        italiano.addCompilazione(new Compilazione(121, false, 130));
        italiano.addCompilazione(new Compilazione(121, false, 160));
        storia.addCompilazione(new Compilazione(130, true, 360));
        
        
        archivio.addQuestionario(italiano);
        archivio.addQuestionario(geografia);
        archivio.addQuestionario(storia);
        archivio.addQuestionario(geografia1);
        
        return archivio;
    }
    
}
