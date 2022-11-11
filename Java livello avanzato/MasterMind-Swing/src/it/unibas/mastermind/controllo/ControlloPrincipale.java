package it.unibas.mastermind.controllo;

import it.unibas.mastermind.Applicazione;
import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Costanti;
import it.unibas.mastermind.modello.OperatoreCombinazione;
import it.unibas.mastermind.modello.Partita;
import it.unibas.mastermind.modello.Risposta;
import it.unibas.mastermind.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {
    
    private final Action azioneTentativo = new AzioneTentativo();
   
    public Action getAzioneTentativo() {
        return this.azioneTentativo;
    }
    
    private class AzioneTentativo extends AbstractAction {

        public AzioneTentativo() {
            this.putValue(NAME, "Tenta");
            this.putValue(SHORT_DESCRIPTION, "Tenta la nuova combinazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_T);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt T"));
            this.setEnabled(false);
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int cifraUno = vista.getCifraUno();
            int cifraDue = vista.getCifraDue();
            int cifraTre = vista.getCifraTre();
            int cifraQuattro = vista.getCifraQuattro();
            Combinazione combinazioneTentativo = new Combinazione(cifraUno, cifraDue, cifraTre, cifraQuattro);
            Partita partita = (Partita) Applicazione.getIstance().getModello().getBean(Costanti.PARTITA);
            Combinazione combinazioneSegreta = partita.getCombinazioneSegreta();
            OperatoreCombinazione operatore = new OperatoreCombinazione();
            if (!operatore.verificaCorrettezzaDiCombinazione(combinazioneTentativo)) {
                Applicazione.getIstance().getFrame().getErrore("La combinazione tentata non è corretta");
                return;
            }
            Risposta risposta = operatore.valutaTentativo(combinazioneSegreta, combinazioneTentativo);
            partita.aggiungiRisposta(risposta);
            if (risposta.getPalliniNeri() == Costanti.CIFRE_COMBINAZIONE) {
                Applicazione.getIstance().getFrame().getMessaggio("Complimenti, hai indovinato in " + partita.getNumeroTentativi() + " tentativi");
                Applicazione.getIstance().getControlloPrincipale().getAzioneTentativo().setEnabled(false);
                Applicazione.getIstance().getControlloMenu().getAzioneIniziaPartita().setEnabled(true);
            }
            vista.aggioranDati();
        }
        
    }
    
}
