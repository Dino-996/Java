package it.unibas.mastermind.controllo;

import it.unibas.mastermind.Applicazione;
import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Costanti;
import it.unibas.mastermind.modello.OperatoreCombinazione;
import it.unibas.mastermind.modello.Partita;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {
    
    private Action azioneEsci = new AzioneEsci();
    private Action azioneIniziaPartita = new AzioneIniziaPartita();
    private Action azioneInterrompiPartita = new AzioneInterrompiPartita();

    public Action getAzioneIniziaPartita() {
        return this.azioneIniziaPartita;
    }
    
    public Action getAzioneEsci() {
        return this.azioneEsci;
    }
    
    public Action getAzioneInterrompiPartita() {
        return this.azioneInterrompiPartita;
    }
    
    private class AzioneInterrompiPartita extends AbstractAction {

        public AzioneInterrompiPartita() {
            this.putValue(NAME, "Interrompi partita");
            this.putValue(SHORT_DESCRIPTION, "Termina la partita corrente");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.setEnabled(false);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Partita partita = (Partita) Applicazione.getIstance().getModello().getBean(Costanti.PARTITA);
            Applicazione.getIstance().getFrame().getMessaggio("Peccato, la combinazione da indovinare era -> " + partita.getCombinazioneSegreta());
            Applicazione.getIstance().getControlloPrincipale().getAzioneTentativo().setEnabled(false);
            Applicazione.getIstance().getControlloMenu().getAzioneIniziaPartita().setEnabled(true);
            Applicazione.getIstance().getControlloMenu().getAzioneInterrompiPartita().setEnabled(false);
            
        }
        
    }
    
    private class AzioneIniziaPartita extends AbstractAction {

        public AzioneIniziaPartita() {
            this.putValue(NAME, "Inizia partita");
            this.putValue(SHORT_DESCRIPTION, "Inizia una nuova partita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt N"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            OperatoreCombinazione operatore = new OperatoreCombinazione();
            Combinazione combinazioneSegreta = operatore.generaCombinazione();
            Partita partita = new Partita(combinazioneSegreta);
            Applicazione.getIstance().getModello().putBean(Costanti.PARTITA, partita);
            Applicazione.getIstance().getControlloPrincipale().getAzioneTentativo().setEnabled(true);
            Applicazione.getIstance().getControlloMenu().getAzioneIniziaPartita().setEnabled(false);
            Applicazione.getIstance().getControlloMenu().getAzioneInterrompiPartita().setEnabled(true);
            
        }

    }
    
    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }    
    }
    
}
