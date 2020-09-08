import processing.core.PApplet;

public class Player extends Duedrengen_The_Videogame {


        boolean isLeft, isRight, isUp, isDown;
        int x, y;
        int d, v;
        int Level;
        ImageLoader iL;
        PApplet p;


        Player(int xx, int yy, int dd, int vv,ImageLoader iL,int Level) {
            x = xx;
            y = yy;
            d = dd;
            v = vv;
            this.iL=iL;
            this.Level=Level;


        }




        void simulate() {
            if(Level ==0) {
                image(iL.startup,0,0);

                fill(220,20,60);
                textAlign(CENTER);
               // textFont(Titelfont);
                text("Velkommen tilbage Agent Duedreng!", 960, 85);
                fill(0);
                //textFont(Lilletitelfont);
                text("Tryk på hvilken som helst tast for at starte spillet",960,880);
                if(keyPressed == true) {
                    Level =1;
                }
            }
        }
        void display() {
            //ellipse(x, y, d, d);
            if(Level ==1){

                image(iL.img,x-40,y-40,d,d);
            }
        }

        void move() {
            int r = d >> 1;
            //x = constrain(x + v*(int(isRight) - int(isLeft)), r, width  - r);//siden
            //y = constrain(y + v*(int(isDown)  - int(isUp)),   r, height - r);//op,ned
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


