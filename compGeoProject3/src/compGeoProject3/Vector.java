package compGeoProject3;

public class Vector {

    private final double x; //x component of the vector
    private final double y; //y component of the vector

    /**
     * Instantiates a Vector object with components (x, y).
     *
     * @param x x-component
     * @param y y-component
     */
    public Vector(double x, double y) 
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x component of this vector.
     *
     * @return x-component
     */
    public double getX()
    {
        return x;
    }

    /**
     * Returns the y component of this vector.
     *
     * @return y-component
     */
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

    /**
     * Constructs a String description of this vector.
     *
     * @return String containing a description of this vector
     */
    @Override
    public String toString()
    {
        return "VECTOR (" + x + ", " + y + ")";
    }
	
}
