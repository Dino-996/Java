#import <iostream>
using namespace std;

const string ESTENSIONE_JPG = ".jpg";
const string ESTENSIONE_PNG = ".png";
const string ESTENSIONE_PDF = ".pdf";
const int MAX_DIM = 100;

void schermoMenu(int &scelta);
void leggiIntero(int min, int max, int &valore, string stampa);
void schermoLeggiDati(lista listaImmagini);

struct lista {

int indicatore;
int array[MAX_DIM];

};

int main () {
	int scelta = 0;
	lista listaImmagini;
	listaImmagini.indicatore = 0;
	while(true) {
		schermoMenu(scelta);
		if (scelta == 0) {
			break;
		}
		if (scelta == 1) {
			schermoLeggiDati(listaImmagini);
		}
		if (scelta == 2) {

		}
		if (scelta == 3) {

		}
	}

	return 0;
}

void schermoMenu(int &scelta) {
	cout << "\n";
	cout << "---------------------------------------" << endl;
	cout << "        COLLEZIONE DI IMMAGINI         " << endl;
	cout << "---------------------------------------" << endl;
	cout << " 1. Inserisci i valori della collezione" << endl;
	cout << " 2. Stampa i valori della collezione   " << endl;
	cout << " 3. Cerca immagini superiori a 200KB   " << endl;
	cout << "---------------------------------------" << endl;
	cout << " 0. Esci                               " << endl;
	cout << "---------------------------------------" << endl;
	cout << "\n";
	leggiIntero(0, 3, scelta, "Scelta--> ");
}

void leggiIntero(int min, int max, int &valore, string stampa) {
	cout << stampa;
	cin >> valore;
	while(valore < min || valore > max) {
		cout << "ERRORE: Immetti un numero compreso tra: " << min << " e " << max << endl;
		cout << stampa;
		cin >> valore;
	}
	return;
}

void schermoLeggiDati(lista listaImmagini) {
	int valore;
	cout << "Quante immagini vuoi inserire?\nScelta--> ";
	cin >> listaImmagini.indicatore;
	for(int i = 0; i < listaImmagini.indicatore; i++) {
		valore = listaImmagini.array[i];
	}
	cout << valore;

}












