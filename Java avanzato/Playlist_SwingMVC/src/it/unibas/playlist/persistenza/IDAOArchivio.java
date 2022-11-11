package it.unibas.playlist.persistenza;

import it.unibas.playlist.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String nomeFile) throws DAOException;
}
