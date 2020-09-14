import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class FontLoader{


    PFont Titelfont;
    PFont Lilletitelfont;
        PImage img;
        PImage startup;
        PApplet p;
        PImage uncleRoger;
    FontLoader(PApplet p){
            this.p=p;
        }



        void loadFonts(){
            Titelfont = p.createFont("Arial",84);
            Lilletitelfont = p.createFont("Arial",34);

}}
