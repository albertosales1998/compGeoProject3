package compGeoProject3;

import java.awt.Graphics;

public class Rectangle extends GeometricObject{
    //begin and end are opposite corners; no guaranties which one
    private final Point begin;
    private final Point end;

    public Rectangle(Point b, Point e)
    {
        begin = new Point(b.getX(), b.getY());
        end = new Point(e.getX(), e.getY());
    }

    /**
     * Draws this rectangle.
     * 
     * @param g graphics context 
     */
    @Override
    public void draw(Graphics g)
    {
        int x = (int)smallestX(); //left x
        int y = (int)smallestY(); //top y
        int w = (int)width();
        int h = (int) height();
        
        g.setColor(getInteriorColor());
        g.fillRect(x, y, w, h);
        
        g.setColor(getBoundaryColor());
        g.drawRect(x, y, w, h);
    }

    /**
     * Calculates the height of this rectangle.
     * 
     * @return the height of this rectangle
     */
    public double height()
    {
        return Math.abs(begin.getY() - end.getY());
    }

    /**
     * Determines the smallest x.
     * 
     * @return the smallest x
     */
    public double smallestX()
    {
        return Math.min(begin.getX(), end.getX());
    }

    /**
     * Determines the smallest y.
     * 
     * @return the smallest y
     */
    public double smallestY()
    {
        return Math.min(begin.getY(), end.getY());
    }
    
    /**
     * Constructs a String description of this rectangle.
     *
     * @return String containing a description of this rectangle
     */
    @Override
    public String toString()
    {
        String str = "RECTANGLE " + super.toString() + "\n";
        str += begin + "\n" + end;

        return str;
    }

    /**
     * Calculates the width of this rectangle.
     * 
     * @return the width of this rectangle
     */
    public double width()
    {
        return Math.abs(begin.getX() - end.getX());
    }

}
