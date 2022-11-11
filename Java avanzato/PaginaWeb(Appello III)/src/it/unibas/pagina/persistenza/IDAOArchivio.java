package it.unibas.pagina.persistenza;

import it.unibas.pagina.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;
}
