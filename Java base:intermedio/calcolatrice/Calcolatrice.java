package calcolatrice;

public class Calcolatrice {
    
    public Calcolatrice() {}
    
    private double risultato;
    
    public double getRisultatoInMemoria() {
        return this.risultato;
    }
    
    public double somma(double a, double b) {
        this.risultato = a + b;
        return this.risultato;
    }
    
    public double sottrai(double a, double b) {
        this.risultato = a - b;
        return this.risultato;
    }
    
    public double moltiplica(double a, double b) {
        this.risultato = a * b;
        return this.risultato;
    }
    
    public double dividi(double a, double b) {
        this.risultato = a / b;
        return this.risultato;
    }
    
    public double sommaAlRisultato(double b) {
        this.risultato = this.risultato + b;
        return this.risultato;
    }
    
    public double sottraiDalRisultato(double b) {
        this.risultato = this.risultato - b;
        return this.risultato;
    }
    
    public double moltiplicaPerIlRisultato(double b) {
        this.risultato = this.risultato * b;
        return this.risultato;
    }
    
    public double dividiIlRisultato(double b) {
        this.risultato = this.risultato / b;
        return this.risultato;
    }
    
}
