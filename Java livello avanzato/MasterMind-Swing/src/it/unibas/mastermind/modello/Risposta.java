package it.unibas.mastermind.modello;

public class Risposta {
    
    private Combinazione tentativo;
    private int palliniNeri;
    private int palliniBianchi;

    public Risposta(Combinazione tentativo, int palliniNeri, int palliniBianchi) {
        this.tentativo = tentativo;
        this.palliniNeri = palliniNeri;
        this.palliniBianchi = palliniBianchi;
    }

    public Combinazione getTentativo() {
        return tentativo;
    }

    public int getPalliniNeri() {
        return palliniNeri;
    }

    public int getPalliniBianchi() {
        return palliniBianchi;
    }  
}
