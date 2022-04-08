package uninter;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		iniciar(teclado); // Chamada de método que inicia a aplicação
	}	
	//-----------------------------------------------------------------------------
	public static void iniciar(Scanner teclado) { // Método que inicia a aplicação
		// Classes instânciadas
		Tabuleiro tab = new Tabuleiro();
		Jogadores jog = new Jogadores();
		Computador comp = new Computador();
		
		// Variáveis usadas
		int movimentoValido = 0, rodada = 0, valorJogador, valorCPU;
		String posicao;
		
		// Opção de escolha de dificuldade
		System.out.print("Escolha uma opção (1, 2, 3): "); 
		int nivel = teclado.nextInt();
		
		// Verificação de escolha
		if(nivel < 1 || nivel > 3) { //--- Condição caso a escoha seja inválida
			System.out.println("Opção Inválida, tente novamente");
			System.out.print("Escolha uma opção (1, 2, 3): ");
			iniciar(teclado); // Chamando o método iniciar novamente
		} else if(nivel == 1) { //---------Escolha do Nivel 01
			System.out.println("Nível 1");
			System.out.println(":::#Jogo da Velha#:::");
			tab.mostraTabuleiro(); // Método para imprimir o tabuleiro
			// Laço de repetição que controlará o numero de jogadas
			while(true) {
				do { // Inicio da jogada do Usuário---------------------------------------------
					jog.Jogador(); // Chamada do Método que retorna o valor da jogada
					valorJogador = jog.valor; // Variável que recebe o valor da jogada
					posicao = Integer.toString(valorJogador); // Conversão de inteiro para String
					while(!tab.jogadaValida(posicao)) { // Laço de repetiçao condicional para validar jogada 
						System.out.println("Jogada Inválida, tente novamente! Informe uma posição (1 - 9): ");
						jog.Jogador(); // Chamada de método novamente
						valorJogador = jog.valor;
						posicao = Integer.toString(valorJogador);
						movimentoValido = 0; // Variável contadora de movimentos válidos
					}
					tab.jogada(posicao, "X"); // Imprimindo a posiçao escolhida no tabuleiro
					movimentoValido = 1; // Validando o movimento
				}while(movimentoValido == 0); // Condição do laço de repetição
				rodada++; // Contador de cada rodada
				movimentoValido = 0; // Zera o contador de jogada valida novamente
				limparTela(); // Método que limpa a tela
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro(); // Método para imprimir o tabuleiro novamente
				if(!tab.Ganhou(rodada).equals("null")) { // Condição caso o jogador ganhe o jogo
					break; // A Aplicação é parada
				}
				
				do { // Escolha do Nivel 01
					  comp.CompA(); // Chamada de Método referente ao computador nivel 01
					  valorCPU = jog.valor; // Variável que recebe o valor da jogada
					  if(valorCPU == valorJogador) { // Comparação de jogadas
						  if(valorCPU == 9) { // Condição caso o valor seja igual a 9
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
			if(rodada == 9) { // Condiçao caso dê empate
				System.out.println("EMPATE!");
			} else { // Mostra o vencedor
				System.out.println("O " + tab.Ganhou(rodada) + " venceu!"); // Após sair do laço informa o ganhador
			}
		}else if(nivel == 2) { //------Escolha da opção 02
			System.out.println("Nível 2");
			System.out.println(":::#Jogo da Velha#:::");
			tab.mostraTabuleiro();
			while(true) {
				do {
					jog.Jogador();
					valorJogador = jog.valor;
					posicao = Integer.toString(valorJogador);
					while(!tab.jogadaValida(posicao)) {
						System.out.println("Jogada Inválida, tente novamente! Informe uma posição (1 - 9): ");
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
				limparTela(); // Método que limpa a tela
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro(); // Método para imprimir o tabuleiro novamente
				if(!tab.Ganhou(rodada).equals("null")) { // Condição caso o jogador ganhe o jogo
					break; // A Aplicação é parada
				}
				
				do { // Escolha do Nivel 02
					  comp.CompB(); // Chamada de método de nivel 02
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
			if(rodada == 9) { // Condiçao caso dê empate
				System.out.println("EMPATE!");
			} else { // Mostra o vencedor
				System.out.println("O " + tab.Ganhou(rodada) + " venceu!"); // Após sair do laço informa o ganhador
			}
		} else if(nivel == 3) { // Escolha do nível 03
			System.out.println("Nível 3");
			System.out.println(":::#Jogo da Velha#:::");
			tab.mostraTabuleiro();
			while(true) {
				do {
					jog.Jogador();
					valorJogador = jog.valor;
					posicao = Integer.toString(valorJogador);
					while(!tab.jogadaValida(posicao)) {
						System.out.println("Jogada Inválida, tente novamente! Informe uma posição (1 - 9): ");
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
				limparTela(); // Método que limpa a tela
				System.out.println(":::#Jogo da Velha#:::");
				tab.mostraTabuleiro(); // Método para imprimir o tabuleiro novamente
				if(!tab.Ganhou(rodada).equals("null")) { // Condição caso o jogador ganhe o jogo
					break; // A Aplicação é parada
				}
				
				do { // Escolha do Nivel 03
					  comp.CompC(); // Chamada de método de nivel 03
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
				System.out.println("O " + tab.Ganhou(rodada) + " venceu!"); // Após sair do laço informa o ganhador
			}
		}
		
	}//-------------------------------------------------------------------------------------------
	
	// Método para limpar a tela
	public static void limparTela() {
		for(int cont=0; cont < 10; cont++) {
			System.out.println("");
		}
	}
}
