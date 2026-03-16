import java.awt.*; 
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;


@SuppressWarnings("serial")
public class SpaceX extends JPanel {

   private static final int OVAL_WIDTH = 20;
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;

   // die wichtigste Variablen
   private int x = 0;
   private int y = 0;

   public SpaceX() {
      addKeyBindings();
   }

   // Key Event settings
   private void addKeyBindings() {
      InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
      ActionMap actionMap = getActionMap();

      KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0); // press up y + 50
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(0, 50));

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0); // press down y - 50
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(0, -50)); 

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0); // press left x + 50
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(50, 0));

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0); // press right x - 50
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(-50, 0));
   }

   // Graphics
   @Override
   protected void paintComponent(Graphics g) {

      Font Regeln = new Font("TimesRoman", Font.PLAIN, 18);
      g.setColor(new Color(231, 123, 21));
      g.setFont(Regeln);
      g.drawString("Hallo, willkommen zu diesem Universum", x + 1200, y + 200);
      g.drawString("Sonne: (-1750, 73800)", x + 1200, y + 220);
      g.drawString("Mars: (19750, -1200)", x + 1200, y + 240);
      g.drawString("Mond: (500, 1850)", x + 1200, y + 260);
      g.drawString("schwarzes Loch: (-2???, -?3??)", x + 1200, y + 280);
      g.drawString("Ziel: Die Flecken von Sonne beobachten", x + 1200, y + 300);
      g.drawString("Mehr Sachen kann in diesen Universum hinzugefügt werden", x + 1200, y + 320);

      // Hintergrundfarbeaederung

      /*setBackground(new Color(204, 229, 255));*/
      setBackground(new Color(0, 0, 0));

/* 
      // Farbeänderung, wenn mann von Erde weg fährt
      // dritte Kuadrante
      if(x > 1500 || y < -900){
         setBackground(new Color(160, 170, 200));
         if(x > 1650 || y < -1050){
            setBackground(new Color(120, 135, 150));
            if(x > 1800 || y < -1300){
               setBackground(new Color(80, 90, 100));
               if(x > 1950 || y < -1450){
                  setBackground(new Color(40, 45, 50));
                  if(x > 2100 || y < -1600){
                     setBackground(new Color(0,0,0));
                  }
               }
            }
         }
      }

      // zweite Kuadrante
      if(x > 1500 || y > 150){
         setBackground(new Color(160, 170, 200));
         if(x > 1650 || y > 300){
            setBackground(new Color(120, 135, 150));
            if(x > 1800 || y > 450){
               setBackground(new Color(80, 90, 100));
               if(x > 1950 || y > 600){
                  setBackground(new Color(40, 45, 50));
                  if(x > 2100 || y > 750){
                     setBackground(new Color(0,0,0));
                  }
               }
            }
         }
      }

      // vierte Kuadrante
      if(x < -1500 || y < -900){
         setBackground(new Color(160, 170, 200));
         if(x < -1650 || y < -1050){
            setBackground(new Color(120, 135, 150));
            if(x < -1800 || y < -1300){
               setBackground(new Color(80, 90, 100));
               if(x < -1950 || y < -1450){
                  setBackground(new Color(40, 45, 50));
                  if(x < -2100 || y < -1600){
                     setBackground(new Color(0,0,0));
                  }
               }
            }
         }
      }
      
      // erste Kuadrante
      if(x < -1500 || y > 150){
         setBackground(new Color(160, 170, 200));
         if(x < -1650 || y > 300){
            setBackground(new Color(120, 135, 150));
            if(x < -1800 || y > 450){
               setBackground(new Color(80, 90, 100));
               if(x < -1950 || y > 600){
                  setBackground(new Color(40, 45, 50));
                  if(x < -2100 || y > 750){
                     setBackground(new Color(0,0,0));
                  }
               }
            }
         }
      }
*/
      // Background points
      int Punktmin = -4000;
      int Punktmax = 4000;
      for (int i = 0; i < 12000 ; i++) {
         int Punktx = ThreadLocalRandom.current().nextInt(Punktmin, Punktmax);
         int Punkty = ThreadLocalRandom.current().nextInt(Punktmin, Punktmax);
         g.setColor(new Color(200, 200, 200));
         g.fillRect(Punktx, Punkty, 1, 1);
         g.drawRect(Punktx, Punkty, 1, 1);
      }
     
     Graphics2D g2 = (Graphics2D) g;
     g2.setColor(new Color(100, 100, 100));
     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

     // Rakete 🚀
     // Rakete Variablen:
     g2.setColor(new Color(124, 121, 118));
     g2.drawArc(940, 700, 40, 130, 0, 180);
     g2.fillArc(940, 700, 40, 130, 0, 180);
     int xPoly[] = {940, 940, 980, 980};
     int yPoly[] = {765, 930, 930, 765};
     g2.drawPolygon(xPoly, yPoly, xPoly.length);
     g2.fillPolygon(xPoly, yPoly, xPoly.length);

     // left wing 
     int xPolyl[] = {925, 950, 940, 925};
     int yPolyl[] = {740, 720, 755, 755};
     g2.fillPolygon(xPolyl, yPolyl, xPoly.length);

     // right wing
     int xPolyr[] = {995, 970, 980, 995};
     int yPolyr[] = {740, 720, 755, 755};
     g2.fillPolygon(xPolyr, yPolyr, xPoly.length);

//Unten
      // left wing 
     int listleftwingx[] = {940, 925, 925, 940};
     int listleftwingy[] = {870, 880, 926, 926};
     g2.fillPolygon(listleftwingx, listleftwingy, xPoly.length);
 
     
     // right wing
     int listrightwingx[] = {980, 995, 995, 980};
     int listrighttwingy[] = {870, 880, 926, 926};
     g2.fillPolygon(listrightwingx, listrighttwingy, xPoly.length);

     

     // Feuer der Rakete 🔥
     g.setColor(new Color(240, 59, 11));
     for(int i = 0; i < 80; i++){
      int richtung = ThreadLocalRandom.current().nextInt(0, 2);
      if (richtung == 0) {  // rechts
         int maxx = 975;
         int minx = 965;
         int maxheight = 150;
         int minheight = 45;
         int maxweidth = 20;
         int minweidth = 5;
         int randomxcoordinate = ThreadLocalRandom.current().nextInt(minx, maxx);
         int randomheight = ThreadLocalRandom.current().nextInt(minheight, maxheight);
         int randomweidth = ThreadLocalRandom.current().nextInt(minweidth, maxweidth);
         g2.drawArc(randomxcoordinate, 910, randomweidth, randomheight, 180, 80);
      }
      if (richtung == 1) { //links
         int maxx = 940;
         int minx = 937;
         int maxheight = 150;
         int minheight = 45;
         int maxweidth = 20;
         int minweidth = 5;
         int randomxcoordinate = ThreadLocalRandom.current().nextInt(minx, maxx);
         int randomheight = ThreadLocalRandom.current().nextInt(minheight, maxheight);
         int randomweidth = ThreadLocalRandom.current().nextInt(minweidth, maxweidth);
         g2.drawArc(randomxcoordinate, 910, randomweidth, randomheight, 280, 80);
         }

      int xishibianliang = ThreadLocalRandom.current().nextInt(0, 3);
      if (xishibianliang == 1){
         int maxx = 970;
         int minx = 952;
         int h = ThreadLocalRandom.current().nextInt(70, 250);
         int randomxcoordinate = ThreadLocalRandom.current().nextInt(minx, maxx);
         g2.drawLine(randomxcoordinate, 935, randomxcoordinate, 908 + h);
      }
         
     }
     
     // Launch-turm // use if to control the arm of the lauch-turm

     // Sonne 
      g.setColor(new Color(234, 77, 23)); 
      g.fillOval(-5000 + x, -77500 + y, 5000, 5000); // Position der Sonne (-5000, 12000)
      g.drawOval(-5000 + x, -77500 + y, 5000, 5000);


      // Flecken von Sonne durch random
      for (int i = 0; i < 50000 ; i++) {
         int maximum = 2500;
         int minimum = -2500;

         // Koordinaten von orangen Flecken
         int xcoordinate = ThreadLocalRandom.current().nextInt(minimum, maximum);
         int ycoordinate = ThreadLocalRandom.current().nextInt(minimum, maximum);

         // Koordinaten von heilen Flecken
         int xcoordinatew = ThreadLocalRandom.current().nextInt(minimum, maximum);
         int ycoordinatew = ThreadLocalRandom.current().nextInt(minimum, maximum);

         int maw = 20;
         int miw = 2;
         int mah = 15;
         int mih = 1;

         // orange
         int wvonflecken = ThreadLocalRandom.current().nextInt(miw, maw);
         int hvonflecken = ThreadLocalRandom.current().nextInt(mih, mah);

         // heile
         int wvonwflecken = ThreadLocalRandom.current().nextInt(miw, maw - 5);
         int hvonwflecken = ThreadLocalRandom.current().nextInt(mih, mah - 5);

         int mar = 238;
         int mir = 210;
         int mag = 252;
         int mig = 106;
         int mab = 69;
         int mib = 46;

         // Flecken (zu viel Verbrauch an Rechnenkraft des Computers)
   
         for (int b = 0; b < 5; b ++){
            int randomr = ThreadLocalRandom.current().nextInt(mir, mar);
            int randomg = ThreadLocalRandom.current().nextInt(mig, mag);
            int randomb = ThreadLocalRandom.current().nextInt(mib, mab);

            // Die Flecken soll in der Sonne sein
            if (Math.sqrt(xcoordinate * xcoordinate + ycoordinate * ycoordinate) < 2485){   // orange
               g.setColor(new Color(randomr, randomg, randomb));
               g.fillRect(-2500 + x + xcoordinate, - 75000 + y + ycoordinate, wvonflecken, hvonflecken);
               g.drawRect(-2500 + x + xcoordinate, - 75000 + y + ycoordinate, wvonflecken, hvonflecken);
            }
         }

         if (Math.sqrt(xcoordinatew * xcoordinatew + ycoordinatew * ycoordinatew) < 2485){ // heil
            g.setColor(new Color(250, 250, 250));
            g.fillRect(-2500 + x + xcoordinatew, - 75000 + y + ycoordinatew, wvonwflecken, hvonwflecken);
            g.drawRect(-2500 + x + xcoordinatew, - 75000 + y + ycoordinatew, wvonwflecken, hvonwflecken);
         }
      }

         

   
// Abitur
      Font Abitur = new Font("TimesRoman", Font.PLAIN, 25);
      g.setColor(new Color(255, 255, 255));
      g.setFont(Abitur);
      g.drawString("12.4.2025 - 26.4.2025", x + 100,y + 100);
      g.drawString("Lernphase: Bio, Mathe, English", x + 100,y + 130);

      g.drawString("27.4.2025 - 7.5.2025", x + 100, y -1000);
      g.drawString("Übungsphase: Mathe, English", x + 100, y -970);

      g.drawString("7.5.2025", x + 100, y - 2000);
      g.drawString("Abiturprüfung Englisch", x + 100, y - 1970);

      g.drawString("9.5.2025", x + 100, y - 2500);
      g.drawString("Abiturprüfung Mathematik", x + 100, y - 2470);
      
      g.drawString("10.5.2025 - 15.5.2025", x + 100, y - 3000);
      g.drawString("Übungsphase: Biologie", x + 100, y - 2970);

      g.drawString("16.5.2025", x + 100, y - 3500);
      g.drawString("Abiturprüfung Biologie", x + 100, y - 3470);


      g.drawString("17.5.2025 - 24.5.2025", x + 100, y - 5000);
      g.drawString("Übung Mathematik", x + 100, y - 4970);
      
      g.drawString("25.5.2025 - 1.5.2024", x + 100, y - 6000);
      g.drawString("Prüfungsvorbereitung Wirtschaft", x + 100, y - 5970);

      g.drawString("2.6.2025", x + 100, y - 6500);
      g.drawString("Beginn mündlicher Abiturprüfungen", x + 100, y - 6490);

      
      










     // Mond🌛
     g2.setColor(new Color(213, 208, 206));
     g2.fillArc(x + 1500, y -1200, 300, 300, 106, 191); // linke Seite // Position 
     g2.drawArc(x + 1500, y -1200, 300, 300, 106, 191); 

     g2.setColor(new Color(0, 0, 0));
     g2.fillArc(x + 1600, y + -1380, 500, 500, 165, 73); // rechte Seite
     g2.drawArc(x + 1600, y + -1380, 500, 500, 165, 73); 

     // Mar
     g.setColor(new Color(122, 45, 24));  
     g.fillOval(x + 20000, y + 1500, 500, 500); // Position: (20000, -1500)
     g.drawOval(x + 20000, y + 1500, 500, 500);
     
     // Erde 🌍
     g.setColor(new Color(89, 217, 30));
     g.fillOval(x + 515, y + 932, 900, 750);
     g.drawOval(x + 515, y + 932, 900, 750);

      // Schwarzes Loch
      g.setColor(new Color(0, 0, 0));
      g.fillOval(x - 1500, y + 3000, 1000, 1000);
      g.drawOval(x - 1500, y + 3000, 1000, 1000);

      // international space station
      g.setColor(new Color(255, 255, 255));
      


      // Kreis des schwarzes Lochs
      g.setColor(new Color(76, 0, 255));
      g.drawOval(x - 1500, y + 3000, 1000, 1000);


// Koordinatenanzeige
     // Koordinaten der Rakete in Universum
     if (x < 100000 && y < 100000){
      Font f = new Font("TimesRoman", Font.PLAIN, 25);
      g.setColor(new Color(255, 100, 100));
      g.setFont(f);
      g.drawString("(" +  -x  + ", " + y + ")", 1000, 800);
     }

     // Koordinaten der Rakete in alternatives Universum
     if (x > 100000 && y > 100000){
      Font newfont = new Font("TimesRoman", Font.PLAIN, 12);
      g.setColor(new Color(255, 100, 100));
      g.setFont(newfont);
      int xcorzeig = - x + 100000000;
      int ycorzeig = y - 100000000;
      g.drawString("(" + xcorzeig + ", " + ycorzeig + ")", 1000, 800);
      }
// geheime Portalen
     // geheime Portal zu schwazem Loch
     if (x == 500 && y == 100){
      x = 2500;
      y = - 3450;
     }

     // geheime Portal zu Sonne
     if (x == 1100 && y == 50){
      x = 1100;
      y = 73000;
     }

      // Effekte des schwarzen Loches
      if(x < 2500 && x > 1400 && y > -3350 && y < -2050){
         x = 100000000;
         y = 100000000;
      }

      // Effekte von Abstoß von Mond
      if(x < -450 && x > -1000 && y > 1600 && y < 2400){
         for(int expl = 0; expl < 20; expl ++){
            for (int i = 0; i < 3000 ; i++) {
               // Grenzwerten für Randomvariablen
               int pxmax = 4000;
               int pmin = -100;
               int pymax = 4000;
               int maxbreite = 60;
               int minboderh = 3;
               int maxhoehe = 70;
   
               // Farben
               int farbermax = 250;
               int farbermin = 200;
               int farbegmax = 255;
               int farbegmin = 58;
               int farbebmax = 255;
               int farbebmin = 0;
               
               // Randomvariablen
               int zufallx = ThreadLocalRandom.current().nextInt(pmin, pxmax);
               int zufally = ThreadLocalRandom.current().nextInt(pmin, pymax);
               int entscheidung = ThreadLocalRandom.current().nextInt(0, 2);
               int zufallr = ThreadLocalRandom.current().nextInt(farbermin, farbermax);
               int zufallg = ThreadLocalRandom.current().nextInt(farbegmin, farbegmax);
               int zufallb = ThreadLocalRandom.current().nextInt(farbebmin, farbebmax);
               int zufallbreite = ThreadLocalRandom.current().nextInt(minboderh, maxbreite);
               int zufallhoehe = ThreadLocalRandom.current().nextInt(minboderh, maxhoehe);
   
               if (entscheidung == 0){
                  g.setColor(new Color(zufallr, zufallg, zufallb));
                  g.fillOval(zufallx, zufally, zufallbreite, zufallhoehe);
                  g.setColor(new Color(0,0,0));
                  g.fillRect(zufallx + 10, zufally + 10, ThreadLocalRandom.current().nextInt(0, 11), ThreadLocalRandom.current().nextInt(0, 10));
                  g.setColor(new Color(255, 0, 0));
                  g.fillOval(zufallx - 5, zufally - 5, zufallbreite - 10, zufallhoehe - 10);
               } 
   
               
               if (entscheidung == 1){
                  g.setColor(new Color(zufallr, zufallg, zufallb));
                  g.fillRect(zufallx, zufally, zufallbreite, zufallhoehe);
               }
            }
         }
         x = 0;
         y = 0;
      }
      
      // Effekte von Abstoß von Sonne
      int xaxis = x - 3400;
      int yaxis = y - 75650;
      if(x < 6050 && x > 900 && y > 73150 && y < 78450  && Math.sqrt(xaxis * xaxis + yaxis * yaxis) < 2450){
         for(int expl = 0; expl < 20; expl ++){
            for (int i = 0; i < 3000 ; i++) {
               // Grenzwerten für Randomvariablen
               int pxmax = 4000;
               int pmin = -100;
               int pymax = 4000;
               int maxbreite = 60;
               int minboderh = 3;
               int maxhoehe = 70;
   
                  // Farben
               int farbermax = 250;
               int farbermin = 200;
               int farbegmax = 255;
               int farbegmin = 58;
               int farbebmax = 255;
               int farbebmin = 0;
               
               // Randomvariablen
               int zufallx = ThreadLocalRandom.current().nextInt(pmin, pxmax);
               int zufally = ThreadLocalRandom.current().nextInt(pmin, pymax);
               int entscheidung = ThreadLocalRandom.current().nextInt(0, 2);
               int zufallr = ThreadLocalRandom.current().nextInt(farbermin, farbermax);
               int zufallg = ThreadLocalRandom.current().nextInt(farbegmin, farbegmax);
               int zufallb = ThreadLocalRandom.current().nextInt(farbebmin, farbebmax);
               int zufallbreite = ThreadLocalRandom.current().nextInt(minboderh, maxbreite);
               int zufallhoehe = ThreadLocalRandom.current().nextInt(minboderh, maxhoehe);
   
               if (entscheidung == 0){
                  g.setColor(new Color(zufallr, zufallg, zufallb));
                  g.fillOval(zufallx, zufally, zufallbreite, zufallhoehe);
                  g.setColor(new Color(0,0,0));
                  g.fillRect(zufallx + 10, zufally + 10, ThreadLocalRandom.current().nextInt(0, 11), ThreadLocalRandom.current().nextInt(0, 10));
                  g.setColor(new Color(255, 0, 0));
                  g.fillOval(zufallx - 5, zufally - 5, zufallbreite - 10, zufallhoehe - 10);
               } 
   
               
               if (entscheidung == 1){
                  g.setColor(new Color(zufallr, zufallg, zufallb));
                  g.fillRect(zufallx, zufally, zufallbreite, zufallhoehe);
               }
            }
         }
         x = 0;
         y = 0;
      }

      // Effekte von Abstoß von Mars
      int xaxismars = x + 19250;
      int yaxismars = y + 800;
      if(x > -19599 && x < -19001 && y > -1350 && y < -550 && Math.sqrt(xaxismars * xaxismars + yaxismars * yaxismars) < 400){
         for(int expl = 0; expl < 20; expl ++){
            for (int i = 0; i < 3000 ; i++) {
               // Grenzwerten für Randomvariablen
               int pxmax = 4000;
               int pmin = -100;
               int pymax = 4000;
               int maxbreite = 60;
               int minboderh = 3;
               int maxhoehe = 70;
   
                  // Farben
               int farbermax = 250;
               int farbermin = 200;
               int farbegmax = 255;
               int farbegmin = 58;
               int farbebmax = 255;
               int farbebmin = 0;
               
               // Randomvariablen
               int zufallx = ThreadLocalRandom.current().nextInt(pmin, pxmax);
               int zufally = ThreadLocalRandom.current().nextInt(pmin, pymax);
               int entscheidung = ThreadLocalRandom.current().nextInt(0, 2);
               int zufallr = ThreadLocalRandom.current().nextInt(farbermin, farbermax);
               int zufallg = ThreadLocalRandom.current().nextInt(farbegmin, farbegmax);
               int zufallb = ThreadLocalRandom.current().nextInt(farbebmin, farbebmax);
               int zufallbreite = ThreadLocalRandom.current().nextInt(minboderh, maxbreite);
               int zufallhoehe = ThreadLocalRandom.current().nextInt(minboderh, maxhoehe);
   
               if (entscheidung == 0){
                  g.setColor(new Color(zufallr, zufallg, zufallb));
                  g.fillOval(zufallx, zufally, zufallbreite, zufallhoehe);
                  g.setColor(new Color(0,0,0));
                  g.fillRect(zufallx + 10, zufally + 10, ThreadLocalRandom.current().nextInt(0, 11), ThreadLocalRandom.current().nextInt(0, 10));
                  g.setColor(new Color(255, 0, 0));
                  g.fillOval(zufallx - 5, zufally - 5, zufallbreite - 10, zufallhoehe - 10);
               } 
   
               
               if (entscheidung == 1){
                  g.setColor(new Color(zufallr, zufallg, zufallb));
                  g.fillRect(zufallx, zufally, zufallbreite, zufallhoehe);
               }
            }
         }
         x = 0;
         y = 0;
      }

      // Effekte von Abstoß von Erde
      int yaxiserde = y + 500;
      if(x < 500 && x > -500 && y > -1000 && y < 0 && Math.sqrt(x * x + yaxiserde * yaxiserde) < 500){
         for(int expl = 0; expl < 20; expl ++){
            for (int i = 0; i < 3000 ; i++) {
               // Grenzwerten für Randomvariablen
               int pxmax = 4000;
               int pmin = -100;
               int pymax = 4000;
               int maxbreite = 60;
               int minboderh = 3;
               int maxhoehe = 70;
   
               // Farben
               int farbermax = 250;
               int farbermin = 200;
               int farbegmax = 255;
               int farbegmin = 58;
               int farbebmax = 255;
               int farbebmin = 0;
               
               // Randomvariablen
               int zufallx = ThreadLocalRandom.current().nextInt(pmin, pxmax);
               int zufally = ThreadLocalRandom.current().nextInt(pmin, pymax);
               int entscheidung = ThreadLocalRandom.current().nextInt(0, 2);
               int zufallr = ThreadLocalRandom.current().nextInt(farbermin, farbermax);
               int zufallg = ThreadLocalRandom.current().nextInt(farbegmin, farbegmax);
               int zufallb = ThreadLocalRandom.current().nextInt(farbebmin, farbebmax);
               int zufallbreite = ThreadLocalRandom.current().nextInt(minboderh, maxbreite);
               int zufallhoehe = ThreadLocalRandom.current().nextInt(minboderh, maxhoehe);
   
               if (entscheidung == 0){
                  g.setColor(new Color(zufallr, zufallg, zufallb));
                  g.fillOval(zufallx, zufally, zufallbreite, zufallhoehe);
                  g.setColor(new Color(0,0,0));
                  g.fillRect(zufallx + 10, zufally + 10, ThreadLocalRandom.current().nextInt(0, 11), ThreadLocalRandom.current().nextInt(0, 10));
                  g.setColor(new Color(255, 0, 0));
                  g.fillOval(zufallx - 5, zufally - 5, zufallbreite - 10, zufallhoehe - 10);
               } 
   
               
               if (entscheidung == 1){
                  g.setColor(new Color(zufallr, zufallg, zufallb));
                  g.fillRect(zufallx, zufally, zufallbreite, zufallhoehe);
               }
            }
         }
         x = 0;
         y = 0;
      }
      
      
      // Alternatives Universum 
      if (x > 100000 && y > 100000){
      Font altuni = new Font("TimesRoman", Font.PLAIN, 18);
      g.setColor(new Color(231, 123, 21));
      g.setFont(altuni);
      g.drawString("Willkommen zu alternativem Universum", - 100000000 + x + 100, - 100000000 + y + 100);
      
         
         g.setColor(new Color(0, 0, 0));

         // Portal zu Erde
         g.setColor(new Color(76, 0, 255));
         g.drawOval(x - 100000000 + 550, y - 100000000 + 400, 100, 100);
         g.setColor(new Color(0, 0, 0));
         g.fillOval(x - 100000000 + 550, y - 100000000 + 400, 100, 100);
         g.setColor(new Color(88, 190, 120));

         Font f1 = new Font("TimesRoman", Font.PLAIN, 16);
         g.setFont(f1);
         g.drawString("Portal zu Erde", x - 100000000 + 550, y - 100000000 + 360);

         if(x < 100000450 && x > 100000200 && y > 100000150 && y < 100000550){
            x = 0;
            y = 0;
         }

         // Portal zu Sonne
         g.setColor(new Color(76, 0, 255));
         g.drawOval(x - 100000000 + 850, y - 100000000 + 200, 100, 100);
         g.setColor(new Color(0, 0, 0));
         g.fillOval(x - 100000000 + 850, y - 100000000 + 200, 100, 100);
         g.setColor(new Color(88, 190, 120));
         g.setFont(f1);
         g.drawString("Portal zu Sonne", x - 100000000 + 850, y - 100000000 + 150);
         if(x < 100000150 && x > 99999950 && y > 100000350 && y < 100000750){
            x = 1100;
            y = 73000;
         }
         
         // Portal zu Mars
         g.setColor(new Color(76, 0, 255));
         g.drawOval(x - 100000000 + 1150, y - 100000000 + 200, 100, 100);
         g.setColor(new Color(0, 0, 0));
         g.fillOval(x - 100000000 + 1150, y - 100000000 + 200, 100, 100);
         g.setColor(new Color(88, 190, 120));
         g.setFont(f1);
         g.drawString("Portal zu Mars", x - 100000000 + 1150, y - 100000000 + 150);
         if(x < 99999850 && x > 99999650 && y > 100000350 && y < 100000750){
            x = -19800;
            y = -1200;
         }
      }
   }







// Window Setting
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
      JFrame frame = new JFrame("Universum 🚀");
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

