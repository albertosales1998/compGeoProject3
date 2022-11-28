package compGeoProject3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Author: Alberto Sales, Anthony Serrano
 * PID's: 6053920, 3607674
 */
public class GraphDisplay extends JPanel implements MouseMotionListener, MouseListener {

    GeometricObject[] gArray;
    private BufferedImage image;
    Point begin;
    Rectangle selectionRectangle;

    public GraphDisplay(int width, int height, GeometricObject[] g)
    {
        this.gArray = g;
        begin = null;
        selectionRectangle = null; 
        addMouseMotionListener(this);
        addMouseListener(this); 
        
        try
        {
            image = ImageIO.read(new File("/Users/albertosales/classes/compGeoProject3/compGeoProject3/src/compGeoProject3/Maze.png"));
        } 
        catch (IOException ex)
        {
            System.out.println("Image file not found, make sure to use absolute path.");
        }
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
    }

    public void mouseDragged(MouseEvent e)
    {	
    	Point end = new Point(e.getX(), e.getY());
        selectionRectangle = new Rectangle(begin, end);
        repaint();
    }

    public void mouseMoved(MouseEvent e)
    {
    	//only for coordinates lookup; remove after project completion
        System.out.println("(" + e.getPoint().x + ", " +
                           e.getPoint().y + ")");
    	 
    }

    @Override
    public void paint(Graphics g)
    {        
        super.paint(g); //clears window
        
        //draws background image
        Dimension d = getSize();
        g.drawImage(image, 0, 0, d.width, d.height, this);


        gArray[0].draw(g); //invokes object's draw method through polymorphism
            
        

    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void mousePressed(MouseEvent e)
    {
        begin = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {  	
    	
    }
    

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
