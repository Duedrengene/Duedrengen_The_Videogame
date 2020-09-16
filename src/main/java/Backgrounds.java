import processing.core.PApplet;

public class Backgrounds {
    PApplet p;
    int level;
    ImageLoader iL;
    FontLoader fL;
    boolean playerCreate = false;
    ImageResizer iR;
    Backgrounds(int Level, PApplet p,  ImageLoader iL,FontLoader fL,ImageResizer iR) {
        this.iL = iL;
        this.level = Level;
        this.p = p;
        this.fL = fL;
        this.iR = iR;
    }

    boolean simulate() {
        boolean result = false;
        if (level == 0) {
            p.image(iL.startup, 0, 0);
            p.text("Velkommen tilbage Agent Duedreng!", 960*iR.scaleW, 85*iR.scaleH);
            p.fill(0);
            }else if(playerCreate == false){
            result = true;
            playerCreate = true;
        }
        return result;
        }
    }





