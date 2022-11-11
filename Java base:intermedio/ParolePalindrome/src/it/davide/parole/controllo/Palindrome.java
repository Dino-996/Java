package it.davide.parole.controllo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Palindrome {
    
    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        p.esegui();
    }

    private void esegui() {
        SimpleDateFormat oraFormattata = new SimpleDateFormat("HH:mm");
        Date oraCorrente = new Date();
        String oraMinuti = oraFormattata.format(oraCorrente);
        DateFormat dataFormattata = DateFormat.getDateInstance(DateFormat.FULL);
        Calendar dataOggi =  Calendar.getInstance();
        String data = dataFormattata.format(dataOggi.getTime());
        String letteraGrande = data.substring(0, 1).toUpperCase();
        System.out.println("INFORMAZIONE DI SISTEMA - " + letteraGrande+data.substring(1) + oraMinuti);
        while (true) {
            int scelta = schermoMenu();
            if (scelta == 0) {
                return; //break oppure System.exit(0);
            }
            if (scelta == 1) {
                boolean isPalindroma = isPalindroma("Inserisci una parola: ");
                if (isPalindroma) {
                    System.out.println("La parola inserita e' palindroma");
                } else {
                    System.out.println("La parola inserita NON e' palindroma");
                }
            }
        }
    }

    private int schermoMenu() {
        System.out.println("Premi 1 per continuare");
        System.out.println("Premi 0 per uscire");
        return convalidaIntero(0, 1, "Scelta: ");
    }

    private int convalidaIntero(int min, int max, String stringa) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(stringa);
        int numero = scanner.nextInt();
        while (numero < min || numero > max) {
            System.out.println("Errore! Riprova!");
            System.out.print(stringa);
            numero = scanner.nextInt();
        }
        return numero;
    }

    private boolean isPalindroma(String stringa) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(stringa);
        String parolaInversa = "";
        String parola = scanner.nextLine();
        int lunghezzaStringa = parola.length();
        boolean verifica = false;
        for (int i = (lunghezzaStringa - 1); i >= 0; i--) {
            parolaInversa = parolaInversa + parola.charAt(i);
            if (parolaInversa.equalsIgnoreCase(parola)) {
                verifica = true;
            }
        }
        return verifica;
    }
}
