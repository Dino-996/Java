package circonferenze;

public class Circonferenza {

    public final static double PIGRECO = 3.14;

    public Circonferenza(double ascissaCentro, double ordinataCentro, double raggio) {
        this.raggio = raggio;
        this.ascissaCentro = ascissaCentro;
        this.ordinataCentro = ordinataCentro;
    }

    //////////////////////////////////
    
    private double ascissaCentro;
    private double ordinataCentro;
    private double raggio;

    public double getAscissaCentro() {
        return this.ascissaCentro;
    }

    public double getOrdinataCentro() {
        return this.ordinataCentro;
    }

    public double getRaggio() {
        return this.raggio;
    }

    public double getLunghezzaCirconferenza() {
        return (2 * Circonferenza.PIGRECO * this.raggio);
    }

    public double getSuperficieCerchio() {
        return (Circonferenza.PIGRECO * Math.pow(this.raggio, 2));
    }

}
