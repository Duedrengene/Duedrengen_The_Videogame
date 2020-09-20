import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class SpecialMove {
    PApplet p;
    PVector location = new PVector();
    PVector velocity = new PVector(-3,0);
    ImageLoader iL;
    ImageResizer iR;



    SpecialMove(PApplet p,float x, float y,ImageResizer iR,ImageLoader iL){
        this.p=p;
        location.x=x;
        location.y=y+20*iR.scaleH;
        this.iR=iR;
        this.iL=iL;
    }

    void drawSpecialMove(){

        p.ellipse(location.x,location.y,10*iR.scaleW,10*iR.scaleH);
    }
    void moveSpecialMove(){

        location.add(velocity);
    }
    boolean outOfBounds(){
        if(location.x>p.width||location.y>p.height){
            return true;

        }
        return false;
    }
    void hit(ArrayList<SpecialMove> special, Character character, int i){
        if (special.get(i).location.x <= character.location.x+64*iR.scaleW && special.get(i).location.x >= character.location.x && special.get(i).location.y <= character.location.y + 64*iR.scaleH && special.get(i).location.y >= character.location.y) {
            character.hp -= 1;
            special.remove(i);


        }

    }
}
