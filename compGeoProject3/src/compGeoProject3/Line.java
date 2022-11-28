package compGeoProject3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class Line extends GeometricObject{

	private final double a;
	private final double b;
	private final double c;

	public Line(Point p, Point q) throws IllegalArgumentException
	{
		if(p.getX() == q.getX() && p.getY() == q.getY())
			throw new IllegalArgumentException();
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
    	// TODO Auto-generated method stub
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
		if(this.b != 0)
			return (-this.a / this.b) * x + (-this.c / this.b);
		else
			throw new IllegalArgumentException("Vertical lines prohibited");
	}
	
	public double getX(double y) throws IllegalArgumentException
	{
		if(this.a != 0)
			return (-this.b / this.a) * y + (-this.c / this.a);
		else
			throw new IllegalArgumentException("Horizontal line prohibited");
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
