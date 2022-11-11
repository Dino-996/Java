package it.unibas.aereomobile.persistenza;

import it.unibas.aereomobile.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;
}
