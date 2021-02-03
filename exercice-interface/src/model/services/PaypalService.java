package model.services;

public class PaypalService implements OnlinePaymentService {
	
	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	
	@Override
	public double paymentFee(double ammount) {
		return ammount * FEE_PERCENTAGE;
		
		
	}
	@Override
	public double interest(double ammount, int months) {
		return ammount * MONTHLY_INTEREST * months;		
	}
}
