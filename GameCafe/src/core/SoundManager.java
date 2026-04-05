package core;

import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;

public class SoundManager {

    public static void playSound(String fileName) {
        try {
            URL url = SoundManager.class.getResource("/assets/" + fileName);
            if (url == null) {
                // Silently return if sound file doesn't exist yet, to prevent game crash.
                // The user can add assets later.
                return;
            }
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            System.out.println("Could not play sound: " + fileName);
        }
    }
}
