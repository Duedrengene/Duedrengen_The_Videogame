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
    Backgrounds backgrounds;

    SoundLoader(PApplet p,Backgrounds backgrounds) {
        this.p = p;
        this.backgrounds = backgrounds;
        normalMusic = new java.io.File("src\\main\\resources\\midgamefil.mp3");
        bossMusic = new java.io.File("src\\main\\resources\\bossfil.mp3");
    }

    public void run() {
        while(0<1){
        if(backgrounds.check){
            backgrounds.check = false;
            loadtheSounds();
        }

        playSounds();
    }}

    public void loadtheSounds() {
        if(!backgrounds.bossLevel)
            file = normalMusic;
        else
            file = bossMusic;
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(file));
            mp3 = new Player(buffer);

        } catch (Exception e) {
            //System.out.println(e);
        }
    }

    public void playSounds() {
        try {
            mp3.play(1);
        } catch (JavaLayerException e) {
            //System.out.println(e);
        }

    }

}








