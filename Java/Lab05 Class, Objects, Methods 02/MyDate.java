
public class MyDate
{
	private int year;
	private int month;
	private int day;
	private int objectNumber = 0;
	
	public static int objectCounter = 0;
	public static String[] strMonths = { "January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December" };
	
	public MyDate()
	{
		year = 1900;
		month = 1;
		day = 1;
		objectCounter++;
		objectNumber = objectCounter;
	}
	
	public MyDate(int aYear, int aMonth, int aDay)
	{
		year = aYear;
		month = aMonth;
		day = aDay;
		objectCounter++;
		objectNumber = objectCounter;
	}
	
	public int getObjectNumber()
	{
		return objectNumber;
	}
	
	public void setDate(int aYear, int aMonth, int aDay)
	{
		year = aYear;
		month = aMonth;
		day = aDay;
	}
	
	public void setYear(int aYear)
	{
		year = aYear;
	}
	
	public void setMonth(int aMonth)
	{
		month = aMonth;
	}
	
	public void setDay(int aDay)
	{
		day = aDay;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public String toString()
	{
		return ""+day+" "+strMonths[month-1]+" "+year+"";
	}
	
	public MyDate nextDay()
	{
		if(month == 12&&day == 31)
		{
			this.year = this.year+1;
			this.month = 1;
			this.day = 1;
		}else if(month == 4||month == 6||month == 9||month == 11)
		{
			if(day == 30)
			{
				this.month = this.month+1;
				this.day = 1;
			} else day = day+1;
		}else if(month != 2)
		{
			if(day == 31)
			{
				this.month = this.month+1;
				this.day = 1;
			} else day = day+1;
		}else if(isLeapYear(year)&&day == 29)
		{
			this.month = this.month + 1;
			this.day = 1;
		}else  if(!isLeapYear(year)&&day == 28)
		{
			this.month = this.month + 1;
			this.day = 1;
		}else this.day = this.day+1;
		return this;
	}
	
	public MyDate nextMonth()
	{
		if(month == 12)
		{
			year = year+1;
			month = 1;
			day = 1;
		} else if((month == 3||month == 5||month == 7||month == 8||month == 10)&&day == 31)
		{
			month = month + 1;
			day = day - 1;
		} else if(isLeapYear(year)&&month == 1&&day>=29)
		{
			month = month + 1;
			day = 29;
		} else if(isLeapYear(year) == false&&month == 1&&day>=28)
		{
			month = month +1;
			day = 28;
		} else month = month + 1;
		return this;
	}
	
	public MyDate nextYear()
	{
		if(isLeapYear(year)&&month == 2&&day == 29)
		{
			this.year = this.year+1;
			this.day = 28;
		} else this.year = this.year+1;
		return this;
	}
	
	public MyDate previousDay()
	{
		if(month == 1&&day == 1)
		{
			this.year = this.year-1;
			this.month = 12;
			this.day = 31;
		}else if(month == 5||month == 7||month == 10||month == 12)
		{
			if(day == 1)
			{
				this.month = this.month -1;
				this.day = 30;
			} else this.day = this.day - 1;
		}else if(month != 3)
		{
			if(day == 1)
			{
				this.month = this.month - 1;
				this.day = 31;
			} else this.day = this.day - 1;
		}else if(isLeapYear(year)&&day == 1)
		{
			this.month = this.month - 1;
			this.day = 29;
		}else if(day == 1)
		{
			this.month = this.month - 1;
			this.day = 28;
		}else this.day = this.day - 1;
		return this;
	}
	
	public MyDate previousMonth()
	{
		if(month == 1)
		{
			this.month = 12;
			this.year = this.year - 1;
		} else if((month == 5||month == 7||month == 8||month == 10)&&day == 31)
		{
			this.month = this.month - 1;
			this.day = 30;
		} else if(month == 3)
		{
			if(isLeapYear(year)&&day>=29)
			{
				this.month = this.month - 1;
				this.day = 29;
			} else if(isLeapYear(year) == false&&day>=28)
			{
				this.month = this.month - 1;
				this.day = 28;
			}
		} else this.month = this.month - 1;
		return this;
	}
	
	public MyDate previousYear()
	{
		if(isLeapYear(year)&&month == 2&&day==29)
		{
			this.year = this.year - 1;
			this.day = 28;
		} else year = year - 1;
		return this;
	}
	
	public static boolean isLeapYear(int year)
	{
		if(year%4!=0)
		{
			return false;
		} else if(year%100!=0)
		{
			return true;
		} else if(year%400!=0)
		{
			return false;
		} else return true;
	}
	
	public static int dateDiff(MyDate a, MyDate b)
	{
		int i, asum = 0, bsum = 0, diff;
		for(i = 1; i < a.month; i++)
		{
			if(i == 1||i == 3||i == 5||i == 7||i == 8||i == 10||i == 12)
			{
				asum = asum + 31;
			}
			else if(i == 4||i == 6||i == 9||i == 11)
			{
				asum = asum + 30;
			}
			else if(i == 2&&isLeapYear(a.year))
			{
				asum = asum + 29;
			} else asum = 28;
		}
		for(i = 1; i < a.year; i++)
		{
			if(isLeapYear(i))
			{
				asum = asum + 366;
			} else asum = asum + 365;
		}
		asum = asum + a.day;
		
		for(i = 1; i < b.month; i++)
		{
			if(i == 1||i == 3||i == 5||i == 7||i == 8||i == 10||i == 12)
			{
				bsum = bsum + 31;
			}
			else if(i == 4||i == 6||i == 9||i == 11)
			{
				bsum = bsum + 30;
			}
			else if(i == 2&&isLeapYear(b.year))
			{
				bsum = bsum + 29;
			} else bsum = 28;
		}
		for(i = 1; i < b.year; i++)
		{
			if(isLeapYear(i))
			{
				bsum = bsum + 366;
			} else bsum = bsum + 365;
		}
		bsum = bsum + b.day;
		
		diff = bsum - asum;
		
		return diff;
	}
}
