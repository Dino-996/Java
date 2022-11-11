package it.unibas.pietanze;

import it.unibas.pietanze.controllo.ControlloMenu;
import it.unibas.pietanze.controllo.ControlloPrincipale;
import it.unibas.pietanze.modello.Modello;
import it.unibas.pietanze.persistenza.DAOArchvio;
import it.unibas.pietanze.persistenza.IDAOArchivio;
import it.unibas.pietanze.vista.Frame;
import it.unibas.pietanze.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getIstance() {
        return singleton;
    }

    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Modello modello;
    private IDAOArchivio daoArchivio;
    private VistaPrincipale vistaPrincipale;
    private Frame frame;

    public void inizializza() {
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.modello = new Modello();
        this.daoArchivio = new DAOArchvio();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();

        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public VistaPrincipale getVista() {
        return vistaPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}