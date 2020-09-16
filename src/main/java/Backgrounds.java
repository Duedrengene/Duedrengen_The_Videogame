import processing.core.PApplet;

public class Backgrounds {
    PApplet p;
    int level;
    ImageLoader iL;
    FontLoader fL;

    Backgrounds(int Level, PApplet p,  ImageLoader iL,FontLoader fL) {
        this.iL = iL;
        this.level = Level;
        this.p = p;
        this.fL = fL;
    }

    void simulate(Player player) {
        if (level == 0) {
            p.image(iL.startup, 0, 0);
            p.fill(220, 20, 60);
            p.textAlign(p.CENTER);
            p.textFont(fL.titelFont);
            p.text("Velkommen tilbage Agent Duedreng!", 960, 85);
            p.fill(0);



            }
        if(player.hp <= 0){
            p.image(iL.deathscreen, 0, 0);
            p.fill(220, 20, 60);
            p.textAlign(p.CENTER);
            p.textFont(fL.titelFont);
            p.text("You died >:(", 960, 85);


        }
        }

    }





