
public class TreeCalculator {

		
	public static int findMax(Node root)
	{	//****YOUR CODE HERE**
		if(root == null)
		{
			return -1;
		}
		int max = root.id;
		int lmax = findMax(root.left);
		int rmax = findMax(root.right);
		if(lmax >= max) max = lmax;
		if(rmax >= max) max = rmax;
		return max;
		//*********************
	}
	
	
	public static int findMin(Node root)
	{	//****YOUR CODE HERE**
		if(root == null)
		{
			return -1;
		}
		int min = root.id;
		int lmin = findMin(root.left);
		int rmin = findMin(root.right);
		if(lmin <= min && lmin != -1) min = lmin;
		if(rmin <= min && rmin != -1) min = rmin;
		return min;
		//*********************
	}
	
	//************* BONUS ****************//
	public static double sumTree(Node root)
	{	
		//****YOUR CODE HERE**
		if(root == null)
		{
			return 0;
		}
		return root.id + sumTree(root.left) + sumTree(root.right);
		//*********************
	}
	
	public static double avgTree(Node root)
	{
		//****YOUR CODE HERE**
		if(root == null)
		{
			return 0;
		}
		return sumTree(root)/sumOfNode(root);
		//*********************
	}
	
	/**
	 * helper method, calculate sum of all nodes in binary tree
	 * @return sum of all nodes
	 */
	public static int sumOfNode(Node root)
	{
		if(root == null)
		{
			return 0;
		}
		return sumOfNode(root.left) + sumOfNode(root.right) + 1;
	}
	
}
