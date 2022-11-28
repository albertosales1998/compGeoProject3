package compGeoProject3;

import java.awt.Graphics;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class SimplePolygon extends GeometricObject{

	   
    private final Point[] vertexList;
	private final int numVertices;

	public SimplePolygon(Point[] vertices) {
    	this.vertexList = vertices;
    	this.numVertices = vertices.length;
    }
    
    public Point getVertex(int i)
    {
    	Point v;
    	v = vertexList[i];
    	return v; 
    }

	public LineSegment[] getEdges()
    {
    	LineSegment[] edges = new LineSegment[numVertices];
    	for(int i = 0;i < numVertices;i++)
			edges[i] = new LineSegment(vertexList[i], vertexList[(i + 1) % numVertices]);

    	return edges;
    }

	@Override
	public void draw(Graphics g) 
	{
		int[] xCord = new int[numVertices];
		int[] yCord = new int[numVertices];
		 
		for(int i = 0;i < numVertices;i++)
		{
			xCord[i] = (int)vertexList[i].getX();
			yCord[i] = (int)vertexList[i].getY();
		}
		
		g.setColor(getInteriorColor());
		g.fillPolygon(xCord, yCord, numVertices);
		g.setColor(getBoundaryColor());
		g.drawPolygon(xCord, yCord, numVertices);
	}

	public int getNumberOfVertices()
	{
		return numVertices;
	}

	public String toString()
	{
		StringBuilder str = new StringBuilder("POLY SIMPLE " + super.toString() + "\n");
		for(int i = 0; i < numVertices; i++)
		{
	        str.append(vertexList[i]).append("\n");
		}

	        return str.toString();
	}

}
