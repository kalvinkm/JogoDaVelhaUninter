package uninter;

import java.util.Scanner;

// Classe que representa o Jogador (Usu?rio)
public class Jogadores {
	Tabuleiro tab = new Tabuleiro();
	Scanner scan = new Scanner(System.in);
	
	int valor;
	
	public int Jogador() { // M?todo que aplica a jogada do usu?rio
		System.out.print("Infome a posi??o (1 - 9): ");
		valor = scan.nextInt();
		
		return valor;
	}	
}
