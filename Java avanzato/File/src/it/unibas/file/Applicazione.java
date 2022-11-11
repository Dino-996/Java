package it.unibas.file;

import it.unibas.file.controllo.ControlloFile;
import it.unibas.file.controllo.ControlloMenu;
import it.unibas.file.controllo.ControlloPrincipale;
import it.unibas.file.modello.Modello;
import it.unibas.file.persistenza.DAOArchivio;
import it.unibas.file.persistenza.IDAOArchivio;
import it.unibas.file.vista.Frame;
import it.unibas.file.vista.VistaFile;
import it.unibas.file.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {
    
    private static final Applicazione singleton = new Applicazione();
    
    private Applicazione() {}
    
    public static Applicazione getIstance() {
        return singleton;
    }
    
    private Modello modello;
    private IDAOArchivio dAOArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloFile controlloFile;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaFile vistaFile;
    
    public void inizializza() {
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloFile = new ControlloFile();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaFile = new VistaFile(frame, true);
        
        this.vistaPrincipale.inizializza();
        this.vistaFile.inizializza();
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

    public ControlloFile getControlloFile() {
        return controlloFile;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaFile getVistaFile() {
        return vistaFile;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Applicazione.getIstance()::inizializza);
    }
}
