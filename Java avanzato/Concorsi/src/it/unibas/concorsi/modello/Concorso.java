package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Concorso {

    private static final Logger logger = LoggerFactory.getLogger(Concorso.class);

    private String codice;
    private String descrizione;
    private int numeroPosti;
    private String regione;
    private Calendar dataOraConcorso;
    private List<Domanda> listaDomande = new ArrayList<>();

    public Concorso(String codice, String descrizione, int numeroPosti, String regione, Calendar dataOraConcorso) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.numeroPosti = numeroPosti;
        this.regione = regione;
        this.dataOraConcorso = dataOraConcorso;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public Calendar getDataOraConcorso() {
        return dataOraConcorso;
    }

    public void setDataOraConcorso(Calendar dataOraConcorso) {
        this.dataOraConcorso = dataOraConcorso;
    }

    public List<Domanda> getListaDomande() {
        return listaDomande;
    }

    public void setListaDomande(List<Domanda> listaDomande) {
        this.listaDomande = listaDomande;
    }

    public void addDomanda(Domanda domanda) {
        this.listaDomande.add(domanda);
    }

    //SCENARIO ALTERNATIVO 1 
    public boolean verificaDuplicati(String codiceFiscale) {
        for (Domanda domanda : this.listaDomande) {
            if (domanda.getCodiceFiscale().equals(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }

    //SCENARIO ALTERNATIVO 2
    public int contaOccorrenze(Domanda altraDomanda) { //Se maggiore di zero ho trovato un duplicato
        int conta = 0;
        for (Domanda domanda : this.listaDomande) {
            if (domanda.getCodiceFiscale().equals(altraDomanda.getCodiceFiscale())) {
                conta++;
            }
        }
        logger.debug("SCENARIO ALTERNATIVO 2 - Domande duplicate trovate: {}", conta);
        return conta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Concorso{");
        sb.append("codice=").append(codice);
        sb.append(", descrizione=").append(descrizione);
        sb.append(", numeroPosti=").append(numeroPosti);
        sb.append(", regione=").append(regione);
        sb.append(", dataOraConcorso=").append(dataOraConcorso);
        sb.append('}');
        return sb.toString();
    }
}