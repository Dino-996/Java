package it.unibas.anagrafica.modello;

import java.text.DateFormat;
import java.util.Calendar;

public class Dipendente {
    private String codFiscale;
    private String nome;
    private String cognome;
    private Calendar dataAssunzione; //OMETTENDO ORA E MINUTI
    private String sesso;

    public Dipendente(String codFiscale, String nome, String cognome, Calendar dataAssunzione, String sesso) {
        this.codFiscale = codFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
        this.sesso = sesso;
    }

    public String getCodFiscale() {
        return codFiscale;
    }

    public void setCodFiscale(String codFiscale) {
        this.codFiscale = codFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Calendar getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(Calendar dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
    
    public String formattaData() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String dataFormattata = df.format(this.dataAssunzione.getTime());
        return dataFormattata;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice fiscale: ").append(this.codFiscale).append("\n");
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Cognome: ").append(this.cognome).append("\n");
        sb.append("Data assunzione: ").append(formattaData()).append("\n");
        sb.append("Sesso: ").append(this.sesso).append("\n");
        sb.append("--------------------------").append("\n");
        return sb.toString().trim();
    }   
}
