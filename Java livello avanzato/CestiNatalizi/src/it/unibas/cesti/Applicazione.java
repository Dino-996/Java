package it.unibas.cesti;

import it.unibas.cesti.controllo.ControlloMenu;
import it.unibas.cesti.controllo.ControlloPrincipale;
import it.unibas.cesti.controllo.ControlloProdotto;
import it.unibas.cesti.modello.Modello;
import it.unibas.cesti.persistenza.DAOArchivio;
import it.unibas.cesti.persistenza.IDAOArchivio;
import it.unibas.cesti.vista.Frame;
import it.unibas.cesti.vista.VistaPrincipale;
import it.unibas.cesti.vista.VistaProdotto;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio dAOArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloProdotto controlloProdotto;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaProdotto vistaProdotto;

    public void inizializza() {
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloProdotto = new ControlloProdotto();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaProdotto = new VistaProdotto(frame, true);

        this.vistaPrincipale.inizializza();
        this.vistaProdotto.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
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

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaProdotto getVistaProdotto() {
        return vistaProdotto;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Applicazione.getIstance()::inizializza);
    }

}
