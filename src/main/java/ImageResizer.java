import processing.core.PApplet;

public class ImageResizer {

PApplet p;
int width;
int height;
ImageLoader iL;

    ImageResizer(PApplet p,int width,int height,ImageLoader iL) {
        this.width=width;
        this.height = height;
        this.p=p;
        this.iL = iL;
}

void resize(int var){

        switch(var){

            case 1:{
                 width = 1920;
                 height = 1080;
                 break;}
            case 2:{
                width = 1280;
                height = 720;

                break;
            }
            case 3: {
                width = 854;
                height = 480;

                break;
            }

            default:
                break;
        }

        iL.loadTheImages(var,width,height);
        p.getSurface().setSize(width,height);
}


}

