import processing.core.PApplet;
import processing.core.PVector;

public class Oatmeal {
    PApplet p;
    PVector location = new PVector();
    PVector velocity = new PVector(3,0);
    ImageLoader iL;



    Oatmeal(PApplet p,float x, float y,ImageLoader iL){
        this.p=p;
        location.x=x+31;
        location.y=y+20;
        this.iL =iL;
    }

    void drawOatmeal(){
        p.fill(0);
        p.image(iL.oatmeal,location.x,location.y);
    }
    void moveOatmeal(){

        location.add(velocity);
    }
}
