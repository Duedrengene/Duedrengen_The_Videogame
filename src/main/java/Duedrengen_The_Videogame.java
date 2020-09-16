import processing.core.PApplet;

import java.awt.*;

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

    UncleRoger uncleroger = new UncleRoger(this,imgLoad,width/2-32,height/2-32, level);
    Backgrounds backgrounds = new Backgrounds(level, this,imgLoad,fontLoad);


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

        p = new Player[100];
        e = new Enemy[100];
        frameRate(1000);

        ellipseMode(CENTER);
        //imgLoad.loadPImage();




        for(int i = 0;i<100;i++)
            p[i] = new Player((int)random(0,1920), (int)random(0,1080), diameter, speed,imgLoad, level,this);

    }

    public void settings() {


        size(1920, 1080);

        smooth(8);

    }






    public void draw() {



        //background(0,255,0);
        background(53,101,77);
        for(int i = 0;i<dueAmount;i++) {
            backgrounds.simulate(p[i]);
        }
        uncleroger.draw(level);


        for(int i = 0;i<dueAmount;i++){
        textFont(fontLoad.smallTitelFont);
        textSize(56);
        fill(253, 106, 2);
        //Play
        settings = bStart.registerClick(mPressed,settings);
        bStart.draw(level,settings,p[i]);
        //Settings
        settings = bSettings.registerClick(mPressed,settings);
        bSettings.draw(level,settings,p[i]);
        //Quit
        settings = bQuit.registerClick(mPressed,settings);
        bQuit.draw(level,settings,p[i]);

fill(0,0,0);







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
