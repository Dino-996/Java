package provamain;

public class Prova {
//La prova va fatta in fase di compilazione
	public static void main (String[] args) {
		//Se gli argomenti del mio arrey (args) sono uguali a 0 allora stampa "Nessun Argomento"
		if (args.length == 0) {
			System.out.println("Nessun Argomento");
			//Oppure itera gli argomenti e fino a quando i è minore dei miei argomenti stampa gli argomenti
		} else {
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i] + " ");
			}
		}
	}
}