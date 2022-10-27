package simpleBankApp;

import java.util.ArrayList;

public class Customer {

	private String name;
	private ArrayList<Double> transactions;
	
	public Customer(String name, double initialAmount) {
		// initialAmount ~ the initial amt to add when customer opens a new account at a particular branch
		this.name = name;
		this.transactions = new ArrayList<Double>(); // initialing the arraylist
		addTransaction(initialAmount); // add the initial amount to the list
	}
	
	// add all transactions in the list
	public void addTransaction(double amount) {
		this.transactions.add(amount);
	}
	
	public String getName() {
		return this.name;
	}
	public ArrayList<Double> getTransactions(){
		return this.transactions;
	}
	
	public double currentBalance() {
		double sum = 0;
		for(int i=0; i<transactions.size();i++) {
			sum = sum + transactions.get(i);
		}
		return sum;
	}
}
