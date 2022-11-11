package it.unibas.mediapesata.modello;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Studente {
    
    private String nome;
    private String cognome;
    private int matricola;
    private ArrayList listaEsami = new ArrayList();
    //private LinkedList listaEsami = new LinkedList();
    // con i generici
    //private List<Esame> listaEsami = new ArrayList<Esame>();
    //private List<Esame> listaEsami = new LinkedList<Esame>();
    
    public Studente() {}
    
    public Studente (String nome, String cognome, int matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        System.out.println("*******  Sto usando ArrayList");
    }
    
    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public int getMatricola() {
        return this.matricola;
    }

    @SuppressWarnings("unchecked")
    public void addEsame(String insegnamento, int voto, boolean lode, int crediti) {
        Esame esame = new Esame(insegnamento, voto, lode, crediti);
        this.listaEsami.add(esame);
    }

    @SuppressWarnings("unchecked")
    public void addEsame(Esame esame) {
        this.listaEsami.add(esame);
    }

    @SuppressWarnings("unchecked")
    public Esame getEsame(int i) {
        return (Esame)this.listaEsami.get(i);
    }

    public int getNumeroEsami() {
        return this.listaEsami.size();
    }

    @SuppressWarnings("unchecked")
    public double getMediaPesata() {
        int sommaVotiPesati = 0;
        int sommaCrediti = 0;
        for (int i = 0; i < listaEsami.size(); i++) {
        //for (Esame esame : this.listaEsami) {
            Esame esame = (Esame)this.listaEsami.get(i);
            sommaVotiPesati += esame.getVoto() * esame.getCrediti();
            sommaCrediti += esame.getCrediti();
        }
        return ((double)sommaVotiPesati)/sommaCrediti;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Cognome: ").append(getCognome()).append(" - Nome: ").append(getNome()).append(" - Matricola: ").append(getMatricola());
        return result.toString();
    }
    
}


