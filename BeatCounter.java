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
import javafx.util.*;
import java.util.*;;

//take out implements key listener when rest moved to new panel
public class BeatCounter extends JPanel implements KeyListener
{
   private static final int framex = 1024;
   private static final int framey = 768;
   JButton back, next, begin;
   private Image image;
   public Dimension size;
   private int buttonPress = 0; //Stores if next or back button is pressed: 0 = none 1 = back 2 = next
   public static ArrayList timevals;
   private long start, end;
   private int index = 0;
   private File song;
      
   public BeatCounter()
   {
      timevals = new ArrayList();
      
      this.setLayout(null);
      
       //image = new ImageIcon("background.png").getImage();
      
      begin = new JButton("Start Recording");
      begin.setFont(new Font("Corbel", Font.BOLD, 30));
      begin.addActionListener(new BeginListener());
      begin.setEnabled(false);
      
      next = new JButton("Next");
      next.setFont(new Font("Corbel", Font.BOLD, 30));
      next.addActionListener(new NextListener());
      
      back = new JButton("Back");
      back.setFont(new Font("Corbel", Font.BOLD, 30));
      back.addActionListener(new BackListener());
      
      size = begin.getPreferredSize();
      begin.setBounds((framex / 2) - (size.width / 2), (framey / 2) - (size.height / 2), size.width, size.height);
      size = back.getPreferredSize();
      back.setBounds(100, framey - size.height - 100, size.width, size.height);
      size = next.getPreferredSize();
      next.setBounds(framex - size.width - 100, framey - size.height - 100, size.width, size.height);
      
      add(next);
      add(back);
      add(begin);
   }
   
   public class BeginListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) //sets start time, plays music
      {
         String songFile = song.toString();
         Media hit = new Media(songFile.toURI().toString());
         MediaPlayer mediaPlayer = new MediaPlayer(hit);
         start = System.nanoTime();
         mediaPlayer.setStartTime(Duration.millis((double)(start/Math.pow(10,6))));
         mediaPlayer.setStopTime(Duration.millis((double)((start+2000000000)/Math.pow(10,6))));
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
   
   public class BackListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         buttonPress = 1;
      }
   }
   
   public void setSongFile(File f)
   {
      song = f;
   }
   
   public void paintComponent(Graphics g)
   {
      g.clearRect(0, 0, framex, framey);
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
   
   public long getBPM()
   {
      long sum = 0;
      for(int i=0;i<timevals.size();i++)
      {
         sum += ((long)timevals.get(i));
      }
      return sum/timevals.size();
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