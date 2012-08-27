/**
 * 
 */
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * @author Michael
 *
 */
public class guiTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JFrame myFrame = new JFrame("my title");
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setSize(400,200);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLayout(new GridBagLayout());
		
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		
		final JLabel myLabel = new JLabel("hi");
		
		
		button1.addActionListener(new 
				ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				myLabel.setText("bye");
				myLabel.setOpaque(true);
				myLabel.setBackground(new Color(255,9,9));
			}
		});
		
		button2.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				myLabel.setText("yo");
				myLabel.setOpaque(true);
				myLabel.setBackground(new Color(31,61,117));
				
			}
		});
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.ipadx=1;
		c.ipady=1;
		GridBagConstraints d = new GridBagConstraints();
		d.gridx=1;
		d.gridy=0;
		d.ipadx=1;
		d.ipady=1;
		GridBagConstraints e = new GridBagConstraints();
		e.fill=GridBagConstraints.HORIZONTAL;
		e.gridx=0;
		e.gridy=1;
		e.ipadx=1;
		e.ipady=1;
		
		myFrame.add(button1, c);
		myFrame.add(button2, d);
		myFrame.add(myLabel, e);
		
		
		
		
	}

}
