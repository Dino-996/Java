package it.unibas.supermercato.persistenza;

public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String s) {
        super(s);
    }

    public DAOException(Exception ex) {
        super(ex);
    }

}
