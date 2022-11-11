package it.unibas.pagina.persistenza;

public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(Exception ex) {
        super(ex);
    }

    public DAOException(String ex) {
        super(ex);
    }
}
