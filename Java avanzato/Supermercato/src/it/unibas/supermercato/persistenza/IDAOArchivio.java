package it.unibas.supermercato.persistenza;

import it.unibas.supermercato.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;
}
