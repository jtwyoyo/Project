import java.text.DecimalFormat;

//Name:	Jittiwat Sanit
//ID: 6388101
//Section: 3


public class CustomerOnline extends Customer {
	
	//**************************** DO NOT MODIFY **********************************//
	private double distance;	// delivery distance
	
	//*****************************************************************************//
	
	/**
	 * Constructor initializes customer's name and delivery distance
	 * @param name
	 * @param distance
	 */
	public CustomerOnline(String name, double distance) {
		//******************* YOUR CODE HERE ******************
		super(name);
		this.distance = distance;
		//*****************************************************
	}
	
	/**
	 * Constructor initializes customer's ID, name and delivery distance
	 * @param id
	 * @param name
	 * @param distance
	 */
	public CustomerOnline(int id, String name, double distance) {
		//******************* YOUR CODE HERE ******************
		super(id, name);
		this.distance = distance;
		//*****************************************************
	}
	
	//**************************** DO NOT MODIFY **********************************//
	public double getDistance() {
		return this.distance;
	}
	
	@Override
	public String toString() {
		return super.toString() + "," + distance;
	}
	//*****************************************************************************//
	
	public String log(){
		return super.log() + "," + new DecimalFormat("##0.00").format(distance);
	}
	
	
}
