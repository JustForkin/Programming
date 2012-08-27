// this code is taken from the support materials of http://www.horstmann.com/design_and_patterns.html
//by Cay Horstmann
//edited by raanan cohen

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import javax.swing.*;
/**
 * this class is an applet that displays a banner of two fonts that run across the banner. 
 * the second font jumps over the first font, when there are about to overlap.
 * this class extends the Applet class and defines the init, start, stop, and paint methods.
 * @author Raanan
 *
 */
public class BannerApplet extends Applet {
	/*
	 * *(non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	
	public void init()
	   {
	      Graphics2D g2 = (Graphics2D) this.getGraphics();
	      FontRenderContext context = g2.getFontRenderContext();
	      //Instantiate two objects of the Message class
		  message1 = new Message(getParameter("message1"), getParameter("fontname1"), 
				  Integer.parseInt(getParameter("fontsize1")), Integer.parseInt(getParameter("delay1")));
	      message2 = new Message(getParameter("message2"), getParameter("fontname2"), 
	    		  Integer.parseInt(getParameter("fontsize2")), Integer.parseInt(getParameter("delay2")));
	      //this is the a 1/ratio  is the fraction of the height that the baseline of fonts will be. 
	      ratio = Integer.parseInt(getParameter("YPositionRatio"));
	      //add the rectangle bounds to the two objects
	      message1.setRectangle(context);
	      message2.setRectangle(context);
	    
	      //used two timers because each can take one delay as input. 
	      //an alternative to this would be to use one listener and two ratios of motion. so they are still able to move at different rates
	      //Implementing this code may be shorter, but harder to understand. 
	      //checked the same time, but when the move them more at different rates. 
	      timer1 = new Timer(Math.abs(message1.getDelay()), new
	        //Anonymous  class  
	    	ActionListener()
	         {
	            public void actionPerformed(ActionEvent event)
	            {
	            	//this method interates and keeps track of where the edge of the rectangle would be if it surrounded the font. 
					message1.iterateLeftEdge(getWidth());
					repaint();
	            }
	         });//end of timer1
	   
	      //second timer
	     timer2 = new Timer(Math.abs(message2.getDelay()), new
	 	         ActionListener()
	 	         {
	 	            public void actionPerformed(ActionEvent event)
	 	            {
	 	            	
						//this method iterates the leftEdge of the rectangle properly. 
	 	            	message2.iterateLeftEdge(getWidth());
						//this inequality checks for overlap of the rectangles in the x direction. 
	 	            	//since they are in the same y value, they always collide if they overlap in the x. 
						if (message2.getLeftEdge()< message1.getRightEdge() && message2.getRightEdge()>message1.getLeftEdge()){
							//if there is overlap, then the second message needs to climb over the first one. this is the height of the base - the 
							//height of the font
							height2 = height1 - message1.getHeight();// 
						}
						//if not, leave it in the line that it began in. 
						else{
							height2 = height1;
						}
						repaint();
	 	            }
	 	         });//end of timer2
	   }//end of init()
	   
		/*
		 * (non-Javadoc)
		 * @see java.applet.Applet#start()
		 */

	   public void start()
	   {
	      timer1.start();
	      timer2.start();
	   }
	   
	   /*
	    * (non-Javadoc)
	    * @see java.applet.Applet#stop()
	    */
	   public void stop()
	   {
		  timer1.stop();
		  timer2.stop();
	   }
	   /*
	    * (non-Javadoc)
	    * @see java.awt.Container#paint(java.awt.Graphics)
	    */
	   public void paint(Graphics g)
	   {
		   //height of the first message
		  height1 =  (getHeight()/ratio);
		 //red for a change
		  g.setColor(Color.RED);
		  //get font from message
		  g.setFont(message1.getFont());
		  //can avoid parameter passing by using class defined draw method, rather than passing all the parameters into the g.drawString
		  message1.drawA(g,height1);
	      g.setFont(message2.getFont());
	      message2.drawA(g,height2);
	   }
	   private static int ratio;
	   private Message message1;
	   private Message message2;
	   private Timer timer1;
	   private Timer timer2;
	   private int height1;
	   private int height2;
}



