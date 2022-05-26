
public class Triangle extends Shape
{
	private double base, height;
	
	public Triangle()
	{
		base = 0;
		height = 0;
	}
	
	public Triangle(String col, double bse, double hgt)
	{
		super(col);
		base = bse;
		height = hgt;
	}
	
	@Override
	public double getArea()
	{
		return 0.5*this.base*this.height;
	}
	
	public double getArea(double base, double height)
	{
		this.base = base;
		this.height = height;
		return getArea();
	}
	
	public String toString()
	{
		return "Triangle[base="+base+",height="+height+",Shape[color="+getColor()+"]]";
	}
}
