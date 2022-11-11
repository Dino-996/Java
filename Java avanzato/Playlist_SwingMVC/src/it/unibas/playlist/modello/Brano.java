package it.unibas.playlist.modello;

public class Brano {
    private String nomeBrano;
    private String nomeArtista;
    private String categoria;
    private int durata; //in secondi

    public Brano(String nomeBrano, String nomeArtista, String categoria, int durata) {
        this.nomeBrano = nomeBrano;
        this.nomeArtista = nomeArtista;
        this.categoria = categoria;
        this.durata = durata;
    }
    
    public String getNomeBrano() {
        return nomeBrano;
    }

    public void setNomeBrano(String nomeBrano) {
        this.nomeBrano = nomeBrano;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    
    public int getDurataInMinuti() {
        return this.durata/60;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brano{");
        sb.append("nomeBrano=").append(nomeBrano);
        sb.append(", nomeArtista=").append(nomeArtista);
        sb.append(", categoria=").append(categoria);
        sb.append(", durata=").append(durata);
        sb.append('}');
        return sb.toString();
    }
    
    
}
