
public class CovidReporter 
{	
	public static void main(String[]args)
	{
		CovidProfile prof1 = new CovidProfile();
		prof1.getDate();
		prof1.setDate("02-04-2021");
		prof1.getLocation();
		prof1.setLocation("Thailand");
		prof1.getAccCases();
		prof1.setAccCases(20454);
		prof1.getCuredCases();
		prof1.setCuredCases(13217);
		prof1.getDeathCases();
		prof1.setDeathCases(79);
		prof1.printCovidInfo();
		
		CovidProfile prof2 = new CovidProfile("02-04-2021", "Madagascar", 19065, 18215, 281);
		prof2.printCovidInfo();

		System.out.print("Total Profile: "+CovidProfile.noProf+"");
	}
}
