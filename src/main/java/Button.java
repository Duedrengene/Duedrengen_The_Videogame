import processing.core.PApplet;

public class Button {

    float xPosition, yPosition;
    float height = 60, width = 200;
    int buttonType;
    PApplet p;
    FontLoader fL;
    ImageResizer iR;
    Backgrounds backgrounds;
    int currentSize = 1;


    Button(PApplet p, float x, float y, int buttonType, Backgrounds backgrounds, ImageResizer iR) {
        this.xPosition = x;
        this.yPosition = y;
        this.iR = iR;
        this.p = p;
        this.buttonType = buttonType;
        this.backgrounds = backgrounds;
    }


    void draw(int level, boolean settings, boolean gamemOver) {
        float xNPosition = xPosition * iR.scaleW;
        float yNPosition = yPosition * iR.scaleH;
        if (backgrounds.level == 0) {

            if (settings) {
                if (buttonType == 1)
                    p.text("Controls", xNPosition, yNPosition);
                if (buttonType == 2)
                    p.text("Resolution", xNPosition, yNPosition);
                if (buttonType == 3)
                    p.text("Back", xNPosition, yNPosition);
            } else {

                if (buttonType == 1)
                    p.text("Play", xNPosition, yNPosition);
                if (buttonType == 2)
                    p.text("Settings", xNPosition, yNPosition);
                if (buttonType == 3)
                    p.text("Quit", xNPosition, yNPosition);
            }
        } else if (gamemOver) {
            if (buttonType == 1)
                p.text("Play Again", xNPosition, yNPosition);
            if (buttonType == 2)
                p.text("Main Menu", xNPosition, yNPosition);
            if (buttonType == 3)
                p.text("Quit", xNPosition, yNPosition);
        }
    }

    boolean registerClick(boolean mPressed, boolean settings, boolean gameOver) {
        float xNPosition = xPosition * iR.scaleW;
        float yNPosition = yPosition * iR.scaleH;
        // p.rect((xNPosition-(width*(iR.scaleW)/2)),(yNPosition - ((height*iR.scaleH) /2)),width,height);
     if(backgrounds.level==0||gameOver==true)
        if (mPressed && p.mouseX < xNPosition + ((width * iR.scaleW) / 2) && p.mouseX > xNPosition - ((width * iR.scaleW) / 2) && p.mouseY > yNPosition - ((height * iR.scaleH) / 2) && p.mouseY < yNPosition + ((height * iR.scaleH) / 2)) {
            switch (buttonType) {
                case 1: {
                    if (settings && backgrounds.level == 0) {
                    } else if (backgrounds.level == 0) {
                        backgrounds.level = 1;
                    } else if (gameOver) {
                        backgrounds.level = 1;
                        backgrounds.gameover = false;
                        backgrounds.gameoverscreen(false);
                        backgrounds.characterCreate = false;
                        backgrounds.reset = true;

                    }
                    break;
                }
                case 2: {

                    if (settings == false && backgrounds.level == 0) {
                        settings = true;
                    } else if (backgrounds.level == 0) {
                        currentSize++;
                        if (currentSize >= 4)
                            currentSize = 1;
                        iR.resize(currentSize);
                    } else if (gameOver) {
                        backgrounds.level = 0;
                        backgrounds.gameover = false;
                        backgrounds.gameoverscreen(false);
                        backgrounds.characterCreate = false;
                        backgrounds.reset = true;
                    }
                    break;
                }
                case 3: {
                    if (settings && backgrounds.level == 0)
                        settings = false;
                    else {
                        p.exit();
                    }
                    break;
                }
                default:
            }
        }
        return settings;
    }
}