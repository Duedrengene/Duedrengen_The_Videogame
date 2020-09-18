import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader {

    //Baggrunde
    PImage by;
    PImage startup;
    PImage uncleBaggrund;

    //items og player modeller.

    PApplet p;
    PImage uncleRoger;
    PImage friedrice;
    PImage msg;
    PImage majs;
    PImage msgbull;
    PImage Syringe;
    PImage havregryn;
    PImage deathscreen;
    PImage fjer;
    PImage james;
    PImage img;
    PImage oatmeal;
    //Animation
    PImage bulletdue;
    PImage duedreng;
    PImage duedrenganimation;
    PImage dueShitting;

    float scaleW = 1;
    float scaleH = 1;

    ImageLoader(PApplet p) {
        this.p = p;
    }


    void loadTheImages(int var, int w, int h) {

        scaleW = (float) w / 1920;
        scaleH = (float) h / 1080;
        //Characters
        img = p.loadImage("duedreng.png");
        uncleBaggrund = p.loadImage("UncleBaggrund.png");
        by = p.loadImage("by.png");
        //Screens
        startup = p.loadImage("pigeon.png");
        deathscreen = p.loadImage("skuffet due.jpg");
        uncleRoger = p.loadImage("Uncle Roger.png");
        //items.
        msgbull = p.loadImage("msgbull.png");
        msg = p.loadImage("MSG salt on crack1.png");
        majs = p.loadImage("majs1.png");
        friedrice = p.loadImage("Fried rice.png");
        Syringe = p.loadImage("Syringe stor1.png");
        havregryn = p.loadImage("havregryn1.png");
        fjer = p.loadImage("fjer1.png");
        //enemies.
        james = p.loadImage("spr_JamesOliver.png");

        //Animation
        bulletdue = p.loadImage("Bullet due.png");
        duedreng = p.loadImage("duedrengstandard.png");
        duedrenganimation = p.loadImage("duedrenganimation.png");
        oatmeal = p.loadImage("Oatmeal.png");
        dueShitting = p.loadImage("due skider.png");

// Resolution resize.

        img.resize((int) (64 * scaleW), (int) (64 * scaleH));
        img.resize((int) (64 * scaleW), (int) (64 * scaleH));
        //Items
        msg.resize((int) (64 * scaleW), (int) (64 * scaleH));
        msgbull.resize((int) (64 * scaleW), (int) (64 * scaleH));
        havregryn.resize((int) (64 * scaleW), (int) (64 * scaleH));
        friedrice.resize((int) (64 * scaleW), (int) (64 * scaleH));
        Syringe.resize((int) (64 * scaleW), (int) (64 * scaleH));
        majs.resize((int) (64 * scaleW), (int) (64 * scaleH));
        fjer.resize((int) (64 * scaleW), (int) (64 * scaleH));
        //Screens
        by.resize(w, h);
        deathscreen.resize(w, h);
        startup.resize(w, h);
        //Characters
        uncleRoger.resize((int) (64 * scaleW), (int) (64 * scaleH));
        james.resize((int) (64 * scaleW), (int) (64 * scaleH));
        duedreng.resize((int) (64 * scaleW), (int) (64 * scaleH));

        //Backgrounds
        uncleBaggrund.resize(w, h);
        //Animation
        bulletdue.resize((int) (64 * scaleW), (int) (64 * scaleH));
        duedrenganimation.resize((int) (64 * scaleW), (int) (64 * scaleH));
        oatmeal.resize((int) (20 * scaleW), (int) (16 * scaleH));
        dueShitting.resize((int) (64 * scaleW), (int) (64 * scaleH));
    }
}

