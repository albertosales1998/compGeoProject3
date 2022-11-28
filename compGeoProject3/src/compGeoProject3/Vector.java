package compGeoProject3;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class Vector {

    private final double x;
    private final double y;

    public Vector(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    /**
     * Computes a vector with same magnitude and direction opposite to that of
     * this vector.
     *
     * @return the vector -this
     */
    public Vector neg()
    {
        return new Vector(-x, -y);
    }

    @Override
    public String toString()
    {
        return "VECTOR (" + x + ", " + y + ")";
    }
	
}
