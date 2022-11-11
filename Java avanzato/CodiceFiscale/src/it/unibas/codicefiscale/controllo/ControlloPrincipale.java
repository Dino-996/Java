package it.unibas.codicefiscale.controllo;

import it.unibas.codicefiscale.Applicazione;
import it.unibas.codicefiscale.modello.CalcoloCodiceFiscale;
import it.unibas.codicefiscale.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneCalcolaCodiceFiscale = new AzioneCalcolaCodiceFiscale();
    
    public Action getAzioneCalcolaCodiceFiscale() {
        return this.azioneCalcolaCodiceFiscale;
    }
    
    private class AzioneCalcolaCodiceFiscale extends AbstractAction {
        
        public AzioneCalcolaCodiceFiscale() {
            this.putValue(NAME, "Calcola");
            this.putValue(SHORT_DESCRIPTION, "Calcola codice fiscale");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVista();
            String nome = vista.getCampoNome();
            String cognome = vista.getCampoCognome();
            String anno = vista.getCampoAnno();
            String sesso = vista.getComboSesso();
            String convalida = errori(nome, cognome, anno, sesso);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoAnno = Integer.parseInt(anno);
            CalcoloCodiceFiscale codice = new CalcoloCodiceFiscale(nome, cognome, interoAnno, sesso);
            String verifica = codice.verificaCodiceFiscale(nome, cognome, interoAnno, sesso);
            vista.setCampoRisultato(verifica);
        }

        private String errori(String nome, String cognome, String anno, String sesso) {
            StringBuilder sb = new StringBuilder();
            if (nome.isEmpty()) {
                sb.append("Inserire un nome prima di continuare").append("\n");
            } else if (nome.length() < 3) {
                sb.append("Il nome deve contenere piu' di tre caratteri").append("\n");
            }
            if (cognome.isEmpty()) {
                sb.append("Inserire un cognome prima di continuare").append("\n");
            } else if (cognome.length() < 3) {
                 sb.append("Il cognome deve contenere piu' di tre caratteri").append("\n");
            }
            if (anno.isEmpty()) {
                sb.append("Inserire un anno prima di continuare").append("\n");
            } else {
                try {
                    Calendar calendar = Calendar.getInstance();
                    int annoCorrente = calendar.get(Calendar.YEAR);
                    int interoAnno = Integer.parseInt(anno);
                    if (interoAnno < 1900 || interoAnno > annoCorrente) {
                        sb.append("Inserire un anno di nascita valido").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato anno non valido").append("\n");
                }
            }
            if (sesso.isEmpty()) {
                sb.append("Scegliere un sesso prima di continuare").append("\n");
            }
            return sb.toString().trim();
        }
        
    }
}
