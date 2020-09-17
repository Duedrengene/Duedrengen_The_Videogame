import processing.core.PApplet;

public class Enemy {
    int x, y;
    int d;
    int Level;
    int specialMoveRNG;
    ImageLoader iL;
    PApplet p;
    boolean iShootNow;
    int type;

    // Fungere meget ligesom player, men uden diameter eller random spawn steder.
    Enemy(int xx, int yy, int dd, ImageLoader iL, int Level, PApplet p,int type) {
        x = xx;
        x = p.width - 50;
        y = yy;
        y = p.height / 2;
        d = dd;
        this.iL = iL;
        this.Level = Level + 1;
        this.p = p;
        this.type=type;
    }

    //Fremviser enemy sprite på level 2, hvis man ændre this.Level == . ;
    void display(int level) {
        this.Level = level;
        if (this.Level == 1) {
            p.fill(255);
            p.ellipse(x, y, d + 200, d + 200);
            //Erstat med enemy sprite
        }
    }

    void move() { //Skal gøres langsomere og fås til at muligvis hoppe i intervaler.
        int r = d >> 1;
        if (Level == 1) {
            for (int i = 0; i < 1; i++) {
                x = p.constrain(x, r, p.width - r); //siden
                x += d;
                //y += d;
                i = 0;
            }
        }
    }

    void shoot() {
        specialMoveRNG = (int) p.random(0, 69);
        if (specialMoveRNG == 0 && iShootNow == false) {
            iShootNow = true;
        } else {
            iShootNow = false;
        }
    }
}
