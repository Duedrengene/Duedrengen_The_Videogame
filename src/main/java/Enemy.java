import processing.core.PApplet;

import java.util.ArrayList;

public class Enemy {
    float x, y;
    float speed;
    int level;
    int specialMoveRNG;
    ImageLoader iL;
    PApplet p;
    boolean iShootNow;
    int type;
    int hp=1;

    // Fungere meget ligesom player, men uden diameter eller random spawn steder.
    Enemy(float xx, float yy, float dd, ImageLoader iL, PApplet p, int type) {
        x = xx;
        y = yy;
        speed = dd;
        this.iL = iL;

        this.p = p;
        this.type = type;
    }

    //Fremviser enemy sprite på level 2, hvis man ændre this.Level == . ;
    void display(int level) {
        this.level = level;
        if (this.level != 0) {
            if (type == 1) {

                p.image(iL.james, x, y);
            }
            if (type == 2) {

                p.image(iL.helen,x,y);
            }
        }
    }

    void move() { //Skal gøres langsomere og fås til at muligvis hoppe i intervaler.
        int r = (int) speed >> 1;
        if (level != 0) {
            for (int i = 0; i < 1; i++) {
                x = p.constrain(x, r, p.width - r); //siden
                x += speed;

                i = 0;
            }
        }
    }

    void shoot() {
        specialMoveRNG = (int) p.random(0, 200);
        if (specialMoveRNG == 0 && !iShootNow) {
            iShootNow = true;
        } else {
            iShootNow = false;
        }
    }
    void imDead(ArrayList<Enemy> list,int i){
        if(hp<=0){
            list.remove(i);
        }
    }
}
