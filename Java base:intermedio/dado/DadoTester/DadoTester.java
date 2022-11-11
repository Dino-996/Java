package dado;

public class DadoTester {
	public static void main (String [] args) {
		//Si crea un oggetto di tipo dado standard
		Dado d6 = new Dado();
		//Si crea un oggetto di tipo dado con parametro predefinito
		Dado d20 = new Dado(20);
		//Si lancia il dado standard(d6) e si stampa il risultato
		int risultato1 = d6.lancia();
		System.out.println("Lancio del d6 usando lancia(): " + risultato1);
		//Si lancia il dado con parametro(d20) e si stampa il risultato
		int risultato2 = d20.lancia2();
		System.out.println("Lancio del d20 usando lancia2(): " + risultato2);
		//Si modifica il parametro
		d20.setFacce(100);
		//Si lancia il dado con parametro modificato e si stampa il risultato
		int risultato3 = d20.lancia2();
		System.out.println("Lancio d20 modificato: " + risultato3);
	}
}