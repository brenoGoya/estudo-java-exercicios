package aplication;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;


public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Account account;		
				
		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		
		System.out.print("Enter account holder: ");		
		sc.nextLine(); // Para consumir a quebra de linha que ficou pendente do sc.nextInt()		
		String holder = sc.nextLine();	
		
		System.out.print("Is there na initial deposit (y/n)? ");
		char response = sc.next().charAt(0); // Para ler o caracter
		
		if (response == 'y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			account = new Account(number, holder, initialDeposit); // construtor de 3 argumentos
		}
		
		else {
			account = new Account(number, holder); // construtor de 2 argumentos
		}
		
		System.out.println();
		System.out.println("Account data:");
		System.out.println(account);		
		
		System.out.println();
		System.out.print("Enter a deposit value: ");
		double depositValue = sc.nextDouble();
		account.deposit(depositValue);
		
		System.out.println("Updated account data: ");
		System.out.println(account);
		
		System.out.println();
		System.out.print("Enter a withdraw value: ");
		double withdrawValue = sc.nextDouble();
		account.withdraw(withdrawValue);
		
		System.out.println("Updated account data: ");
		System.out.println(account);
				
		sc.close();
	}

}
