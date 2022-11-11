package it.unibas.banca.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Conto {

    private String IBAN;
    private String intestatario;
    private Calendar dataApertura;
    private List<Movimento> listaMovimenti = new ArrayList<>();

    public Conto(String IBAN, String intestatario, Calendar dataApertura) {
        this.IBAN = IBAN;
        this.intestatario = intestatario;
        this.dataApertura = dataApertura;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getIntestatario() {
        return intestatario;
    }

    public Calendar getDataApertura() {
        return dataApertura;
    }

    public List<Movimento> getListaMovimenti() {
        return listaMovimenti;
    }
    
    public void addMovimento(Movimento movimento) {
        this.listaMovimenti.add(movimento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContoCorrente{");
        sb.append("IBAN=").append(IBAN);
        sb.append(", intestatario=").append(intestatario);
        sb.append(", dataApertura=").append(dataApertura);
        sb.append(", listaMovimenti=").append(listaMovimenti);
        sb.append('}');
        return sb.toString();
    }
}
