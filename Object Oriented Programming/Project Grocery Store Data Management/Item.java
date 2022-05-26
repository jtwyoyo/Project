//Name:	Jittiwat Sanit
//ID: 6388101
//Section: 3


public class Item {
	
	//**************************** DO NOT MODIFY **********************************//
	private String name;				// item's name
	private double price;				// item's price
	private boolean taxable = false;		// default value is false (non-taxable)
	private int qty = Integer.MAX_VALUE;	// default value is unlimited supply (max_value)
	//*****************************************************************************//
	
	
	/**
	 * Constructor to initialize name, price
	 * @param name
	 * @param price
	 */
	public Item(String name, double price){
		//******************* YOUR CODE HERE *****************
		this.name = name;
		this.price = price;
		//*****************************************************
	}
	
	/**
	 * Constructor to initialize name, price, and taxable value
	 * @param name
	 * @param price
	 * @param taxable
	 */
	
	public Item(String name, double price, boolean taxable){
		//******************* YOUR CODE HERE *****************
		this.name = name;
		this.price = price;
		this.taxable = taxable;
		//*****************************************************
	}
	
	/**
	 * Constructor to initialize, price, taxable, and remaining quantity in the stock  
	 * @param name
	 * @param price
	 * @param taxable
	 * @param qty
	 */
	public Item(String name, double price, boolean taxable, int qty){
		//******************* YOUR CODE HERE ******************
		this.name = name;
		this.price = price;
		this.taxable = taxable;
		this.qty = qty;
		//*****************************************************
	}
	
	/**
	 * Return true if the quantity of the item is larger than 0
	 * @return
	 */
	public boolean isAvailable(){
		
		//******************* YOUR CODE HERE ******************
		return this.qty > 0;
		//*****************************************************
	}
	
	/**
	 * Decrease the quantity by one
	 * @return remaining quantity in the stock
	 */
	public int sold(){
		
		//******************* YOUR CODE HERE ******************
		return this.qty -= 1;
		//*****************************************************
	}
	
	/**
	 * Increase the quantity by one
	 * @return remaining quantity in the stock
	 */
	public int restock() {
		
		//******************* YOUR CODE HERE ******************
		return this.qty += 1;
		//*****************************************************
	}
	
	
	//**************************** DO NOT MODIFY **********************************//
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public boolean getTaxable(){
		return taxable;
	}
	
	public int getQuantity(){
		return qty;
	}
	
	@Override
	public String toString(){
		return "name::" + name 
				+ ",price::" + price 
				+ ",taxable::" + taxable
				+ ",qty::" + qty;
	}
	//*****************************************************************************//
	/* MAKE METHOD log TO GET DATA */
	public String log() {
		return this.name +","+ String.format("%.2f", this.price) +","+ this.taxable +","+ this.qty;
	}
	

}
