import processing.core.PApplet;

public class Button {


    float xPosition, yPosition;
    float height = 60, width = 200;
    int buttonType;
    PApplet p;
    FontLoader fL;
    ImageResizer iR;
    Backgrounds backgrounds;
    int currentSize = 1;
    Button(PApplet p, float x, float y,int buttonType,Backgrounds backgrounds,ImageResizer iR){
        this.xPosition = x;
        this.yPosition = y;
        this.iR = iR;
        this.p =p;
        this.buttonType=buttonType;
    this.backgrounds = backgrounds;
    }


    void draw(int level,boolean settings,Player player) {
        if(backgrounds.level==0){
        if (settings) {
            p.text("Controls", 210, 225);
            p.text("Resolution", 210, 400);
            p.text("Back", 210, 575);
        }
        else{

            p.text("Play", 210, 225);
            p.text("Settings", 210, 400);
            p.text("Quit", 210, 575);
        }
    }
        if(player.hp <= 0){

        }
    }

    boolean registerClick(boolean mPressed, boolean settings) {

        if (mPressed && p.mouseX < xPosition + width /2 && p.mouseX > xPosition- width /2 && p.mouseY > yPosition- height /2 && p.mouseY < yPosition + height /2) {
            switch(buttonType){

                case 1: {
                    if (settings){
                }
                    else{backgrounds.level= 1;}
                    break;
                }
                case 2: {

                    if (settings == false) {
                        settings = true;


                    }
                    else{
                        currentSize++;
                        if (currentSize >=4)
                        currentSize =1;
                       iR.resize(currentSize);



                    }
                    break;
                }
                case 3: {
                    if (settings)
                        settings = false;
                    else {
                        p.exit();
                    }
                    break;
                }
                default:
            }
        }

        return settings;
    }
 

}