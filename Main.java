import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Main
{
   public static void main(String[] args) throws Exception
   {
      MainMenu main = new MainMenu();
      NewDance nd1 = new NewDance();
      int panel = 1;
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      
      JFrame frame = new JFrame("Dance Master");
      frame.setSize(1024, 768);
      frame.setResizable(false);
      frame.setLocation((int)(screenSize.getWidth()/2 - 1024/2), 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(main);
      frame.setVisible(true);
      
      while(1)
      {
         switch(panel)
         {
            case 1:
               switch(main.getButtonPress())
               {
                  case 1: 
                     frame.setContentPane(nd1);
                     break;
                  default:
                     break;
               }
            case 2:
               switch(nd1.getButtonPress())
               {
                  case 1:
                     frame.setContentPane(main);
                     break;
                  case 2:
                     frame.setContentPane(main);
                     break;
                  default:
                     break;
               }
         }
      }
   }
}