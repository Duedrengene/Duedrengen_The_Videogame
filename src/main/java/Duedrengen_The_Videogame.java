import processing.core.PApplet;
import processing.core.PFont;

public class Duedrengen_The_Videogame extends PApplet {
    int DIAMETER = 80, hastighed = 4;
    PFont Titelfont;
    PFont Lilletitelfont;
    Player[] p;
    Enemy[] e;
    int level = 0;
    int width=1920;
    int heigth=1080;
    ImageLoader imgLoad = new ImageLoader(this);
    FontLoader fontLoad = new FontLoader(this);
    int dueAmount =2;
    UncleRoger uncleroger = new UncleRoger(this,imgLoad,width/2-32,500, level);
    Backgrounds backgrounds = new Backgrounds(level, this,imgLoad,fontLoad);

 Knap knap = new Knap(this,210,390);
    int enemyAmount = 1;

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
        knap.registrerSettings();
        knap.draw(level);





        for(int i = 0;i<dueAmount;i++){


            uncleroger.detectPlayer(p[i]);
            uncleroger.draw(backgrounds.Level);
            uncleroger.drawshop(p[i],i);
            p[i].move();
            p[i].display(backgrounds.Level);

        }
        //text(frameRate,500,500);
        for(int i = 0;i<enemyAmount;i++){
            //e[i].display();
        }
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








}
