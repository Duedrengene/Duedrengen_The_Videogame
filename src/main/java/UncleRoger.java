import processing.core.PApplet;
import processing.core.PVector;

public class UncleRoger {
    PApplet p;
    PVector position = new PVector();
    //ArrayList<PVector> floorPoints = new ArrayList<PVector>();

    boolean p1shopOpen;
    boolean p2shopOpen;
    ImageLoader unclePic;
    int level;
    boolean i1b,i2b,i3b,i4b,i5b,i6b,i7b,i8b,i9b,i10b;
    boolean someoneIsClose;
    ImageResizer iR;


UncleRoger(PApplet p,ImageLoader iL,int posX,int posY,int level,ImageResizer iR){
    this.p = p;
    this.iR = iR;
    this.position.x = posX;
    this.position.y = posY;
    this.unclePic = iL;
    this.level = level;

}

void draw(int level){
    this.level=level;

    if(level != 0){
    p.image(unclePic.uncleRoger,position.x,position.y);


    p.textSize(18);

    if(someoneIsClose==true){
        p.fill(0);
        p.textSize(18);
        p.text("Want some MSG? (Interact with me)",position.x-20,position.y-20);
    }
}
    
}

void detectCharacter(Character character){
    if(position.x-20<= character.location.x+64 && position.x+80> character.location.x&&position.y-20<= character.location.y+64 && position.y+80> character.location.y){
        someoneIsClose = true;
    }else{
        someoneIsClose=false;
    }
}
void lukShop(Character character){
    if (character.goBackp1 == true && p1shopOpen == true) {
        p1shopOpen=false;
    }
    if (character.goBackp2 == true && p2shopOpen == true) {
        p2shopOpen=false;
    }
    }
void drawshop(Character character, int i) {
    p.rectMode(p.CORNER);


    if ((level != 0 && i==0 && character.interact==true && someoneIsClose)||p1shopOpen == true) {

        p.fill(255,108,0);
        p.rect(100*iR.scaleW, 200*iR.scaleH, (1020)/2*iR.scaleW, 680*iR.scaleH);
        //Uncommon Item for player 1
        p.fill(108,255,0);

      p.rect(140*iR.scaleW,340*iR.scaleH,64*iR.scaleW,64*iR.scaleH);//
        p.image(unclePic.havregryn,140*iR.scaleW,340*iR.scaleH);
       p.rect(490*iR.scaleW,340*iR.scaleH,64*iR.scaleW,64*iR.scaleH);//
        p.image(unclePic.friedrice,490*iR.scaleW,340*iR.scaleH );
        p.rect(490*iR.scaleW,540*iR.scaleH,64*iR.scaleW,64*iR.scaleH);//
        p.image(unclePic.msgbull,490*iR.scaleW,540*iR.scaleH);
        p.rect(140*iR.scaleW,740*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.image(unclePic.Syringe,140*iR.scaleW,740*iR.scaleH);
        p.rect(490*iR.scaleW,740*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.rect(267*iR.scaleW,285*iR.scaleH,20*iR.scaleW,20*iR.scaleH);

        p.fill(0);
        p.textSize(30*iR.scaleW);
        p.text("Uncle Rogers Shop",345*iR.scaleW,240*iR.scaleH);
        p.textSize(18*iR.scaleW);
        p.text("Uncommon item: ",200*iR.scaleW,300*iR.scaleH);
        //Ability Player 1
        p.text("Ability:",480*iR.scaleW,300*iR.scaleH);
        p.fill(63,72,204);
        p.rect(507*iR.scaleW,285*iR.scaleH,20*iR.scaleW,20*iR.scaleH);
        p.rect(140*iR.scaleW,540*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.image(unclePic.fjer,140*iR.scaleW,540*iR.scaleH);
        p1shopOpen = true;

    }
    if ((level != 0  && i==1 && character.interact==true && someoneIsClose)||p2shopOpen == true) {
        p.fill(255,108,0);
        p.rect((1920/2+100)*iR.scaleW, 200*iR.scaleH, ((1920- 900)/2)*iR.scaleW, (1080 - 400)*iR.scaleH);

// Uncommon items for player 2
        p.fill(108,255,0);
        p.rect((1920/2+140)*iR.scaleW,340*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.image(unclePic.havregryn,(1920/2+140)*iR.scaleW,340*iR.scaleH);
        p.rect((1920/2+490)*iR.scaleW,340*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.image(unclePic.friedrice,(1920/2+490)*iR.scaleW,340 *iR.scaleH);
        p.rect((1920/2+490)*iR.scaleW,540*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.image(unclePic.msgbull,(1920/2+490)*iR.scaleW,540*iR.scaleH);
        p.rect((1920/2+140)*iR.scaleW,740*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.image(unclePic.Syringe,(1920/2+140)* iR.scaleW,740* iR.scaleH);
        p.rect((1920/2+490)*iR.scaleW,740*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.rect((1920/2+267)* iR.scaleW,285*iR.scaleH,20* iR.scaleW,20* iR.scaleH);
        p.fill(0);
        p.textSize(30*iR.scaleW);
        p.text("Uncle Rogers Shop",(1920/2+345)*iR.scaleW,240*iR.scaleH);
        p.textSize(18* iR.scaleW);
        p.text("Uncommon item: ",(1920/2+200)*iR.scaleW,300*iR.scaleH);
        //Ability Player 1
        p.text("Uncommon item: ",1920/2+200*iR.scaleW,300*iR.scaleH);
        //Ability Player 2
        p.text("Ability:",(1920/2+480)*iR.scaleW,300* iR.scaleH);
        p.fill(63,72,204);
        p.rect((1920/2+507)*iR.scaleW,285*iR.scaleH,20*iR.scaleW,20* iR.scaleH);
        p.rect((1920/2+140)*iR.scaleW,540*iR.scaleH,64*iR.scaleW,64*iR.scaleH);
        p.image(unclePic.majs,(1920/2+140)*iR.scaleW,(540*iR.scaleH));
        p2shopOpen = true;
    }
}
void buyitem(Character character,int i,Backgrounds backgrounds){
    if (i == 0&&p1shopOpen){
    if(character.location.x + 64 * iR.scaleW>140*iR.scaleW&&character.location.x <140*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>340*iR.scaleH  && character.location.y<340*iR.scaleH+64*iR.scaleH&&character.interact && backgrounds.monetos>=1+character.n1 && !i1b){
    character.shotAmount++;
    backgrounds.monetos--;
        character.n1++;
    }
        if(character.location.x + 64 * iR.scaleW>490*iR.scaleW&&character.location.x <490*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>340*iR.scaleH  && character.location.y<340*iR.scaleH+64*iR.scaleH &&character.interact && backgrounds.monetos>=1+character.n2 && !i2b){
            character.hp++;
            character.n2++;
        }
        if(character.location.x + 64 * iR.scaleW>490*iR.scaleW&&character.location.x <490*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>540*iR.scaleH  && character.location.y<540*iR.scaleH+64*iR.scaleH &&character.interact && backgrounds.monetos>=1+character.n3 && !i3b){
           character.v += 0.3;
            backgrounds.monetos--;
            character.n3++;
        }
        if(character.location.x + 64 * iR.scaleW>140*iR.scaleW&&character.location.x <140*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>740*iR.scaleH  && character.location.y<740*iR.scaleH+64*iR.scaleH &&character.interact && backgrounds.monetos>=1+character.n4 && !i4b){
            p.println("hej");
            backgrounds.monetos--;
            character.n4++;
        }
        if(character.location.x + 64 * iR.scaleW>140*iR.scaleW&&character.location.x <140*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>540*iR.scaleH  && character.location.y<540*iR.scaleH+64*iR.scaleH &&character.interact && backgrounds.monetos>=1+character.n5 && !i5b){
            p.println("hej");
            backgrounds.monetos--;
            character.n5++;
        }

    }
    if (i == 1&&p2shopOpen){
        if(character.location.x + 64 * iR.scaleW>(1920/2+140)*iR.scaleW&&character.location.x <(1920/2+140)*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>340*iR.scaleH  && character.location.y<340*iR.scaleH+64*iR.scaleH &&character.interact && backgrounds.monetos>=1+character.n1 && !i6b){
            p.println("hej");
            backgrounds.monetos--;
            character.n1++;
        }
        if(character.location.x + 64 * iR.scaleW>(1920/2+490)*iR.scaleW&&character.location.x <(1920/2+490)*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>340*iR.scaleH  && character.location.y < 340 * iR.scaleH + 64 * iR.scaleH && character.interact && backgrounds.monetos >= 1 + character.n2 && !i7b){
            character.hp++;
            backgrounds.monetos--;
            character.n2++;
        }
        if(character.location.x + 64 * iR.scaleW>(1920/2+490)*iR.scaleW&&character.location.x <(1920/2+490)*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>540*iR.scaleH  && character.location.y < 540 * iR.scaleH + 64 * iR.scaleH && character.interact && backgrounds.monetos >= 1 + character.n3 && !i8b){
            character.h += 0.3;
            backgrounds.monetos--;
            character.n3++;
        }
        if(character.location.x + 64 * iR.scaleW>(1920/2+140)*iR.scaleW&&character.location.x <(1920/2+140)*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>740*iR.scaleH  && character.location.y<740*iR.scaleH+64*iR.scaleH &&character.interact && backgrounds.monetos>=1+character.n4 && !i9b){
            p.println("hej");
            backgrounds.monetos--;
            character.n4++;
        }
        if(character.location.x + 64 * iR.scaleW>(1920/2+140)*iR.scaleW&&character.location.x <(1920/2+140)*iR.scaleW + 64 * iR.scaleW && character.location.y+64*iR.scaleH>540*iR.scaleH  && character.location.y<540*iR.scaleH+64*iR.scaleH &&character.interact && backgrounds.monetos>=1+character.n5 && !i10b){
            p.println("hej");
            backgrounds.monetos--;
            character.n5++;
        }


    }
    }

}


