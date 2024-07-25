package with.templatemethod;

public class PaypalPaymentProcessor extends PaymentProcessor{

	String paypalAddress;

	public PaypalPaymentProcessor(String paypalAddress) {
		this.paypalAddress = paypalAddress;
	}

	@Override
	public boolean validatePaymentDetails() {
		// logic to validate paypal address
		System.out.println("Validate paypal address "+paypalAddress);
		return true;
	}

	@Override
	public void makePayment(double dollarAmount) {
		// logic to perform paypal payment
		System.out.println("Perform payment with paypal address "+paypalAddress+" and amount $"+dollarAmount);
	}

	@Override
	public void notifyCustomer(Customer customer) {
		// logic to notify customer
		System.out.println("Notify customer "+customer.getName()+" with email "+customer.getEmail()+" about paypal payment to address "+paypalAddress);
	}
}
