import processing.core.PApplet;

public class Knap
{
    PApplet p;
    float positionx;
    float positiony;
    float stoerrelsex;
    float stoerrelsey;
    Knap(PApplet p,float a, float b, float c, float d)
    {
        positionx = a ;
        positiony = b ;
        stoerrelsex = c ;
        stoerrelsey = d ;
        this.p =p;
    }
    void Tegnknap()
    {
        p.rect(positionx,positiony,stoerrelsex,stoerrelsey);


    }






}