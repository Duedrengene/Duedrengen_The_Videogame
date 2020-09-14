import processing.core.PApplet;

public class Knap {


    float xPosition = 10, yPosition  = 5;
    float hojde = 25, bredde = 225;
    PApplet p;
    boolean klikket;

    Knap(PApplet p,float x, float y){
        this.xPosition = x;
        this.yPosition = y;
        this.p =p;
    }


    void tegn() {
        if (klikket) {
            p.text("Controls", 210, 225);
            p.text("Resolution", 210, 400);
            p.text("Back", 210, 575);
        }
        p.rect(xPosition, yPosition, bredde, hojde,10);
        p.fill(255);

    }

    void registrerSettings() {
        if (p.mousePressed && p.mouseX < xPosition +bredde && p.mouseX > xPosition && p.mouseY > yPosition && p.mouseY < yPosition + hojde) {
            klikket = true;
        } else {
            klikket = false;
        }
    }
 
    boolean erKlikket() {
        return klikket;
    }
}