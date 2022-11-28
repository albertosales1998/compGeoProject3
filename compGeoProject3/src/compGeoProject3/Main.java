package compGeoProject3;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Main {

    private int dir;

    public static void main(String[] args) throws InterruptedException 
    {
        new Main();
    }
    
    public Main() throws InterruptedException 
    {
        int dir = 0;//index of initial translation direction
        Random r = new Random();
    	SimplePolygon[] sp = makeObstacles();
    	Vector[] compass = makeCompass();

        sp[0].setInteriorColor(Color.MAGENTA);
        FrameDisplay frame = new FrameDisplay(800, 800, sp);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);

     
    	while(true)
    	{
    		boolean intersection = false;
    		Thread.sleep(1);
    		for(int i = 0; i < sp[0].getNumberOfVertices(); i++)
    		{
    			sp[0].getVertex(i).translate(compass[dir]);
    		}
    		
    		for(int i = 1; i < sp.length; i++) 
    		{
    			if(Algorithms.isThereAnIntersection(sp[0], sp[i]))
    			{
    				intersection = true;
    				break;
    			}
    		}
    		
    		if(intersection)
    		{
    			for(int i = 0; i < sp[0].getNumberOfVertices(); i++)
        		{
        			sp[0].getVertex(i).translate(compass[dir].neg());
        		}
    			dir = (dir +  Math.abs(r.nextInt(8))) % compass.length;

    		}
    		 
    		frame.repaint();
    	}
    	
    }

    public Vector[] makeCompass(){
        return new Vector[]{
                new Vector(0, -1),
                new Vector(0, 1),
                new Vector(1, 0),
                new Vector(-1, 0),
                new Vector(1, 1),
                new Vector(1, -1),
                new Vector(-1, -1),
                new Vector(-1, 1)
        };
    }

    public SimplePolygon[] makeObstacles(){
        return new SimplePolygon[] {
                new SimplePolygon(new Point[]{ //watchman
                        new Point(978/2, 962/2),
                        new Point(978/2, (962/2)+7),
                        new Point((978/2)+7, (962/2)+7),
                        new Point((978/2)+7, 962/2),
                }),
                new SimplePolygon(new Point[]{ //WU
                        new Point(0,0),
                        new Point(0,44),
                        new Point(800,44),
                        new Point(800,0),
                }),
                new SimplePolygon(new Point[]{ //WL
                        new Point(0,0),
                        new Point(0,800),
                        new Point(30,800),
                        new Point(30,0),
                }),
                new SimplePolygon(new Point[]{ //WD
                        new Point(0,760),
                        new Point(0,800),
                        new Point(800,800),
                        new Point(800,760),
                }),
                new SimplePolygon(new Point[]{ //WR
                        new Point(770,0),
                        new Point(770,800),
                        new Point(800,800),
                        new Point(800,0),
                }),
                new SimplePolygon(new Point[]{ //ULM L Conn
                        new Point(85,200),
                        new Point(85,217),
                        new Point(385,217),
                        new Point(385,200),
                }),
                new SimplePolygon(new Point[]{ //UMM body
                        new Point(565,110),
                        new Point(565,392),
                        new Point(585,392),
                        new Point(585,110),
                }),
                new SimplePolygon(new Point[]{ //ULM body
                        new Point(85,110),
                        new Point(85,220),
                        new Point(100,220),
                        new Point(100,110),
                }),
                new SimplePolygon(new Point[]{ //upper Left obst
                        new Point(0,110),
                        new Point(0,130),
                        new Point(100,130),
                        new Point(100,110),
                }),
                new SimplePolygon(new Point[]{ //upper most mid
                        new Point(150,110),
                        new Point(150,130),
                        new Point(720,130),
                        new Point(720,110),
                }),
                new SimplePolygon(new Point[]{ //rotated t vert
                        new Point(700,200),
                        new Point(700,306),
                        new Point(720,306),
                        new Point(720,200),
                }),
                new SimplePolygon(new Point[]{ //rotated t hori bar
                        new Point(635,240),
                        new Point(635,246),
                        new Point(720,246),
                        new Point(720,240),
                }),
                new SimplePolygon(new Point[]{ // ulm t vert connector
                        new Point(135,200),
                        new Point(135,305),
                        new Point(150,305),
                        new Point(150,200),
                }),
                new SimplePolygon(new Point[]{ //ULM t hori connector
                        new Point(85,285),
                        new Point(85,305),
                        new Point(220,305),
                        new Point(220,285),
                }),
                new SimplePolygon(new Point[]{ //ulm vert bar
                        new Point(265,200),
                        new Point(265,305),
                        new Point(285,305),
                        new Point(285,200),
                }),
                new SimplePolygon(new Point[]{
                        new Point(567,370),
                        new Point(567,393),
                        new Point(717,393),
                        new Point(717,370),
                }),
                new SimplePolygon(new Point[]{ // odd t
                        new Point(500,200),
                        new Point(500,695),
                        new Point(517,695),
                        new Point(517,200),
                }),
                new SimplePolygon(new Point[]{ // odd t
                        new Point(500,565),
                        new Point(500,590),
                        new Point(650,590),
                        new Point(650,565),
                }),
                new SimplePolygon(new Point[]{ //h
                        new Point(435,200),
                        new Point(435,610),
                        new Point(450,610),
                        new Point(450,200),
                }),
                new SimplePolygon(new Point[]{ // h
                        new Point(267,500),
                        new Point(267,525),
                        new Point(450,525),
                        new Point(450,500),
                }),
                new SimplePolygon(new Point[]{ //h
                        new Point(268,500),
                        new Point(268,610),
                        new Point(285,610),
                        new Point(285,500),
                }),
                new SimplePolygon(new Point[]{ // zig zag
                        new Point(367,285),
                        new Point(367,392),
                        new Point(385,392),
                        new Point(385,285),
                }),
                new SimplePolygon(new Point[]{ // zig zag
                        new Point(200, 370),
                        new Point(200,392),
                        new Point(385,392),
                        new Point(385,370),
                }),
                new SimplePolygon(new Point[]{ // zig zag
                        new Point(200,370),
                        new Point(200,610),
                        new Point(218,610),
                        new Point(218,370),
                }),
                new SimplePolygon(new Point[]{ // left wall stick
                        new Point(0,370),
                        new Point(0,393),
                        new Point(150,393),
                        new Point(150,370),
                }),

        };
    }
	
}
