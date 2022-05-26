public class CovidProfile 
{
	boolean x;
	static int noProf = 0;
	
	private String date;
	private String location;
	private int accumulatedCases;
	private int curedCases;
	private int deathCases;
	
	public CovidProfile() 
	{
		date = "none";
		location = "none";
		accumulatedCases = 0;
		curedCases = 0;
		deathCases = 0;
	}
	
	public CovidProfile(String _date, String loc, int noACC, int noCured, int noDeath)
	{
		date = _date; 
		location = loc; 
		accumulatedCases = noACC; 
		curedCases = noCured; 
		deathCases = noDeath; 
	}
	
	public boolean isSevere()
	{
		if(deathCases>10000)
		{
			x = true;
		} else x = false;
		return x;
	}
	
	public String getLocation() 
	{
		return location;
	}

	public int getAccCases() 
	{
		return accumulatedCases;
	}

	public int getCuredCases() 
	{
		return curedCases;
	}

	public int getDeathCases() 
	{
		return deathCases;
	}

	public void setLocation(String location) 
	{
		this.location = location;
	}
	public void setAccCases(int accumulatedCases) 
	{
		this.accumulatedCases = accumulatedCases;
	}
	public void setCuredCases(int curedCases) 
	{
		this.curedCases = curedCases;
	}
	public void setDeathCases(int deathCases) 
	{
		this.deathCases = deathCases;
	}
	
	public void printCovidInfo()
	{
		System.out.println(""+location+" at "+date+"");
		System.out.println("Accumulative Patient: "+accumulatedCases+"");
		System.out.println("Cured Patient: "+curedCases+"");
		System.out.println("Death Case: "+deathCases+"");
		System.out.println("Severe: "+x+"\n");
		noProf++;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}
}
