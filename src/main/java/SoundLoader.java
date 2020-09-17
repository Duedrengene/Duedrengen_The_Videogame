import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import processing.core.PApplet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;




public class SoundLoader {
    String filename = "midgamefil.mp3";
    PApplet p;


    Player mp3;


    SoundLoader(PApplet p) {
        this.p = p;



       }

    public void  loadtheSounds() {
        java.io.File file = new java.io.File("C:\\Users\\Michael Bendtsen\\Documents\\GitHub\\New folder\\Duedrengen_The_Videogame\\src\\main\\resources\\midgamefil.mp3");
try{
    BufferedInputStream buffer = new BufferedInputStream(
            new FileInputStream(file));
    mp3 = new Player(buffer);

}
catch (Exception e){
    System.out.println(e);
}}

public void playSounds(){

            try {
                mp3.play();
            } catch (JavaLayerException e) {
                System.out.println(e);
            }

        }





    }








