package it.unibas.cesti.controllo;

import it.unibas.cesti.Applicazione;
import it.unibas.cesti.modello.Cesto;
import it.unibas.cesti.modello.Costanti;
import it.unibas.cesti.modello.Prodotto;
import it.unibas.cesti.vista.VistaProdotto;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloProdotto {

    private final Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(Action.NAME, "Aggiungi prodotto");
            this.putValue(Action.SHORT_DESCRIPTION, "Aggiungi prodotto all'applicazione");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaProdotto vista = Applicazione.getIstance().getVistaProdotto();
            String nome = vista.getCampoNome();
            String peso = vista.getCampoPeso();
            String tipologia = vista.getComboTipologia();
            String giorno = vista.getGiorno();
            String mese = vista.getMese();
            String anno = vista.getAnno();
            String errori = convalida(nome, peso, tipologia, giorno, mese, anno);
            if (!errori.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(errori);
                return;
            }
            int interoPeso = Integer.parseInt(peso);
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            Calendar dataUtente = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno);
            Calendar dataOggi = new GregorianCalendar();
            if (dataUtente.before(dataOggi)) {
                Applicazione.getIstance().getFrame().getErrore("Prodotto scaduto: Inserire una data di scadenza valida");
                return;
            }
            dataOggi.add(Calendar.MONTH, +6);
            if (tipologia.equals(Costanti.DOLCI)) {
                if (dataUtente.getTime().after(dataOggi.getTime())) {
                    Applicazione.getIstance().getFrame().getErrore("Scadenza non valida: Un prodotto di tipo dolce non può avere una scadena superiore ai 6 mesi");
                    return;
                }
            }
            Cesto cestoSelezionato = (Cesto) Applicazione.getIstance().getModello().getBean(Costanti.CESTO_SELEZIONATO);
            Prodotto prodotto = new Prodotto(nome, tipologia, interoPeso, dataUtente);
            String dimensioneConsentita = verificaProdotti(cestoSelezionato.getTipologia(), cestoSelezionato);
            if (!dimensioneConsentita.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(dimensioneConsentita);
                return;
            }
            cestoSelezionato.addProdotto(prodotto);
            vista.aggiornaTabella();
        }

        private String convalida(String nome, String peso, String tipologia, String giorno, String mese, String anno) {
            StringBuilder sb = new StringBuilder();
            if (nome.isEmpty()) {
                sb.append("Inserisci un nome").append("\n");
            }
            if (peso.isEmpty()) {
                sb.append("Inserisci un peso").append("\n");
            } else {
                try {
                    int interoPeso = Integer.parseInt(peso);
                    if (interoPeso < 0) {
                        sb.append("Il peso non può essere inferiore di 0").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato peso non valido").append("\n");
                }
            }
            if (tipologia.isEmpty()) {
                sb.append("Scegli una tipologia").append("\n");
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                Calendar data = new GregorianCalendar();
                data.setLenient(false);
                data.set(interoAnno, interoMese - 1, interoGiorno);
                data.getTime();
            } catch (IllegalArgumentException e) {
                sb.append("Formato data non valido").append("\n");
            }
            return sb.toString().trim();
        }

        public String verificaProdotti(String tipologia, Cesto cestoSelezionato) {
            StringBuilder sb = new StringBuilder();
            if (tipologia.equals(Costanti.CESTO_PICCOLO)) {
                if (cestoSelezionato.getListaProdotti().size() == 3) {
                    sb.append("Impossibile aggiungere piu di 3 prodotti in un cesto piccolo");
                }
            }
            if (tipologia.equals(Costanti.CESTO_MEDIO)) {
                if (cestoSelezionato.getListaProdotti().size() ==  5) {
                    sb.append("Impossibile aggiungere piu di 5 prodotti in un cesto medio");

                }
            }
            if (tipologia.equals(Costanti.CESTO_GRANDE)) {
                if (cestoSelezionato.getListaProdotti().size() == 7) {
                    sb.append("Impossibile aggiungere piu di 7 prodotti in un cesto grande");
                }
            }
            return sb.toString().trim();
        }

    }
}
