package aplication;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Número de linhas: ");
		int numeroDeLinhas = sc.nextInt();
		
		System.out.print("Número de colunas: ");
		int numeroDeColunas = sc.nextInt();
		
		int[][] matriz = new int[numeroDeLinhas][numeroDeColunas]; 
		
		System.out.println("Digite a matriz:");
		
		for (int linha = 0; linha < matriz.length; linha++) {
			for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
				matriz[linha][coluna] = sc.nextInt();
			}
		}
		
		System.out.print("Digite um numero que pertence a matriz: ");
		int numeroDaMatriz = sc.nextInt();
		
		for (int linha = 0; linha < matriz.length; linha++) {			
			for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
				
				if (matriz[linha][coluna] == numeroDaMatriz) {
					System.out.println("Position " + linha + ", " + coluna + ":");
					
					if (coluna > 0) {
						System.out.println("Left: " + matriz[linha][coluna - 1]);
					}
					if (linha > 0) {
						System.out.println("Up: " + matriz[linha - 1][coluna]);
					}
					if (coluna < matriz[linha].length - 1) {
						System.out.println("Right: " + matriz[linha][coluna + 1]);
					}
					if (linha < matriz.length - 1) {
						System.out.println("Down: " + matriz[linha + 1][coluna]);
					}
				}
			}
		}
		
		sc.close();
	}

}
