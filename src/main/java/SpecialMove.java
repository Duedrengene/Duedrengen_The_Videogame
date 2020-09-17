import processing.core.PApplet;
import processing.core.PVector;

public class SpecialMove {
    PApplet p;
    PVector location = new PVector();
    PVector velocity = new PVector(3,0);




    SpecialMove(PApplet p,float x, float y){
        this.p=p;
        location.x=x+31;
        location.y=y+20;

    }

    void drawSpecialMove(){

        p.ellipse(location.x,location.y,10,10);
    }
    void moveSpecialMove(){

        location.add(velocity);
    }
}
