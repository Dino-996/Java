package it.unibas.lavoro;

import it.unibas.lavoro.controllo.ControlloMenu;
import it.unibas.lavoro.controllo.ControlloVistaPrincipale;
import it.unibas.lavoro.modello.Modello;
import it.unibas.lavoro.persistenza.DAOArchivio;
import it.unibas.lavoro.persistenza.IDAOArchivio;
import it.unibas.lavoro.vista.Frame;
import it.unibas.lavoro.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio daoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloVistaPrincipale controlloVistaPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;

    public void inizializza() {
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloVistaPrincipale = new ControlloVistaPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();

        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloVistaPrincipale getControlloVistaPrincipale() {
        return controlloVistaPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }

}
