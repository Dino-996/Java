package it.unibas.lavoro.persistenza;

import it.unibas.lavoro.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException;
}
