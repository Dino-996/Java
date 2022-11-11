package it.unibas.aule.persistenza;

import it.unibas.aule.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;
}
