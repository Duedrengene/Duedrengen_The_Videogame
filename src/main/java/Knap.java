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
        p.fill(100, 0, 0);
        if (klikket) {
            p.fill(100, 100, 0);
        }
        p.rect(xPosition, yPosition, bredde, hojde,10);
        p.fill(255);

    }

    void registrerKlik() {
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