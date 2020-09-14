import processing.core.PApplet;

public class Knap {

    String tekst;
    String detteErMaster;
    String detteErNedarvingsOpgave222;
    float xPosition = 10, yPosition  = 5;
    float hojdeKnap = 25, breddeKnap = 250;
    PApplet p;
    boolean klikket;

    Knap(PApplet p,float x, float y){
        this.xPosition = x;
        this.yPosition = y;
        this.p =p;
    }


    void tegn() {
        p.fill(100, 0, 0);
        if (klikket) {
            fill(100, 100, 0);
        }
        rect(xPosition, yPosition, breddeKnap, hojdeKnap,10);
        fill(255);
        text(tekst, xPosition+10, yPosition+18);
    }

    void registrerKlik() {
        if (mousePressed && p.mouseX < xPosition +breddeKnap && mouseX > xPosition && mouseY > yPosition && mouseY < yPosition + hojdeKnap) {
            klikket = true;
        } else {
            klikket = false;
        }
    }

    boolean erKlikket() {
        return klikket;
    }
}