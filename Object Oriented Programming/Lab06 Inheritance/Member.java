import java.util.ArrayList;

public class Member
{
	private String email, password;
	ArrayList<Video> vdoList = new ArrayList<Video>();
	
	public Member(String emaill, String pass)
	{
		email = emaill;
		password = pass;
	}
	
	public boolean addVideo(Video vdo)
	{
		if(vdo != null)
		{
			vdoList.add(vdo);
			return true;
		} else return false;
	}
	
	
	public boolean removeVideo(Video vdo)
	{
		for(int i = 0; i < vdoList.size(); i++)
		{
			if(vdoList.get(i)==vdo)
			{
				vdoList.remove(i);
				System.out.println(""+vdo+"\nis successfully remove.");
				return true;
			}
		} 
		return false;
	}
	
	public void printMemberinfo()
	{
		System.out.println("Email: "+email+" (pwd: "+password+")");
		for(int i = 0; i < vdoList.size(); i++)
		{
			Video b = vdoList.get(i);
			System.out.println("["+(i+1)+"] "+b.toString()+"");
		}
	}
}
