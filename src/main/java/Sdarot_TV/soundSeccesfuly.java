package Sdarot_TV;

import javax.sound.sampled.*;
import java.io.File;

public class soundSeccesfuly {

    static Clip clip;

    public static void runMusic(){
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\eeeee\\Documents\\GitHub\\Sdarot_TV\\src\\sound\\song1.wav"));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(5);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }public void play(){
        clip.start();
    }
    public void stopMusic(){
        clip.stop();
    }
}
