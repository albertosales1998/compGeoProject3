package compGeoProject3;

public class Algorithms {

    public static boolean isThereAnIntersection(SimplePolygon pol1, SimplePolygon pol2)
    {
    	LineSegment[] edges1 = pol1.getEdges();
    	LineSegment[] edges2 = pol2.getEdges();
    	
    	for(int i = 0; i < pol1.getNumberOfVertices(); i++)
    	{
    		LineSegment e1 = edges1[i];
    		for(int j = 0; j < pol2.getNumberOfVertices(); j++)
    		{
    			LineSegment e2 = edges2[j];
    			Point p = new Point();
    			if (e1.intersect(e2, p) == 1)
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }

}

