package it.unibas.file.controllo;

import it.unibas.file.Applicazione;
import it.unibas.file.modello.Cartella;
import it.unibas.file.modello.Costanti;
import it.unibas.file.modello.File;
import it.unibas.file.vista.VistaFile;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloFile {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi file");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi file alla cartella selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaFile vista = Applicazione.getIstance().getVistaFile();
            String nome = vista.getNome();
            String dimensione = vista.getEstensione();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String ore = vista.getOra();
            String minuti = vista.getMinuti();
            String convalida = errori(nome, dimensione, giorno, mese, anno, ore, minuti);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            if (convalidaEstensione(nome)) {
                Applicazione.getIstance().getFrame().getErrore("Inserire un estensione consentita (.dll, .exe, .doc, .txt)");
                return;
            }
            int interoDimensione = Integer.parseInt(dimensione);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            int interoOre = Integer.parseInt(ore);
            int interoMinuti = Integer.parseInt(minuti);
            Calendar dataUtente = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
            Cartella cartellaSelezionata = (Cartella) Applicazione.getIstance().getModello().getBean(Costanti.CARTELLA_SELEZIONATA);
            if (dataUtente.getTime().before(cartellaSelezionata.getDataCreazione().getTime())) {
                Applicazione.getIstance().getFrame().getErrore("La data di creazione del file non può essere precedente alla data di creazione della cartella");
                return;
           } 
            cartellaSelezionata.addFile(new File(nome, interoDimensione, dataUtente));
            vista.aggiornaTabella();
        }

        private String errori(String nome, String dimensione, String giorno, String mese, String anno, String ore, String minuti) {
            StringBuilder sb = new StringBuilder();
            if (nome.isEmpty()) {
                sb.append("Inserisci un nome").append("\n");
            }
            if (dimensione.isEmpty()) {
                sb.append("Inserisci una dimensione").append("\n");
            } else {
                try {
                    int interoDimensione = Integer.parseInt(dimensione);
                    if (interoDimensione <= 0) {
                        sb.append("Inserisci una dimensione file maggiore di 0").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato dimensione non valido").append("\n");
                }
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                int interoOre = Integer.parseInt(ore);
                int interoMinuti = Integer.parseInt(minuti);
                Calendar calendar = new GregorianCalendar();
                calendar.setLenient(false);
                calendar.set(interoAnno, interoMese - 1, interoGiorno, interoOre, interoMinuti);
                calendar.getTime();
            } catch (IllegalArgumentException e) {
                sb.append("Formato data non valido").append("\n");
            }
            return sb.toString().trim();
        }
    }

    private boolean convalidaEstensione(String estensione) {
        boolean verifica = true;
        if (estensione.contains(".dll")) {
            verifica = false;
        }
        if (estensione.contains(".exe")) {
            verifica = false;
        }
        if (estensione.contains(".txt")) {
            verifica = false;
        }
        if (estensione.contains(".doc")) {
            verifica = false;
        }
        return verifica;
    }

}
