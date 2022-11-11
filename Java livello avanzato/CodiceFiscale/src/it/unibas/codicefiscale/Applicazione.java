package it.unibas.codicefiscale;

import it.unibas.codicefiscale.controllo.ControlloMenu;
import it.unibas.codicefiscale.controllo.ControlloPrincipale;
import it.unibas.codicefiscale.vista.Frame;
import it.unibas.codicefiscale.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {
    private static final Applicazione singleton = new Applicazione();
    
    private Applicazione() {}
    
    public static Applicazione getIstance() {
        return singleton;
    }
    
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private VistaPrincipale vista;
    private Frame frame;
    
    public void inizializza() {
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.vista = new VistaPrincipale();
        this.frame = new Frame();
        
        this.vista.inizializza();
        this.frame.inizializza();
    }

    public VistaPrincipale getVista() {
        return vista;
    }
    
    public Frame getFrame() {
        return frame;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
