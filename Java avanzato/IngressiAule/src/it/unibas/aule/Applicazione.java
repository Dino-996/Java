package it.unibas.aule;

import it.unibas.aule.controllo.ControlloAccessi;
import it.unibas.aule.controllo.ControlloMenu;
import it.unibas.aule.controllo.ControlloPrincipale;
import it.unibas.aule.modello.Modello;
import it.unibas.aule.persistenza.DAOArchivio;
import it.unibas.aule.persistenza.IDAOArchivio;
import it.unibas.aule.vista.Frame;
import it.unibas.aule.vista.VistaAccessi;
import it.unibas.aule.vista.VistaPrincipale;
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
    private ControlloAccessi controlloAccessi;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaAccessi vistaAccessi;

    public void inizializza() {

        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloAccessi = new ControlloAccessi();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        this.vistaAccessi = new VistaAccessi(frame, true);

        this.vistaPrincipale.inizializza();
        this.vistaAccessi.inizializza();
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

    public ControlloAccessi getControlloAccessi() {
        return controlloAccessi;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaAccessi getVistaAccessi() {
        return vistaAccessi;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
