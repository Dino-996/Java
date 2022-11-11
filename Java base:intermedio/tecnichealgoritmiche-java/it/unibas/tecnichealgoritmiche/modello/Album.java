package it.unibas.tecnichealgoritmiche.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Album {
 
    private final List<Figurina> listaFigurine = new ArrayList<Figurina>();
    
    public void addFigurina(Figurina figurina) {
        this.listaFigurine.add(figurina);
    }
    
    public void setFigurina(int i, Figurina figurina) {
        this.listaFigurine.set(i, figurina);
    }

    public Figurina getFigurina(int i) {
        return this.listaFigurine.get(i);
    }

    public void removeFigurina(int i) {
        this.listaFigurine.remove(i);
    }

    public void removeFigurina(Figurina figurina) {
        this.listaFigurine.remove(figurina);
    }

    public int getNumeroFigurine() {
        return this.listaFigurine.size();
    }

    //Devo calcolare il costo totale delle figurine
    public double getCostoTotale() {
        double costoTotale = 0;
        for (Figurina figurina : this.listaFigurine) {
            costoTotale += figurina.getCosto();
        }
        return costoTotale;
    }

    //Devo contare quante figurine hanno un costo maggiore di quello dato
    public int getNumeroFigurineCostose(double sogliaPrezzo) {
        int numeroFigurine = 0;
        for (Figurina figurina : this.listaFigurine) {
            if (figurina.getCosto() > sogliaPrezzo) {
                numeroFigurine++;
            }
        }
        return numeroFigurine;
    }

    //Devo cercare la figurina con il costo maggiore (versione "procedurale")
    public Figurina cercaFigurinaMaxCostoProcedurale() {
        int posizioneMassimo = 0;
        for (int i = 1; i < this.listaFigurine.size(); i++) {
            Figurina figurina = this.listaFigurine.get(i);
            if (figurina.getCosto() > this.listaFigurine.get(posizioneMassimo).getCosto()) {
                posizioneMassimo = i;
            }
        }
        return this.listaFigurine.get(posizioneMassimo);
    }
    
    //Devo cercare la figurina con il costo maggiore (versione migliorata)
    //restituisce null nel caso in cui la collezione sia vuota
    public Figurina cercaFigurinaMaxCosto() {
        Figurina figurinaCostoMassimo = null;
        for (Figurina figurina : this.listaFigurine) {
             if (figurinaCostoMassimo == null || figurina.getCosto() > figurinaCostoMassimo.getCosto()){
                figurinaCostoMassimo = figurina;
            }
        }
        return figurinaCostoMassimo;
    }

    //Devo verificare se esiste almeno una figurina con valore zero
    public boolean verificaFigurinaSenzaValore(){
        for (Figurina figurina : this.listaFigurine) {
            if(figurina.getCosto() == 0){
                return true;
            }
        }
        return false;
    }

    //Devo cercare la figurina con un certo numero
    public Figurina cercaFigurinaPerNumero(int numero) {
        for (Figurina figurina : this.listaFigurine) {
            if (figurina.getNumero() == numero) {
                return figurina;
            }            
        }
        return null;
    }
    
    //Devo cercare tutte le figurine con una certa descrizione
    public List<Figurina> cercaFigurinePerDescrizione(String parolaChiave) {
        List<Figurina> risultato = new ArrayList<Figurina>();
        for (Figurina figurina : this.listaFigurine) {
            if (figurina.getDescrizione().contains(parolaChiave)) {
                risultato.add(figurina);
            }
        }
        return risultato;
    }
    
    //Devo verificare se ho delle figurine consecutive con lo stesso numero
    public boolean verificaFigurineConsecutiveUguali() {
        for (int i = 0; i < this.listaFigurine.size() - 1; i++) {
            Figurina figurina = this.listaFigurine.get(i);
            Figurina figurinaSuccessiva = this.listaFigurine.get(i + 1);
            if (figurina.getNumero() == figurinaSuccessiva.getNumero()) {
                return true;
            }
        }
        return false;
    }

    //Devo verificare se tutte le figurine hanno valore zero
    public boolean verificaTutteFigurineSenzaValore(){
        for (Figurina figurina : this.listaFigurine) {
            if(figurina.getCosto() > 0){
                return false;
            }
        }
        return true;
    }
    
    //Devo contare quante figurine ho con un dato numero
    public int getOccorrenzeFigurinaNumero(int numeroFigurina) {
        int occorrenze = 0;
        for (Figurina figurina : this.listaFigurine) {
            if (figurina.getNumero() == numeroFigurina) {
                occorrenze++;
            }
        }
        return occorrenze;
    }

    //Devo verificare se ci sono due figurine con lo stesso numero
    public boolean verificaFigurineDiverse() {
        for (Figurina figurina : this.listaFigurine) {
            if (this.getOccorrenzeFigurinaNumero(figurina.getNumero()) > 1) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("-------------  Album  -----------------\n");
        for (Figurina figurina : this.listaFigurine) {
            result.append(figurina).append("\n");
        }
        result.append("---------------------------------------\n");
        return result.toString(); 
    }

}
