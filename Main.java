import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Main
{
   public static void main(String[] args) throws Exception
   {
      MainMenu main = new MainMenu();
      NewDance nd1 = new NewDance();
      int panel = 1; //Stores what panel it's on; 1 = MainMenu 2 = NewDance 3 = BeatTap 4 = ViewDance
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      
      JFrame frame = new JFrame("Dance Master");
      frame.setSize(1024, 768);
      frame.setResizable(false);
      frame.setLocation((int)(screenSize.getWidth()/2 - 1024/2), 0);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(main);
      frame.setVisible(true);
      
      while(true)
      {
         if(panel == 1)
         {
            switch(main.getButtonPress())
            {
               case 2: 
               frame.setVisible(false);
               frame.setContentPane(nd1);
                  panel = 2;
                  main.setButtonPress(0);
                  frame.setVisible(true);
                  break;
               default:
                  break;
            }
         }
         else if(panel == 2)
         {
            switch(nd1.getButtonPress())
            {
               case 1:
                  frame.setVisible(false);
                  frame.setContentPane(main);
                  nd1.setButtonPress(0);
                  panel = 1;
                  frame.setVisible(true);
                  break;
               case 2:
               frame.setVisible(false);
                  frame.setContentPane(main);
                  nd1.setButtonPress(0);
                  panel = 1;
                  frame.setVisible(true);
                  break;
               default:
                  break;
            }
         }
      }
   }
}