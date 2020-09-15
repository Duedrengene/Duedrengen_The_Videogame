import processing.core.PApplet;
import processing.core.PFont;

public class Duedrengen_The_Videogame extends PApplet {
    int DIAMETER = 80, hastighed = 4;
    int level = 0;
    int dueAmount =2;
    int enemyAmount = 1;

    boolean mPressed = false;
    boolean settings = false;
    Player[] p;
    Enemy[] e;

    ImageLoader imgLoad = new ImageLoader(this);
    FontLoader fontLoad = new FontLoader(this);

    UncleRoger uncleroger = new UncleRoger(this,imgLoad,500,500, level);
    Backgrounds backgrounds = new Backgrounds(level, this,imgLoad,fontLoad);


    Button bStart = new Button(this,210,225-10,1,backgrounds);
    Button bSettings = new Button(this,210,390,2,backgrounds);
    Button bQuit = new Button(this,210,575-10,3,backgrounds);



    public static void main(String[] args ) {
        PApplet.main("Duedrengen_The_Videogame");
    }

    @Override
    public void setup() {
        super.setup();
        imgLoad.loadTheImages();
        fontLoad.loadFonts();

        p = new Player[100];
        e = new Enemy[100];
        frameRate(1000);

        ellipseMode(CENTER);
        //imgLoad.loadPImage();




        for(int i = 0;i<100;i++)
            p[i] = new Player((int)random(0,1920), (int)random(0,1080), DIAMETER, hastighed,imgLoad, level,this);

    }

    public void settings() {
        size(1920, 1080);
        smooth(8);

    }



    public void draw() {
        //background(0,255,0);
        background(53,101,77);
        backgrounds.simulate();
        uncleroger.draw(level);
        backgrounds.simulate();


        textFont(fontLoad.Lilletitelfont);
        textSize(56);
        fill(253, 106, 2);
        //Play
        settings = bStart.registrerClick(mPressed,settings);
        bStart.draw(level,settings);
        //Settings
        settings = bSettings.registrerClick(mPressed,settings);
        bSettings.draw(level,settings);
        //Quit
        settings = bQuit.registrerClick(mPressed,settings);
        bQuit.draw(level,settings);

fill(0,0,0);



        for(int i = 0;i<dueAmount;i++){

            p[i].move();
            p[i].display(backgrounds.level);
            uncleroger.detectPlayer(p[i]);
            uncleroger.draw(backgrounds.level);

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
        }

    }

    public void keyReleased() {
        for(int i = 0;i<dueAmount;i++){
            p[i].setMove(keyCode, false,i);
        }

    }



    public void mousePressed(){
    mPressed = true;
    }




}
