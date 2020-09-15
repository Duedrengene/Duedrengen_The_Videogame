import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class FontLoader{


    PFont titelFont;
    PFont smallTitelFont;
        PImage img;
        PImage startup;
        PApplet p;
        PImage uncleRoger;
    FontLoader(PApplet p){
            this.p=p;
        }



        void loadFonts(){
            titelFont = p.createFont("Arial",84);
            smallTitelFont = p.createFont("Arial",34);

}}
