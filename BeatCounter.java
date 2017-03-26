import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javafx.scene.media.Media;
import java.util.*;
//take out implements key listener when rest moved to new panel
public class BeatCounter extends JPanel implements KeyListener
{
   private static final int framex = 1024;
   private static final int framey = 768;
   JButton next, back, select;
   private Image image;
   public Dimension size;
   private int buttonPress = 0; //Stores if next or back button is pressed: 0 = none 1 = back 2 = next
   private ArrayList timevals;
   private long start, end;
   private int index = 0;
   File song;
      
   public BeatCounter()
   {
      //move this to new panel later
      timevals = new ArrayList();
      
      this.setLayout(null);
      
       //image = new ImageIcon("background.png").getImage();
      
      next = new JButton("Start Recording");
      next.setFont(new Font("Impact", Font.BOLD, 30));
      next.addActionListener(new NextListener());
      next.setEnabled(false);
      
      back = new JButton("Next");
      back.setFont(new Font("Impact", Font.BOLD, 30));
      back.addActionListener(new BackListener());
      
      size = next.getPreferredSize();
      next.setBounds(100 + size.width, (framey / 2) - (size.height / 2) - 90, size.width, size.height);
      size = back.getPreferredSize();
      back.setBounds((framex / 2) - (size.width / 2), 270, size.width, size.height);
      size = select.getPreferredSize();
      select.setBounds((framex / 2) - (size.width / 2), (framey / 2) - (size.height / 2), size.width, size.height);
      
      add(next);
      add(back);
      add(select);
   }
   
   public class NextListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         buttonPress = 2;
      }
   }
   
   public class BackListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         buttonPress = 1;
      }
   }
   
   public void paintComponent(Graphics g)
   {
      //g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
   }
   
   public File getSongFile()
   {
      return song;
   }
   
   public void setButtonPress(int i)
   {
      buttonPress = i;
   }
   
   public int getButtonPress()
   {
      return buttonPress;
   }
   
   //button press event (move to new panel later)
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_SPACE)
      {
         //set start b4
         end = System.nanoTime();
         timevals.add(end-start);
         start = System.nanoTime();
      }   
   }
   public void keyReleased(KeyEvent e)
   {
   }
   public void keyTyped(KeyEvent e)
   {
   }
}