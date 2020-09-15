import processing.core.PApplet;
import processing.core.PFont;

public class Backgrounds {
    PApplet p;
    int Level;
    ImageLoader iL;
    FontLoader fL;

    Backgrounds(int Level, PApplet p,  ImageLoader iL,FontLoader fL) {
        this.iL = iL;
        this.Level = Level;
        this.p = p;
        this.fL = fL;
    }

    void simulate() {
        if (Level == 0) {
            p.image(iL.startup, 0, 0);
            p.fill(220, 20, 60);
            p.textAlign(p.CENTER);
            p.textFont(fL.Titelfont);
            p.text("Velkommen tilbage Agent Duedreng!", 960, 85);
            p.fill(0);
            p.textFont(fL.Lilletitelfont);
            // p.text("Tryk på hvilken som helst tast for at starte spillet",960,880);
            p.textSize(56);
            p.fill(253, 106, 2);
            p.text("Play", 210, 225);
            p.text("Settings", 210, 400);
            p.text("Quit", 210, 575);

            if (p.keyPressed == true) {
                Level = 1;
           if(Level==1){
             //  p.image();
               }
            }
        }
    }
}




