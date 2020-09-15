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
    uncleRoger = p.loadImage("Uncle Roger.png");
    startup.resize(w,h);
    img.resize((int)(64*scaleW),(int)(64*scaleH));
    uncleRoger.resize((int)(64*scaleW),(int)(64*scaleH));
        }




}

