import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;

/**
 * makes Dot icons
 * @author Michael
 *
 */
public class Dot implements Icon{

	private int rad;
	private Color myColor = Color.RED;
	
	/**
	 * constructs a Dot icon of given radius
	 * @param radius
	 */
	public Dot(int radius)
	{
		rad = radius;
	}
	
	
	
	/**
	 * gets height ie twice the radius
	 * @return height
	 * @Override
	 */
	public int getIconHeight() {
		
		return rad*2;
	}

	/**
	 * gets width ie twice the radius
	 * @return width
	 * @Override
	 */
	public int getIconWidth() {
		
		return rad*2;
	}

	/**
	 * sets color of Dot icon
	 * @param col
	 */
	public void setColor(Color col)
	{
		myColor = col;
	}
	
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Shape s = new Ellipse2D.Double(x, y, rad*2, rad*2);
		g2.setColor(myColor);
		g2.fill(s);
		
	}
	
	

}
