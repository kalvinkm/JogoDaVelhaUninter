package uninter;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		iniciar(teclado); // Chamada de m?todo que inicia a aplica??o
	}	
	//-----------------------------------------------------------------------------
	public static void iniciar(Scanner teclado) { // M?todo que inicia a aplica??o
		// Classes inst?nciadas
		Tabuleiro tab = new Tabuleiro();
		Jogadores jog = new Jogadores();
		Computador comp = new Computador();
		
		// Vari?veis usadas
		int movimentoValido = 0, rodada = 0, valorJogador, valorCPU;
		String posicao;
		
		// Op??o de escolha de dificuldade
		System.out.print("Escolha uma op??o (1, 2, 3): "); 
		int nivel = teclado.nextInt();
		
		// Verifica??o de escolha
		if(nivel < 1 || nivel > 3) { //--- Condi??o caso a escoha seja inv?lida
			System.out.println("Op??o Inv?lida, tente novamente");
			System.out.print("Escolha uma op??o (1, 2, 3): ");
			iniciar(teclado); // Chamando o m?todo iniciar novamente
		} else if(nivel == 1) { //---------Escolha do Nivel 01
			System.out.println("N?vel 1");
			System.out.println(":::#Jogo da Velha#:::");
			tab.mostraTabuleiro(); // M?todo para imprimir o tabuleiro
			// La?o de repeti??o que controlar? o numero de jogadas
			while(true) {
				do { // Inicio da jogada do Usu?rio---------------------------------------------
					jog.Jogador(); // Chamada do M?todo que retorna o valor da jogada
					valorJogador = jog.valor; // Vari?vel que recebe o valor da jogada
					posicao = Integer.toString(valorJogador); // Convers?o de inteiro para String
					while(!tab.jogadaValida(posicao)) { // La?o de repeti?ao condicional para validar jogada 
						System.out.println("Jogada Inv?lida, tente novamente! Informe uma posi??o (1 - 9): ");
						jog.Jogador(); // Chamada de m?todo novamente
						valorJogador = jog.valor;
						posicao = Integer.toString(valorJogador);
						movimentoValido = 0; // Vari?vel contadora de movimentos v?lidos
					}
					tab.jogada(posicao, "X"); // Imprimindo a posi?ao escolhida no tabuleiro
					movimentoValido = 1; // Validando o movimento
				}while(movimentoValido == 0); // Condi??o do la?o de repeti??o
				rodada++; // Contador de cada rodada
				movimentoValido = 0; // Zera o contador de jogada valida novamente
				limparTela(); // M?todo que limpa a tela
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro(); // M?todo para imprimir o tabuleiro novamente
				if(!tab.Ganhou(rodada).equals("null")) { // Condi??o caso o jogador ganhe o jogo
					break; // A Aplica??o ? parada
				}
				
				do { // Escolha do Nivel 01
					  comp.CompA(); // Chamada de M?todo referente ao computador nivel 01
					  valorCPU = jog.valor; // Vari?vel que recebe o valor da jogada
					  if(valorCPU == valorJogador) { // Compara??o de jogadas
						  if(valorCPU == 9) { // Condi??o caso o valor seja igual a 9
							  valorCPU = valorCPU - 8;
						  } else {
							  valorCPU = valorCPU + 1;
						  }
					  } else {
						  posicao = Integer.toString(valorCPU); // Conversao de valores inteiros para String
					  }
					  while(!tab.jogadaValida(posicao)) {
						  	comp.CompA();
						  	if(valorCPU == 9) {
								 valorCPU = valorCPU - 8;
							} else {
								 valorCPU = valorCPU + 1;
							}
						  	posicao = Integer.toString(valorCPU);
							movimentoValido = 0;
					 }
					  tab.jogada(posicao, "O");
					  movimentoValido = 1;
				}while(movimentoValido == 0);
				rodada++;
				movimentoValido = 0;
				limparTela();
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro();
				if(!tab.Ganhou(rodada).equals("null")) {
					break; 
				}
			}
			if(rodada == 9) { // Condi?ao caso d? empate
				System.out.println("EMPATE!");
			} else { // Mostra o vencedor
				System.out.println("O " + tab.Ganhou(rodada) + " venceu!"); // Ap?s sair do la?o informa o ganhador
			}
		}else if(nivel == 2) { //------Escolha da op??o 02
			System.out.println("N?vel 2");
			System.out.println(":::#Jogo da Velha#:::");
			tab.mostraTabuleiro();
			while(true) {
				do {
					jog.Jogador();
					valorJogador = jog.valor;
					posicao = Integer.toString(valorJogador);
					while(!tab.jogadaValida(posicao)) {
						System.out.println("Jogada Inv?lida, tente novamente! Informe uma posi??o (1 - 9): ");
						jog.Jogador();
						valorJogador = jog.valor;
						posicao = Integer.toString(valorJogador);
						movimentoValido = 0;
					}
					tab.jogada(posicao, "X");
					movimentoValido = 1;
				}while(movimentoValido == 0);
				rodada++; // Contador de cada rodada
				movimentoValido = 0; // Zera o contador de jogada valida novamente
				limparTela(); // M?todo que limpa a tela
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro(); // M?todo para imprimir o tabuleiro novamente
				if(!tab.Ganhou(rodada).equals("null")) { // Condi??o caso o jogador ganhe o jogo
					break; // A Aplica??o ? parada
				}
				
				do { // Escolha do Nivel 02
					  comp.CompB(); // Chamada de m?todo de nivel 02
					  valorCPU = jog.valor;
					  if(valorCPU == valorJogador) {
						  if(valorCPU == 9) {
							  valorCPU = valorCPU - 8;
						  } else {
							  valorCPU = valorCPU + 1;
						  }
					  } else {
						  posicao = Integer.toString(valorCPU);
					  }
					  while(!tab.jogadaValida(posicao)) {
						  	comp.CompB();
						  	if(valorCPU == 9) {
								 valorCPU = valorCPU - 8;
							} else {
								 valorCPU = valorCPU + 1;
							}
						  	posicao = Integer.toString(valorCPU);
							movimentoValido = 0;
					 }
					  tab.jogada(posicao, "O");
					  movimentoValido = 1;
				}while(movimentoValido == 0);
				rodada++;
				movimentoValido = 0;
				limparTela();
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro();
				if(!tab.Ganhou(rodada).equals("null")) {
					break; 
				}
			}
			if(rodada == 9) { // Condi?ao caso d? empate
				System.out.println("EMPATE!");
			} else { // Mostra o vencedor
				System.out.println("O " + tab.Ganhou(rodada) + " venceu!"); // Ap?s sair do la?o informa o ganhador
			}
		} else if(nivel == 3) { // Escolha do n?vel 03
			System.out.println("N?vel 3");
			System.out.println(":::#Jogo da Velha#:::");
			tab.mostraTabuleiro();
			while(true) {
				do {
					jog.Jogador();
					valorJogador = jog.valor;
					posicao = Integer.toString(valorJogador);
					while(!tab.jogadaValida(posicao)) {
						System.out.println("Jogada Inv?lida, tente novamente! Informe uma posi??o (1 - 9): ");
						jog.Jogador();
						valorJogador = jog.valor;
						posicao = Integer.toString(valorJogador);
						movimentoValido = 0;
					}
					tab.jogada(posicao, "X");
					movimentoValido = 1;
				}while(movimentoValido == 0);
				rodada++; // Contador de cada rodada
				movimentoValido = 0; // Zera o contador de jogada valida novamente
				limparTela(); // M?todo que limpa a tela
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro(); // M?todo para imprimir o tabuleiro novamente
				if(!tab.Ganhou(rodada).equals("null")) { // Condi??o caso o jogador ganhe o jogo
					break; // A Aplica??o ? parada
				}
				
				do { // Escolha do Nivel 03
					  comp.CompC(); // Chamada de m?todo de nivel 03
					  valorCPU = jog.valor;
					  if(valorCPU == valorJogador) {
						  if(valorCPU == 9) {
							  valorCPU = valorCPU - 8;
						  } else {
							  valorCPU = valorCPU + 1;
						  }
					  } else {
						  posicao = Integer.toString(valorCPU);
					  }
					  while(!tab.jogadaValida(posicao)) {
						  	comp.CompC();
						  	if(valorCPU == 9) {
								 valorCPU = valorCPU - 8;
							} else {
								 valorCPU = valorCPU + 1;
							}
						  	posicao = Integer.toString(valorCPU);
							movimentoValido = 0;
					 }
					  tab.jogada(posicao, "O");
					  movimentoValido = 1;
				}while(movimentoValido == 0);
				rodada++;
				movimentoValido = 0;
				limparTela();
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro();
				if(!tab.Ganhou(rodada).equals("null")) {
					break; 
				}
			}
			if(rodada == 9) { //Verificar o numero de jogadas
				System.out.println("EMPATE!");
			} else {
				System.out.println("O " + tab.Ganhou(rodada) + " venceu!"); // Ap?s sair do la?o informa o ganhador
			}
		}
		
	}//-------------------------------------------------------------------------------------------
	
	// M?todo para limpar a tela
	public static void limparTela() {
		for(int cont=0; cont < 10; cont++) {
			System.out.println("");
		}
	}
}
