package it.unibas.playlist.modello;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private List<Playlist> listaPlaylist = new ArrayList<>();

    public void addPlaylist(Playlist playlist) {
        this.listaPlaylist.add(playlist);
    }

    public List<Playlist> getListaPlaylist() {
        return this.listaPlaylist;
    }

    public void setListaPlaylist(List<Playlist> listaPlaylist) {
        this.listaPlaylist = listaPlaylist;
    }
    
    public boolean isDuplicato(Playlist nuovaPlaylist) {
        for (Playlist playlist : this.listaPlaylist) {
            if (playlist.getNomeBrano().equalsIgnoreCase(nuovaPlaylist.getNomeBrano())) {
                return true;
            }
        }
        return  false;
    }
}
