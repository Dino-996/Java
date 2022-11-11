package dado;

import java.util.Random;
import java.lang.Math;

public class Dado {
 private int numeroFacce;
 private Random gen;
 /*Costruttore che crea un dado standard a 6 facce e inizializza l'oggetto gen*/
 public Dado () {
 	numeroFacce = 6;
 	gen = new Random();
 }
 /*Costruttore che crea un dado con un numero dato di facce e inizializza l'oggetto gen.
 @param numFacce Il numero di facce che avrà il Dado*/
 public Dado (int numFacce) {
 	numeroFacce = numFacce;
 	gen = new Random();
 }
 /*Metodo che cambia il numero di facce del dado.
 @param nuovoVal Il nuovo numero di facce del dado*/
 public void setFacce(int nuovoVal) {
 	numeroFacce = nuovoVal;
 }
 /*Metodo che simula il lancio del dado.
 @return Il risultato del lancio.*/
 public int lancia () {
 	int result = gen.nextInt (numeroFacce) + 1;
 	return result;
 }
 /*Metodo che simula il lancio del dado senza utilizzare l'oggetto di tipo Random ma utilizzando la classe Math.
 @return Il risultato del lancio. */
 public int lancia2 () {
 	return ((int)(Math.random() * numeroFacce)) + 1;
 }
}