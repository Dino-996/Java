package it.unibas.concorsi;

import it.unibas.concorsi.controllo.ControlloDomanda;
import it.unibas.concorsi.controllo.ControlloMenu;
import it.unibas.concorsi.controllo.ControlloPrincipale;
import it.unibas.concorsi.modello.Modello;
import it.unibas.concorsi.persistenza.DAOArchivio;
import it.unibas.concorsi.persistenza.IDAOArchvio;
import it.unibas.concorsi.vista.Frame;
import it.unibas.concorsi.vista.VistaDomanda;
import it.unibas.concorsi.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getIstance() {
        return singleton;
    }
    
    private Modello modello;
    private IDAOArchvio dAOArchivio;
    
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloDomanda controlloDomanda;
    
    private VistaPrincipale vistaPrincipale;
    private Frame frame;
    private VistaDomanda vistaDomanda;
    
    public void inizializza() {
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivio();
        
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloDomanda = new ControlloDomanda();
        
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDomanda = new VistaDomanda(frame, true);
        
        this.vistaPrincipale.inizializza();
        this.vistaDomanda.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchvio getdAOArchivio() {
        return dAOArchivio;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public ControlloDomanda getControlloDomanda() {
        return controlloDomanda;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaDomanda getVistaDomanda() {
        return vistaDomanda;
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Applicazione.getIstance()::inizializza);
    }
}
