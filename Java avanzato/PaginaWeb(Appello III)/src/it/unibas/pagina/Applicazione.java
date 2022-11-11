package it.unibas.pagina;

import it.unibas.pagina.controllo.ControlloAnnotazione;
import it.unibas.pagina.controllo.ControlloMenu;
import it.unibas.pagina.controllo.ControlloPrincipale;
import it.unibas.pagina.modello.Modello;
import it.unibas.pagina.persistenza.DAOArchivio;
import it.unibas.pagina.persistenza.IDAOArchivio;
import it.unibas.pagina.vista.VistaAnnotazioni;
import it.unibas.pagina.vista.VistaPrincipale;
import it.unibas.pagina.vista.Frame;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getIstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio iDaoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloAnnotazione cotrolloAnnotazione;
    private VistaPrincipale vistaPrincipale;
    private VistaAnnotazioni vistaAnnotazioni;
    private Frame frame;

    private void inizializza() {
        modello = new Modello();
        iDaoArchivio = new DAOArchivio();
        controlloMenu = new ControlloMenu();
        controlloPrincipale = new ControlloPrincipale();
        cotrolloAnnotazione = new ControlloAnnotazione();
        vistaPrincipale = new VistaPrincipale();
        frame = new Frame();
        vistaAnnotazioni = new VistaAnnotazioni(frame, true);

        vistaPrincipale.inizializza();
        vistaAnnotazioni.inizializza();
        frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getiDaoArchivio() {
        return iDaoArchivio;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public ControlloAnnotazione getCotrolloAnnotazione() {
        return cotrolloAnnotazione;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaAnnotazioni getVistaAnnotazioni() {
        return vistaAnnotazioni;
    }

    public Frame getFrame() {
        return frame;
    }

    public static void main(String[] argomenti) {
        SwingUtilities.invokeLater(() -> {
            Applicazione.getIstance().inizializza();
        });
    }
}
