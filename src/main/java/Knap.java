import processing.core.PApplet;

public class Knap {


    float xPosition = 210, yPosition  = 400;
    float hojde = 60, bredde = 200;
    PApplet p;
    boolean klikket;

    Knap(PApplet p,float x, float y){
        this.xPosition = x;
        this.yPosition = y;
        this.p =p;
    }


    void draw(int level) {
        if(level==0){
        if (klikket) {
            p.text("Controls", 210, 225);
            p.text("Resolution", 210, 400);
            p.text("Back", 210, 575);
        }
        //p.rectMode(p.CENTER);
        //p.rect(xPosition, yPosition, bredde, hojde,10
    }
    }

    void registrerSettings() {

        if (p.mousePressed && p.mouseX < xPosition + bredde/2 && p.mouseX > xPosition-bredde/2 && p.mouseY > yPosition-hojde/2 && p.mouseY < yPosition + hojde/2) {
            klikket = true;
        } else {
            klikket = false;
        }
    }
 
    boolean erKlikket() {
        return klikket;
    }
}