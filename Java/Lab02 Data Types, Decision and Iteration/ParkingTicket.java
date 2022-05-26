import java.util.Scanner;

public class ParkingTicket 
{
	static void printParkingFee(int hour, int minute) 
	{
		double fee = 0;
		if(minute<30&&minute>0)
		{
			fee = 49.5;
		} else
			if(minute>=30)
			{
				fee = 99;
			} else
				if(minute==0)
				{
					fee = 0;
				}
		if(hour>2)
		{
			fee = fee+((hour-2)*99);
		}
		if(hour<=2)
		{
			fee = 0;
			if(minute<=30)
			{
				fee = 49.5;
			}
			if(minute>30)
			{
				fee = 99;
			}
		}
		System.out.printf("Parking fee: %.1f", fee);
	}
	static void  printParkingDuration(String enterTime, String leaveTime)
	{
		System.out.println("Entering time -> "+enterTime+"");
		System.out.print("Leaving time -> "+leaveTime+"");
		int x = Integer.parseInt(enterTime);
		int y = Integer.parseInt(leaveTime);
		int enter = (x/100)*60+x%100;
		int leave = (y/100)*60+y%100;
		int diff, hrs, mins;
		if(x>y)
		{
			diff = (1440-enter) + leave;
			System.out.print(" (overnight)");
		} else diff = leave - enter;
		hrs = diff/60;
		mins = diff%60;
		System.out.println();
		System.out.printf("Parking duration: %d hours and %d minutes", hrs, mins);
		System.out.println();
		
		int i,j;
		for(i = 1 ; i <= hrs ; i++ )
		{
			System.out.print("|xxxxxxxxxxxxxxx");
			System.out.print("|xxxxxxxxxxxxxxx");
			System.out.print("|xxxxxxxxxxxxxxx");
			System.out.print("|xxxxxxxxxxxxxxx ");
			System.out.println(""+i+" hours");
		}
		System.out.print("|");
		for(i = 1; i <= mins ; i++)
		{
			System.out.print("x");
			if(i%15==0)
			{
				System.out.print("|");
			}
		}
		for(j = i; j < 60 ; j++)
		{
			System.out.print(" ");
			if(j%15==0)
			{
				System.out.print("|");
			}
		}
		System.out.println("  "+mins+" minutes");
		printParkingFee(hrs, mins);
	}
	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String a = in.nextLine();
		in.close();
		printParkingDuration(s ,a);
	}
}
