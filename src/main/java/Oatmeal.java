import processing.core.PApplet;
import processing.core.PVector;

public class Oatmeal {
    PApplet p;
    PVector location = new PVector();
    PVector velocity = new PVector(3,0);




    Oatmeal(PApplet p,float x, float y){
        this.p=p;
        location.x=x+31;
        location.y=y+20;

    }

    void drawOatmeal(){
        p.fill(0);
        p.ellipse(location.x,location.y,10,10);
    }
    void moveOatmeal(){

        location.add(velocity);
    }
}
