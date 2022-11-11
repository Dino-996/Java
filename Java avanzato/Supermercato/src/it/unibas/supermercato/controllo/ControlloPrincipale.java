package it.unibas.supermercato.controllo;

import it.unibas.supermercato.Applicazione;
import it.unibas.supermercato.modello.Archivio;
import it.unibas.supermercato.modello.Carrello;
import it.unibas.supermercato.modello.Costanti;
import it.unibas.supermercato.modello.Supermercato;
import it.unibas.supermercato.persistenza.DAOException;
import it.unibas.supermercato.persistenza.IDAOArchivio;
import it.unibas.supermercato.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private final Action azioneAggiungi = new AzioneAggiungi();
    private final Action azioneCerca = new AzioneCerca();
    private final Action azioneVisualizza = new AzioneVisualizza();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneVisualizza() {
        return azioneVisualizza;
    }

    private class AzioneVisualizza extends AbstractAction {

        public AzioneVisualizza() {
            this.putValue(NAME, "Visualizza prodotti");
            this.putValue(SHORT_DESCRIPTION, "Visualizza prodotti dal supermercato selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getMessaggio("Seleziona un supermercato per visualizzare i prodotti disponibili");
                return;
            }
            List<Supermercato> listaFiltrata = (List<Supermercato>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Supermercato supermercatoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBeans(Costanti.SUPERMERCATO_SELEZIONATO, supermercatoSelezionato);
            Carrello carrello = new Carrello();
            Applicazione.getIstance().getModello().putBeans(Costanti.CARRELLO, carrello);
            Applicazione.getIstance().getVistaProdotto().visualizza();
        }
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Invia");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi una nuova richiesta");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            String comboCitta = vista.getComboCittaInserimento();
            String campoIndirizzoDiConsegna = vista.getCampoIndirizzoInserimento();
            String civico = vista.getCampoCivicoInserimento();
            String comboSupermercato = vista.getComboSupermercatoInserimento();
            String convalida = errori(comboCitta, comboSupermercato, campoIndirizzoDiConsegna, civico);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoCivico = Integer.parseInt(civico);
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            archivio.addSupermercato(new Supermercato(comboSupermercato, comboCitta, campoIndirizzoDiConsegna, interoCivico, new GregorianCalendar()));
            Applicazione.getIstance().getFrame().getMessaggio("La richiesta e' stata inserita correttamente");
        }

        private String errori(String comboSupermercato, String comboNome, String campoIndirizzoDiConsegna, String civico) {
            StringBuilder sb = new StringBuilder();
            if (comboSupermercato.isEmpty()) {
                sb.append("Scegli una citta").append("\n");
            }
            if (comboNome.isEmpty()) {
                sb.append("Scegli il supermercato desiderato").append("\n");
            }
            if (campoIndirizzoDiConsegna.isEmpty()) {
                sb.append("Inserisci un indirizzo di consegna").append("\n");
            } else {
                for (int i = 0; i < 10; i++) {
                    String numero = String.valueOf(i);
                    if (campoIndirizzoDiConsegna.contains(numero)) {
                        sb.append("Inserire SOLO l'indirizzo di consegna (inserire il numero civico nel campo apposito)").append("\n");
                        break;
                    }
                }
            }
            if (campoIndirizzoDiConsegna.contains("Via") || campoIndirizzoDiConsegna.toUpperCase().contains("VIA") || campoIndirizzoDiConsegna.toLowerCase().contains("via")) {
                sb.append("Inserire l'indirizzo di consegna OMETTENDO il prefisso (Via)").append("\n");
            }
            if (civico.isEmpty()) {
                sb.append("Inserisci il numero civico").append("\n");
            } else {
                try {
                    int interoCivico = Integer.parseInt(civico);
                    if (interoCivico < 0) {
                        sb.append("Il numero civico non può essere negativo").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Inserisci un civico valido").append("\n");
                }
            }
            return sb.toString().trim();
        }

    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca supermercato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getIstance().getIdaoArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getIstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getIstance().getControlloPrincipale().getAzioneAggiungi().setEnabled(true);
                Applicazione.getIstance().getControlloPrincipale().getAzioneVisualizza().setEnabled(true);
                VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
                String comboCitta = vista.getComboCitta();
                String campoIndirizzoDiConsegna = vista.getCampoIndirizzo();
                String civico = vista.getCivico();
                boolean nomeCrescente = vista.isNomeCrescente();
                boolean nomeDecerescente = vista.isNomeDecrescente();
                boolean prodottiCrescente = vista.isProdottiCrescente();
                boolean prodottiDecrescenti = vista.isProdottiDecerescente();
                String convalida = errori(comboCitta, campoIndirizzoDiConsegna, civico);
                if (!convalida.isEmpty()) {
                    Applicazione.getIstance().getFrame().getErrore(convalida);
                    return;
                }
                int interoCivico = Integer.parseInt(civico);
                String criterio = "";
                if (nomeCrescente) {
                    criterio = Costanti.CRITERIO_NOME_CRESCENTE;
                }
                if (nomeDecerescente) {
                    criterio = Costanti.CRITERIO_NOME_DECRESCENTE;
                }
                if (prodottiCrescente) {
                    criterio = Costanti.CRITERIO_PRODOTTI_CRESCENTE;
                }
                if (prodottiDecrescenti) {
                    criterio = Costanti.CRITERIO_PRODOTTI_DECRESCENTE;
                }
                List<Supermercato> listaFiltrata = archivio.cercaSupermercati(campoIndirizzoDiConsegna, comboCitta, interoCivico, criterio);
                if (listaFiltrata.isEmpty()) {
                    Applicazione.getIstance().getFrame().getMessaggio("Ci dispiace, non sono disponibili supermercati aderenti nella tua zona");
                    return;
                }
                Applicazione.getIstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
                vista.aggiornaTabella();
            } catch (DAOException ex) {
                Applicazione.getIstance().getFrame().getErrore("Archivio supermercati non caricato: " + ex.getLocalizedMessage());
            }
        }

        private String errori(String comboSupermercato, String campoIndirizzoDiConsegna, String civico) {
            StringBuilder sb = new StringBuilder();
            if (comboSupermercato.isEmpty()) {
                sb.append("Scegli una citta").append("\n");
            }
            if (campoIndirizzoDiConsegna.isEmpty()) {
                sb.append("Inserisci un indirizzo di consegna").append("\n");
            } else {
                for (int i = 0; i < 10; i++) {
                    String numero = String.valueOf(i);
                    if (campoIndirizzoDiConsegna.contains(numero)) {
                        sb.append("Inserire SOLO l'indirizzo di consegna (inserire il numero civico nel campo apposito)").append("\n");
                        break;
                    }
                }
            }
            if (campoIndirizzoDiConsegna.contains("Via") || campoIndirizzoDiConsegna.toUpperCase().contains("VIA") || campoIndirizzoDiConsegna.toLowerCase().contains("via")) {
                sb.append("Inserire l'indirizzo di consegna OMETTENDO il prefisso (Via)").append("\n");
            }
            if (civico.isEmpty()) {
                sb.append("Inserisci il numero civico").append("\n");
            } else {
                try {
                    int interoCivico = Integer.parseInt(civico);
                    if (interoCivico < 0) {
                        sb.append("Il numero civico non può essere negativo").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Inserisci un civico valido").append("\n");
                }
            }
            return sb.toString().trim();
        }
    }
}
