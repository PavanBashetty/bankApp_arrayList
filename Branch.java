package simpleBankApp;

import java.util.ArrayList;


public class Branch {

	/*
	 * add new customer with initial transaction amount, and additional transactions
	 * store list of customers
	 */
	
	private String branchName;
	private ArrayList<Customer> customers;
	
	public Branch(String branchName) {
		this.branchName = branchName;
		this.customers = new ArrayList<Customer>(); // initialing the arraylist so that it is ready to be adding records
	}
	
	public String getBranchName() {
		return this.branchName;
	}
	
	public ArrayList<Customer> getCustomers(){
		return this.customers;
	}
	
	public boolean newCustomer(String custName, double initialAmount) {
		if(findCustomer(custName) == null) {
			this.customers.add(new Customer(custName, initialAmount));
			return true;
		}
		
		return false;
	}
	
	public boolean addCustomerTransaction(String custName, double amount) {
		Customer existingCustomer = findCustomer(custName);
		if(existingCustomer != null) {
			existingCustomer.addTransaction(amount);
			return true;
		}
		return false;
	}
	
	private Customer findCustomer(String custName) {
		for(int i=0; i<this.customers.size(); i++) {
			Customer checkedCustomers = this.customers.get(i);
			if(checkedCustomers.getName().equals(custName)) {
				return checkedCustomers;
			}
		}
		return null;
	}
}
