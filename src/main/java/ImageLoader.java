import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader  {

    PImage img;
    PImage startup;
    PApplet p;
    PImage uncleRoger;
ImageLoader(PApplet p){
    this.p=p;
}



void loadTheImages(){
    img = p.loadImage("duedreng.png");
    startup = p.loadImage("pigeon.png");

    startup.resize(1920,1080);
    uncleRoger = p.loadImage("Uncle Roger.png");
        }
}