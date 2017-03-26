import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.*;
import java.time.*;
//take out implements key listener when rest moved to new panel
public class BeatCounter extends JPanel implements KeyListener
{
   private static final int framex = 1024;
   private static final int framey = 768;
   JButton next, begin;
   private Image image;
   public Dimension size;
   private int buttonPress = 0; //Stores if next or back button is pressed: 0 = none 1 = back 2 = next
   private ArrayList timevals;
   private long start, end;
   private int index = 0;
   private File song;
      
   public BeatCounter()
   {
      timevals = new ArrayList();
      
      this.setLayout(null);
      
       //image = new ImageIcon("background.png").getImage();
      
      begin = new JButton("Start Recording");
      begin.setFont(new Font("Impact", Font.BOLD, 30));
      begin.addActionListener(new BeginListener());
      begin.setEnabled(false);
      next = new JButton("Next");
      next.setFont(new Font("Impact", Font.BOLD, 30));
      next.addActionListener(new NextListener());
      
      size = next.getPreferredSize();
      begin.setBounds(100 + size.width, (framey / 2) - (size.height / 2) - 90, size.width, size.height);
      size = begin.getPreferredSize();
      next.setBounds((framex / 2) - (size.width / 2), 270, size.width, size.height);
      
      add(begin);
      add(next);
   }
   
   public class BeginListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) //sets start time, plays music
      {
         String bip = "bip.mp3";
         Media hit = new Media(new File(bip).toURI().toString());
         MediaPlayer mediaPlayer = new MediaPlayer(hit);
         start = System.nanoTime();
         Duration startTime = Duration.ofNanos(start);
         Duration endTime = Duration.ofNanos(start+2000000000);
         mediaPlayer.setStartTime(startTime);
         mediaPlayer.setStopTime(endTime);
         mediaPlayer.play();
      }
   }
   
   public class NextListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         buttonPress = 2;
      }
   }
   
   public void setFile(File f)
   {
      song = f;
   }
   
   public void paintComponent(Graphics g)
   {
      //g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
   }
   
   public void setButtonPress(int i)
   {
      buttonPress = i;
   }
   
   public int getButtonPress()
   {
      return buttonPress;
   }
   
   public void keyPressed(KeyEvent e)
   {  
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_SPACE)
      {
         end = System.nanoTime();
         timevals.add((Integer)((int)(end-start/Math.pow(10,6))));
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