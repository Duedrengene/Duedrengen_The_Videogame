import processing.core.PApplet;
import javax.sound.sampled.AudioFormat;

public class SoundLoader {
    PApplet p;



    SoundLoader(PApplet p,SoundLoader midgame, SoundLoader boss) {
        this.p=p;
     this.boss=boss;
     this.midgame=midgame;


        }

    public void loadtheSounds() {
    midgame = new SoundLoader(this,"midgamefil.mp3");

    }
}


