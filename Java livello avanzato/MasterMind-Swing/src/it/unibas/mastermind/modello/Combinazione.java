package it.unibas.mastermind.modello;

public class Combinazione {
    //Array di interi dinamico
    private int [] cifre = new int[Costanti.CIFRE_COMBINAZIONE];
    
    //Costruttore senza argomenti
    public Combinazione() {}
    
    //Costruttore con argomenti per i test
    public Combinazione(int c1, int c2, int c3, int c4) {
        setCifraInPosizione(c1, 0);
        setCifraInPosizione(c2, 1);
        setCifraInPosizione(c3, 2);
        setCifraInPosizione(c4, 3);
    }
    
    //Get e set di utilità(non dell'array)
    public int getCifraInPosizione(int posizione) {
        if (posizione < 0 || posizione >= Costanti.CIFRE_COMBINAZIONE) {
            throw new IllegalArgumentException("Posizione scorretta");
        }
        return cifre[posizione];
    }
    
    public void setCifraInPosizione(int cifra, int posizione) {
        if (posizione < 0 || posizione >= Costanti.CIFRE_COMBINAZIONE) {
            int risultato = cifre[posizione] = cifra;
            throw new IllegalArgumentException("Posizione scorretta: " + risultato);
        }
        if (cifra < 1 || cifra > Costanti.CIFRA_MASSIMA) {
            int risultato = cifre[posizione] = cifra;
            throw new IllegalArgumentException("Cifra scorretta: " + risultato);
        }
        cifre[posizione] = cifra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Combinazione: ");
        for (int i = 0; i < cifre.length; i++) {
            sb.append(cifre[i]);
        }
        return sb.toString();
    } 
}
