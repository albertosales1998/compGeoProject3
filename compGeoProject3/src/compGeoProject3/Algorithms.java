package compGeoProject3;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class Algorithms {

    public static boolean isThereAnIntersection(SimplePolygon polygon1, SimplePolygon polygon2)
    {
    	for(int i = 0; i < polygon1.getNumberOfVertices(); i++)
			for(int j = 0; j < polygon2.getNumberOfVertices(); j++)
				if (polygon1.getEdges()[i].intersect(polygon2.getEdges()[j], new Point()) == 1)
    				return true;
    	return false;
    }

}

