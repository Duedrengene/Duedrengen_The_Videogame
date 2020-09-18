
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Duedrengen_The_Videogame extends PApplet {

    boolean pressed = false;
    int speed = 4;
    int level = 0;
    int dueAmount = 2;
    int enemyAmount = 1;
    int width = 1920;
    int height = 1080;
    boolean alreadyRemoved;
    ArrayList<SpecialMove> specialList = new ArrayList<>();
    ArrayList<Oatmeal> oatListp1 = new ArrayList<>();
    ArrayList<Oatmeal> oatListp2 = new ArrayList<>();
    boolean gameOver = false;
    boolean mPressed = false;
    boolean settings = false;

    PVector gravity = new PVector(0, (float) 0.10);
    Character[] p;
    ImageLoader imgLoad = new ImageLoader(this);
    ImageResizer imgResize = new ImageResizer(this, width, height, imgLoad);

    FontLoader fontLoad = new FontLoader(this);
    UncleRoger uncleroger;
    Backgrounds backgrounds = new Backgrounds(level, this, imgLoad, fontLoad, imgResize);
    SoundLoader soundLoad = new SoundLoader(this, backgrounds);
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

        //Uncleroger and his background + player constuctor and enemy constuctor
        fill(220, 20, 60);
        textAlign(CENTER);
        textFont(fontLoad.titelFont);
        textSize(84 * imgResize.scaleW);
        if (uncleroger == null && backgrounds.level % 2 == 0 && backgrounds.level != 0)
            uncleroger = new UncleRoger(this, imgLoad, imgResize.width / 2, imgResize.height / 2, level, imgResize);
        if (backgrounds.simulate()) {
            for (int i = 0; i < dueAmount; i++) {
                p[i] = new Character(64, height/2 +1, speed, imgLoad, level, this, imgResize, i, backgrounds, enemyList, gravity);
            }
            enemyList.add(new Enemy(200 * imgResize.scaleW, 984 * imgResize.scaleH, -2 * imgResize.scaleW, imgLoad, this, 1));

        }
        //Background deathscreen
        if (p[0] != null)
            for (int i = 0; i < dueAmount; i++) {
                if (!gameOver) {
                    gameOver = backgrounds.gameover(p[i]);
                }
                if (gameOver) {
                    backgrounds.gameoverscreen(true);
                }
            }

        //Buttons
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

        //Unclerogers shop
        if (!gameOver)
            if (p[0] != null) {
                if (uncleroger != null)
                    for (int i = 0; i < dueAmount; i++) {
                        uncleroger.detectCharacter(p[i]);
                        uncleroger.draw(backgrounds.level);
                        uncleroger.lukShop(p[i]);
                        uncleroger.drawshop(p[i], i);
                        uncleroger.buyitem(p[i], i, backgrounds);
                    }

                //level transition
                int var = p[0].levelTransition(pressed, oatListp1);

                if (var != 0)
                    p[1].location.x = 0;
                if (var == 2)
                    uncleroger = null;


                //Due and duedreng attack configurations
                for (int i = 0; i < dueAmount; i++) {
                    p[i].iHaveShot = false;
                    p[i].move();
                    if (p[i].shoot == true && oatListp1.size() <= p[i].shotAmount && i==0) {

                        oatListp1.add(new Oatmeal(this, p[i].location.x, p[i].location.y, imgLoad, imgResize, backgrounds,0));
                        if (i == 0)
                            image(imgLoad.duedrenganimation, p[i].location.x, p[i].location.y);
                        if (i == 1)
                            image(imgLoad.dueShitting, p[i].location.x, p[i].location.y);
                        p[i].iHaveShot = true;
                    }
                    if (p[i].shoot == true && oatListp2.size() <= p[i].shotAmount && i == 1) {

                        oatListp2.add(new Oatmeal(this, p[i].location.x, p[i].location.y, imgLoad, imgResize, backgrounds,1));
                        if (i == 0)
                            image(imgLoad.duedrenganimation, p[i].location.x, p[i].location.y);
                        if (i == 1)
                            image(imgLoad.dueShitting, p[i].location.x, p[i].location.y);
                        p[i].iHaveShot = true;
                    }
                    if (!p[i].iHaveShot)
                        p[i].display(backgrounds.level);
                }
                for (int i = 0; i < oatListp1.size(); i++) {
                    alreadyRemoved=false;
                    oatListp1.get(i).moveOatmeal();
                    oatListp1.get(i).drawOatmeal();

                    if(oatListp1.get(i).outOfBounds(oatListp1,i)){
                        oatListp1.remove(i);
                        alreadyRemoved=true;}
                    for(int j = 0;j<enemyList.size();j++){
                        if(!alreadyRemoved)
                            oatListp1.get(i).hit(oatListp1,enemyList.get(j),i);

                    



                    }

                }
                for (int i = 0; i < oatListp2.size(); i++) {
                    alreadyRemoved=false;
                    oatListp2.get(i).moveOatmeal();
                    oatListp2.get(i).drawOatmeal();
                    if(oatListp2.get(i).outOfBounds(oatListp2,i)){
                        oatListp2.remove(i);
                        alreadyRemoved=true;}
                    for(int j = 0;j<enemyList.size();j++){
                        if(!alreadyRemoved)
                        oatListp2.get(i).hit(oatListp2,enemyList.get(j),i);




                    }
                }

                //Enemy functions
                for (int i = 0; i < enemyList.size(); i++) {
                    enemyList.get(i).shoot();
                    if (enemyList.get(i).iShootNow == true) {
                    }
                    enemyList.get(i).display(backgrounds.level);
                    enemyList.get(i).move();
                    enemyList.get(i).imDead(enemyList, i);
                }

                for (int i = 0; i < dueAmount; i++) {
                    for (int j = 0; j < enemyList.size(); j++) {
                        p[i].colission(enemyList.get(j));
                    }

                }
            }
        //text(frameRate,500,500);
        mPressed = false;
        println(oatListp1.size(), "", oatListp2.size());
    }

    //Key to initiate actions
    public void keyPressed() {
        pressed = true;
        if (p[0] != null)
            for (int i = 0; i < dueAmount; i++) {
                p[i].setMove(keyCode, true, i);
                p[i].interact(i, true, keyCode);
                p[i].goBack(i, true, keyCode);
                p[i].shoot(i, true, keyCode);
                //println(p[i].interact);
            }
    }

    //Keyreleased to stop initiated actions
    public void keyReleased() {
        pressed = false;
        if (p[0] != null)
            for (int i = 0; i < dueAmount; i++) {
                p[i].setMove(keyCode, false, i);
                p[i].goBack(i, false, keyCode);
                p[i].interact(i, false, keyCode);
                p[i].shoot(i, false, keyCode);
            }
    }

    //Initiator for buttons pressed
    public void mousePressed() {
        mPressed = true;
    }

}
