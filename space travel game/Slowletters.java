import java.io.*;
public class Slowletters {
    public static void main(String... args) throws IOException, InterruptedException {
        int letter = 'A';
        while(true) {
            System.out.write(letter);
            // out.flush();                                                    
            Thread.sleep(100);
            letter++;
            if(letter > 'Z')
                letter = 'A';
        }
    }
}