package it.unibas.cesti.persistenza;

import it.unibas.cesti.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;
}
