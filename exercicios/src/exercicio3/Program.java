package exercicio3;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Student student = new Student();
		
		student.name = sc.nextLine();
		
		student.grade1 = sc.nextDouble();
		student.grade2 = sc.nextDouble();
		student.grade3 = sc.nextDouble();
		
			
		
		System.out.printf("FINAL GRADE = " + student);
		
		if (student.finalGrade() < 60) {
			
			System.out.printf("%nFAILED");
			
			double total = 60 - student.finalGrade();
			
			System.out.printf("%nMISSING " + total + " POINTS");
		}
		
		else {
			System.out.printf("%nPASS");
		}
		
		sc.close();
	}

}
