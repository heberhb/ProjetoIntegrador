package Classes;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
    private Clip bip;
     
     
     public Sounds(String SoundFileName){
        try{
            File fileSound = new File(SoundFileName);
            AudioInputStream audioImputStream = AudioSystem.getAudioInputStream(fileSound);
            bip = AudioSystem.getClip();
            bip.open(audioImputStream);
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
            e.getMessage();
        }
     }
     
     public void play() {
        if (bip != null) {
            bip.setFramePosition(0); // Rewind to the beginning
            bip.start();
        }
     }
        
}
