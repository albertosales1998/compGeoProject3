package compGeoProject3;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException 
    {
        new Main();
    }
    
    public Main() throws InterruptedException 
    {   
    	/*
    	int frameWidth = 800;
    	int frameHeight = 800;
    
        //Defining the geometric objects that represent the problem data
        int pointNumber = 10;
        Line[] lineArray = new Line[pointNumber];
        
        //creating a set of random points
        Random rnd = new Random();
        double a,b,c;
        for(int i=0; i<pointNumber; i++)
        {
            a = 1 + rnd.nextInt(5);
            b = 1 + rnd.nextInt(5);
            c = -(100 + rnd.nextInt(4000));
            lineArray[i] = new Line(a,b,c);
            lineArray[i].setBoundaryColor(Color.red); 
        }
      
         
        //graphing
        FrameDisplay frame = new FrameDisplay(frameWidth, frameHeight, lineArray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.repaint();
        */
  
    	
     	int frameWidth = 800;
    	int frameHeight = 800;
        int dir = 0;//index of initial translation direction
        Random r = new Random();
    	SimplePolygon[] sp = new SimplePolygon[25];
    	Vector[] v = new Vector[8];//array of Vectors(Directions)
    	
    	v[0] = new Vector(0, -1);//north
    	v[1] = new Vector(0, 1);//south
    	v[2] = new Vector(1,0);//east
    	v[3] = new Vector(-1,0);//west
    	v[4] = new Vector(1,1);//
    	v[5] = new Vector(1,-1);//
    	v[6] = new Vector(-1,-1);//
    	v[7] = new Vector(-1,1);//
 
    	
        Point p = new Point(85, 200);
        Point p1 = new Point(85, 217);
        Point p2 = new Point(385, 217);
        Point p3 = new Point(385, 200);
        sp[1] = new SimplePolygon();
        sp[1].addVertex(p);
        sp[1].addVertex(p1);
        sp[1].addVertex(p2);
        sp[1].addVertex(p3);
        //ULM L connector

        //top border
        SimplePolygon topBorder = new SimplePolygon(
        		new Point[] {
        				new Point(20, 20),
        				new Point(778, 20),
        				new Point(778, 40),
        				new Point(20, 40)
                });
        System.out.println(topBorder.getVertexList()[0].toString());

        //left border
        SimplePolygon leftBorder = new SimplePolygon(
                new Point[] {
                        new Point(20, 45),
                        new Point(30, 45),
                        new Point(30, 758),
                        new Point(20, 758)
                });

        //bottom border
        SimplePolygon bottomBorder = new SimplePolygon(
                new Point[] {
                        new Point(20, 763),
                        new Point(778, 763),
                        new Point(778, 777),
                        new Point(20, 777)
                });

        //right border
        SimplePolygon rightBorder = new SimplePolygon(
                new Point[] {
                        new Point(770, 45),
                        new Point(778, 45),
                        new Point(778, 758),
                        new Point(770, 758)
                });
        
        
        p = new Point(565, 110);
        p1 = new Point(565, 392);
        p2 = new Point(585, 392);
        p3 = new Point(585, 110);
        sp[2] = new SimplePolygon();
        sp[2].addVertex(p);
        sp[2].addVertex(p1);
        sp[2].addVertex(p2);
        sp[2].addVertex(p3);
        //UMM body
        
        p = new Point(85, 110);
        p1 = new Point(85, 220);
        p2 = new Point(100, 220);
        p3 = new Point(100, 110);
        sp[3] = new SimplePolygon();
        sp[3].addVertex(p);
        sp[3].addVertex(p1);
        sp[3].addVertex(p2);
        sp[3].addVertex(p3);
        //ULM body
        
        p = new Point(0, 110);
        p1 = new Point(0, 130);
        p2 = new Point(100, 130);
        p3 = new Point(100, 110);
        sp[4] = new SimplePolygon();
        sp[4].addVertex(p);
        sp[4].addVertex(p1);
        sp[4].addVertex(p2);
        sp[4].addVertex(p3);
        //uppermost left-obstacle
        
        p = new Point(150, 110);
        p1 = new Point(150, 130);
        p2 = new Point(720, 130);
        p3 = new Point(720, 110);
        sp[5] = new SimplePolygon();
        sp[5].addVertex(p);
        sp[5].addVertex(p1);
        sp[5].addVertex(p2); 
        sp[5].addVertex(p3);
        //Uppermost mid-obstacle
        
        p = new Point(978/2, 962/2);
        p1 = new Point(978/2, (962/2)+10);
        p2 = new Point((978/2)+10, (962/2)+10);
        p3 = new Point((978/2)+10, 962/2);
        sp[0] = new SimplePolygon();
        sp[0].addVertex(p);
        sp[0].addVertex(p1);
        sp[0].addVertex(p2); 
        sp[0].addVertex(p3);
        //watchman
        
        sp[0].setInteriorColor(Color.RED);
        FrameDisplay frame = new FrameDisplay(frameWidth, frameHeight, sp);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
        p = new Point(0,0);
        p1 = new Point(0,64);
        p2 = new Point(800,64);
        p3 = new Point(800,0); 
        sp[6] = new SimplePolygon();
        sp[6].addVertex(p);
        sp[6].addVertex(p1);
        sp[6].addVertex(p2); 
        sp[6].addVertex(p3);
        //wall up
        
        p = new Point(0,0);
        p1 = new Point(0,800);
        p2 = new Point(30,800);
        p3 = new Point(30,0);
        sp[7] = new SimplePolygon();
        sp[7].addVertex(p);
        sp[7].addVertex(p1);
        sp[7].addVertex(p2); 
        sp[7].addVertex(p3);
        //wall left
        
        p = new Point(0,750);
        p1 = new Point(0,800);
        p2 = new Point(800,800);
        p3 = new Point(800,750);
        sp[8] = new SimplePolygon();
        sp[8].addVertex(p);
        sp[8].addVertex(p1);
        sp[8].addVertex(p2); 
        sp[8].addVertex(p3);
        //wall down
        
        p = new Point(770,0);
        p1 = new Point(770,800);
        p2 = new Point(800,800);
        p3 = new Point(800,0); 
        sp[9] = new SimplePolygon();
        sp[9].addVertex(p);
        sp[9].addVertex(p1);
        sp[9].addVertex(p2); 
        sp[9].addVertex(p3); 
        //wall right

        p = new Point(700,200);
        p1 = new Point(700,306);
        p2 = new Point(720,306);
        p3 = new Point(720,200);
        sp[10] = new SimplePolygon();
        sp[10].addVertex(p);
        sp[10].addVertex(p1);
        sp[10].addVertex(p2);
        sp[10].addVertex(p3);
        //rotated T vertical bar

        p = new Point(635,240);
        p1 = new Point(635,264);
        p2 = new Point(720,264);
        p3 = new Point(720,240);
        sp[11] = new SimplePolygon();
        sp[11].addVertex(p);
        sp[11].addVertex(p1);
        sp[11].addVertex(p2);
        sp[11].addVertex(p3);
        //rotated T hori bar

        p = new Point(135,200);
        p1 = new Point(135,305);
        p2 = new Point(150,305);
        p3 = new Point(150,200);
        sp[12] = new SimplePolygon();
        sp[12].addVertex(p);
        sp[12].addVertex(p1);
        sp[12].addVertex(p2);
        sp[12].addVertex(p3);
        //ULM T vert connector

        p = new Point(85,285);
        p1 = new Point(85,305);
        p2 = new Point(220,305);
        p3 = new Point(220,285);
        sp[13] = new SimplePolygon();
        sp[13].addVertex(p);
        sp[13].addVertex(p1);
        sp[13].addVertex(p2);
        sp[13].addVertex(p3);
        //ULM T hori connector

        p = new Point(265,200);
        p1 = new Point(265,305);
        p2 = new Point(285,305);
        p3 = new Point(285,200);
        sp[14] = new SimplePolygon();
        sp[14].addVertex(p);
        sp[14].addVertex(p1);
        sp[14].addVertex(p2);
        sp[14].addVertex(p3);
        //ULM Vert bar

        p = new Point(567,370);
        p1 = new Point(567,393);
        p2 = new Point(717,393);
        p3 = new Point(717,370);
        sp[15] = new SimplePolygon();
        sp[15].addVertex(p);
        sp[15].addVertex(p1);
        sp[15].addVertex(p2);
        sp[15].addVertex(p3);
        //odd T

        p = new Point(500,200);
        p1 = new Point(500,695);
        p2 = new Point(517,695);
        p3 = new Point(517,200);
        sp[16] = new SimplePolygon();
        sp[16].addVertex(p);
        sp[16].addVertex(p1);
        sp[16].addVertex(p2);
        sp[16].addVertex(p3);
        //odd T

        p = new Point(500,565);
        p1 = new Point(500,590);
        p2 = new Point(650,590);
        p3 = new Point(650,565);
        sp[17] = new SimplePolygon();
        sp[17].addVertex(p);
        sp[17].addVertex(p1);
        sp[17].addVertex(p2);
        sp[17].addVertex(p3);
        //odd T

        p = new Point(435,200);
        p1 = new Point(435,610);
        p2 = new Point(450,610);
        p3 = new Point(450,200);
        sp[18] = new SimplePolygon();
        sp[18].addVertex(p);
        sp[18].addVertex(p1);
        sp[18].addVertex(p2);
        sp[18].addVertex(p3);
        //h shape

        p = new Point(267,500);
        p1 = new Point(267,525);
        p2 = new Point(450,525);
        p3 = new Point(450,500);
        sp[19] = new SimplePolygon();
        sp[19].addVertex(p);
        sp[19].addVertex(p1);
        sp[19].addVertex(p2);
        sp[19].addVertex(p3);
        //h shape

        p = new Point(268,500);
        p1 = new Point(268,610);
        p2 = new Point(285,610);
        p3 = new Point(286,500);
        sp[20] = new SimplePolygon();
        sp[20].addVertex(p);
        sp[20].addVertex(p1);
        sp[20].addVertex(p2);
        sp[20].addVertex(p3);
        //h shape

        p = new Point(367,285);
        p1 = new Point(367,392);
        p2 = new Point(385,392);
        p3 = new Point(385,285);
        sp[21] = new SimplePolygon();
        sp[21].addVertex(p);
        sp[21].addVertex(p1);
        sp[21].addVertex(p2);
        sp[21].addVertex(p3);
        //zig zag

        p = new Point(200,370);
        p1 = new Point(200,392);
        p2 = new Point(385,392);
        p3 = new Point(385,370);
        sp[22] = new SimplePolygon();
        sp[22].addVertex(p);
        sp[22].addVertex(p1);
        sp[22].addVertex(p2);
        sp[22].addVertex(p3);
        //zig zag

        p = new Point(200,370);
        p1 = new Point(200,610);
        p2 = new Point(218,610);
        p3 = new Point(218,370);
        sp[23] = new SimplePolygon();
        sp[23].addVertex(p);
        sp[23].addVertex(p1);
        sp[23].addVertex(p2);
        sp[23].addVertex(p3);
        //zig zag

        p = new Point(0,370);
        p1 = new Point(0,393);
        p2 = new Point(150,393);
        p3 = new Point(150, 370);
        sp[24] = new SimplePolygon();
        sp[24].addVertex(p);
        sp[24].addVertex(p1);
        sp[24].addVertex(p2);
        sp[24].addVertex(p3);
        //left wall sticking out big
     
    	while(true)
    	{
    		boolean intersection = false;
    		Thread.sleep(1);
    		for(int i = 0; i < sp[0].getNumberOfVertices(); i++)
    		{
    			sp[0].getVertex(i).translate(v[dir]);
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
        			sp[0].getVertex(i).translate(v[dir].neg()); 
        		}
    			dir = (dir +  Math.abs(r.nextInt(8))) % v.length;

    		}
    		 
    		frame.repaint();
    	}
    	
    }
	
}
