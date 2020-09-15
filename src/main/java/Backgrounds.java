import processing.core.PApplet;
import processing.core.PFont;

public class Backgrounds {
    PApplet p;
    int level;
    ImageLoader iL;
    FontLoader fL;

    Backgrounds(int Level, PApplet p,  ImageLoader iL,FontLoader fL) {
        this.iL = iL;
        this.level = Level;
        this.p = p;
        this.fL = fL;
    }

    void simulate() {
        if (level == 0) {
            p.image(iL.startup, 0, 0);
            p.fill(220, 20, 60);
            p.textAlign(p.CENTER);
            p.textFont(fL.Titelfont);
            p.text("Velkommen tilbage Agent Duedreng!", 960, 85);
            p.fill(0);



            }
        }
    }





