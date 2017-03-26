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
public class NewDance extends JPanel implements KeyListener
{
   private static final int framex = 1024;
   private static final int framey = 768;
   JButton next, back, select;
   public Dimension size;
   private int buttonPress = 0; //Stores if next or back button is pressed: 0 = none 1 = back 2 = next
   private ArrayList timevals;
   private int start, end;
      
   public NewDance()
   {
      //move this to new panel later
      timevals = new ArrayList();
      
      File song;
      
      next = new JButton("Next");
      next.setFont(new Font("Impact", Font.BOLD, 30));
      next.addActionListener(new NextListener());
      
      back = new JButton("Back");
      back.setFont(new Font("Impact", Font.BOLD, 30));
      back.addActionListener(new BackListener());
      
      select = new JButton("Select Song");
      select.setFont(new Font("Impact", Font.BOLD, 30));
      select.addActionListener(new BackListener());
      
      size = next.getPreferredSize();
      next.setBounds(100 + size.width, (framey / 2) - (size.height / 2) - 90, size.width, size.height);
      size = back.getPreferredSize();
      back.setBounds((framex / 2) - (size.width / 2), 270, size.width, size.height);
      size = select.getPreferredSize();
      select.setBounds((framex / 2) - (size.width / 2), (framey / 2) - (size.height / 2), size.width, size.height);
      
      add(next);
      add(back);
      add(select);
      
      JButton selectSong = new JButton("Select"); //Select button in window
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new java.io.File("C:/"));
      fc.setDialogTitle("Select Song File");
      FileNameExtensionFilter filter = new FileNameExtensionFilter("MPEG-I Layer 3 (*.mp3)", "mp3"); //sets filter for mp3 files
      fc.setFileFilter(filter);
      fc.setFileSelectionMode(JFileChooser.FILES_ONLY); //Opens the file selector that only lets you pick mp3 files
      
      while(buttonPress == 0) //until user selects valid file or clicks on back button
      {
         if(fc.showOpenDialog(selectSong) == JFileChooser.APPROVE_OPTION)
         {
            song = fc.getSelectedFile();
            break;
         }
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
      }
   }
   public void keyReleased(KeyEvent e)
   {
   }
   public void keyTyped(KeyEvent e)
   {
   }
}