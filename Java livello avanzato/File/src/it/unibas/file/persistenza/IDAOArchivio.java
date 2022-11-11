package it.unibas.file.persistenza;

import it.unibas.file.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String files) throws DAOException;
}
