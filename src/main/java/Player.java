import processing.core.PApplet;
import processing.core.PFont;

import static processing.core.PApplet.constrain;
import static processing.core.PConstants.*;

public class Player {

        boolean isLeft, isRight, isUp, isDown;
        boolean interact;
        int x, y;
        int d, v;
        int Level;
        ImageLoader iL;
        PApplet p;
        int hp = 2;


        Player(int xx, int yy, int dd, int vv,ImageLoader iL,int Level,PApplet p) {
            x = xx-40;
            y = yy-40;
            d = dd;
            v = vv;
            this.iL = iL;
            this.Level = Level;
            this.p = p;
        }

        void display(int level) {
            //ellipse(x, y, d, d);
            this.Level = level;
            if(this.Level ==1){

                p.image(iL.img,x,y);
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

            if(player == 0)
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
        boolean interact(int player,boolean b,int k){
            if(player == 0)
                switch (k) {

                    case +'M':
                        return interact=b;
                    default:
                        return b;
                }else if(player == 1)
                switch (k) {

                    case +'E':
                        return interact=b;
                    default:
                        return b;
                }else return b;
        }
    }


