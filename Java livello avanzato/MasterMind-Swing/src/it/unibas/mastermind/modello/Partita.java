package it.unibas.mastermind.modello;

import java.util.ArrayList;
import java.util.List;

public class Partita {
    
    private Combinazione combinazioneSegreta;
    private List<Risposta> listaRisposte = new ArrayList<>();

    public Partita(Combinazione combinazioneSegreta) {
        this.combinazioneSegreta = combinazioneSegreta;
    }

    public Combinazione getCombinazioneSegreta() {
        return combinazioneSegreta;
    }

    public List<Risposta> getListaRisposte() {
        return listaRisposte;
    }
    
    public int getNumeroTentativi() {
        return this.listaRisposte.size();
    }
    
    public void aggiungiRisposta(Risposta nuovaRisposta) {
        this.listaRisposte.add(nuovaRisposta);
    }
}
