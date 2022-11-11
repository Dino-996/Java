package Desktop.tabellina;

public class tabellina {

	public static void main (String[] args) {
	
		int matrice [][] = new int [10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
			matrice [i][j] = (i+1)*(j+1);
			}
		}
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.print(matrice [i][j] + " ");
				}
			}
		System.out.println();
	}
}