
public class Sphere extends Shape
{
private double radius;
	
	public Sphere()
	{
		radius = 0;
	}
	
	public Sphere(String col, double rad)
	{
		super(col);
		radius = rad;
	}
	
	public String toString()
	{
		return "Rectangle[radius="+radius+",Shape[color="+getColor()+"]]";
	}
	
	@Override
	public double getArea()
	{
		return 4*(Math.PI*Math.pow(radius, 2));
	}
	
	public double getArea(double radius)
	{
		this.radius = radius;
		return getArea();
	}
}
