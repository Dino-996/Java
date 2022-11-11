package circonferenze;

public class Comparatore {

    //public Comparatore() {}
    
    public int posizioneMassimaCirconferenza(Circonferenza[] collezione) {
        int posizioneMassimo = 0;
        for (int i = 1; i < collezione.length; i++) {
            if (collezione[posizioneMassimo].getLunghezzaCirconferenza() <
                    collezione[i].getLunghezzaCirconferenza()) {
                posizioneMassimo = i;
            }
        }
        return posizioneMassimo;
    }
    
}
