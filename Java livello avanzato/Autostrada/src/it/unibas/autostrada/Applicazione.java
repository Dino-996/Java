package it.unibas.autostrada;

import it.unibas.autostrada.controllo.ControlloMenu;
import it.unibas.autostrada.controllo.ControlloPrincipale;
import it.unibas.autostrada.modello.Modello;
import it.unibas.autostrada.persistenza.DAOArchivio;
import it.unibas.autostrada.persistenza.IDAOArchivio;
import it.unibas.autostrada.vista.Frame;
import it.unibas.autostrada.vista.VistaPrincipale;
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
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;

    public void inizializza() {
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
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

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Applicazione.getIstance()::inizializza);
    }
}
