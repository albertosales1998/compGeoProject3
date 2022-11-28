package compGeoProject3;

import java.awt.Graphics;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class Rectangle extends GeometricObject{
    private final Point begin;
    private final Point end;

    public Rectangle(Point b, Point e)
    {
        begin = new Point(b.getX(), b.getY());
        end = new Point(e.getX(), e.getY());
    }

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


    public double height()
    {
        return Math.abs(begin.getY() - end.getY());
    }

    public double smallestX()
    {
        return Math.min(begin.getX(), end.getX());
    }


    public double smallestY()
    {
        return Math.min(begin.getY(), end.getY());
    }

    @Override
    public String toString()
    {
        String str = "RECTANGLE " + super.toString() + "\n";
        str += begin + "\n" + end;

        return str;
    }

    public double width()
    {
        return Math.abs(begin.getX() - end.getX());
    }

}
