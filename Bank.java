package simpleBankApp;

import java.util.ArrayList;


public class Bank {

	private String bankName;
	private ArrayList<Branch> branches;
	
	public Bank(String bankName) {
		this.bankName = bankName;
		this.branches = new ArrayList<Branch>();
	}
	
	public String getBankName() {
		return this.bankName;
	}
	
	public boolean addBranch(String branchName) {
		if(findBranch(branchName) == null) {
			this.branches.add(new Branch(branchName)); // calling Branch constructor
			return true;
		}
		return false;
	}
	
	public boolean addCustomer(String branchName, String custName, double initialAmount) {
		Branch branch = findBranch(branchName);
		if(branch != null) {
			return branch.newCustomer(custName, initialAmount);
		}
		
		return false;
	}
	
	public boolean addCustomerTransaction(String branchName, String custName, double amount) {
		Branch branch = findBranch(branchName);
		if(branch != null) {
			return branch.addCustomerTransaction(custName, amount);
		}
		return false;
	}
	
	private Branch findBranch(String branchName) {
		for(int i=0; i<this.branches.size(); i++) {
			Branch checkedBranch = this.branches.get(i);
			if(checkedBranch.getBranchName().equals(branchName)) {
				return checkedBranch;
			}
		}
		return null;
	}
	
	// To show a list of customers for a particular branch and 
	// optionally a list of their transactions
	public boolean listCustomers(String branchName, boolean showTranscations) {
		Branch branch = findBranch(branchName);
		if(branch != null) {
			System.out.println("Customer details for branch: " + branch.getBranchName());
			ArrayList<Customer> branchCustomers = branch.getCustomers();
			for(int i=0; i<branchCustomers.size(); i++) {
				Customer branchCustomer = branchCustomers.get(i);
				System.out.println("Customer: "  + "["+(i+1)+"] " + branchCustomer.getName());
				if(showTranscations) {
					System.out.println("Transactions: ");
					System.out.println();
					ArrayList<Double> transactions = branchCustomer.getTransactions();
					for(int j=0; j<transactions.size();j++) {
						System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
					}
					System.out.println("Current account balance: " + branchCustomer.currentBalance());
					System.out.println("----------------------");
				}
			}
			return true;
		}else {
			return false;
		}
		
	}
}
