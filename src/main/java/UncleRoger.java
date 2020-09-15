import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class UncleRoger {
    PApplet p;
    PVector position = new PVector();
    boolean shopOpen;
    ImageLoader unclePic;
    int level;
    boolean someoneIsClose;
UncleRoger(PApplet p,ImageLoader iL,int posX,int posY,int level){
    this.p = p;
    this.position.x = posX;
    this.position.y = posY;
    this.unclePic = iL;
    this.level = level;
}



void draw(int level){
    this.level=level;
    if(level == 1){
    p.image(unclePic.uncleRoger,position.x,position.y);
    if(someoneIsClose==true){
        p.text("Want some MSG? (Interact with me)",position.x-20,position.y-20);
    }
}

}
void detectPlayer(Player player){
    if(position.x-20<=player.x+64 && position.x+80>player.x&&position.y-20<=player.y+64 && position.y+80>player.y){
        //p.println("vi rammer");
        someoneIsClose = true;
    }else{
        someoneIsClose=false;
    }
}

void drawShop(Player player, int i) {
  //  if (level == 1 && i==0 && interact==true) {
    //    p.rect(100, 200, (p.width - 400)/2, p.height - 400);
    //}
    //if (level == 1  && i==1&&interact==true) {
      //  p.rect(p.width/2+100, 200, (p.width - 400)/2, p.height - 400);
    //}
}
}
