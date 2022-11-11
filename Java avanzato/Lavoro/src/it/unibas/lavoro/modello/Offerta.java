package it.unibas.lavoro.modello;

import java.util.ArrayList;
import java.util.List;

public class Offerta implements Comparable<Offerta> {

    private String codiceUnivoco;
    private String descrizione;
    private int retribuzioneAnnua;
    private String modalita;
    private List<Candidatura> listaCandidature = new ArrayList<>();

    public Offerta(String codiceUnivoco, String descrizione, int retribuzioneAnnua, String modalita) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.retribuzioneAnnua = retribuzioneAnnua;
        this.modalita = modalita;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getRetribuzioneAnnua() {
        return retribuzioneAnnua;
    }

    public void setRetribuzioneAnnua(int retribuzioneAnnua) {
        this.retribuzioneAnnua = retribuzioneAnnua;
    }

    public String getModalita() {
        return modalita;
    }

    public void setModalita(String modalita) {
        this.modalita = modalita;
    }

    public List<Candidatura> getListaDomande() {
        return listaCandidature;
    }

    public void setListaDomande(List<Candidatura> listaCandidature) {
        this.listaCandidature = listaCandidature;
    }

    public void addCandidatura(Candidatura candidatura) {
        this.listaCandidature.add(candidatura);
    }

    public int getDomandeOverTrenta() {
        int overTrenta = 0;
        for (Candidatura candidatura : this.listaCandidature) {
            if (candidatura.getEta() > 30) {
                overTrenta += 1;
            }
        }
        return overTrenta;
    }

    //Punto 3 - UTENTE VERIFICA OFFERTA
    public int contaOccorrenze(Offerta offertaSelezionata) {
        Candidatura altraCandidatura = null;
        int conta = 0;
        for (Candidatura candidatura : offertaSelezionata.getListaDomande()) {

            if (altraCandidatura == null) {
                altraCandidatura = candidatura; //Conta qui vale 1 a prescindere perche altraCandidatura vede se stesso per primo e poi va avanti
            }

            if (candidatura.getCodiceFiscale().equals(altraCandidatura.getCodiceFiscale())) {
                conta++;
            }
        }
        return conta;
    }

    public int contaDomandeDuplicate(Offerta offertaSelezionata) {
        int duplicati = contaOccorrenze(offertaSelezionata);
        return duplicati;
    }

    //Punto 4 - UTENTE VERIFICA ARCHIVIO
    public double getMediaEtaCandidati() {
        double media = 0.0;
        for (Candidatura candidatura : this.listaCandidature) {
            media += candidatura.getEta();
        }
        return media / this.listaCandidature.size();
    }

    //Punto 4 - UTENTE VERIFICA ARCHIVIO (FINE)

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Offerta{");
        sb.append("codiceUnivoco=").append(codiceUnivoco);
        sb.append(", descrizione=").append(descrizione);
        sb.append(", retribuzioneAnnua=").append(retribuzioneAnnua);
        sb.append(", modalita=").append(modalita);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Offerta o) {
        return this.retribuzioneAnnua - o.getRetribuzioneAnnua();
    }
}
