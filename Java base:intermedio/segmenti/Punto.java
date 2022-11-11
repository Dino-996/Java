package segmenti;

public class Punto {
    
    private double ascissa;
    private double ordinata;
	    
    public void setAscissa(double ascissa) {
        this.ascissa = ascissa;
    }
    
    public double getAscissa() {
        return this.ascissa;
    }
    
    public void setOrdinata(double ordinata) {
        this.ordinata = ordinata;
    }
    
    public double getOrdinata() {
        return this.ordinata;
    }
    
    public int getQuadrante() {
        int quadrante = 4;
        if (this.ascissa >= 0 && this.ordinata >= 0) {
            quadrante = 1;
        } else if (this.ascissa < 0 && this.ordinata >= 0){
            quadrante = 2;
        } else if (this.ascissa < 0 && this.ordinata < 0) {
            quadrante = 3;
        }
        return quadrante;
    }
    
    public String toString() {
        return "(" + this.ascissa + ", " + this.ordinata + ")";
    }
    
}
