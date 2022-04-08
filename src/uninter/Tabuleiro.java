package uninter;


// Classe que representa o tabuleiro do jogo
public class Tabuleiro {
	
	// Tabuleiro montado
	private String[][] tabuleiro = {{"1", "2", "3"},
									{"4", "5", "6"},
									{"7", "8", "9"}};
	


	
	public String mostraTabuleiro() { // Método para imprimir o tabuleiro
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				System.out.printf(" |_" + tabuleiro[linha][coluna] + "_| "); 
			}
			System.out.printf("\n");
		}
		return null;
	} //----------------------------------------------------------------------------
	
	public boolean jogadaValida(String posicao) { // Método validador de jogada
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				if(tabuleiro[linha][coluna].equals(posicao)) {
					return true;
				}
			}
		}
		return false;
	} //------------------------------------------------------------------------------
	
	public void jogada(String posicao, String jogador) { // Método de inserção da jogada no tabuleiro
		if(posicao.equals("1")) {
			tabuleiro[0][0] = jogador;
		} else if(posicao.equals("2")) {
			tabuleiro[0][1] = jogador;
		} else if(posicao.equals("3")) {
			tabuleiro[0][2] = jogador;
		} else if(posicao.equals("4")) {
			tabuleiro[1][0] = jogador;
		} else if(posicao.equals("5")) {
			tabuleiro[1][1] = jogador;
		} else if(posicao.equals("6")) {
			tabuleiro[1][2] = jogador;
		} else if(posicao.equals("7")) {
			tabuleiro[2][0] = jogador;
		} else if(posicao.equals("8")) {
			tabuleiro[2][1] = jogador;
		} else if(posicao.equals("9")) {
			tabuleiro[2][2] = jogador;
		}
	}
	
	public String Ganhou(int jogadas) { // Método que mostra o ganhador
		String[] possibilidades = new String[8];
		String vencedor = "null";
		if(jogadas == 9) { // Condição em caso de empate
			vencedor = "EMPATE";
		}
		
		// Possibilidades de jogadas para chegar a vitória do jogo
		possibilidades[0] = tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2];
		possibilidades[1] = tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2];
		possibilidades[2] = tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2];
		
		possibilidades[3] = tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0];
		possibilidades[4] = tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1];
		possibilidades[5] = tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2];
		
		possibilidades[6] = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
		possibilidades[7] = tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0];
		
		for(int i = 0; i < possibilidades.length; i++) {
			if(possibilidades[i].equals("XXX")) { // Condição que representa o simbolo do usuário
				vencedor = "Jogador 1";
			} else if(possibilidades[i].equals("OOO")) { // Condição que representa o simbolo do computador
				vencedor = "Jogador 2";
			}
		}
		return vencedor;
	}
}
