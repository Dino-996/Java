package it.unibas.aereomobile;

import it.unibas.aereomobile.controllo.ControlloMenu;
import it.unibas.aereomobile.controllo.ControlloPrincipale;
import it.unibas.aereomobile.controllo.ControlloVoli;
import it.unibas.aereomobile.modello.Modello;
import it.unibas.aereomobile.persistenza.DAOArchivio;
import it.unibas.aereomobile.persistenza.IDAOArchivio;
import it.unibas.aereomobile.vista.Frame;
import it.unibas.aereomobile.vista.VistaPrincipale;
import it.unibas.aereomobile.vista.VistaVoli;
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
    private ControlloVoli controlloVoli;
    private Frame frame;
    private VistaVoli vistaVoli;
    private VistaPrincipale vistaPrincipale;

    public void inizializza() {
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloVoli = new ControlloVoli();
        this.frame = new Frame();
        this.vistaVoli = new VistaVoli(frame, true);
        this.vistaPrincipale = new VistaPrincipale();
        
        this.vistaPrincipale.inizializza();
        this.vistaVoli.inizializza();
        this.frame.inizializza();
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
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

    public ControlloVoli getControlloVoli() {
        return controlloVoli;
    }

    public VistaVoli getVistaVoli() {
        return vistaVoli;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
