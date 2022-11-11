package it.unibas.aereomobile.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Aereomobile {

    private String codice;
    private int numPasseggeri;
    private String tipologia;
    private Calendar dataUltimaManutenzione;
    private List<Volo> listaVoli = new ArrayList<>();

    public Aereomobile(String codice, int numPasseggeri, String tipologia, Calendar dataUltimaManutenzione) {
        this.codice = codice;
        this.numPasseggeri = numPasseggeri;
        this.tipologia = tipologia;
        this.dataUltimaManutenzione = dataUltimaManutenzione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public int getNumPasseggeri() {
        return numPasseggeri;
    }

    public void setNumPasseggeri(int numPasseggeri) {
        this.numPasseggeri = numPasseggeri;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Calendar getDataUltimaManutenzione() {
        return dataUltimaManutenzione;
    }

    public void setDataUltimaManutenzione(Calendar dataUltimaManutenzione) {
        this.dataUltimaManutenzione = dataUltimaManutenzione;
    }

    public List<Volo> getListaVoli() {
        return listaVoli;
    }

    public void setListaVoli(List<Volo> listaVoli) {
        this.listaVoli = listaVoli;
    }

    public void addVolo(Volo volo) {
        listaVoli.add(volo);
    }

    //Almeno uno che non è partio dallo stesso aereoporto
    //Prendo il primo e lo verifico con tutti gli aereomobili
    public boolean isStessoAereoporto() {
        if (listaVoli.size() < 2) {
            return false;
        }
        String primoAereoporto = listaVoli.get(0).getAereoportoPartenza();
        for (Volo volo : listaVoli) {
            if (!volo.getAereoportoPartenza().equals(primoAereoporto)) {
                return false;
            }
        }
        return true;
    }

    public double calcolaMedia() {
        double media = 0.0;
        for (Volo volo : listaVoli) {
            media += volo.getDurataInMinuti();
        }
        return media / listaVoli.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice: ").append(codice).append("\n");
        sb.append("Numero passeggeri: ").append(numPasseggeri).append("\n");
        sb.append("Tipologia: ").append(tipologia).append("\n");
        sb.append("Data ultima manutenzione: ").append(GestoreDate.getDataFormattata(dataUltimaManutenzione.getTime())).append("\n");
        return sb.toString().trim();
    }
}
