package it.unibas.mastermind;

import it.unibas.mastermind.controllo.ControlloMenu;
import it.unibas.mastermind.controllo.ControlloPrincipale;
import it.unibas.mastermind.modello.Modello;
import it.unibas.mastermind.vista.Frame;
import it.unibas.mastermind.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();
    
    public static Applicazione getIstance() {
        return singleton;
    }
    
    private Applicazione() {}
    
    private Modello modello;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    
    public void inizializza() {
        this.modello = new Modello();
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getIstance().inizializza();
            }
        });
    }
}
