package it.unibas.file.controllo;

import it.unibas.file.Applicazione;
import it.unibas.file.modello.Archivio;
import it.unibas.file.modello.Cartella;
import it.unibas.file.modello.Costanti;
import it.unibas.file.vista.VistaPrincipale;
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

public class ControlloPrincipale {

    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneSeleziona = new AzioneSeleziona();

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneSeleziona() {
        return azioneSeleziona;
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca cartella");
            this.putValue(SHORT_DESCRIPTION, "Cerca cartella in base all'utente e per dimensione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String utente = vista.getNomeUtente();
            String numeroFile = vista.getNumeroFile();
            String convalida = errori(utente, numeroFile);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getMessaggio(convalida);
                return;
            }
            int interoNumero = Integer.parseInt(numeroFile);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Cartella> listaFiltrata = archivio.cercaCartella(utente, interoNumero);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

        private String errori(String utente, String numeroFile) {
            StringBuilder sb = new StringBuilder();
            if (utente.isEmpty()) {
                sb.append("Inserire un nome utente").append("\n");
            }
            if (numeroFile.isEmpty()) {
                sb.append("Inserire un numero di file da visualizzare").append("\n");
            } else {
                try {
                    int interoNumero = Integer.parseInt(numeroFile);
                    if (interoNumero < 0) {
                        sb.append("Inserire un numero maggiore di 0").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato numero non valido").append("\n");
                }
            }
            return sb.toString().trim();
        }
    }

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Visualizza file");
            this.putValue(SHORT_DESCRIPTION, "Visualizza file contenuti nella cartella selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_F);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt F"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getMessaggio("Selezionare una cartella prima di continuare;");
                return;
            }
            List<Cartella> listaFiltrata = (List<Cartella>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Cartella cartellaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.CARTELLA_SELEZIONATA, cartellaSelezionata);
            Applicazione.getIstance().getVistaFile().visualiazza();
        }
    }
}
