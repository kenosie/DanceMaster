import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.*;
import javafx.scene.*;

public class DispRes extends JPanel
{
   private static final int framex = 1024;
   private static final int framey = 768;
   private Image image;
   private int bpm;
   private Graphics myBuffer;
   private Boolean inMainMenu = true;
   public Dimension newDanceSize, quitSize, size, size2;
   int buttonPress = 0; //1 = MainMenu Panel 2 = New Dance
   public DispRes()
   {      
      // JFrame clipPlayer = new JFrame("Dance Clip");
   //       clipPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //       MediaPlayer mediaPanel = new MediaPlayer();
   //       clipPlayer.add(mediaPanel);
   //       clipPlayer.setSize(800,700);
   //       clipPlayer.setLocationRelativeTo(null);
   //       clipPlayer.setVisible(true);
      //mediaPlayer.playMedia("lmao.mp4");
      
      //String bip = "bip.mp3";
      //Media hit = new Media(new File(bip).toURI().toString());
      //MediaPlayer mediaPlayer = new MediaPlayer(hit);
      //mediaPlayer.play();
      
      Stage s = new Stage();
      s.setTitle("Dance Sequence");
      Group root = new Group();
      int rand = ((int)Math.random() * 3 + 1);
      Media media = new Media(new File(rand + ".avi").toURI().toString());
      MediaPlayer mediaPlayer = new MediaPlayer(media);
      mediaPlayer.play();
      
      MediaView mediaView = new MediaView(mediaPlayer);
   
      root.getChildren().add(mediaView);
      Scene scene = SceneBuilder.create().width(framex).height(framey).root(root).build();
      s.setScene(scene);
      s.show();
   }
   
   public void setBPM(long l)
   {
      bpm = (int)(l);
   }
   
   public int getButtonPress()
   {
      return buttonPress;
   }
   
   public void setButtonPress(int i)
   {
      buttonPress = i;
   }
}
   
/*
to do:
display dance moves over music
display next move coming up in corner

*/