import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class MainMenu extends JPanel
{
   private static final int framex = 1024;
   private static final int framey = 768;
   private Image image;
   private Graphics myBuffer;
   private Boolean inMainMenu = true;
   public Dimension newDanceSize, quitSize, size, size2;
   int buttonPress = 0; //1 = MainMenu Panel 2 = New Dance
   public MainMenu()
   {
      this.setLayout(null);
      
      //image = new ImageIcon("background.png").getImage();
      
      JLabel title = new JLabel("Dance Master");
      title.setForeground(Color.WHITE);
      title.setFont(new Font("Impact", Font.BOLD, 30));
      
      JButton newDance = new JButton("New Dance");
      newDance.setFont(new Font("Impact", Font.BOLD, 30));
      newDance.addActionListener(new NewDanceListener());
      
      JButton quit  = new JButton("Quit");
      quit.setFont(new Font("Impact", Font.BOLD, 30));
      quit.addActionListener(new QuitListener());
      
      size = title.getPreferredSize();
      title.setBounds((framex / 2) - (size.width / 2), 90, size.width, size.height);
      newDanceSize = newDance.getPreferredSize();
      newDance.setBounds((framex / 2) - (newDanceSize.width / 2), 270, newDanceSize.width, newDanceSize.height);
      quitSize = quit.getPreferredSize();
      quit.setBounds((framex / 2) - (quitSize.width / 2), 670, quitSize.width, quitSize.height);
      
      add(title);
      add(newDance);
      add(quit);
   }
   
   public int getButtonPress()
   {
      return buttonPress;
   }
   
   public void setButtonPress(int b )
   {
      buttonPress = b;
   }
   
   public void paintComponent(Graphics g)
   {
      //g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
   }
         
   private class NewDanceListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         buttonPress = 2;
      }
   }
   
   private class QuitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
}