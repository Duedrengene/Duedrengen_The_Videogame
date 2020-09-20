import processing.core.PApplet;

public class Backgrounds {
    PApplet p;
    int hp;
    int level;
    float lifetext =255;
    boolean text=true;
    int monetos;
    ImageLoader iL;
    FontLoader fL;
    boolean characterCreate = false;
    ImageResizer iR;
    boolean bossLevel = false;
    boolean gameover;
    boolean reset = false;

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
       if(level %2 ==0) {
           p.image(iL.uncleBaggrund,0,0);
           lifetext-=0.55;
           if(text==true) {
               p.fill(255,lifetext);
               p.text("Shopmaster",960*iR.scaleW,85*iR.scaleH);
           }
       }
        if(level%2==1) {
            p.image(iL.by, 0, 0);
        lifetext -=0.55;
        if(text==true) {
            p.fill(255, lifetext);
            p.text("City Groove",960*iR.scaleW,85*iR.scaleH);
        }
        }
        if (level == 0) {
            p.image(iL.startup, 0, 0);
            p.textFont(fL.titelFont);
            p.textSize(84*iR.scaleW);
            p.fill(253,106,2);
            p.text("Velkommen tilbage Agent Duedreng!", 960 * iR.scaleW, 85 * iR.scaleH);
            p.fill(0);

        } else if (characterCreate == false) {
            result = true;
            characterCreate = true;


        }
        if(level!=0) {
            p.textFont(fL.smallTitelFont);
            p.fill(255);
            p.text(monetos, 1855 * iR.scaleW, 60 * iR.scaleH);
            p.image(iL.msg, 1780 * iR.scaleW, 10 * iR.scaleH);
        }
        return result;


    }


    boolean gameover(Character character) {

        if (character.hp <= 0) {
            gameover = true;
        }
        return gameover;
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





