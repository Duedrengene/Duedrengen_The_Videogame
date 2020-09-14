import processing.core.PApplet;
import processing.core.PFont;

public class Backgrounds {
    PApplet p;
    int Level;
    ImageLoader iL;
    PFont Titelfont;
    PFont Lilletitelfont;

    Backgrounds(int Level,PApplet p,PFont Titelfont,PFont Lilletitelfont) {


    }

    void simulate() {
        if(Level == 0) {
            p.image(iL.startup,0,0);

            p.fill(220,20,60);
            p.textAlign(p.CENTER);
            p.textFont(Titelfont);
            p.text("Velkommen tilbage Agent Duedreng!", 960, 85);
            p.fill(0);
            p.textFont(Lilletitelfont);
            p.text("Tryk på hvilken som helst tast for at starte spillet",960,880);
            if(p.keyPressed == true) {
                Level =1;
            }
        }
    }
}
