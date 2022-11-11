//Classe Tutorial, sempre lettera maiuscola (in Java tutti i metodi appartengono alla classe Tutorial (funzioni e procedure in c++))
//Classe = Definisce come saranno gli oggetti, stapa gli oggetti, contiene metodi (funzioni)
public class Tutorial {
	//metodo saluta (sottoprogramma (procedura in C++))
	//public: accessibile ad altre classi 
	//static: il metodo appartiene alla classe
	public static void saluta() {
		System.out.println("We tutt a post?");
		System.out.println("Statt buon!");
	}
	//metodo privato (sottoprogramma, procedura in c++)
	//private = accessibile solamente alla classe Tutorial
	private void privato () {
		int numero;
		numero = 5;
		System.out.println(numero);
	}
	//metodo principale che parte all'avvio (funzione principale in C++)
	//public = accessibile ad altre classi
	//static = il metodo appartiene alla classe
	public static void main (String[] args) {
		saluta();
		privato();
	}
}
