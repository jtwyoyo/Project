//Name: Jittiwat Sanit
//ID: 6388101
//Section: 3


public class Customer  {
	
	//**************************** DO NOT MODIFY **********************************//
	public static int runningID = 0;	// static variable for assigning a unique ID to a customer

	private int custID;		// customer's ID
	private String name;	// customer's name
	//*****************************************************************************//
	
	/**
	 * Constructor initializes the customer's name.
	 * The customer's ID will be automatically assigned according to the running ID. 
	 * The first customer will have ID as 1, and the second customer will have ID as 2, and so on
	 * @param name
	 */
	public Customer(String name) {
		//******************* YOUR CODE HERE ******************
		
		//*****************************************************
		this.name = name;
		runningID++;
		this.custID = runningID;
	}
	
	/**
	 * Constructor initializes both customer's ID and name.
	 * If the provided ID is larger than the running ID, then the running ID will be set to equal to that provided ID. 
	 * @param id
	 * @param name
	 */
	public Customer(int id, String name) {
		//******************* YOUR CODE HERE ******************
		
		//*****************************************************
		this.custID = id;
		this.name = name;
		if(runningID < id){
			runningID = id;
		}
	}
	
	//**************************** DO NOT MODIFY **********************************//
	public int getCustID() {
		return this.custID;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "CID::" + custID + ",name::" + name;
	}

	public void print() {
		System.out.printf("%-15s %-4d \n", "Customer ID:", custID);
		
		// [2021-04-10]
		// Change from "%-4d" to "%s" to print customer's name
		System.out.printf("%-15s %s \n", "Name:", name);
	}
	//*****************************************************************************//


	/* MAKE METHOD log TO GET DATA */
	public String log() {
		return this.custID +","+ this.name;
	}
	
}
