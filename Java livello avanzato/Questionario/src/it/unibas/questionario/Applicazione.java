package it.unibas.questionario;

import it.unibas.questionario.controllo.ControlloMenu;
import it.unibas.questionario.controllo.ControlloPrincipale;
import it.unibas.questionario.modello.Modello;
import it.unibas.questionario.persistenza.DAOArchivio;
import it.unibas.questionario.persistenza.IDAOArchivio;
import it.unibas.questionario.vista.Frame;
import it.unibas.questionario.vista.VistaPrincipale;
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
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        
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
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
