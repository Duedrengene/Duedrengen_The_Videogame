import javazoom.jl.player.Player;
import processing.core.PApplet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class SoundLoader {
    String filename = "midgamefil.mp3";
    PApplet p;


    Player mp3;


    SoundLoader(PApplet p) {
        this.p = p;



       }

    public void  loadtheSounds() {
//File()
try{
    BufferedInputStream buffer = new BufferedInputStream(
            new FileInputStream(filename));
    mp3 = new Player(buffer);
    mp3.play();
}
catch (Exception e){
    System.out.println(e);
}

}



public void playSounds(){


    }

    }








