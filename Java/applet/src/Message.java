import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
/**
 * Message class represents a font message that can be displayed.
 * @author Raanan
 *
 */
public class Message {
	/**
	 * Constructor for Message class.
	 * @param message text message that will be displayed. 
	 * @param fontName the name of the font type.
	 * @param fontSize size of font.
	 * @param delay time delay. this is critical to determine the speed that the banner scrolls across the screen with. cannot be zero.
	 */
	public Message(String message, String fontName, int fontSize, int delay){
		//checks for zero delay. if(delay==0) throw new IllegalArgumentException("Delay must be non zero!");
		this.message = message;
		font  = new Font(fontName, Font.PLAIN, fontSize);
		this.delay = delay;
	}
	
	/**
	 * accessor for delay
	 * @return  delay
	 */
	public int getDelay(){
		return delay;
	}
	
	/**
	 * this creates a rectangle the binds the font, and initializes the left edge of the font as the left edge of the rectangle.
	 * @param context this is a FontRenderContext which allows us to get the approximate rectangle that binds the font. 
	 */
	public void setRectangle(FontRenderContext context){
		rectangle = font.getStringBounds(message, context);
		leftEdge = (int) rectangle.getX();
	}
	
	/**
	 * accessor for messages font field.
	 * @return a the font of message.
	 */
	 public Font getFont(){
		 return font;
	 }
	 /**
	  * accesesor for the Ascent of the font 
	  * @return the ascent of a font
	  */
	 public int getAscent(){
		 return (int) rectangle.getY();
	 }
	 
	 /**
	  * calculates and returns the descent of a font.
	  * @return the descent of a font
	  */
	 public int getDescent(){
		 return (int) (rectangle.getHeight()-rectangle.getY());
	 }
	 
	 /**
	  * accessor for leftedge, which is the location of the edge of the font
	  * @return the x location of the left edge of a font. 
	  */
	public int getLeftEdge(){
		return leftEdge;
	}
	
	/**
	 * calculates and returns the right edge of a font
	 * @return the x location of the right edge of a font
	 */
	public int getRightEdge(){
		return (int) (leftEdge+ rectangle.getWidth());
	}
	
	/**
	 * accessor for the height of a font
	 * @return the height
	 */
	public int getHeight(){
		return (int) rectangle.getHeight();
	}
	
	/**
	 * draws a message on a graphic at a given height
	 * @param g graphic to be drawn on
	 * @param height the y location to put the baseline of the font. 
	 */
	 public void drawA(Graphics g, int height){
		 g.setFont(font);
	     g.drawString(message, leftEdge, height);
	 }
	 
	 /**
	  * this method decides what direction the message is moving, and then chooses the appropriate private method to handle it. 
	  * @param width this is the width of the frame, it is important for the calculations i the private methods. 
	  */
	 public void iterateLeftEdge(int width){
		   if(delay>0)  moveLeft( width);
		   else  moveRight( width);
	 }
	 
	 private void moveLeft(int width){
		   leftEdge--;
       //this means that the text is no longer on screen at all. the 
       //the edge is a whole length off the screen.
        if (leftEdge + rectangle.getWidth() < 0) 
           //sets the left edge of message to the right hand edge of the screen
     	   // this means the text is about to re enter the screen from the other side
     	   leftEdge = width;
	 }
	 
	 // just like the move left method, but for the opposite direction
	 private void moveRight(int width){
		   leftEdge++;
        if (leftEdge - width > 0) 
     	   leftEdge = (int) - rectangle.getWidth();
	 }
		private String message;
		private int delay;
		private Font font;
		private Rectangle2D rectangle;
		private int leftEdge;
		boolean overlap;
}
