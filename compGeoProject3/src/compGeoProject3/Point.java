package compGeoProject3;

import java.awt.Graphics;

public class Point extends GeometricObject{

	    private double x;
	    private double y;

	/**
	     * Instantiates a Point object with coordinates (0, 0) and parent's default
	     * options.
	     */
	    public Point() 
	    {
	        x = y = 0; 
	    }

	/**
	     * Instantiates a Point object with coordinates (x, y) and parent's default
	     * options.
	     *
	     * @param x x-coordinate
	     * @param y y-coordinate
	     */
	    public Point(double x, double y)
	    {
	        this.x = x;
	        this.y = y;
	    }
	    
	    /**
	     * Calculates distance between this point and point p.
	     *
	     * @param p Point object
	     *
	     * @return distance between this point and point p
	     */
	    public double distance(Point p)
	    {
	        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	    }
	    
	    public void draw(Graphics g)
	    {
	        int radius = 5;
	        
	        g.setColor(getInteriorColor());
	        g.fillOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
	        g.setColor(getBoundaryColor());
	        g.drawOval((int) x - radius, (int) y - radius, 2 * radius, 2 * radius);
	    }

	    /**
	     * Returns the x coordinate of this point.
	     *
	     * @return x-coordinate
	     */
	    public double getX()
	    {
	        return x;
	    }

	    /**
	     * Returns the y coordinate of this point.
	     *
	     * @return y-coordinate
	     */
	    public double getY()
	    {
	        return y;
	    }

	/**
	     * Sets the x-coordinate of this point.
	     *
	     * @param x x-coordinate
	     */
	    public void setX(double x)
	    {
	        this.x = x;
	    }

	    /**
	     * Sets the y-coordinate of this point.
	     *
	     * @param y y-coordinate
	     */
	    public void setY(double y)
	    {
	        this.y = y;
	    }

	    /**
	     * Constructs a String description of this point.
	     *
	     * @return String containing a description of this point
	     */
	    @Override
	    public String toString()
	    {
	        return "POINT (" + x + ", " + y + ") " + super.toString();
	    }

	    /**
	     * Translates this point by given vector.
	     *
	     * @param v given vector
	     */
	    public void translate(Vector v)
	    {
	        x += v.getX();
	        y += v.getY();
	    }

	
}
