package it.unibas.lavoro.controllo;

import it.unibas.lavoro.Applicazione;
import it.unibas.lavoro.modello.Archivio;
import it.unibas.lavoro.modello.Costanti;
import it.unibas.lavoro.modello.Offerta;
import it.unibas.lavoro.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloVistaPrincipale {
    
    private final Action azioneCerca = new AzioneCerca();
    
    public Action getAzioneCerca() {
        return this.azioneCerca;
    }
    
    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            putValue(NAME, "Cerca");
            putValue(SHORT_DESCRIPTION, "Cerca offerte di lavoro");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String modalita = vista.getModalita();
            String retribuzione = vista.getRetribuzioneAnnua();
            String convalida = errori(modalita, retribuzione);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoModalita = Integer.parseInt(retribuzione);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Offerta> listaFiltrata = archivio.cercaOffertaDiLavoro(modalita, interoModalita);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

        private String errori(String modalita, String retribuzione) {
            StringBuilder sb = new StringBuilder();
            if (modalita.isEmpty()) {
             sb.append("Scegli una modalita' di lavoro").append("\n");
            }
            if (retribuzione.isEmpty()) {
                sb.append("Inserisci una retribuzione annua").append("\n");
            } else {
                try {
                    int interoRetribuzione = Integer.parseInt(retribuzione);
                    if (interoRetribuzione < 10000) {
                        sb.append("Inserisci una retribuzione annua reale (minimo 10000 euro)").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato per retribuzione annua non valido").append("\n");
                }
            }
            return sb.toString().trim();
        }
    } 
}
