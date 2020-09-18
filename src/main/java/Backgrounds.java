import processing.core.PApplet;

public class Backgrounds {
    PApplet p;
    int level;
    ImageLoader iL;
    FontLoader fL;
    boolean CharacterCreate = false;
    ImageResizer iR;

    Backgrounds(int Level, PApplet p, ImageLoader iL, FontLoader fL, ImageResizer iR) {
        this.iL = iL;
        this.level = Level;
        this.p = p;
        this.fL = fL;
        this.iR = iR;
    }


    boolean simulate() {
        boolean result = false;
      if(level==3) {
          p.image(iL.by,0,0);
          

      }
       if(level==2) {
           p.image(iL.uncleBaggrund,0,0);
       }
        if(level==1) {
            p.image(iL.by, 0, 0);
        }
        if (level == 0) {
            p.image(iL.startup, 0, 0);
            p.text("Velkommen tilbage Agent Duedreng!", 960 * iR.scaleW, 85 * iR.scaleH);
            p.fill(0);

        } else if (CharacterCreate == false) {
            result = true;
            CharacterCreate = true;


        }
        return result;


    }


    boolean gameover(Character character) {
        if (character.hp <= 0) {
            return true;
        }
        return false;
    }

    void gameoverscreen(boolean gameoverscreen) {
        if (gameoverscreen) {
            p.image(iL.deathscreen, 0, 0);
            p.fill(220, 20, 60);
            p.textAlign(p.CENTER);
            p.textFont(fL.titelFont);
            p.text("You died <:)", 960*iR.scaleW, 85*iR.scaleH);
            p.fill(0);
        }

    }
}





