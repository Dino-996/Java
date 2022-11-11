package it.unibas.anagrafica.persistenza;

import it.unibas.anagrafica.modello.Archivio;

public interface IDAOArchivio {
    Archivio carica(String file) throws DAOException;
}
