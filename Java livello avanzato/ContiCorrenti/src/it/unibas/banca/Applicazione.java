package it.unibas.banca;

import it.unibas.banca.controllo.ControlloMenu;
import it.unibas.banca.controllo.ControlloMovimenti;
import it.unibas.banca.controllo.ControlloPrincipale;
import it.unibas.banca.modello.Modello;
import it.unibas.banca.persistenza.DAOArchivio;
import it.unibas.banca.persistenza.IDAOArchivio;
import it.unibas.banca.vista.Frame;
import it.unibas.banca.vista.VistaMovimenti;
import it.unibas.banca.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio daoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloMovimenti controlloMovimenti;
    private VistaPrincipale vistaPrincipale;
    private Frame frame;
    private VistaMovimenti vistaMovimenti;

    public void inizializza() {
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloMovimenti = new ControlloMovimenti();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        this.vistaMovimenti = new VistaMovimenti(frame, true);
        
        this.vistaPrincipale.inizializza();
        this.vistaMovimenti.inizializza();
        this.frame.inizializza();
    }

    public static Applicazione getSingleton() {
        return singleton;
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

    public ControlloMovimenti getControlloMovimenti() {
        return controlloMovimenti;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaMovimenti getVistaMovimenti() {
        return vistaMovimenti;
    }

    public Frame getFrame() {
        return frame;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Applicazione.getInstance()::inizializza);
    }
}
