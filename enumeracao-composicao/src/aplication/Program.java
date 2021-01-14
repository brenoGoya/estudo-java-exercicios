package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		// CONFIGURA��ES DO PROJETO
		
		Locale.setDefault(Locale.US);		
		Scanner sc  = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		// DADOS DO TRABALHADOR (WORKER)
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		
		System.out.print("Name: ");
		String workerName  = sc.nextLine();
		
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("Base Salary: ");
		double workerBaseSalary = sc.nextDouble();
		
		// CRIA��O DO TRABALHADOR (Worker)
		
		// ASSOCIA O TRABALHADOR COM DEPARTAMENTO (N�VEL DO TRABALHADOR USANDO ENUM) (WorkerLevel)
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));
		
		// DADOS DO(S) CONTRATO(S) 
		
		System.out.print("How many contracts to this worker?" );
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			System.out.println("Enter contract #" + (i + 1) + " data:" );
			
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours):	");
			int hours = sc.nextInt();
			
			// CRIA��O DO CONTRATO (HourContract)
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			
			worker.addContract(contract); // ASSOCIA O CONTRATO COM O TRABALHADOR
		}
		
		// C�LCULO DO SAL�RIO 
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		
		// RECORTAR A STRING (GUARDAR O VALOR DO M�S E ANO EM UMA VARI�VEL(INT)
		
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " +  worker.getName());
		
		// COMPOSI��O DE OBJETOS (WORKER -> DEPARTAMENT -> NOME DEPARTAMENTO)
		
		System.out.println("Department: " + worker.getDepartment().getName());
		
		//  CHAMADA DO M�TODO income() DENTRO DA CLASSE Worker
		
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
}
