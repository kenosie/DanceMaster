import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

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
   }
}