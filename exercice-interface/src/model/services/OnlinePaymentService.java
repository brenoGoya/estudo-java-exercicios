package model.services;

public interface OnlinePaymentService {
	
	double paymentFee(double ammount);
	double interest(double ammount, int months);

}
