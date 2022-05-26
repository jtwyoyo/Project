
public class EggStop 
{
	static void up()
	{
		System.out.println("     ______      ");
		System.out.println("    /      \\    ");
		System.out.println("   /        \\   ");
	}
	static void mid()
	{
		System.out.println("   |  STOP  |   ");
	}
	static void down()
	{
		System.out.println("   \\        /  ");
		System.out.println("    \\______/   ");
	}
	static void line()
	{
		System.out.println("   +--------+  ");
	}
	public static void main(String[] args)
	{
		up();
		down();
		System.out.println("");
		up();
		down();
		line();
		System.out.println("");
		up();
		mid();
		down();
		line();
	}
}
