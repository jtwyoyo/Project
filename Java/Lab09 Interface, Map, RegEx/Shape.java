
abstract class Shape implements Comparable
{
	public static double PI = 3.14;
	public String color;
	public String description;
	
	public Shape(String color, String description)
	{
		this.color = color;
		this.description = description;
	}
	
	public void setColor(String _color)
	{
		color = _color;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return ""+description+" (color = "+getColor()+", area = "+getArea()+")";
	}
	
	public int compareTo(Object shape)
	{
		Shape x = (Shape) shape;
		if(getArea() > x.getArea())
		{
			return 1;
		} else if(getArea() == x.getArea())
		{
			return 0;
		} else return -1;
	}
	
	public abstract double getArea();
}
