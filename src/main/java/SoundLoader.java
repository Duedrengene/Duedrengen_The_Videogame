import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.PlayerApplet;
import processing.core.PApplet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;


public class SoundLoader extends Thread {
    File normalMusic;
    File bossMusic;
    File file;
    PApplet p;
    Player mp3;

    SoundLoader(PApplet p) {
        this.p = p;
        normalMusic = new java.io.File("src\\main\\resources\\midgamefil.mp3");
        bossMusic = new java.io.File("src\\main\\resources\\bossfil.mp3");
    }

    public void run() {
        loadtheSounds();
    }

    public void loadtheSounds() {
        if(false)
            file = normalMusic;
        else
            file = bossMusic;
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(file));
            mp3 = new Player(buffer);
            mp3.play();
        } catch (Exception e) {
            //System.out.println(e);
        }
    }

    public void playSounds() {
        try {
            mp3.play(0);
        } catch (JavaLayerException e) {
            //System.out.println(e);
        }

    }

}








