package it.unibas.anagrafica.modello;

import java.util.List;
import java.util.ArrayList;

public class Azienda {

    private String partitaIVA;
    private String denominazione;
    private String sedeSociale;
    private List<Dipendente> listaDipendenti = new ArrayList<>();

    public Azienda(String partitaIVA, String denominazione, String sedeSociale) {
        this.partitaIVA = partitaIVA;
        this.denominazione = denominazione;
        this.sedeSociale = sedeSociale;
    }

    public String getPartitaIVA() {
        return partitaIVA;
    }

    public void setPartitaIVA(String partitaIVA) {
        this.partitaIVA = partitaIVA;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getSedeSociale() {
        return sedeSociale;
    }

    public void setSedeSociale(String sedeSociale) {
        this.sedeSociale = sedeSociale;
    }

    public List<Dipendente> getListaDipendenti() {
        return listaDipendenti;
    }

    public void setListaDipendenti(List<Dipendente> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }

    public void addDipendente(Dipendente dipendente) {
        this.listaDipendenti.add(dipendente);
    }

    /**
     * SCENARIO ALTERNATIVO - UTENTE VERIFICA DUPLICATI
     * @param codiceFiscale
     * @return 
     */
    
    public boolean verificaCodiceFiscale(String codiceFiscale) {
        for (Dipendente dipendente : this.listaDipendenti) {
            if (dipendente.getCodFiscale().equals(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PartitaIVA: ").append(this.partitaIVA).append("\n");
        sb.append("Denominazione: ").append(this.denominazione).append("\n");
        sb.append("Sede sociale: ").append(this.sedeSociale).append("\n");
        return sb.toString().trim();
    }
}
