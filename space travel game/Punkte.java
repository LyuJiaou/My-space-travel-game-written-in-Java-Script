import java.awt.*; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;
import java.awt.geom.*;

public class Punkte {
    public void paint(Graphics Punkte){
        int Punktmin = -4000;
        int Punktmax = 4000;
            for (int i = 0; i <10000 ; i++) {
                int Punktx = ThreadLocalRandom.current().nextInt(Punktmin, Punktmax);
                int Punkty = ThreadLocalRandom.current().nextInt(Punktmin, Punktmax);
                Punkte.setColor(Color.BLACK);
                Punkte.fillRect(Punktx, Punkty, 3, 3);
                Punkte.drawRect(Punktx, Punkty, 3, 3);
            }
    }
}
