package segmenti;

public class Principale {
    
    public void esegui() {
        // fase a: creazione dei vertici
        System.out.println("Immetti le coordinate del primo vertice");
        Punto primoVertice = schermoLeggiDatiPunto();
        System.out.println();
        System.out.println("Immetti le coordinate del secondo vertice");
        Punto secondoVertice = schermoLeggiDatiPunto();
        // fase b: creazione del segmento
        Segmento segmento = new Segmento();
        segmento.setPrimoVertice(primoVertice);
        segmento.setSecondoVertice(secondoVertice);
        // fase c: elaborazione
        schermoStampaDatiSegmento(segmento);
        System.out.println("\nArrivederci.");
    }
    
    private Punto schermoLeggiDatiPunto() {
        System.out.print("Ascissa   : --> ");
        double ascissa = it.unibas.utilita.Console.leggiDouble();
        System.out.print("Ordinata  : --> ");
        double ordinata = it.unibas.utilita.Console.leggiDouble();
        Punto punto = new Punto();
        punto.setAscissa(ascissa);
        punto.setOrdinata(ordinata);
        return punto;
    }
    
    private void schermoStampaDatiSegmento(Segmento segmento) {
        System.out.println("\nDati del segmento:");
        System.out.println("----------------------");
        String stringaPrimoVertice = segmento.getPrimoVertice().toString();
        String stringaSecondoVertice = segmento.getSecondoVertice().toString();
        System.out.println("Primo vertice   : " + stringaPrimoVertice);
        System.out.println("Secondo vertice : " + stringaSecondoVertice);
        System.out.println("Quadrante del primo vertice   : " + segmento.getPrimoVertice().getQuadrante());
        System.out.println("Quadrante del secondo vertice : " + segmento.getSecondoVertice().getQuadrante());
        System.out.println("Lunghezza del segmento: " + segmento.getLunghezza());
    }
    
    public static void main(String[] args) {
        Principale principale = new Principale();
        principale.esegui();
    }
    
}
