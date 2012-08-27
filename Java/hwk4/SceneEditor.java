import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A program that allows users to edit a scene composed
   of items.
*/
public class SceneEditor
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      final SceneComponent scene = new SceneComponent();

      JButton houseButton = new JButton("House");
      houseButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               scene.add(new HouseShape(20, 20, 50));
            }
         });
      
      JButton treeButton = new JButton("Tree");
      treeButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               scene.add(new TreeShape(20, 20, 50));
            }
         });
      
      JButton faceButton = new JButton("Face");
      faceButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               scene.add(new FaceShape(20, 20, 50));
            }
         });

      JButton carButton = new JButton("Car");
      carButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               scene.add(new CarShape(20, 20, 50));
            }
         });

      JButton removeButton = new JButton("Remove");
      removeButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               scene.removeSelected();
            }
         });

      JPanel buttons = new JPanel();
      buttons.add(houseButton);
      buttons.add(carButton);
      buttons.add(treeButton);
      buttons.add(faceButton);
      buttons.add(removeButton);
     

      frame.add(scene, BorderLayout.CENTER);
      frame.add(buttons, BorderLayout.NORTH);

      frame.setSize(600, 600);
      frame.setVisible(true);
   }
}


