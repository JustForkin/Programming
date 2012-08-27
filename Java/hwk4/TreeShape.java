import java.awt.geom.*;

/**
   A tree shape.
*/
public class TreeShape extends CompoundShape
{
   /**
      Constructs a tree shape.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
   */
   public TreeShape(int x, int y, int width)
   {
      Rectangle2D.Double trunk 
         = new Rectangle2D.Double(x + width/4, y + width, width/2, width*3/2);
      Ellipse2D.Double knot
       	 = new Ellipse2D.Double(x + width/3, y + width * 2, width/4, width/4);

      // branch a
      Point2D.Double a1
         = new Point2D.Double(x + width/4, y + width * 3/2);
      Point2D.Double a2
         = new Point2D.Double(x - width * 1/6, y + width);
      // branch b
      Point2D.Double b1
         = new Point2D.Double(x + width * 3/4, y + width * 6/5);
      Point2D.Double b2
       	= new Point2D.Double(x + width, y + width * 3/4);
      //branch c
      Point2D.Double c1
       	= new Point2D.Double(x + width * 3/4, y + width * 5/3);
	  Point2D.Double c2
	  	 = new Point2D.Double(x + width, y + width * 5/4);

      Line2D.Double branchA
         = new Line2D.Double(a1, a2);
      Line2D.Double branchB
         = new Line2D.Double(b1, b2);
      Line2D.Double branchC
      	 = new Line2D.Double(c1, c2);

      add(trunk);
      add(knot);
      add(branchA);
      add(branchB);
      add(branchC);
   }
}
