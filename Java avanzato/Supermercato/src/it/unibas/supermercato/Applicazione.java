package it.unibas.supermercato;

import it.unibas.supermercato.controllo.ControlloMenu;
import it.unibas.supermercato.controllo.ControlloPrincipale;
import it.unibas.supermercato.controllo.ControlloProdotto;
import it.unibas.supermercato.modello.Modello;
import it.unibas.supermercato.persistenza.DAOArchivio;
import it.unibas.supermercato.persistenza.IDAOArchivio;
import it.unibas.supermercato.vista.Frame;
import it.unibas.supermercato.vista.VistaPrincipale;
import it.unibas.supermercato.vista.VistaProdotto;
import javax.swing.SwingUtilities;

public class Applicazione {

    private Applicazione() {}
    
    private static final Applicazione singleton = new Applicazione();

    public static Applicazione getIstance() {
        return singleton;
    }
    
    private Modello modello;
    private IDAOArchivio idaoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloProdotto controlloProdotto;
    private VistaPrincipale vistaPrincipale;
    private VistaProdotto vistaProdotto;
    private Frame frame;
    
    public void inizializza() {
        this.modello = new Modello();
        this.idaoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloProdotto = new ControlloProdotto();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaProdotto = new VistaProdotto(frame, true);
        this.frame = new Frame();
        
        this.vistaPrincipale.inizializza();
        this.vistaProdotto.inizializza();
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

    public ControlloProdotto getControlloProdotto() {
        return controlloProdotto;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaProdotto getVistaProdotto() {
        return vistaProdotto;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
