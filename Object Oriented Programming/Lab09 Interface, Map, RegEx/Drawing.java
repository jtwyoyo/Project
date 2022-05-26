import javax.swing.*;
import java.awt.*;

public class Drawing extends JFrame
{	
	public Drawing()
	{
		setTitle("Circle");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GRAY);
		g2d.fillRect(150, 170, 100, 100);
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval(60, 80, 100, 100);
		g2d.fillOval(240, 80, 100, 100);
	}
	
	public static void main(String [] args)
	{
		new Drawing();
	}
}

