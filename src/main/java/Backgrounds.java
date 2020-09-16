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


    boolean simulate(Player player) {
        boolean result = false;

        if (level == 0) {
            p.image(iL.startup, 0, 0);
            p.text("Velkommen tilbage Agent Duedreng!", 960*iR.scaleW, 85*iR.scaleH);
            p.fill(0);

            }else if(playerCreate == false){
            result = true;
            playerCreate = true;
        
            
        if(player.hp <= 0){
            p.image(iL.deathscreen, 0, 0);
            p.fill(220, 20, 60);
            p.textAlign(p.CENTER);
            p.textFont(fL.titelFont);
            p.text("You died >:(", 960, 85);
            p.fill(0);
        }
		        return result;
        }

    }





