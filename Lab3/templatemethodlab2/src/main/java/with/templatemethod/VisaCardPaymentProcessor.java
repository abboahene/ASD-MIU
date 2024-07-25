package with.templatemethod;

public class VisaCardPaymentProcessor extends PaymentProcessor {

	VisaCard visaCard;
	public VisaCardPaymentProcessor(VisaCard visaCard) {
		this.visaCard = visaCard;
	}


	@Override
	public boolean validatePaymentDetails() {
		// logic to validate visa card
		System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
		return true;
	}

	@Override
	public void makePayment(double dollarAmount) {
		// logic to perform payment visa card
		System.out.println("Perform payment with visa card with card number " + visaCard.getCreditCardNumber()
				+ " and amount $" + dollarAmount);
	}

	@Override
	public void notifyCustomer(Customer customer) {
		// logic to notify customer
		System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
				+ " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
	}
}
