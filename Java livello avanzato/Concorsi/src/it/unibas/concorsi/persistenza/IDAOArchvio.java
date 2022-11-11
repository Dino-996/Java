package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;

public interface IDAOArchvio {
    Archivio carica(String file) throws DAOException;
}
