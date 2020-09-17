
import javazoom.jl.player.Player;
import processing.core.PApplet;

public class Duedrengen_The_Videogame extends PApplet {
    int speed = 4;
    int level = 0;
    int dueAmount = 2;
    int enemyAmount = 1;
    int width = 1920;
    int height = 1080;

    boolean gameOver = false;
    boolean mPressed = false;
    boolean settings = false;

    Character[] p;

    ImageLoader imgLoad = new ImageLoader(this);
    ImageResizer imgResize = new ImageResizer(this,width,height,imgLoad);
   SoundLoader soundLoad = new SoundLoader(this);
    FontLoader fontLoad = new FontLoader(this);


    UncleRoger uncleroger;
    Backgrounds backgrounds = new Backgrounds(level, this,imgLoad,fontLoad,imgResize);
    Enemy enemy = new Enemy(width/2, height/2, speed, imgLoad, level,this);


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


        p=new Character[dueAmount];
        frameRate(144);


        ellipseMode(CENTER);
        //imgLoad.loadPImage();





    }

    public void settings() {


        size(1920, 1080);

        smooth(8);

    }






    public void draw() {

       // soundLoad.playSounds();
        soundLoad.loadtheSounds();
        //background(0,255,0);
        background(53, 101, 77);
        fill(220, 20, 60);
        textAlign(CENTER);
        textFont(fontLoad.titelFont);
        textSize(84 * imgResize.scaleW);
        if (backgrounds.simulate()) {
            for (int i = 0; i < dueAmount; i++) {
                p[i] = new Character((int) random(0, 1920), (int) random(0, 1080), speed, imgLoad, level, this, imgResize);
            }
            uncleroger = new UncleRoger(this, imgLoad, width / 2 - 32, height / 2 - 32, level, imgResize);
        }

            if (p[0] != null)
                for (int i = 0; i < dueAmount; i++) {
                    gameOver =backgrounds.gameover(p[i]);
                }
            if(!gameOver)
        if (uncleroger != null)
        uncleroger.draw(level);



            textFont(fontLoad.smallTitelFont);

            textSize(56 * imgResize.scaleW);
            fill(253, 106, 2);
            //Play
            settings = bStart.registerClick(mPressed, settings,gameOver);
            bStart.draw(level, settings, gameOver);
            //Settings
            settings = bSettings.registerClick(mPressed, settings,gameOver);
            bSettings.draw(level, settings, gameOver);
            //Quit
            settings = bQuit.registerClick(mPressed, settings,gameOver);
            bQuit.draw(level, settings, gameOver);

            fill(0, 0, 0);

            if(!gameOver)
            if (p[0] != null){
                for (int i = 0; i < dueAmount; i++) {
                    uncleroger.detectPlayer(p[i]);
                    uncleroger.draw(backgrounds.level);
                    uncleroger.lukShop(p[i]);
                    uncleroger.drawshop(p[i], i);}

                for (int i = 0; i < dueAmount; i++) {

                    p[i].move();
                    p[i].display(backgrounds.level);

                }}
        if(!gameOver)
            for (int i = 0; i < enemyAmount; i++) {
                enemy.display(backgrounds.level);
                enemy.move();
            }
            //text(frameRate,500,500);
            mPressed = false;
        }

    public void keyPressed() {
        for(int i = 0;i<dueAmount;i++){
            p[i].setMove(keyCode, true,i);
            p[i].interact(i,true,keyCode);
            p[i].goBack(i,true,keyCode);
            println(p[i].interact);
        }

    }

    public void keyReleased() {
        for(int i = 0;i<dueAmount;i++){
            if(p[0]!=null){
            p[i].setMove(keyCode, false,i);
            p[i].goBack(i,false,keyCode);
            p[i].interact(i,false,keyCode);}
        }

    }



    public void mousePressed(){
    mPressed = true;
    }




}
