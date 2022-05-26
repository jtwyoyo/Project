//Name: Jittiwat Sanit
//ID: 6388101
//Section: 3

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	//*********************** DO NOT MODIFY ****************************//
	public static enum CustomerType{DEFAULT, STUDENT, PROFESSOR, ATHLETE, ICTSTUDENT};	//Different types of customers 
	private static int customerRunningNumber = 1;	//static variable for assigning a unique ID to a customer
	private CanteenICT canteen = null;	//reference to the CanteenICT object
	private int customerID = -1;		//this customer's ID
	protected CustomerType customerType = CustomerType.DEFAULT;	//the type of this customer, initialized with a DEFAULT customer.
	protected List<FoodStall.Menu> requiredDishes = new ArrayList<FoodStall.Menu> ();	//List of required dishes
	//*****************************************************************//
	
	private int state = 0;
	private int eatingTime = -1;
	FoodStall myfs = null;
	Table t = new Table();
	
	Customer(CanteenICT _canteen)
	{
		//******************* YOUR CODE HERE **********************
		canteen = _canteen;
		this.customerID=customerRunningNumber++;
		this.requiredDishes.add(FoodStall.Menu.NOODLES);
		this.requiredDishes.add(FoodStall.Menu.DESSERT);
		this.requiredDishes.add(FoodStall.Menu.MEAT);
		this.requiredDishes.add(FoodStall.Menu.SALAD);
		this.requiredDishes.add(FoodStall.Menu.BEVERAGE);
		
		state = 1;
		eatingTime = 0;
		for(FoodStall.Menu dish : this.requiredDishes)
		{
			eatingTime += FoodStall.EAT_TIME[dish.ordinal()];
		}
		//*****************************************************
	}
	
	/**
	 * return true if the customer finish eating
	 * @return 
	 */
	public boolean FinishEating()
	{
		return (eatingTime == 0);
	}
	
	/**
	 * Take action for each customers
	 */
	public void takeAction()
	{
		//************************** YOUR CODE HERE **********************//
		int alrdymove = 0;
		if(this.state == 1) //Take waited customer to customer queue
		{
			if(!canteen.getwaitToEnterQueue().isEmpty() && canteen.getwaitToEnterQueue() != null)
			{
				int min = 1000000;
				for(FoodStall fscheck : canteen.getfoodStalls())
				{
					if(min > fscheck.getCustomerQueue().size())
					{
						myfs = fscheck;
					}
				}
				if(myfs != null && canteen.getwaitToEnterQueue().get(0).equals(this) 
						&& myfs.getCustomerQueue().size() < 5)
				{
					myfs.getCustomerQueue().add(canteen.getwaitToEnterQueue().get(0));
					canteen.getwaitToEnterQueue().remove(0);
					this.state = 2;
				}
			}
		}
		
		else if(this.state == 2) //If the food stall is not cooking, the customer take order
		{
			if(myfs.getCustomerQueue().get(0).equals(this) && !myfs.isCooking())
			{
				myfs.takeOrder(requiredDishes);
				this.state = 3;
			}
		}
		
		else if(this.state == 3) //If ready to serve, serve and take customer to wait to seat queue
		{
			if(myfs.getCustomerQueue().get(0).equals(this) && myfs.isReadyToServe())
			{
				myfs.serve();
				canteen.getwaitToSeatQueue().add(myfs.getCustomerQueue().get(0));
				myfs.getCustomerQueue().remove(0);
				this.state = 4;
			}
		}
		
		/*else if(this.state == 4)
		{
			if(canteen.getwaitToSeatQueue().get(0).equals(this) && !t.isFull())
			{
				t.getSeatedCustomers().add(canteen.getwaitToSeatQueue().get(0));
				canteen.getwaitToSeatQueue().remove(0);
				this.eatingTime = 28;
				this.state = 5;
			}
		}
		
		else if(this.state == 5)
		{
			if(FinishEating())
			{
				canteen.getDoneQueue().add(t.getSeatedCustomers().get(0));
				t.getSeatedCustomers().remove(0);
			} else this.eatingTime--;
		}*/
		//**************************************************************//
	}
	//***************For hashing, equality checking, and general purposes. DO NOT MODIFY **************************//	
	
	public CustomerType getCustomerType()
	{
		return this.customerType;
	}
	
	public int getCustomerID()
	{
		return this.customerID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerType=" + customerType +"]";
	}

	public String getCode()
	{
		return this.customerType.toString().charAt(0)+""+this.customerID;
	}
	
	/**
	 * print something out if VERBOSE is true 
	 * @param str
	 */
	public void jot(String str)
	{
		if(CanteenICT.VERBOSE) System.out.println(str);
		
		if(CanteenICT.WRITELOG) CanteenICT.append(str, canteen.name+"_state.log");
	}
	
	//*************************************************************************************************//
	
}
