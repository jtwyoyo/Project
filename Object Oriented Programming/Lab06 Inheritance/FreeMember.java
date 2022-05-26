
public class FreeMember extends Member
{
	private int FREE_LIMITED_VDOs = 3, numDownloadedVDO = 0;
	
	public FreeMember(String emaill, String pass) 
	{
		super(emaill, pass);
	}
	
	@Override
	public boolean addVideo(Video vdo)
	{
		if(numDownloadedVDO == FREE_LIMITED_VDOs)
		{
			System.out.println(""+vdo+"\ncannot be downloaded because the number of the video is reaching the limit.");
			return false;
		} else 
		
		{
		numDownloadedVDO++;
		super.addVideo(vdo);
		return true;
		}
	}
	
	@Override
	public boolean removeVideo(Video vdo)
	{
		if(super.removeVideo(vdo)==true)
		{
			super.removeVideo(vdo);
			numDownloadedVDO--;
			return true;
		} else return false;
	}
	
	public void printMemberInfo()
	{
		System.out.println("---- FREE MEMBER ----");
		super.printMemberinfo();
		System.out.println("---------------------");
	}
	
	public int getNumVideo()
	{
		return numDownloadedVDO;
	}
}
