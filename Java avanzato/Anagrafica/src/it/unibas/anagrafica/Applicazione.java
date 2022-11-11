package it.unibas.anagrafica;

import it.unibas.anagrafica.controllo.ControlloDipendente;
import it.unibas.anagrafica.controllo.ControlloMenu;
import it.unibas.anagrafica.controllo.ControlloPrincipale;
import it.unibas.anagrafica.modello.Modello;
import it.unibas.anagrafica.persistenza.DAOArchivio;
import it.unibas.anagrafica.persistenza.IDAOArchivio;
import it.unibas.anagrafica.vista.Frame;
import it.unibas.anagrafica.vista.VistaDipendente;
import it.unibas.anagrafica.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio idaoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloDipendente controlloDipendente;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDipendente vistaDipendente;

    public void inizializza() {
        this.modello = new Modello();
        this.idaoArchivio = new DAOArchivio();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.controlloDipendente = new ControlloDipendente();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDipendente = new VistaDipendente(frame, true);

        this.vistaPrincipale.inizializza();
        this.vistaDipendente.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getIdaoArchivio() {
        return idaoArchivio;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public ControlloDipendente getControlloDipendente() {
        return controlloDipendente;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaDipendente getVistaDipendente() {
        return vistaDipendente;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
