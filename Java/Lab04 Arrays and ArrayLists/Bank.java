import java.util.ArrayList;
import java.util.List;

public class Bank {
	//1.variable
	private ArrayList<BankAccount> accounts;
	//2.constructor
	public Bank(){
		accounts = new ArrayList<BankAccount>();
	}
	//3.methods
	//add an account to this bank
	public void addAccount(BankAccount a){
		accounts.add(a);
	}
	//gets the sum of the balances of all accounts in this bank
	public double getTotalBalance(){
		
		//**************** YOUR CODE HERE****************
		double totalBalance = 0;
		for(BankAccount a : accounts)
		{
			totalBalance += a.getBalance();
		}
		return totalBalance;
		//*********************************************
	}
	//counts the number of bank account whose balance is at least given value.
	public int countBalanceAtLeast(double atLeast){
		
		//**************** YOUR CODE HERE****************
		int pairs = 0;
		for(BankAccount a : accounts)
		{
			if(a.getBalance()>=atLeast) pairs++;
		}
		return pairs;
		//*********************************************
	}
	
	//finds a bank account with a given number
	public BankAccount find(int accountNumber){
		
		//**************** YOUR CODE HERE****************
		for(BankAccount a : accounts)
		{
			if(a.getBalance()>=accountNumber) return a;
		}
		return null;
		//*********************************************
	}
	
	//gets the bank account with the largest balance.
	public BankAccount getMax(){
		
		//**************** YOUR CODE HERE****************
		if(accounts.size()==0) return null;
		BankAccount max = accounts.get(0);
		for(int i = 1; i < accounts.size(); i++)
		{
			BankAccount a = accounts.get(i);
			if(a.getBalance() > max.getBalance()) max = a;
		}
		return max;
		//*********************************************
	}
	
	//gets the bank account with the minimum balance.
	public BankAccount getMin(){
		
		//**************** YOUR CODE HERE****************
		if(accounts.size()==0) return null;
		BankAccount min = accounts.get(0);
		for(int i = 1; i < accounts.size(); i++)
		{
			BankAccount a = accounts.get(i);
			if(a.getBalance() < min.getBalance()) min = a;
		}
		return min;
		//*********************************************
	}
	
	
	//finds duplicate accounts by checking the account numbers in O(N) without using Set and Map
	//return the list of all the accounts that are later found to be duplicate, if there is no duplicate simply return an empty list
	public List<BankAccount> findDuplicate(){
		
		//**************** YOUR CODE HERE****************
		List<BankAccount> x = new ArrayList<BankAccount>();
		for(int i = 0; i < accounts.size(); i++)
		{
			BankAccount a = accounts.get(i);
			for(int j = i+1; j < accounts.size();j++)
			{
				BankAccount b = accounts.get(j);
				if(a.getAccountNumber()==b.getAccountNumber())
				{
					x.add(b);
					break;
				}
			}
		}
		return x;
		//*********************************************
	}
	
}
