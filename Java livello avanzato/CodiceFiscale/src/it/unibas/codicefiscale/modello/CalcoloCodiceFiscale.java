package it.unibas.codicefiscale.modello;

public class CalcoloCodiceFiscale {

    private String nome;
    private String cognome;
    private int anno;
    private String sesso;

    public CalcoloCodiceFiscale(String nome, String cognome, int anno, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.anno = anno;
        this.sesso = sesso;
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

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public String verificaCodiceFiscale(String nome, String cognome, int anno, String sesso) {
        StringBuilder codiceFiscale = new StringBuilder();
        this.nome = nome.substring(0, 3).toUpperCase();
        this.cognome = cognome.substring(0, 3).toUpperCase();
        this.anno = anno;
        this.sesso = sesso.substring(0, 1).toUpperCase();
        codiceFiscale.append(this.nome).append(this.cognome).append(this.anno).append(this.sesso);
        return codiceFiscale.toString().trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CalcoloCodiceFiscale{");
        sb.append("nome=").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", anno=").append(anno);
        sb.append(", sesso=").append(sesso);
        sb.append('}');
        return sb.toString();
    }

}
