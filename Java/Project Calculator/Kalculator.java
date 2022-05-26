//Name: Jittiwat Sanit
//ID: 6388101
//Section: 3

import java.util.ArrayList;


public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	ArrayList<Double> data; //An ArrayList to contain all the input data
	double sum, avg, x = 0, prev, std, Max, Min; //varibles used to calculate
	double[] maxk; double[] mink;//An array used to contain MinK and MaxK value in order to return and print out
	int i, j; // variable for initializing for loop
	double temp; // temporary variable for sorting when using MinK and MaxK method
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
		data = new ArrayList<Double>();
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		data.add(number);
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size()>0)
		{
			data.remove(0);
		}
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size()>0)
		{
			data.remove(data.size()-1);
		}
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size()>0)
		{
			for(i = 0; i < data.size(); i++)
			{
				sum = sum + data.get(i);
			} 
			return sum;
		} else return 0;
		//**************************************
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size()>0)
		{
			avg = sum/data.size();
			return avg;
		} else return 0;
		//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size()>2)
		{
			for(i = 0; i < data.size(); i++)
			{
				prev = x;
				x = Math.pow(data.get(i)-avg, 2);
				x = x + prev;
			}
			std = Math.sqrt(x/(data.size()-1));
			return std;
		} else return 0;
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size()>0)
		{
			Max = data.get(0);
			for(i = 1; i < data.size(); i++)
			{
				if(data.get(i) > Max)
				{
					Max = data.get(i);
				}
			}
			return Max;
		} else return 0;
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size()>0)
		{
			Min = data.get(0);
			for(i = 1; i < data.size(); i++)
			{
				if(data.get(i) < Min)
				{
					Min = data.get(i);
				}
			}
			return Min;
		} else return 0;
		//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size() > k) // unless data size is beyond k the code will return null
		{
			for(i = 0; i < data.size(); i++) // for loop sorting before getting max k values
			{
				for(j = data.size()-1; j > i; j--)
				{
					if(data.get(i) > data.get(j))
					{
						temp = data.get(i);
						data.set(i,data.get(j));
						data.set(j,temp);
					}
				}
			}
			double[] maxk = new double[k]; // setting the size of maxk according to integer k
			for(i = 0; i < k; i++)
			{
				maxk[i] = data.get(data.size()-(i+1));
			}
			return maxk;
		} else return null;
		//**************************************
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		if(data.size() > k) // unless data size is beyond k the code will return null
		{
			for(i = 0; i < data.size(); i++) //for loop sorting before getting min k values
			{
				for(j = data.size()-1; j > i; j--)
				{
					if(data.get(i) > data.get(j))
					{
						temp = data.get(i);
						data.set(i,data.get(j));
						data.set(j,temp);
					}
				}
			}
			double[] mink = new double[k]; // setting the size of mink according to integer k
			for(i = 0; i < k; i++)
			{
				mink[i] = data.get(i);
			}
			return mink;
		} else return null;
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		System.out.println("DATA["+data.size()+"]:"+data+"");
		//**************************************
	}
}
