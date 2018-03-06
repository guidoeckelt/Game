package de.charaktar.game.media;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Speaker {

    private String libRoot;

    public Speaker() {
        this.libRoot = "D:\\DevGame\\PointyAndClicky\\media\\sounds\\";
    }

    public void play(String filePath) {
        try {
            // Open an audio input stream.
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(this.libRoot + filePath));
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
