package it.unibas.indovinailnumero.modello;

import java.util.Random;

public class Partita {
    
    private static final Random GENERATORE = new Random();

    private String nome;
    private final int numeroDaIndovinare;
    private int numeroDiTentativi;
    private boolean trovato;
    private String suggerimento;

    public Partita() {
        this.numeroDaIndovinare = Partita.GENERATORE.nextInt(100) + 1;
        this.trovato = false;
        this.numeroDiTentativi = 0;
        this.suggerimento = "Ho scelto un numero tra 1 e 100. Prova a indovinarlo.";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void gestisciTentativo(int tentativo) {
        this.numeroDiTentativi++;
        if (tentativo == this.numeroDaIndovinare) {
            this.trovato = true;
            this.suggerimento = "Numero indovinato";
        } else if (tentativo < numeroDaIndovinare) {
            this.suggerimento = "Prova con un numero piu' alto";
        } else if (tentativo > numeroDaIndovinare) {
            this.suggerimento = "Prova con un numero piu' basso";
        }
    }

    public boolean getTrovato() {
        return this.trovato;
    }

    public String getSuggerimento() {
        return this.suggerimento;
    }

    public int getNumeroDiTentativi() {
        return this.numeroDiTentativi;
    }

    public int getNumeroDaIndovinare() {
        return this.numeroDaIndovinare;
    }

    public String getNome() {
        return this.nome;
    }

}

