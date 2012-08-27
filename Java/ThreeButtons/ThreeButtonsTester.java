import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Paints a dot (default color red) and makes 3 buttons which can change it's color (r/g/b)
 * @author Michael
 *
 */
public class ThreeButtonsTester{
	
	public static void main(String[] args)
	{
		//make icon and put it in label
		final Dot myDot = new Dot(40);
		final JLabel myLabel = new JLabel(myDot);
		
		//make frame and 3 buttons
		final JFrame myFrame = new JFrame("Click a button!");
		
		final JButton redButton = new JButton("Red");
		final JButton greenButton = new JButton("Green");
		final JButton blueButton = new JButton("Blue");
		
		//set layout of frame and put buttons and icon label in it
		myFrame.setLayout(new FlowLayout());
		
		myFrame.add(redButton);
		myFrame.add(greenButton);
		myFrame.add(blueButton);
		myFrame.add(myLabel);
		
		//things you need for Frame
		myFrame.pack();
		myFrame.setVisible(true);
		
		myFrame.setSize(400,200);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//actions listeners for 3 buttons
		redButton.addActionListener(new
			ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				myDot.setColor(Color.RED);
				myLabel.repaint();
			}
		});
		
		greenButton.addActionListener(new
			ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				myDot.setColor(Color.GREEN);
				myLabel.repaint();
			}
		});
		
		blueButton.addActionListener(new
			ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				myDot.setColor(Color.BLUE);
				myLabel.repaint();
			}
		});
		
	

	}
}
