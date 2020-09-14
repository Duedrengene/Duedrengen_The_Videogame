import processing.core.PApplet;
import processing.core.PFont;

import static processing.core.PApplet.constrain;
import static processing.core.PConstants.*;

public class Player {
    PFont Titelfont;
    PFont Lilletitelfont;

    boolean isLeft, isRight, isUp, isDown;
    int x, y;
    int d, v;
    int Level;
    float xPosition = 210, yPosition = 250;
    float hojdetekst = 25, breddetekst = 250;
    boolean klikket;


    ImageLoader iL;
    PApplet p;


    Player(int xx, int yy, int dd, int vv, ImageLoader iL, int Level, PApplet p, PFont Titelfont, PFont lilletitelfont) {
        x = xx;
        //Hastighed i x retning.
        y = yy;
        //Hastighed i y retning.
        d = dd;
        //d = Størrelse af player (højde og bredde)
        v = vv;
        //v er med til at forme grænsen af vinduet i form af constrain.
        this.iL = iL;
        this.Level = Level;
        this.p = p;
        this.Titelfont = Titelfont;
        this.Lilletitelfont = lilletitelfont;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }


    void simulate() {
        if (Level == 0) {
            p.image(iL.startup, 0, 0);

            p.fill(220, 20, 60);
            p.textAlign(p.CENTER);
            p.textFont(Titelfont);
            p.text("Velkommen tilbage Agent Duedreng!", 960, 85);
            p.fill(0);
            p.textFont(Lilletitelfont);
            //p.text("Tryk på hvilken som helst tast for at starte spillet",960,880);


            p.textSize(56);
 p.fill(253,106,2);
            p.text("Play", 210, 225);
            p.text("Settings", 210, 400);
            p.text("Quit", 210, 575);
            if (p.keyPressed == true) {
                Level = 1;
            }
        }
    }

    void registrerKlikket() {
        if (p.mousePressed && p.mouseX < xPosition + breddetekst && p.mouseX > xPosition && p.mouseY < yPosition && p.mouseY < yPosition + hojdetekst) {
            klikket = true;
        } else {
            klikket = false;

        }
    }

    boolean erKlikket() {
        return klikket;
    }


        void display() {
            //ellipse(x, y, d, d);
            if(Level ==1){

                p.image(iL.img,x-40,y-40,d,d);
            }
        }

        void move() {
            int r = d >> 1;
            int isRightInt = isRight ? 1:0;
            int isLeftInt = isLeft ? 1:0;
            int isDownInt = isDown ? 1:0;
            int isUpInt = isUp ? 1:0;
            x = constrain(x + v*(isRightInt - isLeftInt), r, p.width  - r); //siden
            y = constrain(y + v*(isDownInt  - isUpInt),   r, p.height - r); //op,ned
        }
        boolean setMove(int k, boolean b,int player) {

            if(player ==0)
                switch (k) {

                    case UP:
                        return isUp = b;

                    case DOWN:
                        return isDown = b;

                    case LEFT:
                        return isLeft = b;

                    case RIGHT:
                        return isRight = b;

                    default:
                        return b;
                }else if(player ==1)
                switch (k) {

                    case +'W':
                        return isUp = b;

                    case +'S':
                        return isDown = b;

                    case +'A':
                        return isLeft = b;

                    case +'D':
                        return isRight = b;

                    default:
                        return b;
                }else return b;

        }
    }


