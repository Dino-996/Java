package it.unibas.mediapesata.modello;

public class Esame {
    
    private String insegnamento;
    private int voto;
    private boolean lode;
    private int crediti;
    
    public Esame (String insegnamento, int voto, boolean lode, int crediti) {
        setInsegnamento(insegnamento);
        setVoto(voto);
        setLode(lode);
        setCrediti(crediti);
    }
    
    public String getInsegnamento() {
        return this.insegnamento;
    }
        
    public int getVoto() {
        return this.voto;
    }
        
    public int getCrediti() {
        return this.crediti;
    }
        
    public boolean isLode() {
        return this.lode;
    }
    
    private void setInsegnamento(String insegnamento) {
        this.insegnamento = insegnamento;
    }

    private void setVoto(int voto) {
        this.voto = voto;
    }

    private void setCrediti(int crediti) {
        this.crediti = crediti;
    }

    private void setLode(boolean lode) {
        this.lode = lode;
    }
    
    public String toString() {
        String risultato = "Esame di " + this.insegnamento + " (" + this.crediti + " CFU) - voto: " + this.voto;
        if (this.lode) {
            risultato = risultato + " e lode";
        }
        return risultato;
    }

}
