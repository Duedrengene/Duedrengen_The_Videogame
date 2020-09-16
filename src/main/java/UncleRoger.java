import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import javax.swing.*;

public class UncleRoger {
    PApplet p;
    PVector position = new PVector();
    boolean p1shopOpen;
    boolean p2shopOpen;
    ImageLoader unclePic;
    int level;
    int monetos;
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
    p.image(unclePic.msg,1780,10);
    p.text(monetos,1855,60);
    if(someoneIsClose==true){
        p.fill(0);
        p.text("Want some MSG? (Interact with me)",position.x-20,position.y-20);
    }
}
}

void detectPlayer(Player player){
    if(position.x-20<=player.x+64 && position.x+80>player.x&&position.y-20<=player.y+64 && position.y+80>player.y){
        someoneIsClose = true;
    }else{
        someoneIsClose=false;
    }
}

void drawshop(Player player,int i) {
    p.rectMode(p.CORNER);
    if ((level == 1 && i==0 && player.interact==true && someoneIsClose)||p1shopOpen == true) {
        p.fill(255,108,0);
        p.rect(100, 200, (p.width - 900)/2, p.height - 400);
        //Uncommon Item for player 1
        p.fill(108,255,0);
        p.rect(140,340,64,64);
        p.image(unclePic.havregryn,140,340);
        p.rect(490,340,64,64);
        p.image(unclePic.friedrice,490,350 );
        p.rect(490,540,64,64);
        p.image(unclePic.msgbull,490,540);
        p.rect(140,740,64,64);
        p.image(unclePic.Syringe,140,740);
        p.rect(490,740,64,64);
        p.rect(267,245,20,20);
        p.fill(0);
        p.textSize(18);
        p.text("Uncommen item: ",200,260);
        //Ability Player 1
        p.text("Ability:",480,260);
        p.fill(63,72,204);
        p.rect(507,245,20,20);
        p.rect(140,540,64,64);
        p.image(unclePic.majs,140,540);



        p1shopOpen = true;
    }
    if ((level == 1  && i==1 && player.interact==true && someoneIsClose)||p2shopOpen == true) {
        p.fill(255,108,0);
        p.rect(p.width/2+100, 200, (p.width - 900)/2, p.height - 400);

// Uncommon items for player 2
        p.fill(108,255,0);
        p.rect(p.width/2+140,340,64,64);
        p.image(unclePic.havregryn,p.width/2+140,340);
        p.rect(p.width/2+490,340,64,64);
        p.image(unclePic.friedrice,p.width/2+490,350 );
        p.rect(p.width/2+490,540,64,64);
        p.image(unclePic.msgbull,p.width/2+490,540);
        p.rect(p.width/2+140,740,64,64);
        p.image(unclePic.Syringe,p.width/2+140,740);
        p.rect(p.width/2+490,740,64,64);
        p.rect(p.width/2+267,245,20,20);
        p.fill(0);
        p.textSize(18);
        p.text("Uncommen item: ",p.width/2+200,260);
        //Ability Player 2
        p.text("Ability:",p.width/2+480,260);
        p.fill(63,72,204);
        p.rect(p.width/2+507,245,20,20);
        p.rect(p.width/2+140,540,64,64);
        p.image(unclePic.majs,p.width/2+140,540);
        p2shopOpen = true;
    }
}
}
