package with.templatemethod;

public abstract class PaymentProcessor {

	protected void proccessPayment(double amount, String currency, Customer customer) {
		double dollarAmount = amount;

		if (currency.contentEquals("EUR")) { // European Euro
			dollarAmount = amount * 1.1;
			System.out.println("Convert "+amount+" "+currency+" to US dollars");

		}
		if (currency.contentEquals("INR")) { // Indian Rupee
			dollarAmount = amount * 0.014;
			System.out.println("Convert "+amount+" "+currency+" to US dollars");

		}

		boolean validation = validatePaymentDetails();
		if(validation) {
			makePayment(dollarAmount);
			notifyCustomer(customer);
		}
	}
	
	public abstract boolean validatePaymentDetails();
	public abstract void makePayment(double dollarAmount);
	public abstract void notifyCustomer(Customer customer);

}
