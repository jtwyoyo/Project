import java.util.ArrayList;

public class PremiumMember extends Member
{
	private double fee;
	private static double Family_FEE = 80.00;
	ArrayList<String> family = new ArrayList<String>();
	
	public PremiumMember(String emaill, String pass, double feee) 
	{
		super(emaill, pass);
		fee = feee ;
	}
	
	public void printMemberInfo()
	{
		System.out.println("---- PREMIUM MEMBER ----");
		System.out.println("Member fee: "+fee+"");
		super.printMemberinfo();
		if(family.size()>0)
		{
			System.out.println("---------------------");
			System.out.println("List of family");
			for(int i = 0; i < family.size(); i++)
			{
				System.out.print(""+family.get(i)+", ");
			}
			System.out.println();
		}
	}
	
	public boolean addFamily(String username)
	{
		if(username.length() != 0 && family.size() <= 1)
		{
			family.add(username);
			System.out.println(""+username+" is added successfully.");
			return true;
		} else 
			{
			System.out.println("user: "+username+" cannot be added, the Family user is reached the limit");
			return false;
			}
	}
	
	public boolean removeFamily(String username)
	{
		for(int i = 0; i < family.size(); i++)
		{
			if(family.get(i) == username)
			{
				family.remove(i);
				System.out.println(""+username+" is removed successfully");
				return true;
			}
		} 
		System.out.println("user: "+username+" does not exist and cannot be removed.");
		return false;
	}
	
	public double getMonthlyBill()
	{
		Family_FEE = Family_FEE + fee;
		return Family_FEE;
	}
}
