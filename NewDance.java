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
   JLabel songName;
   private Image image;
   public Dimension size;
   private int buttonPress = 0; //Stores if next or back button is pressed: 0 = none 1 = back 2 = next -1 = file selected
   private ArrayList timevals;
   private int start, end;
   File song;
   Boolean selection = false;
      
   public NewDance()
   {
      //move this to new panel later
      timevals = new ArrayList();
      
      this.setLayout(null);
      
       //image = new ImageIcon("background.png").getImage();
      
      next = new JButton("Next");
      next.setFont(new Font("Corbel", Font.BOLD, 30));
      next.addActionListener(new NextListener());
      next.setEnabled(false);
      
      back = new JButton("Back");
      back.setFont(new Font("Corbel", Font.BOLD, 30));
      back.addActionListener(new BackListener());
      
      select = new JButton("Select Song");
      select.setFont(new Font("Corbel", Font.BOLD, 30));
      select.addActionListener(new SelectListener());
      
      songName = new JLabel("No File Selected");
      songName.setFont(new Font("Corbel", Font.PLAIN,  15));
      
      size = back.getPreferredSize();
      back.setBounds(50 + (size.width / 2), framey - (size.height / 2) - 100, size.width, size.height);
      size = next.getPreferredSize();
      next.setBounds(framex - (size.width * 3 / 2) - 50, framey - (size.height / 2) - 100, size.width, size.height);
      size = select.getPreferredSize();
      select.setBounds((framex / 2) - (size.width / 2), (framey / 2) - (size.height / 2), size.width, size.height);
      size = songName.getPreferredSize();
      songName.setBounds((framex / 2) - (size.width / 2), (framey / 2) + (size.height * 3 / 2), size.width, size.height);
      
      add(next);
      add(back);
      add(select);
      add(songName);
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
   
   public class SelectListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JButton selectSong = new JButton("Select"); //Select button in window
         JFileChooser fc = new JFileChooser();
         fc.setCurrentDirectory(new java.io.File("C:/"));
         fc.setDialogTitle("Select Song File");
         FileNameExtensionFilter filter = new FileNameExtensionFilter("MPEG-I Layer 3 (*.mp3)", "mp3"); //sets filter for mp3 files
         fc.setFileFilter(filter);
         fc.setFileSelectionMode(JFileChooser.FILES_ONLY); //Opens the file selector that only lets you pick mp3 files
         
         selection = fc.showOpenDialog(selectSong) == JFileChooser.APPROVE_OPTION;
         
         if(selection)
         {
            song = fc.getSelectedFile();
            String songText = song.getAbsolutePath();
            
            
            
            songText = songText.substring(songText.lastIndexOf("\\") + 1, songText.lastIndexOf("."));
            songName.setText("Song Selected: " + songText);
            size = songName.getPreferredSize();
            songName.setBounds((framex / 2) - (size.width / 2), (framey / 2) + (size.height * 3 / 2), size.width, size.height);
            next.setEnabled(true);
            
            repaint();
         }
      }
   }
   
   public void paintComponent(Graphics g)
   {
      g.clearRect(0, 0, framex, framey);
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
      }
   }
   public void keyReleased(KeyEvent e)
   {
   }
   public void keyTyped(KeyEvent e)
   {
   }
}