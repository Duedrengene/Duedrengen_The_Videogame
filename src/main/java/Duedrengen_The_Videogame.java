import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Duedrengen_The_Videogame extends PApplet {
    public static void main(String[] args ) {
        PApplet.main("Duedrengen_The_Videogame");
    }



    int DIAMETER = 80, hastighed = 4;
    PFont Titelfont;
    PFont Lilletitelfont;
    Player[] p;
    int  Level = 0;
    ImageLoader imgLoad = new ImageLoader(this);
    int dueAmount =2;

    @Override
    public void setup() {
        super.setup();
        imgLoad.loadTheImages();

        Titelfont =createFont("Arial",84);
        Lilletitelfont = createFont("Arial",34);
        p= new Player[100];
        frameRate(1000);

        ellipseMode(CENTER);
        //imgLoad.loadPImage();




        for(int i = 0;i<100;i++)
            p[i] = new Player((int)random(0,1920), (int)random(0,1080), DIAMETER, hastighed,imgLoad,Level,this,Titelfont,Lilletitelfont);

    }
    public void settings() {
        size(1920, 1080);
        smooth(8);

    }



    public void draw() {
        //background(0,255,0);
        background(53,101,77);
        for(int i = 0;i<dueAmount;i++){

            p[i].move();
            p[i].display();
            p[i].simulate();
        }
        //text(frameRate,500,500);
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
