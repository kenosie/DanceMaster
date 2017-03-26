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
   }
}

/*
to do:
display dance moves over music
display next move coming up in corner
https://www.google.com/search?q=get+numberical+values+from+wav+file&ie=utf-8&oe=utf-8
*/