package simpleBankApp;

public class Main {

	/*
	 * Simple banking application.
	 * A bank class with an arraylist of branches
	 * each branch should have an arraylist of customers
	 * customer class should have an arraylist of (Double) transactions (Double ~ wrapper object of double)
	 */
	
	public static void main(String[] args) {
		
		Bank bank = new Bank("Sparkasse");
		bank.addBranch("Heidelberg");
		bank.addCustomer("Heidelberg", "Pavan", 100.0d);
		bank.addCustomer("Heidelberg", "Goku", 300.0d);
		bank.addCustomer("Heidelberg", "Gohan", 400.0d);
		
		bank.addBranch("Frankfurt");
		bank.addCustomer("Frankfurt", "Picallo", 120.0d);
		bank.addCustomer("Frankfurt", "Vegeta", 320.0d);
		
		bank.addCustomerTransaction("Heidelberg", "Pavan", 55.0d);
		bank.addCustomerTransaction("Frankfurt", "Vegeta", 35.4d);
		bank.addCustomerTransaction("Heidelberg", "Pavan", -12.3d);
		bank.addCustomerTransaction("Heidelberg", "Pavan", 10.3d);
		
		bank.listCustomers("Heidelberg", true);
		bank.listCustomers("Frankfurt", true);
		
	}
}
