package it.unibas.playlist;

import it.unibas.playlist.controllo.ControlloBrani;
import it.unibas.playlist.controllo.ControlloMenu;
import it.unibas.playlist.controllo.ControlloPlaylist;
import it.unibas.playlist.controllo.ControlloPrincipale;
import it.unibas.playlist.modello.Modello;
import it.unibas.playlist.modello.Playlist;
import it.unibas.playlist.persistenza.DAOArchivio;
import it.unibas.playlist.persistenza.IDAOArchivio;
import it.unibas.playlist.vista.Frame;
import it.unibas.playlist.vista.VistaBrano;
import it.unibas.playlist.vista.VistaPlaylist;
import it.unibas.playlist.vista.VistaPrincipale;
import java.util.List;
import javax.swing.SwingUtilities;

public class Applicazione {
    
    private static Applicazione singleton = new Applicazione();
    
    public static Applicazione getIstance(){
        return singleton;
    }
    
    private Applicazione() {}
    
    private Modello modello;
    private IDAOArchivio dAOArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private ControlloBrani controlloBrani;
    private ControlloPlaylist controlloPlaylist;
    private Frame frame;
    private VistaPlaylist vistaPlaylist;
    private VistaBrano vistaBrano;
    private VistaPrincipale vistaPrincipale;
    
    public void inizializza() {
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloBrani = new ControlloBrani();
        this.controlloPlaylist = new ControlloPlaylist();
        this.frame = new Frame();
        this.vistaPlaylist = new VistaPlaylist(frame, true);
        this.vistaBrano = new VistaBrano(frame, true);
        this.vistaPrincipale = new VistaPrincipale();
        
        this.vistaPrincipale.inizializza();
        this.vistaPlaylist.inizializza();
        this.vistaBrano.inizializza();
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

    public ControlloBrani getControlloBrani() {
        return controlloBrani;
    }

    public void setControlloBrani(ControlloBrani controlloBrani) {
        this.controlloBrani = controlloBrani;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaBrano getVistaBrano() {
        return vistaBrano;
    }

    public VistaPlaylist getVistaPlaylist() {
        return vistaPlaylist;
    }

    public ControlloPlaylist getControlloPlaylist() {
        return controlloPlaylist;
    }

    public void setControlloPlaylist(ControlloPlaylist controlloPlaylist) {
        this.controlloPlaylist = controlloPlaylist;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getIstance().inizializza();
            }
        });
    }

    public List<Playlist> getModello(String LISTA_FILTRATA) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
