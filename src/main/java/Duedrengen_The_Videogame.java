
import processing.core.PApplet;

import java.util.ArrayList;

public class Duedrengen_The_Videogame extends PApplet {


    int speed = 4;
    int level = 0;
    int dueAmount = 2;
    int enemyAmount = 1;
    int width = 1920;
    int height = 1080;
    ArrayList<SpecialMove> specialList = new ArrayList<>();
    ArrayList<Oatmeal> oatList = new ArrayList<>();
    boolean gameOver = false;
    boolean mPressed = false;
    boolean settings = false;
    Character[] p;
    ImageLoader imgLoad = new ImageLoader(this);
    ImageResizer imgResize = new ImageResizer(this, width, height, imgLoad);
    SoundLoader soundLoad = new SoundLoader(this);
    FontLoader fontLoad = new FontLoader(this);
    UncleRoger uncleroger;
    Backgrounds backgrounds = new Backgrounds(level, this, imgLoad, fontLoad, imgResize);
    ArrayList<Enemy> enemyList = new ArrayList<>();
    Button bStart = new Button(this, 210, 225 - 10, 1, backgrounds, imgResize);
    Button bSettings = new Button(this, 210, 390, 2, backgrounds, imgResize);
    Button bQuit = new Button(this, 210, 575 - 10, 3, backgrounds, imgResize);

    public static void main(String[] args) {
        PApplet.main("Duedrengen_The_Videogame");
        Thread thread = new Thread();
        thread.start();
    }

    @Override
    public void setup() {
        super.setup();
        soundLoad.start();
        imgLoad.loadTheImages(1, width, height);
        fontLoad.loadFonts();

        p = new Character[dueAmount];
        frameRate(144);

        ellipseMode(CENTER);
        //imgLoad.loadPImage();
    }

    public void settings() {
        size(1920, 1080);
        smooth(8);
    }




    public void draw() {

        //soundLoad.playSounds();
        //background(0,255,0);
        background(53, 101, 77);

        fill(220, 20, 60);
        textAlign(CENTER);
        textFont(fontLoad.titelFont);
        textSize(84 * imgResize.scaleW);
        if (backgrounds.simulate()) {
            for (int i = 0; i < dueAmount; i++) {
                p[i] = new Character((int) random(0, 1920), (int) random(0, 1080), speed, imgLoad, level, this, imgResize, i,backgrounds,enemyList);
            }
            enemyList.add(new Enemy(200 * imgResize.scaleW, 200 * imgResize.scaleH, -2 * imgResize.scaleW, imgLoad, this, 1));
            uncleroger = new UncleRoger(this, imgLoad, imgResize.width / 2 , imgResize.height/2, level, imgResize);
        }
        if (p[0] != null)
            for (int i = 0; i < dueAmount; i++) {
                if (!gameOver) {
                    gameOver = backgrounds.gameover(p[i]);
                }
                if (gameOver) {
                    backgrounds.gameoverscreen(gameOver);
                }
            }
        if (!gameOver)
            if (uncleroger != null)
                // uncleroger.draw(level);
                textFont(fontLoad.smallTitelFont);
        textSize(56 * imgResize.scaleW);
        fill(253, 106, 2);
        //Play
        settings = bStart.registerClick(mPressed, settings, gameOver);
        bStart.draw(level, settings, gameOver);
        //Settings
        settings = bSettings.registerClick(mPressed, settings, gameOver);
        bSettings.draw(level, settings, gameOver);
        //Quit
        settings = bQuit.registerClick(mPressed, settings, gameOver);
        bQuit.draw(level, settings, gameOver);
        fill(0, 0, 0);

        if (!gameOver)
            if (p[0] != null) {
                for (int i = 0; i < dueAmount; i++) {
                    uncleroger.detectCharacter(p[i]);
                    uncleroger.draw(backgrounds.level);
                    uncleroger.lukShop(p[i]);
                    uncleroger.drawshop(p[i], i);
                }


                    if(p[0].levelTransition())
                    p[1].location.x=0;


                for (int i = 0; i < dueAmount; i++) {
                    p[i].iHaveShot = false;
                    p[i].move();
                    if (p[i].shoot == true) {

                        oatList.add(new Oatmeal(this, p[i].location.x, p[i].location.y, imgLoad,imgResize));
                        if(i==0)
                        image(imgLoad.duedrenganimation, p[i].location.x, p[i].location.y);
                        if(i==1)
                         image(imgLoad.dueShitting, p[i].location.x, p[i].location.y);
                        p[i].iHaveShot = true;
                    }
                    if (!p[i].iHaveShot)
                        p[i].display(backgrounds.level);
                }
                for (int i = 0; i < oatList.size(); i++) {
                    oatList.get(i).moveOatmeal();
                    oatList.get(i).drawOatmeal();
                    for(int j = 0;j<enemyList.size();j++){
                    oatList.get(i).hit(oatList,enemyList.get(j),i,uncleroger);
                    oatList.get(i).outOfBounds(oatList,i);
                    }
                }
                for (int i = 0; i < enemyList.size(); i++) {
                    enemyList.get(i).shoot();
                    if (enemyList.get(i).iShootNow == true) {
                    }
                    enemyList.get(i).display(backgrounds.level);
                    enemyList.get(i).move();
                    enemyList.get(i).imDead(enemyList,i);
                }

                for (int i = 0; i < dueAmount; i++) {
                    for (int j = 0; j < enemyList.size(); j++) {
                        p[i].colission(enemyList.get(j));
                    }

                }
               // println(oatList.size());
            }
        //text(frameRate,500,500);
        mPressed = false;
    }

    public void keyPressed() {
        if (p[0] != null)
            for (int i = 0; i < dueAmount; i++) {
                p[i].setMove(keyCode, true, i);
                p[i].interact(i, true, keyCode);
                p[i].goBack(i, true, keyCode);
                p[i].shoot(i, true, keyCode);
                //println(p[i].interact);
            }
    }

    public void keyReleased() {
        if (p[0] != null)
            for (int i = 0; i < dueAmount; i++) {
                p[i].setMove(keyCode, false, i);
                p[i].goBack(i, false, keyCode);
                p[i].interact(i, false, keyCode);
                p[i].shoot(i, false, keyCode);
            }
    }

    public void mousePressed() {
        mPressed = true;
    }

}
