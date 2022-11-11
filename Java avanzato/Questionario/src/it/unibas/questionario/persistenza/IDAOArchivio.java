package it.unibas.questionario.persistenza;

import it.unibas.questionario.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException;
}
