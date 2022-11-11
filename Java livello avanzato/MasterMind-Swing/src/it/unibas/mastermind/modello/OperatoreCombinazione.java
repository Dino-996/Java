package it.unibas.mastermind.modello;
//Classe che fa solo operazioni(solo logica applicativa)
//Non ha ne proprietà ne metodi statici

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OperatoreCombinazione {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(OperatoreCombinazione.class);
    
    //Genero un oggetto random (Genera nuove combinazioni ogni volta)
    private static final Random random = new Random();
    
    public Combinazione generaCombinazione() {
        Combinazione combinazione = new Combinazione();
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            // + 1 perché voglio far partire da 1
            int cifraCasuale = random.nextInt(Costanti.CIFRA_MASSIMA) + 1;
            while(ContaOccorrenze(cifraCasuale, combinazione) > 0) {
                cifraCasuale = random.nextInt(Costanti.CIFRA_MASSIMA) + 1;
            }
            combinazione.setCifraInPosizione(cifraCasuale, i);
        }
        logger.debug("Generata la " + combinazione);
        return combinazione;
    }
    
    public int ContaOccorrenze(int cifra, Combinazione combinazione) {
        int conta = 0;
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (combinazione.getCifraInPosizione(i) == cifra) {
                conta++;
            }
        }
        return conta;
    }   
    
    //Per essere corrette devono essere tutte corrette tra di loro e maggiori di 0
    public boolean verificaCorrettezzaDiCombinazione(Combinazione combinazione) {
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            int cifra = combinazione.getCifraInPosizione(i);
            if (ContaOccorrenze(cifra, combinazione) > 1) {
               return false;
            }
            if (cifra < 1 || cifra > Costanti.CIFRA_MASSIMA) {
                return false;
            }
        }
        return true;
    }
    
    //Mi serve per produrre la risposta
    //Input --> Combinazione pensata, combinazione tentativo
    public Risposta valutaTentativo(Combinazione combinazioneNascosta, Combinazione combinazioneTentativo) {
        logger.debug("Valuto la combinazione {} rispetto al tentativo {}", combinazioneNascosta, combinazioneTentativo);
        int palliniNeri = calcolaPalliniNeri(combinazioneNascosta, combinazioneTentativo);
        int palliniBianchi = calcolaPalliniBianchi(combinazioneNascosta, combinazioneTentativo);
        logger.debug("Risultato - Neri {} - Bianchi {}", palliniNeri, palliniBianchi);
        return new Risposta(combinazioneTentativo, palliniNeri, palliniBianchi);
    }
    
    //Metodi per calcolare i palliniNeri e i palliniBianchi
    private int calcolaPalliniNeri(Combinazione combinazioneNascosta, Combinazione combinazioneTentativo) {
        int somma = 0;
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if(combinazioneNascosta.getCifraInPosizione(i) == combinazioneTentativo.getCifraInPosizione(i)) {
                logger.debug("Trovato pallino nero in posizione {}", i);
                somma++;
            }
        }
        return somma;
    }
    
    private int calcolaPalliniBianchi(Combinazione combinazioneNascosta, Combinazione combinazioneTentativo) {
        int somma = 0;
        for(int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (combinazioneNascosta.getCifraInPosizione(i) != combinazioneTentativo.getCifraInPosizione(i)) {
                if (ContaOccorrenze(combinazioneTentativo.getCifraInPosizione(i), combinazioneNascosta) > 0) {
                    logger.debug("Trovato pallino bianco in posizione {}", i);
                    somma++;
                }
            }
        }
        return somma;
    }
}
