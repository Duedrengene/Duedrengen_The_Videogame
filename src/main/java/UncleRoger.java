import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class UncleRoger {
    PApplet p;
    PVector position = new PVector();
    boolean shopOpen;
    PImage unclePic;
    int level;
UncleRoger(PApplet p,ImageLoader iL,int posX,int posY,int level){
    this.p = p;
    this.position.x = posX;
    this.position.y = posY;
    this.unclePic = iL.uncleRoger;
    this.level = level;
}
void tegn(){
    //if(level == 1){
    p.image(unclePic,position.x,position.y,64,64);
//}

}

}
