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
            float  xNPosition=xPosition*iR.scaleW;
            float  yNPosition=yPosition*iR.scaleH;
        if (settings) {
            if(buttonType==1)
            p.text("Controls", xNPosition, yNPosition);
            if(buttonType==2)
            p.text("Resolution", xNPosition, yNPosition);
            if(buttonType==3)
            p.text("Back", xNPosition, yNPosition);
        }
        else{

            if(buttonType==1)
            p.text("Play", xNPosition, yNPosition);
            if(buttonType==2)
            p.text("Settings", xNPosition, yNPosition);
            if(buttonType==3)
            p.text("Quit", xNPosition, yNPosition);


        }
    }
        if(player.hp <= 0){

        }
    }

    boolean registerClick(boolean mPressed, boolean settings) {
        float  xNPosition=xPosition*iR.scaleW;
        float  yNPosition=yPosition*iR.scaleH;
       // p.rect((xNPosition-(width*(iR.scaleW)/2)),(yNPosition - ((height*iR.scaleH) /2)),width,height);
        if (mPressed && p.mouseX < xNPosition + ((width*iR.scaleW) /2) && p.mouseX > xNPosition- ((width*iR.scaleW) /2) && p.mouseY > yNPosition- ((height*iR.scaleH) /2) && p.mouseY < yNPosition + ((height*iR.scaleH) /2)) {
            switch(buttonType){

                case 1: {
                    if (settings){
                }
                    else{
                        backgrounds.level=1;
                    }
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