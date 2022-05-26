//Name:	Jittiwat Sanit
//ID: 6388101
//Section: 3

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class DataManagement {
	
	public static final String SAMPLE_PATH = Paths.get("").toAbsolutePath().toString() 
								+ File.separator + "sample" +  File.separator;
	
	public static final String STOCK_FILE = SAMPLE_PATH + "stocks.txt";
	public static final String CUSTOMER_FILE = SAMPLE_PATH + "customers.txt";
	public static final String WALLET_FILE = SAMPLE_PATH + "wallets.txt";
	public static final String ORDER_FILE = SAMPLE_PATH + "orders.txt";
	
	//**************************** DO NOT MODIFY **********************************//
	
	public static Map<Integer, Customer> customerData = new HashMap<Integer, Customer>();
			// The key of customerData is the customer's ID
	
	public static Map<Integer, EWallet> walletData = new HashMap<Integer, EWallet>();
			// The key of walletData is the customer's ID associated with that EWallet
	
	public static Map<String, Item> stockData = new HashMap<String, Item>();
			// The key of stockData is the item's name
	
	public static Map<Integer, Order> orderData = new HashMap<Integer, Order>();
			// The key of orderData is the order's ID
	
	//*****************************************************************************//
	
	
	/**
	 * Reads data line by line from the text file.
	 * For any valid line with correct customer's format, recreates a Customer object, and put in the customerData map.
	 * The invalid line will be skipped.
	 * 
	 * Note that customer can be either general customer or an online customer.
	 * 
	 * @param filename that keeps customers data
	 * @return Map collection of customers read from the text file
	 */
	public static Map<Integer, Customer> initCustomer(String filename) {
		
		//******************* YOUR CODE HERE ******************
		File file = new File(filename);
		String temp = "";
		CustomerOnline CustOn;
		Customer Cust;
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((temp = in.readLine()) != null)
					if(!temp.trim().isEmpty() && temp.trim() != null)
					{ 
						String[] line = temp.split(",", 3);
						if(line.length == 3)
						{
							if(line[0].matches("[0-9]+") && line[1].chars().allMatch(Character::isLetter) && line[2].matches("[0-9]+[\\.]?[0-9]*"))
							{
								CustOn = new CustomerOnline(Integer.parseInt(line[0]), line[1], Double.parseDouble(line[2]));
								customerData.put(Integer.parseInt(line[0]), CustOn);
							}
						}else if(line.length == 2)
						{
							if(line[0].matches("[0-9]+") && line[1].chars().allMatch(Character::isLetter))
							{
								Cust = new Customer(Integer.parseInt(line[0]), line[1]);
								customerData.put(Integer.parseInt(line[0]), Cust);
							}
						}
					}
			in.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return customerData;
		//*****************************************************
	}
	
	/**
	 * Reads data line by line from the text file.
	 * For any valid line with correct wallet's format, recreates a EWallet object, and put in the walletData map.
	 * The invalid line will be skipped.
	 * 
	 * Note that the password in the log file must be encoded password (positive or negative number only)
	 * 
	 * @param filename that keeps e-wallet data
	 * @return Map collection of wallets read from the text file
	 */
	public static Map<Integer, EWallet> initWallet(String filename) {
		
		//******************* YOUR CODE HERE ******************
		File file = new File(filename);
		String temp = "";
		EWallet wallet;
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((temp = in.readLine()) != null)
					if(!temp.trim().isEmpty() && temp.trim() != null)
					{ 
						String[] line = temp.split(",", 4);
						if(line.length == 4)
						{
							if(line[0].matches("[0-9]+") && !line[1].isBlank() && line[2].matches("-?\\d+") && line[3].matches("[0-9]+[\\.]?[0-9]*"))
							{
								wallet = new EWallet(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]), Double.parseDouble(line[3]));
								walletData.put(Integer.parseInt(line[0]), wallet);
							}
						}
					}
			in.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return walletData;
		//*****************************************************

	}
	
	
	/**
	 * Reads data line by line from the text file.
	 * For any valid line with correct item's format, recreates an Item object, and put in the stockData map.
	 * The invalid line will be skipped.
	 * 
	 * @param filename that keeps stocks data
	 * @return Map collection of items read from the text file
	 */
	public static Map<String, Item> initStock(String filename){
		
		//******************* YOUR CODE HERE ******************
		File file = new File(filename);
		String temp = "";
		Item obj;
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((temp = in.readLine()) != null)
					if(!temp.trim().isEmpty() && temp.trim() != null)
					{ 
						String[] line = temp.split(",", 4);
						if(line.length == 4)
						{
							if(!line[0].isBlank() && line[1].matches("[0-9]+[\\.]?[0-9]*") && line[2].matches("(true|false).*") && line[3].matches("[0-9]+"))
							{
								obj = new Item(line[0], Double.parseDouble(line[1]), Boolean.parseBoolean(line[2]), Integer.parseInt(line[3]));
								stockData.put(line[0], obj);
							}
						}
					}
			in.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return stockData;
		//*****************************************************
		
	}
	
	/**
	 * Reads data line by line from the text file.
	 * For any valid line with correct order's format, recreates an Order object, and put in the orderData map.
	 * The invalid line will be skipped.
	 * 
	 * Note that if the qty is equal to 2147483647, this mean the item has unlimited supply
	 * 
	 * @param filename that keeps orders data
	 * @return Map collection of orders read from the text file
	 */
	
	public static Map<Integer, Order> initOrder(String filename) {
		//******************* YOUR CODE HERE ******************

		File file = new File(filename);
		String temp = "";
		Order obj;
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(file));
			while((temp = in.readLine()) != null)
				if(!temp.trim().isEmpty() && temp.trim() != null)
				{
					String[] line = temp.split(",", 4);
					String[] item = line[2].split("\\|");
					if(line[0].matches("[0-9]+") && line[1].matches("[0-9]+") && item.length > 0 && line[3].matches("(VOID|PENDING|PAID).*::(UNKNOWN|CASH|CARD|EWALLET).*"))
					{
						obj = new Order(Integer.parseInt(line[0]));
						orderData.put(Integer.parseInt(line[0]), obj);
					}
				}
			in.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return orderData;
		
		//*****************************************************
		
	}
	
	//**************************** DO NOT MODIFY **********************************//
	/**
	 * Initialize customerData, stockData, walletData, and orderData by calling initCustomer, initStock, initWallet, and initOrder respectively
	 * 
	 */
	public static void initData(){
		initStock(STOCK_FILE); 
		initCustomer(CUSTOMER_FILE);
		initWallet(WALLET_FILE);
		initOrder(ORDER_FILE);
	}

	
	/**
	 * Delete existing log files if any
	 */
	public static void removeLogFile(String filename) {
		
		try {
			File log = new File(filename);
			Files.deleteIfExists(log.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A convenient method to write str to the File identified by filename. 
	 * Only works with newer version of Java.
	 * @param filename
	 * @param append
	 * @param str
	 */
	public static void writeDataLog(String filename, Boolean append, String str)
	{
		try {
			FileWriter fileWriter = new FileWriter(filename, append);
			PrintWriter printWriter = new PrintWriter(fileWriter);
		    printWriter.println(str); 
		    printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	//*****************************************************************************//
	
	/**
	 * Write the list of items into the given text file
	 * If the append is true, the list of items will be appended into the existing log file
	 * Otherwise, the content in the existing log file will be replaced with this new list of items.
	 * 
	 * @param filename
	 * @param append: whether append the text file or not
	 * @param items: list of items
	 */
	public static void storeItems(
			String filename, Boolean append, List<Item> items) {
		//******************* YOUR CODE HERE ******************
		try {
			FileWriter fileWriter = new FileWriter(filename, append);
			/* CREATE NEW log FILE */
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(Item i:items) {
				printWriter.println(i.log());
			}
			printWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//***************************************************** 
	}
	
	/**
	 * Write the list of customers into the given text file
	 * If the append is true, the list of customers will be appended into the existing log file
	 * Otherwise, the content in the existing log file will be replaced with this new list of customers.
	 *   
	 * @param filename
	 * @param append
	 * @param customers
	 */
	public static void storeCustomers(
			String filename, Boolean append, List<Customer> customers) {
		
		//******************* YOUR CODE HERE ******************
		try {
			FileWriter fileWriter = new FileWriter(filename, append);
			/* CREATE NEW log FILE */
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(Customer i:customers) {
				printWriter.println(i.log());
			}
			printWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//*****************************************************
	}
	
	/**
	 * Write the list of wallets into the given text file
	 * If the append is true, the list of wallets will be appended into the existing log file
	 * Otherwise, the content in the existing log file will be replaced with this new list of wallets.
	 * 
	 * @param filename
	 * @param append
	 * @param wallets
	 */
	public static void storeEWallets(
			String filename, Boolean append, List<EWallet> wallets) {
		
		//******************* YOUR CODE HERE ******************
		try {
			FileWriter fileWriter = new FileWriter(filename, append);
			/* CREATE NEW log FILE */
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(EWallet i:wallets) {
				printWriter.println(i.log());
			}
			printWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//*****************************************************
	}
	
	/**
	 * Write the list of orders into the given text file
	 * If the append is true, the list of orders will be appended into the existing log file
	 * Otherwise, the content in the existing log file will be replaced with this new list of orders.
	 * 
	 * @param append
	 * @param orders
	 */
	
	public static void storeOrders(
			String filename, Boolean append, List<Order> orders) {
		
		//******************* YOUR CODE HERE ******************
		try {
			FileWriter fileWriter = new FileWriter(filename, append);
			/* CREATE NEW log FILE */
			PrintWriter printWriter = new PrintWriter(fileWriter);
			for(Order i:orders) {
				printWriter.println(i.log());
			}
			printWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		//*****************************************************
	}
	

	
	
	/**
	 * Filter the orders data (in the Map Collection) by the order's status and/or payment method
	 * and calculate the summation of the sub-total amount of those filtered ordered.
	 * 
	 * @param status
	 * @param method
	 * @return total summation of the sub-total of the orders matched with the given condition
	 */
	public static double filterSubTotal(Order.Status status, String method) {
		
		//******************* YOUR CODE HERE ******************
		double subTotal=0;
        for (int id : orderData.keySet()){
            Order order = orderData.get(id);
            if (order.getPaymentStatus()==status&&order.getPaymentMethod()==method){
                subTotal+=order.getSubTotal();
            }
        }

        return subTotal;
		//*****************************************************
		
	}
	
	/**
	 * Filter the orders data (in the Map Collection) by the order's status and/or payment method
	 * and calculate the summation of the grand total amount of those filtered ordered.
	 * 
	 * @param status
	 * @param method
	 * @return total summation of the grand total of the orders matched with the given condition
	 */
	
	public static double filterGrandTotal(Order.Status status, String method) {
		
		//******************* YOUR CODE HERE ******************
		double grandTotal = 0.0;
        for (int id : DataManagement.orderData.keySet()) {
            Order order = DataManagement.orderData.get(id);
            if (order.getPaymentStatus() == status && order.getPaymentMethod() == method) {
                grandTotal += order.getGrandTotal();
            }
        }
        return grandTotal;
		//*****************************************************
				
	}
	
	/**
	 * Calculate the grand total payment group by each payment method for all paid ordered
	 * The voided or pending orders are ignored
	 * 
	 * @return Map<String, Double> where key is the method name, and value is the total of grand total payment
	 */
	public static Map<String, Double> groupGrandTotalByPaymentMethod(){
		
		//******************* YOUR CODE HERE ******************
		Map<String, Double> grandtotal = new HashMap<String, Double>();
        grandtotal.put("CASH", filterGrandTotal(Order.Status.PAID, "CASH"));
        grandtotal.put("CARD", filterGrandTotal(Order.Status.PAID, "CARD"));
        grandtotal.put("EWALLET", filterGrandTotal(Order.Status.PAID, "EWALLET"));
        return grandtotal;
		//*****************************************************
				
	}
	
	/**
	 * Sort the orders data (in Map Collection) by their grandTotal
	 * If asc is true, the grandTotal is sorted in ascending order
	 * Otherwise, the grandTotal is sorted in descending order 
	 * Only "paid" orders are included in the output
	 * If the amounts are equal, the order ID will be used later.
	 * 
	 * @param asc indicate ascending or descending order
	 * @return the sorted list of orders
	 */
	public static ArrayList<Order> sortPaidGrandTotal(boolean asc) {
		
		//******************* YOUR CODE HERE ******************
		ArrayList<Order> sorted = new ArrayList<Order>();
		int i = 0;
        for (int id : DataManagement.orderData.keySet()) {
            Order order = DataManagement.orderData.get(id);
            if (order.getPaymentStatus() == Order.Status.PAID) {
                sorted.add(i, order);
                ++i;
            }
        }
        if(asc)
        {
        	for (int fill = 0; fill < sorted.size()-1; fill++) 
        	{
        		int posMax = fill;
        		for (int nxt = fill+1; nxt < sorted.size(); nxt++)
        			if (sorted.get(nxt).getGrandTotal() < (sorted.get(posMax).getGrandTotal()))
        				posMax = nxt;
        		Order tmp = sorted.get(fill);
        		sorted.set(fill, sorted.get(posMax));
        		sorted.set(posMax, tmp);
        	}
        } else 
        {
        	for (int fill = 0; fill < sorted.size()-1; fill++) 
        	{
        		int posMax = fill;
        		for (int nxt = fill+1; nxt < sorted.size(); nxt++)
        			if (sorted.get(nxt).getGrandTotal() > (sorted.get(posMax).getGrandTotal()))
        				posMax = nxt;
        		Order tmp = sorted.get(fill);
        		sorted.set(fill, sorted.get(posMax));
        		sorted.set(posMax, tmp);
        	}
        }
        return sorted;
		//*****************************************************
	}

}
