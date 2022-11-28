package compGeoProject3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Line extends GeometricObject{

	private final double a;
	private final double b;
	private final double c;

	public Line(Point p, Point q) throws IllegalArgumentException
	{
		if(p.getX() == q.getX() && p.getY() == q.getY())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			if(!(p.getX() == q.getX()))
			{
				a = ((q.getY() - p.getY()) / (q.getX() - p.getX()));
				b = -1;
				c = p.getY() - (a * p.getX());
			}
			else
			{
				a = 1;
				b = 0;
				c = -(p.getX());
			}
		}
	}

	public void draw(Graphics g)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double maxX = screenSize.width;
		double maxY = screenSize.height;
		
		double x1, y1, x2, y2;
		
		if(isVertical())//line is not vertical
		{
			x1 = 0.0;
			y1 = getY(x1);
			x2 = maxX;
			y2 = getY(x2);
		}
		else//line is vertical
		{
			y1 = 0.0;
			x1 = getX(y1);
			y2 = maxY;
			x2 = getX(y2);
		}
		g.setColor(getBoundaryColor());
		g.drawLine((int)x1,(int)y1, (int)x2, (int)y2);	
	}
	
	public double getA() 
	{
		return a;
	}
	
	public double getB() 
	{
		return b;
	}

	public double getC() 
	{
		return c;
	}
	
	public double getY(double x) throws IllegalArgumentException
	{
		if(b != 0)
		{
			return (-a / b) * x + (-c / b);
		}
		else
		{
			throw new IllegalArgumentException("Vertical line cannot be used here");
		}
	}
	
	public double getX(double y) throws IllegalArgumentException
	{
		if(a != 0)
		{
			return (-b / a) * y + (-c / a);
		}
		else
		{
			throw new IllegalArgumentException("Horizontal line cannot be used here");
		}
	}
	
	boolean isVertical()
	{
		return b != 0;
	}

	public String toString()
	{
		return "LINE " + a + " " + b + " " + c + " " + " " + super.toString();
	}

}
