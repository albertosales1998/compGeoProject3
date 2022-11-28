package compGeoProject3;

import java.awt.Graphics;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class LineSegment extends GeometricObject{
	private final Point begin;
	private final Point end;
	
	public LineSegment(Point p, Point q)
	{
		begin = p;
		end = q;	
	}
	
	public Point getBegin()
	{
        return begin;
	}
	
	public Point getEnd()
	{
        return end;
	}

    private boolean sameSign(double a, double b)
    {
        return (a>0 &&  b>0) || (a<0) && (b<0);
    }

    public int intersect(LineSegment ls, Point p) throws IllegalArgumentException
    {
        Line line1 = new Line(begin, end);
        Line line2 = new Line(ls.getBegin(), ls.getEnd());

        double s1 = solveLine(line2.getA(), line2.getB(), line2.getC(), this.getBegin().getX(), this.getBegin().getY());
        double s2 = solveLine(line2.getA(), line2.getB(), line2.getC(), this.getEnd().getX(), this.getEnd().getY());
        double s3 = solveLine(line1.getA(), line1.getB(), line1.getC(), ls.getBegin().getX(), ls.getBegin().getY());
        double s4 = solveLine(line1.getA(), line1.getB(), line1.getC(), ls.getEnd().getX(), ls.getEnd().getY());

        if ((this.getBegin().getX()==this.getEnd().getX() && this.getBegin().getY()==this.getEnd().getY()) ||
                (ls.getBegin().getX()==ls.getEnd().getX() && ls.getBegin().getY()==ls.getEnd().getY()))
            throw new IllegalArgumentException();
        else
            if (s1 == 0 && s2 == 0)
                return 0;
            else
                if (sameSign(s3, s4))
                    return -1;
                else
                    if (sameSign(s1, s2))
                        return -1;
                    else
                    {
                        double x = (line1.getB()*line2.getC() - line2.getB()*line1.getC()) / line1.getA()*line2.getB() - line2.getA()*line1.getB();
                        double y = (line2.getA()*line1.getC() - line1.getA()*line2.getC()) / line1.getA()*line2.getB() - line2.getA()*line1.getB();
                        p.setX(x);
                        p.setY(y);
                        return 1;
                    }
    }

    public double solveLine(double a, double b, double c, double x, double y)
    {
        return a * x + b * y + c;
    }

	@Override
	public void draw(Graphics g)
    {
		// TODO Auto-generated method stub
	}
}
