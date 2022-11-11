package it.unibas.autostrada.persistenza;

import it.unibas.autostrada.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException;
}
