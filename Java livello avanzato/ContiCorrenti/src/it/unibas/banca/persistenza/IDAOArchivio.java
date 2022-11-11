package it.unibas.banca.persistenza;

import it.unibas.banca.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException; 
}
