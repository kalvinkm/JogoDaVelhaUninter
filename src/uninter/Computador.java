package uninter;

import java.util.Random;

public class Computador {
	Random rand = new Random();
	Jogadores jog = new Jogadores();
	int valor;
	

	public int CompA() { // Método jogada de nivel 01
		valor = jog.valor; // Valor recebido do usuário
		if(valor == 1) {
			valor+= valor;
		} else if(valor == 2) {
			valor += valor;
		} else if(valor == 3) {
			valor += valor;
		} else if(valor == 4) {
			valor += valor;
		} else if(valor == 5) {
			valor += 1;
		} else if(valor == 6) {
			valor += 1;
		} else if(valor == 7) {
			valor += 1;
		} else if(valor == 8) {
			valor += 1;
		} else if(valor == 9) {
			valor += 8;
		}
		
		return valor;
	}
	
	public int CompB() { // Método referente ao nivel 02
		  int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		  int i; 
		  for (i=0;i<arr.length; i++) {
			  arr[i] = 1 + rand.nextInt(8); 
			  } 
		  valor = arr[1]; 
		  return valor;	 
	}
	
	public int CompC() { // Método referente ao nivel 03
		valor = jog.valor;
		
		switch(valor) {
		case 1:
			valor += 1;
			break;
		case 2:
			valor += 1;
			break;
		case 3:
			valor += 1;
			break;
		case 4:
			valor += 1;
			break;
		case 5:
			valor += 1;
			break;
		case 6:
			valor += 1;
			break;
		case 7:
			valor += 1;
			break;
		case 8:
			valor += 1;
			break;
		case 9:
			valor += 8;
			break;
		}
		
		return valor;
		
	}
	
	
}

