package segmenti;

public class Segmento {

    private Punto primoVertice;
    private Punto secondoVertice;
    
    public void setPrimoVertice(Punto primoVertice) {
        this.primoVertice = primoVertice;
    }
    
    public Punto getPrimoVertice() {
        return this.primoVertice;
    }
    
    public void setSecondoVertice(Punto secondoVertice) {
        this.secondoVertice = secondoVertice;
    }
    
    public Punto getSecondoVertice() {
        return this.secondoVertice;
    }
    
    public double getLunghezza() {
        double x1 = this.primoVertice.getAscissa();
        double y1 = this.primoVertice.getOrdinata();
        double x2 = this.secondoVertice.getAscissa();
        double y2 = this.secondoVertice.getOrdinata();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    
    
}
