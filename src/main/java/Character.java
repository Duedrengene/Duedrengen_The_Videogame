import processing.core.PApplet;
import processing.core.PFont;

import java.awt.*;

import static processing.core.PApplet.constrain;
import static processing.core.PApplet.round;
import static processing.core.PConstants.*;

public class Character {

        boolean isLeft, isRight, isUp, isDown;
        boolean interact;
        boolean goBackp1, goBackp2;
        boolean shootp1, shootp2;
        float x, y;
        float v;
        int Level;
		int hp = 2;
        ImageLoader iL;
        PApplet p;
        ImageResizer iR;

        Character(int xx, int yy, int vv, ImageLoader iL, int Level, PApplet p, ImageResizer iR) {



            this.iL=iL;
            this.Level=Level;
            this.p = p;
            this.iR = iR;
            x = (xx-40)*iR.scaleW;
            y = (yy-40)*iR.scaleH;
            v = (round((float)vv*iR.scaleW));

        }

        void display(int level) {
            //ellipse(x, y, d, d);
            this.Level = level;
            if(this.Level ==1){

                p.image(iL.img,x,y);
            }
        }

        void move() {

            int r = (int)(64*iR.scaleW) >> 1;
            int isRightInt = isRight ? 1:0;
            int isLeftInt = isLeft ? 1:0;
            int isDownInt = isDown ? 1:0;
            int isUpInt = isUp ? 1:0;
            x = constrain(x + (v*iR.scaleW)*(isRightInt - isLeftInt), r, p.width  - r); //siden
            y = constrain(y + (v*iR.scaleW)*(isDownInt  - isUpInt),   r, p.height - r); //op,ned
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

                    case + 'M' :
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

        boolean goBack(int player,boolean b,int k){
            if(player == 0)
                switch (k) {

                    case +',':
                        return goBackp1=b;
                    default:
                        return b;
                }else if(player == 1)
                switch (k) {

                    case +'Q':
                        return goBackp2=b;
                    default:
                        return b;
                }else return b;
        }
    boolean shoot(int player,boolean b,int k){
        if(player == 0)
            switch (k) {

                case + ' ':
                    return shootp1=b;
                default:
                    return b;
            }else if(player == 1)
            switch (k) {

                case +'F':
                    return shootp2=b;
                default:
                    return b;
            }else return b;

    }
        void colission(Enemy enemy){
            if (x*iR.scaleW <= enemy.x*iR.scaleW + 64*iR.scaleW && x*iR.scaleW >= enemy.x*iR.scaleW && y*iR.scaleH <= enemy.y*iR.scaleH + 64*iR.scaleH && y*iR.scaleH >= enemy.y*iR.scaleH) {
                hp -= 1;
            }


        }
    }


