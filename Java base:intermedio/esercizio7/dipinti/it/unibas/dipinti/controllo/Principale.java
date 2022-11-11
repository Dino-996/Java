package it.unibas.dipinti.controllo;
import it.unibas.dipinti.modello.*;
import it.unibas.utilita.*;

public class Principale {
	public static void main(String[] args) {
		Principale principale = new Principale();
		principale.esegui();
	}

	private void esegui() {
		Collezione collezione = new Collezione();
		collezione = caricaMock();
		while(true) {
			int scelta = leggiInteroLimitato();
			if (scelta == 0) {
				
			}
			if (scelta == 1) {
				
			}
			if (scelta == 2) {
				
			}
			if (scelta == 3) {
				
			}
			if (scelta == 4) {
				
			}
		}
	}

	private Collezione caricaMock() {
		Collezione collezione = new Collezione();
		
		Dipinti dipinti1 = new Dipinti("Michelangelo", 1867);
		Dipinti dipinti2 = new Dipinti("Donatello", 1900);
		Dipinti dipinti3 = new Dipinti("Leonardo", 1843);
		Dipinti dipinti4 = new Dipinti("Giovannini", 1789);
		Dipinti dipinti5 = new Dipinti("Botticelli", 1952);

		collezione.addDipinto(dipinti1);
		collezione.addDipinto(dipinti2);
		collezione.addDipinto(dipinti3);
		collezione.addDipinto(dipinti4);
		collezione.addDipinto(dipinti5);

		return collezione;
	}
}