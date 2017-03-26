import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.runtime.windows.WindowsCanvas;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class DispRes extends JPanel
{
   private static final int framex = 768;
   private static final int framey = 1024;
   private Image image;
   private Graphics myBuffer;
   private Boolean inMainMenu = true;
   public Dimension newDanceSize, quitSize, size, size2;
   int buttonPress = 0; //1 = MainMenu Panel 2 = New Dance
   public DispRes()
   {
      //create canvas, add to panel
      WindowsCanvas canvas = new WindowsCanvas();
      panel.add(canvas);
      panel.revalidate();
      panel.repaint();
      
      //create media player
      MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
      EmbeddedMediaPlayer mediaPlayer = new EmbeddedMediaPlayer();
      CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas);
      mediaPlayer.setVideoSurface(videoSurface);
      
      long sum = 0;
      for(i=0;i<BeatCounter.timevals.size();i++)
      {
         sum+=BeatCounter.timevals.get(i);
      }
      long avg = sum/BeatCounter.timevals.size();
      
      //mediaPlayer.playMedia("lmao.mp4");
      
      //String bip = "bip.mp3";
      //Media hit = new Media(new File(bip).toURI().toString());
      //MediaPlayer mediaPlayer = new MediaPlayer(hit);
      //mediaPlayer.play();
   }
}
   
/*
to do:
display dance moves over music
display next move coming up in corner

*/