package circonferenze;

public class Principale {
    
    public void esegui() {
        int numeroCirconferenze = this.schermoLeggiNumeroCirconferenze();
        if (numeroCirconferenze > 0) {
            Circonferenza[] collezione = new Circonferenza[numeroCirconferenze];
            for (int i = 0; i < collezione.length; i++) {
                collezione[i] = this.schermoLeggiDatiCirconferenza();
            }
            for (int i = 0; i < collezione.length; i++) {
                this.schermoStampaDatiCirconferenza(collezione[i]);
            }
            Comparatore comparatore = new Comparatore();
            System.out.println("\nLa circonferenza di lunghezza massima e' in posizione: " +
                    comparatore.posizioneMassimaCirconferenza(collezione));
        }
        System.out.println("\nArrivederci.");
    }
    
    private int schermoLeggiNumeroCirconferenze() {
        System.out.println("------------------------------------");
        System.out.println("   Analisi circonferenze");
        System.out.println("------------------------------------\n");
        System.out.println("Quante circonferenze vuoi analizzare ?");
        System.out.print("---> ");
        int numeroCirconferenze = it.unibas.utilita.Console.leggiIntero();
        while (numeroCirconferenze < 0) {
            System.out.println("Errore. Numero scorretto.");
            System.out.print("Ripeti. ---> ");
            numeroCirconferenze = it.unibas.utilita.Console.leggiIntero();
        }
        return numeroCirconferenze;
    }
    
    private Circonferenza schermoLeggiDatiCirconferenza() {
        System.out.println("\nImmetti i dati della circonferenza:");
        System.out.print("Ascissa del centro: --> ");
        double ascissaCentro = it.unibas.utilita.Console.leggiDouble();
        System.out.print("Ordinata del centro: --> ");
        double ordinataCentro = it.unibas.utilita.Console.leggiDouble();
        System.out.print("Lunghezza del raggio: --> ");
        double raggio = it.unibas.utilita.Console.leggiDouble();
        while (raggio <= 0) {
            System.out.println("Errore. Numero scorretto.");
            System.out.print("Ripeti. ---> ");
            raggio = it.unibas.utilita.Console.leggiDouble();
        }
        Circonferenza circonferenza = new Circonferenza(ascissaCentro, ordinataCentro, raggio);
        return circonferenza;
    }
    
    private void schermoStampaDatiCirconferenza(Circonferenza circonferenza) {
        System.out.println("\nDati della circonferenza:");
        System.out.println("Ascissa del centro: " + circonferenza.getAscissaCentro());
        System.out.println("Ordinata del centro: " + circonferenza.getOrdinataCentro());
        System.out.println("Lunghezza del raggio: " + circonferenza.getRaggio());
        System.out.println("Lunghezza circonferenza: " + circonferenza.getLunghezzaCirconferenza());
        System.out.println("Superficie cerchio: " + circonferenza.getSuperficieCerchio());
    }
    
    public static void main(String args[]) {
        //Principale principale = new Principale();
        //principale.esegui();
        new Principale().esegui();
    }
    
}
