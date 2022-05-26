
public class Rectangle extends Shape
{	
	private double length, width;
	
	public Rectangle()
	{
		length = 0;
		width = 0;
	}
	
	public Rectangle(String col, double lth, double wth)
	{
		super(col);
		length = lth;
		width = wth;
	}
	
	public String toString()
	{
		return "Rectangle[length="+length+", width="+width+",Shape[color="+getColor()+"]]";
	}
	
	@Override
	public double getArea()
	{
		return this.length * this.width;
	}
	
	public double getArea(double length, double width)
	{
		this.length = length;
		this.width = width;
		return getArea();
	}
}
