package calcolatricestatica;

public class CalcolatriceStatica {

    private static double risultato;

    public static double getRisultatoInMemoria() {
        return CalcolatriceStatica.risultato;
    }

    public static double somma(double a, double b) {
        CalcolatriceStatica.risultato = a + b;
        return CalcolatriceStatica.risultato;
    }

    public static double sottrai(double a, double b) {
        CalcolatriceStatica.risultato = a - b;
        return risultato;
    }

    public static double moltiplica(double a, double b) {
        CalcolatriceStatica.risultato = a * b;
        return risultato;
    }

    public static double dividi(double a, double b) {
        CalcolatriceStatica.risultato = a / b;
        return risultato;
    }

    public static double sommaAlRisultato(double b) {
        CalcolatriceStatica.risultato = CalcolatriceStatica.risultato + b;
        return risultato;
    }

    public static double sottraiDalRisultato(double b) {
        CalcolatriceStatica.risultato = CalcolatriceStatica.risultato - b;
        return risultato;
    }

    public static double moltiplicaPerIlRisultato(double b) {
        CalcolatriceStatica.risultato = CalcolatriceStatica.risultato * b;
        return risultato;
    }

    public static double dividiIlRisultato(double b) {
        CalcolatriceStatica.risultato = CalcolatriceStatica.risultato / b;
        return risultato;
    }

}
