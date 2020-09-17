import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader  {

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

    float scaleW = 1;
    float scaleH = 1;
ImageLoader(PApplet p){
    this.p=p;
}



void loadTheImages(int var,int w,int h){

    scaleW = (float)w/1920;
    scaleH = (float)h/1080;

    img = p.loadImage("duedreng.png");
    uncleBaggrund = p.loadImage("UncleBaggrund.png");
    by = p.loadImage("by.png");

    startup = p.loadImage("pigeon.png");
    deathscreen = p.loadImage("skuffet due.jpg");
    uncleRoger = p.loadImage("Uncle Roger.png");
    //items.
    msgbull = p.loadImage("msgbull.png");
    msg = p.loadImage("MSG salt on crack.png");
    majs = p.loadImage("majs.png");
    friedrice = p.loadImage("Fried rice (ikke jamie edition).png");
    Syringe = p.loadImage("Syringe stor.png");
    havregryn = p.loadImage("havregryn.png");
    fjer = p.loadImage("fjer.png");
    //enemies.
    james = p.loadImage("spr_JamesOliver.png");

// Resolution resize.


    msg.resize((int)(64*scaleW),(int)(64*scaleH));
    msgbull.resize((int)(64*scaleW),(int)(64*scaleH));
    havregryn.resize((int)(64*scaleW),(int)(64*scaleH));
    friedrice.resize((int)(64*scaleW),(int)(64*scaleH));
    Syringe.resize((int)(64*scaleW),(int)(64*scaleH));
    majs.resize((int)(64*scaleW),(int)(64*scaleH));
    fjer.resize((int)(64*scaleW),(int)(64*scaleH));
    img.resize((int)(64*scaleW),(int)(64*scaleH));
    startup.resize(w,h);
    deathscreen.resize(w,h);
    img.resize((int)(64*scaleW),(int)(64*scaleH));
    uncleRoger.resize((int)(64*scaleW),(int)(64*scaleH));
    james.resize((int)(64*scaleW),(int)(64*scaleH));
    uncleBaggrund.resize(w,h);
    by.resize(w,h);
        }


}

