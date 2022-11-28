package compGeoProject3;

import javax.swing.JFrame;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class FrameDisplay extends JFrame{

    public FrameDisplay(int width, int height, GeometricObject[] g)
    {
        setTitle("8-Bit Maze");
        setSize(width, height);

        GraphDisplay panel = new GraphDisplay(width, height, g);
        add(panel);
        pack();
    }
	
}
