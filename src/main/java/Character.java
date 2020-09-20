//import jdk.internal.org.jline.terminal.MouseEvent;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;

import java.awt.*;
import java.util.ArrayList;

import static processing.core.PApplet.constrain;
import static processing.core.PApplet.round;
import static processing.core.PConstants.*;

public class Character {
    PVector location = new PVector();
    PVector gravity = new PVector();
    PVector velocity = new PVector();
    boolean isLeft, isRight, isUp, isDown;
    int n1, n2, n3, n4, n5;
    boolean interact;
    boolean goBackp1, goBackp2;
    boolean shoot;
    boolean iHaveShot;
    int shotAmount;
    float v, h;
    int Level;
    int dmg = 1;
    int hp = 2;
    int playerNumber;
    boolean iShootNow;
    Backgrounds background;
    ImageLoader iL;
    PApplet p;
    ImageResizer iR;
    ArrayList<Enemy> eList;

    Character(int xx, int yy, int vv, ImageLoader iL, int Level, PApplet p, ImageResizer iR, int playerNumber, Backgrounds background, ArrayList<Enemy> eList, PVector gravity) {
        this.playerNumber = playerNumber;
        this.iL = iL;
        this.Level = Level;
        this.p = p;
        this.iR = iR;
        location.set(((xx - 40) * iR.scaleW), ((yy - 40) * iR.scaleH));
        //  location.x = (xx - 40) * iR.scaleW;
        //location.y = (yy - 40) * iR.scaleH;
        v = (round((float) vv * iR.scaleW));
        this.background = background;
        this.eList = eList;
        if (playerNumber == 0)
            this.gravity.set(gravity.x, gravity.y * iR.scaleH);

    }

    public int levelTransition(boolean pressed, ArrayList<Oatmeal> oat,ArrayList<SpecialMove> specialList) {

        int result = 0;
        if (playerNumber == 0)
            if (location.x > iR.width - 100) {
                p.textMode(p.CENTER);
                p.text("Next Level (M) ", location.x, location.y - 50);


                if (p.key == 'm' && pressed) {
                    result = 1;
                    if (background.level % 2 == 0)
                        result = 2;
                    background.level++;
                    background.levelStart=true;
                    background.lifetext = 250;
                    location.x = 0;
                    oat.clear();
                    eList.clear();
                    specialList.clear();

                }
            }
        return result;
    }

    void display(int level) {

        this.Level = level;
        if (this.Level != 0) {
            if (playerNumber == 0)
                p.image(iL.duedreng, location.x, location.y);
            else
                p.image(iL.bulletdue, location.x, location.y);
        }
    }

    void move() {
        if (velocity.y > 1.5) {
            velocity.set(velocity.x, (float) 1.5);
        }
        int r = (int) ((64 * iR.scaleW)) >> 1;
        int rY = (int) ((64 * iR.scaleH)) >> 1;
        float isRightInt = isRight ? 1 : 0;
        float isLeftInt = isLeft ? 1 : 0;
        float isDownInt = isDown ? 1 : 0 + gravity.y;
        float isUpInt = isUp ? 1 : 0;
        velocity.set(isRightInt - isLeftInt, velocity.y + isDownInt - isUpInt);
//System.out.println( velocity.y);
        if (playerNumber == 1 || background.level % 2 == 0)
            velocity.set(isRightInt - isLeftInt, isDownInt - gravity.y - isUpInt);
        location.x = constrain(location.x + (v + h * iR.scaleW) * (velocity.x), 0, iR.width - r * 3); //siden
        location.y = constrain(location.y + (v * iR.scaleH) * (velocity.y), 0, iR.height - rY * 3); //op,ned
        // System.out.println(velocity.y);
    }

    boolean setMove(int k, boolean b, int player) {
        if (player == 0)
            switch (k) {
                case UP:
                    if (background.level % 2 != 0) {
                        int rY = (int) ((64 * iR.scaleH)) >> 1;
                        if (location.y == iR.height - rY * 3) {
                            velocity.y = -3;
                        }
                        return isUp = false;
                    } else
                        return isUp = b;
                case DOWN:
                    return isDown = b;
                case LEFT:
                    return isLeft = b;
                case RIGHT:
                    return isRight = b;
                default:
                    return b;
            }
        else if (player == 1)
            switch (k) {
                case +'W':
                    return isUp = b;
                case +'S':
                    if (background.level % 2 != 0) {
                        if (location.y > iR.height / 2) {
                            return isDown = false;
                        } else
                            return isDown = b;
                    } else
                        return isDown = b;

                case +'A':
                    return isLeft = b;
                case +'D':
                    return isRight = b;
                default:
                    return b;
            }
        else return b;
    }

    boolean interact(int player, boolean b, int k) {
        if (player == 0)
            switch (k) {
                case +'M':
                    return interact = b;
                default:
                    return b;
            }
        else if (player == 1)
            switch (k) {
                case +'E':
                    return interact = b;
                default:
                    return b;
            }
        else return b;
    }

    boolean goBack(int player, boolean b, int k) {
        if (player == 0)
            switch (k) {
                case +',':
                    return goBackp1 = b;
                default:
                    return b;
            }
        else if (player == 1)
            switch (k) {
                case +'Q':
                    return goBackp2 = b;
                default:
                    return b;
            }
        else return b;
    }

    boolean shoot(int player, boolean b, int k) {
        if (player == 0)
            switch (k) {

                case +' ':
                    return shoot = b;
                default:
                    return b;
            }
        else if (player == 1)
            switch (k) {

                case +'F':
                    return shoot = b;
                default:
                    return b;
            }
        else return b;

    }

    void collision(Enemy enemy) {
        if (location.x <= enemy.x + 64 && location.x >= enemy.x && location.y <= enemy.y + 64 && location.y >= enemy.y) {
            hp -= dmg;
        }


    }


}


