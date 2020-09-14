import processing.core.PApplet;
import processing.core.PFont;

public class Backgrounds {
    PApplet p;
    int Level;
    ImageLoader iL;
    PFont Titelfont;
    PFont Lilletitelfont;
    float xPosition = 210, yPosition = 250;
    float hojdetekst = 25, breddetekst = 250;
    boolean klikket;


    Backgrounds(int Level,PApplet p,PFont Titelfont,PFont Lilletitelfont,ImageLoader iL) {
    this.iL=iL;
    this.Titelfont = Titelfont;
    this.Lilletitelfont = Lilletitelfont;
    this.Level=Level;
    float xPosition = this.xPosition;
    float yPosition = this.yPosition;
    }

    void simulate() {
        if (Level == 0) {
            p.image(iL.startup, 0, 0);

            p.fill(220, 20, 60);
            p.textAlign(p.CENTER);
            p.textFont(Titelfont);
            p.text("Velkommen tilbage Agent Duedreng!", 960, 85);
            p.fill(0);
            p.textFont(Lilletitelfont);
            // p.text("Tryk på hvilken som helst tast for at starte spillet",960,880);
            p.textSize(56);
            p.fill(253, 106, 2);
            p.text("Play", 210, 225);
            p.text("Settings", 210, 400);
            p.text("Quit", 210, 575);

            if (p.keyPressed == true) {
                Level = 1;
            }
        }
    }

    void registrerKlikket() {♦
        if (p.mousePressed && p.mouseX < xPosition + breddetekst && p.mouseX > xPosition && p.mouseY < yPosition && p.mouseY < yPosition + hojdetekst) {
            klikket = true;
        } else {
            klikket = false;

        }
    }

    boolean erKlikket() {
        return klikket;
    }
}
