import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader  {

    PImage img;
    PImage startup;
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
    float scaleW = 1;
    float scaleH = 1;
ImageLoader(PApplet p){
    this.p=p;
}



void loadTheImages(int var,int w,int h){

    scaleW = (float)w/1920;
    scaleH = (float)h/1080;

    img = p.loadImage("duedreng.png");
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
        }


}

