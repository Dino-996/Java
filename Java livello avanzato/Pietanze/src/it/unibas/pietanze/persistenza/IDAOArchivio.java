package it.unibas.pietanze.persistenza;

import it.unibas.pietanze.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;

}
