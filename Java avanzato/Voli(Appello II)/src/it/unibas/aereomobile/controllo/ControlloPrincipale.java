package it.unibas.aereomobile.controllo;

import it.unibas.aereomobile.Applicazione;
import it.unibas.aereomobile.modello.Aereomobile;
import it.unibas.aereomobile.modello.Archivio;
import it.unibas.aereomobile.modello.Costanti;
import it.unibas.aereomobile.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
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

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Visualizza voli");
            this.putValue(SHORT_DESCRIPTION, "Visualizza i voli disponibili per l'aereomobile selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt Z"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            int rigaSelezionata = vista.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getIstance().getFrame().getErrore("Selezionare un aereomobile prima di continuare!");
                return;
            }
            List<Aereomobile> listaFiltrata = (List<Aereomobile>) Applicazione.getIstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Aereomobile aereomobileSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getIstance().getModello().putBean(Costanti.AEREOMOBILE_SELEZIONATO, aereomobileSelezionato);
            Applicazione.getIstance().getVistaVoli().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca aereomobile");
            this.putValue(SHORT_DESCRIPTION, "Cerca aereomobile in base ai criteri selezionati");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vista = Applicazione.getIstance().getVistaPrincipale();
            boolean isDecrescente = vista.getPasseggeriDecrescente();
            boolean isCrescente = vista.getPasseggeriCrescente();
            boolean isTipologiaCrescente = vista.getTipologiaCrescente();
            String numeroMinimoPasseggeri = vista.getPasseggeri();
            String convalida = errori(numeroMinimoPasseggeri);
            if (!convalida.isEmpty()) {
                Applicazione.getIstance().getFrame().getErrore(convalida);
                return;
            }
            int interoNumeroPasseggeri = Integer.parseInt(numeroMinimoPasseggeri);
            String criterio = "";
            if (isTipologiaCrescente) {
                criterio = Costanti.ORDINA_TIPOLOGIA_CRESCENTE;
            }
            if (isDecrescente) {
                criterio = Costanti.ORDINA_PASSEGGERI_DECRESCENTE;
            }
            if (isCrescente) {
                criterio = Costanti.ORDINA_PASSEGGERI_CRESCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getIstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Aereomobile> listaFiltrata = archivio.listaFiltrata(criterio, interoNumeroPasseggeri);
            Applicazione.getIstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vista.aggiornaTabella();
        }

        private String errori(String numeroMinimoPasseggeri) {
            StringBuilder sb = new StringBuilder();
            if (numeroMinimoPasseggeri.isEmpty()) {
                sb.append("Inserire un numero minimo di passeggeri.").append("\n");
            } else {
                try {
                    int interoNumeroPasseggeri = Integer.parseInt(numeroMinimoPasseggeri);
                    if (interoNumeroPasseggeri <= 0) {
                        sb.append("Inserire un numero di passeggeri maggiore di 0").append("\n");
                    }
                } catch (NumberFormatException e) {
                    sb.append("Formato numero non corretto");
                }
            }
            return sb.toString().trim();
        }
    }
}
