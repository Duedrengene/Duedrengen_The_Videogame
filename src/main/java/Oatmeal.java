import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Oatmeal {
    PApplet p;
    PVector location = new PVector();
    PVector velocity = new PVector(3,0);
    ImageLoader iL;
    ImageResizer iR;
    Backgrounds backgrounds;

    Oatmeal(PApplet p,float x, float y,ImageLoader iL,ImageResizer iR,Backgrounds backgrounds){
        this.p=p;
        location.x=x+31;
        location.y=y+20;
        this.iL =iL;
        this.iR=iR;
        this.backgrounds = backgrounds;
    }

    void drawOatmeal(){
        p.fill(0);
        p.image(iL.oatmeal,location.x,location.y);
    }
    void moveOatmeal(){

        location.add(velocity);
    }
    void hit(ArrayList<Oatmeal> oat,Enemy enemy,int i,UncleRoger roger){
        if (oat.get(i).location.x <= enemy.x+64*iR.scaleW && oat.get(i).location.x >= enemy.x && oat.get(i).location.y <= enemy.y + 64*iR.scaleH && oat.get(i).location.y >= enemy.y) {
            enemy.hp -= 1;
            oat.remove(i);
            backgrounds.monetos++;

        }

    }
    void outOfBounds(ArrayList<Oatmeal> oat,int i){
    if(location.x>p.width){
        oat.remove(i);
    }
    }
}
