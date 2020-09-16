//My name is Ichigo Kurosaki, and I am retarded. This is my Bankai, it is also retarted
import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;

public class Duedrengen_The_Videogame extends PApplet {
    int diameter = 80, speed = 4;
    int level = 0;
    int dueAmount =2;
    int enemyAmount = 1;
    int width=1920;
    int height =1080;

	
    boolean mPressed = false;
    boolean settings = false;

    Player[] p;
    Enemy[] e;

    ImageLoader imgLoad = new ImageLoader(this);
    ImageResizer imgResize = new ImageResizer(this,width,height,imgLoad);
    FontLoader fontLoad = new FontLoader(this);

    UncleRoger uncleroger;
    Backgrounds backgrounds = new Backgrounds(level, this,imgLoad,fontLoad,imgResize);

    Button bStart = new Button(this,210,225-10,1,backgrounds,imgResize);
    Button bSettings = new Button(this,210,390,2,backgrounds,imgResize);
    Button bQuit = new Button(this,210,575-10,3,backgrounds,imgResize);




    public static void main(String[] args ) {
        PApplet.main("Duedrengen_The_Videogame");
    }

    @Override
    public void setup() {
        super.setup();
        imgLoad.loadTheImages(1,width,height);
        fontLoad.loadFonts();

        p=new Player[dueAmount];
        e = new Enemy[100];
        frameRate(144);

        ellipseMode(CENTER);
        //imgLoad.loadPImage();




    }

    public void settings() {


        size(1920, 1080);

        smooth(8);

    }






    public void draw() {



        //background(0,255,0);
        background(53,101,77);
        fill(220, 20, 60);
        textAlign(CENTER);
        textFont(fontLoad.titelFont);
        textSize(84*imgResize.scaleW);
        if(backgrounds.simulate()){
            for(int i = 0;i < dueAmount; i++) {
                p[i] = new Player((int) random(0, 1920), (int) random(0, 1080), speed, imgLoad, level, this, imgResize);
            }
            uncleroger = new UncleRoger(this,imgLoad,width/2-32,height/2-32, level,imgResize);
        }
        if(uncleroger != null)
        uncleroger.draw(level);
        backgrounds.simulate();


        textFont(fontLoad.smallTitelFont);

        textSize(56*imgResize.scaleW);
        fill(253, 106, 2);
        //Play
        settings = bStart.registerClick(mPressed,settings);
        bStart.draw(level,settings);
        //Settings
        settings = bSettings.registerClick(mPressed,settings);
        bSettings.draw(level,settings);
        //Quit
        settings = bQuit.registerClick(mPressed,settings);
        bQuit.draw(level,settings);

fill(0,0,0);

if( p[0] != null)
        for(int i = 0;i<dueAmount;i++){



            uncleroger.detectPlayer(p[i]);
            uncleroger.draw(backgrounds.level);
            uncleroger.drawshop(p[i],i);
            p[i].move();
            p[i].display(backgrounds.level);


        }
        //text(frameRate,500,500);
        for(int i = 0;i<enemyAmount;i++){
            //e[i].display();
        }
        mPressed = false;
    }

    public void keyPressed() {
        for(int i = 0;i<dueAmount;i++){
            p[i].setMove(keyCode, true,i);
            p[i].interact(i,true,keyCode);
            println(p[i].interact);
        }

    }

    public void keyReleased() {
        for(int i = 0;i<dueAmount;i++){
            p[i].setMove(keyCode, false,i);
            p[i].interact(i,false,keyCode);
        }

    }



    public void mousePressed(){
    mPressed = true;
    }




}
