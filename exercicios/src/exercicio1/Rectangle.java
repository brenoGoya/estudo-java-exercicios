package exercicio1;

public class Rectangle {

	public double width;
	public double heigth;
	
	public double area() {
		return width * heigth;
	}
	
	public double perimeter() {
		return (width + heigth) * 2; 
	}
	
	public double diagonal() {
		return Math.sqrt(Math.pow(width, 2) + (Math.pow(heigth, 2)));
	}
	
	public String toString() {
		return "AREA = "
				+ String.format("%.2f%n", area())
				+ "PERIMETER = " 
				+ String.format("%.2f%n", perimeter())
				+ "DIAGONAL = " + String.format("%.2f%n", diagonal()); 
	}
}
