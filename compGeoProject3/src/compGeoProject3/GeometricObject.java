package compGeoProject3;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public abstract class GeometricObject {

    private final Color boundaryColor;
    private Color interiorColor;

    public GeometricObject()
    {
        interiorColor = Color.white;
        boundaryColor = Color.black;
    }

    abstract public void draw(Graphics g);

    public Color getBoundaryColor()
    {
        return boundaryColor;
    }
    
    public Color getInteriorColor()
    {
        return interiorColor;
    }

    public void setInteriorColor(Color interiorColor)
    {
        this.interiorColor = interiorColor;
    }

    @Override
    public String toString()
    {
        String str;
        str = boundaryColor.getRed() + " " +
              boundaryColor.getGreen() + " " +
              boundaryColor.getBlue() + " " +
              boundaryColor.getAlpha() + " " +
              interiorColor.getRed() + " " +
              interiorColor.getGreen() + " " +
              interiorColor.getBlue() + " " +
              interiorColor.getAlpha();
        
        return str;
    }
	
}
