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

public class GraphDisplay extends JPanel implements MouseMotionListener, MouseListener {

    GeometricObject[] gArray;
    private BufferedImage image;
    String description;
    Point begin;
    Rectangle selectionRectangle;

    /**
     * Parameterized constructor.
     */
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
        
        description = "";
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
    }
    

    /**
     * Continuously redefines the second corner of the selection rectangle 
     * as the user drags the mouse.
     * 
     * @param e  event of mouse dragged
     */
    public void mouseDragged(MouseEvent e)
    {	
    	Point end = new Point(e.getX(), e.getY());
        selectionRectangle = new Rectangle(begin, end);
        repaint();
    }
   
    /**
     * Captures mouse movement events.
     * 
     * @param e contains current location of mouse
     */
    public void mouseMoved(MouseEvent e)
    {
    	//only for coordinates lookup; remove after project completion
        System.out.println("(" + e.getPoint().x + ", " +
                           e.getPoint().y + ")");
    	 
    }
    
    
    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
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

    /**
     * The first corner of the selection rectangle is set in this method.
     * 
     * @param e event of mouse pressed
     */
    @Override
    public void mousePressed(MouseEvent e)
    {
        begin = new Point(e.getX(), e.getY());
    }


    /**
     * The final value of the second corner of the selection rectangle is set
     * in this method (the first corner was set in mousePressed); range search
     * is then performed.
     *
     * @param e  event of mouse release
     */
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
