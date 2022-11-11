package it.unibas.playlist.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Playlist {
    private String nomePlaylist;
    private String nomeProprietario;
    private Calendar dataCreazione;
    
    private List<Brano> listaBrani = new ArrayList<>();

    public Playlist() {}
    
    public Playlist(String nomeBrano, String nomeProprietario, Calendar dataCreazione) {
        this.nomePlaylist = nomeBrano;
        this.nomeProprietario = nomeProprietario;
        this.dataCreazione = dataCreazione;
    }
    
    public void addBrano (Brano brano) {
        this.listaBrani.add(brano);
    }

    public String getNomeBrano() {
        return nomePlaylist;
    }

    public void setNomeBrano(String nomeBrano) {
        this.nomePlaylist = nomeBrano;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public Calendar getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Calendar dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public List<Brano> getListaBrani() {
        return listaBrani;
    }

    public void setListaBrani(List<Brano> listaBrani) {
        this.listaBrani = listaBrani;
    }
    
    public List<Brano> filtraPerCategoria(String categoria) {
        List<Brano> listaFiltrata = new ArrayList<>();
        for (Brano brano : this.listaBrani) {
            if (brano.getCategoria().equals(categoria)) {
                listaFiltrata.add(brano);
            }
        }
        return listaFiltrata;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(this.nomePlaylist);
        sb.append(", Proprietario: ").append(this.nomeProprietario);
        sb.append(", Creazione: ").append(this.dataCreazione);
        return sb.toString();
    }
}
