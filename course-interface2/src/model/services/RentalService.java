package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;
	
	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour,TaxService taxService) {		
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		
		// Get the instant date (milliseconds)
		
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();
		
		// Convert java date in milliseconds to hour
		
		double hours = (double)(t2 - t1) / 1000 / 60 / 60;
		
		double basicPayment;
		
		if (hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour;					
		}
		else {
			basicPayment = Math.ceil(hours / 24) * pricePerDay;
		}
		
		// Calculate tax (model.services.BrazilTaxServices)
		
		double tax = taxService.tax(basicPayment);
		
		// Associate a Invoice  object with a carRental object
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
