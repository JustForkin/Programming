import java.awt.geom.*;

/**
   A face shape.
*/
public class FaceShape extends CompoundShape
{
   /**
      Constructs a face shape.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public FaceShape(int x, int y, int width)
   {
	   
	   Ellipse2D.Double head 
       = new Ellipse2D.Double(x, y + width, width, width);
	   
	   Ellipse2D.Double eye1 
       = new Ellipse2D.Double(x + width/4, y + width*5/4, width/5, width/5);
	   Ellipse2D.Double eye2 
       = new Ellipse2D.Double(x + width*2/4, y + width*5/4, width/5, width/5);

	   Ellipse2D.Double nose 
       = new Ellipse2D.Double(x + width*4/9, y + width*6/4, width/9, width/9);
	   
	   Point2D.Double a
	   = new Point2D.Double(x + width * 6/9, y + width * 16/9);
	   Point2D.Double b
	   = new Point2D.Double(x + width * 3/9, y + width * 16/9);
	   Line2D.Double mouth
	   = new Line2D.Double(a, b);
     
      add(head);
      add(eye1);
      add(eye2);
      add(nose);
      add(mouth);
      
   }
}
