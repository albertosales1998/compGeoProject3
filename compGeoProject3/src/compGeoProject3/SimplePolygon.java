package compGeoProject3;

import java.awt.Graphics;

public class SimplePolygon extends GeometricObject{

	   
    private Point[] vertexList;
    private int size;
    private int vertNumber;

	public SimplePolygon()
    {
    	size = 100;
        vertexList = new Point[size];
        vertNumber = 0; 
    }
    
    public SimplePolygon(Point[] vertices) {
    	this.vertexList = vertices;
    	this.vertNumber = vertices.length;
    }
    
    public Point getVertex(int i)
    {
    	Point v;
    	v = vertexList[i];
    	return v; 
    }
    
    public Point[] getVertexList() 
    {
    	return vertexList;
    }
    
    public LineSegment[] getEdges()
    {
    	LineSegment[] edges = new LineSegment[vertNumber];
    	for(int i = 0;i < vertNumber;i++)
    	{
    		edges[i] = new LineSegment(vertexList[i], vertexList[(i + 1) % vertNumber]);
    	}
    	return edges;
    }

	@Override
	public void draw(Graphics g) 
	{
		int[] xCord = new int[vertNumber];
		int[] yCord = new int[vertNumber];
		 
		for(int i = 0;i < vertNumber;i++)
		{
			xCord[i] = (int)vertexList[i].getX();
			yCord[i] = (int)vertexList[i].getY();
		}
		
		g.setColor(getInteriorColor());
		g.fillPolygon(xCord, yCord, vertNumber);
		g.setColor(getBoundaryColor());
		g.drawPolygon(xCord, yCord, vertNumber);
	}
	
	public void addVertex(Point v)
	{
		vertexList[vertNumber] = v;
		vertNumber++;
	}

	public int getNumberOfVertices()
	{
		return vertNumber;
	}
	
	public double greatestX()
	{
		double max = vertexList[0].getX();
		for(int i = 0; i < vertNumber; i++)
		{
			double x = vertexList[i].getX();
			if(x > max)
			{
				max = x;
			}
		}
		return max;
	}
	
	public double greatestY()
	{
		double max = vertexList[0].getY();
		for(int i = 0; i < vertNumber; i++)
		{
			double y = vertexList[i].getY();
			if(y > max)
			{
				max = y;
			}
		}
		return max;
	}
	
	public String toString()
	{
		StringBuilder str = new StringBuilder("POLY SIMPLE " + super.toString() + "\n");
		for(int i = 0; i < vertNumber; i++)
		{
	        str.append(vertexList[i]).append("\n");
		}

	        return str.toString();
	}
	
	public double smallestX()
	{
		double min = vertexList[0].getX();
		for(int i = 0; i < vertNumber; i++)
		{
			double x = vertexList[i].getX();
			if(x < min)
			{
				min = x;
			}
		}
		return min;
	}
	
	public double smallestY()
	{
		double min = vertexList[0].getY();
		for(int i = 0; i < vertNumber; i++)
		{
			double y = vertexList[i].getY();
			if(y < min)
			{
				min = y;
			}
		}
		return min;
	}

	public boolean isPointInRecPolygon(Point p)
	{
		int j = 1;
		for(int i =0; i < vertNumber - 1; i++)
		{
			//double x =  p.getX();
			//double y =  p.getY();
			Point n1 = vertexList[i];
			Point n2 = vertexList[j];
			if(n1.getX() == n2.getX())
			{
				//vertical edge
				if(!(smallestY() <= p.getY() && p.getY() < greatestY()))
				{
					return false;
				}
				
			}
			else
			{
				//horizontal edge
				if(!(smallestX() <= p.getX() && p.getX() < greatestX()))
				{
					return false;
				}
			}
			j++;
					
		}
		return true;
	}
}
