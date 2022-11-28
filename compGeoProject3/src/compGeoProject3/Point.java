package compGeoProject3;

import java.awt.Graphics;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class Point extends GeometricObject{

	    private double x;
	    private double y;

	    public Point() 
	    {
			x = y = 0;
	    }

	    public Point(double x, double y)
	    {
	        this.x = x;
	        this.y = y;
	    }

	public void draw(Graphics g)
	    {
	        int radius = 5;
	        
	        g.setColor(getInteriorColor());
	        g.fillOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
	        g.setColor(getBoundaryColor());
	        g.drawOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
	    }

	    public double getX()
	    {
	        return x;
	    }

	    public double getY()
	    {
	        return y;
	    }

	    public void setX(double x)
	    {
	        this.x = x;
	    }

	    public void setY(double y)
	    {
	        this.y = y;
	    }

	    @Override
	    public String toString()
	    {
	        return "POINT (" + x + ", " + y + ") " + super.toString();
	    }

	    public void translate(Vector v)
	    {
	        x += v.getX();
	        y += v.getY();
	    }

	
}
