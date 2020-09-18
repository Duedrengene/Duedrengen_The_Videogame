import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Oatmeal {
    PApplet p;
    PVector location = new PVector();
    PVector velocity1 = new PVector(3,0);
    PVector velocity2 = new PVector(0,2);
    ImageLoader iL;
    ImageResizer iR;
    Backgrounds backgrounds;
    int type;

    Oatmeal(PApplet p,float x, float y,ImageLoader iL,ImageResizer iR,Backgrounds backgrounds,int type){
        this.p=p;
        location.x=x+31;
        location.y=y+20;
        this.iL =iL;
        this.iR=iR;
        this.backgrounds = backgrounds;
        this.type=type;
    }

    void drawOatmeal(){
        p.fill(0);
        p.image(iL.oatmeal,location.x,location.y);
    }
    void moveOatmeal(){
if(type==0){
        location.add(velocity1);}
if(type==1){
    location.add(velocity2);}
    }
    void hit(ArrayList<Oatmeal> oat,Enemy enemy,int i){
        if (oat.get(i).location.x <= enemy.x+64*iR.scaleW && oat.get(i).location.x >= enemy.x && oat.get(i).location.y <= enemy.y + 64*iR.scaleH && oat.get(i).location.y >= enemy.y) {
            enemy.hp -= 1;
            oat.remove(i);
            backgrounds.monetos++;

        }

    }
    boolean outOfBounds(ArrayList<Oatmeal> oat,int i){
    if(location.x>p.width||location.y>p.height){
        return true;

    }
    return false;
    }
}
