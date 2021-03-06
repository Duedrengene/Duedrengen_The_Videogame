import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Oatmeal {
    PApplet p;
    PVector location = new PVector();
    //Duedreng bullet speed
    PVector velocity1 = new PVector(6,0);
    //Pigeon bullet speed
    PVector velocity2 = new PVector(0,4);
    ImageLoader iL;
    ImageResizer iR;
    Backgrounds backgrounds;
    int type;

    Oatmeal(PApplet p,float x, float y,ImageLoader iL,ImageResizer iR,Backgrounds backgrounds,int type){
        this.p=p;
        location.x=x+31*iR.scaleW;
        location.y=y+20*iR.scaleH;
        this.iL =iL;
        this.iR=iR;
        this.backgrounds = backgrounds;
        this.type=type;
        velocity1.set(velocity1.x*iR.scaleW,velocity1.y*iR.scaleH);
        velocity2.set(velocity2.x*iR.scaleW,velocity2.y*iR.scaleH);
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
        if (location.x <= enemy.x+64*iR.scaleW && location.x >= enemy.x && location.y <= enemy.y + 64*iR.scaleH && location.y >= enemy.y) {
            enemy.hp -= 1;
            oat.remove(i);
            backgrounds.monetos++;

        }

    }
    boolean outOfBounds(){
    if(location.x>p.width||location.y>p.height){
        return true;

    }
    return false;
    }

}
