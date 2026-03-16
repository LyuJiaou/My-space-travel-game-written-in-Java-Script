import java.awt.*; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.geom.*;

@SuppressWarnings("serial")

public class alternativesUniversum extends JPanel {
   private static final int OVAL_WIDTH = 20;
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private int x = 0;
   private int y = 0;

   public alternativesUniversum() {
      addKeyBindings();
   }

   private void addKeyBindings() {
      InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
      ActionMap actionMap = getActionMap();

      KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(0, 50));

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(0, -50));

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(50, 0));

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(-50, 0));
   }

   @Override
   protected void paintComponent(Graphics g) {
      setBackground(new Color(0, 0 ,0 )); // use variable and if loop to change the color of the background gradually
      
      int Punktmin = -4000;
      int Punktmax = 4000;
      for (int i = 0; i <12000 ; i++) {
         int Punktx = ThreadLocalRandom.current().nextInt(Punktmin, Punktmax);
         int Punkty = ThreadLocalRandom.current().nextInt(Punktmin, Punktmax);
         g.setColor(new Color(200, 200, 200));
         g.fillRect(Punktx, Punkty, 1, 1);
         g.drawRect(Punktx, Punkty, 1, 1);
     }
     
     Graphics2D g2 = (Graphics2D) g;
     g2.setColor(new Color(100, 100, 100));
     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

     // use if loop here to decide whether the rocket should move or not 


     // Rakete 🚀
     // Rakete Variablen:


     g2.drawArc(940, 700, 40, 130, 0, 180);
     g2.drawLine(940, 765, 940, 930); // Körper 
     g2.drawLine(980, 765, 980, 930); // Körper // how to fill this with color???
     g2.drawLine(940, 930, 980, 930); // Körper

     // left wing 
     g2.drawLine(920, 730, 945, 720);
     g2.drawLine(920, 730, 920, 755);
     g2.drawLine(920, 755, 940, 755);

     // right wing
     g2.drawLine(1000, 730, 975, 720);
     g2.drawLine(1000, 730, 1000, 755);
     g2.drawLine(1000, 755, 980, 755);
     

     // Feuer der Rakete 🔥
     /* 
     for(int i; i < 20; i++){
         int maxx = 
         int minx =
         int maxy = 
         int miny =
         int maxl = 
         int minl = 
         int maxb =
         int minb = 
         int generiert
         g2.drawOval()
     }*/
     


     // Launch-turm // use if to control the arm of the lauch-turm
                

      



     g2.fillRect(x, y, OVAL_WIDTH, OVAL_WIDTH); 
   }



   
   
   
   // ... 
   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class MyAction extends AbstractAction {
      private int xDirection;
      private int yDirection;

      public MyAction(int xDirection, int yDirection) {
         this.xDirection = xDirection;
         this.yDirection = yDirection;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         x += xDirection;
         y += yDirection;
         repaint();
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("alternatives Universum 🛸");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new SpaceX());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      frame.setSize(1920, 1080);

   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}



    