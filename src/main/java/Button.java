import processing.core.PApplet;

public class Button {


    float xPosition, yPosition;
    float hojde = 60, bredde = 200;
    PApplet p;
    boolean klikket;
    int buttonType;
    FontLoader fL;
    Backgrounds backgrounds;
    Button(PApplet p, float x, float y,int buttonType,Backgrounds backgrounds){
        this.xPosition = x;
        this.yPosition = y;
        this.p =p;
        this.buttonType=buttonType;
    this.backgrounds = backgrounds;
    }


    void draw(int level,boolean settings) {
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
        p.rectMode(p.CENTER);
            p.fill(255);
       // p.rect(xPosition, yPosition, bredde, hojde,10);


    }}

    boolean registrerClick(boolean mPressed,boolean settings) {

        if (mPressed && p.mouseX < xPosition + bredde/2 && p.mouseX > xPosition-bredde/2 && p.mouseY > yPosition-hojde/2 && p.mouseY < yPosition + hojde/2) {
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
                    else ;
                    break;
                }
                case 3: {
                    if (settings)
                        settings = false;
                    else {
                        p.exit();
                    }
                    System.out.println(buttonType   );
                    break;
                }
                default:
            }
        }

        return settings;
    }
 
    boolean erKlikket() {
        return klikket;
    }
}