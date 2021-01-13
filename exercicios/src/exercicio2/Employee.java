package exercicio2;

public class Employee {

	public String name;
	public double grossSalary;
	public double tax;
	public double percentage;

	public double netSalary() {
		return grossSalary - tax;
	}

	
	public double increaseSalary() {
		return percentage * grossSalary / 100 + netSalary();
	}

	public String toString() {
		return name
			+ ", $" + String.format("%.2f", increaseSalary());
			
	}
}
