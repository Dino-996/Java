package it.unibas.aereomobile.persistenza;

public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String m) {
        super(m);
    }

    public DAOException(Exception e) {
        super(e);
    }

}
