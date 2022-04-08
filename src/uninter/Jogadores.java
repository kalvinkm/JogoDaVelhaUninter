package uninter;

import java.util.Scanner;

// Classe que representa o Jogador (Usuário)
public class Jogadores {
	Tabuleiro tab = new Tabuleiro();
	Scanner scan = new Scanner(System.in);
	
	int valor;
	
	public int Jogador() { // Método que aplica a jogada do usuário
		System.out.print("Infome a posição (1 - 9): ");
		valor = scan.nextInt();
		
		return valor;
	}	
}
