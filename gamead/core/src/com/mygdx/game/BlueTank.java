package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

import java.util.Random;

public class BlueTank extends Unity {

    private static final int FRAME_COLS = 6, FRAME_ROWS = 1;
    public static Animation<TextureRegion> walkAnimation;
    public static Sprite sprite;
    public static Texture tex;
    public static Boolean Actif = false;
    public static Boolean Moved = false;
    public static int posx =0;
    public static int posy =0;
    public static int posxFont =0;
    public static int posyFont =0;
    public static boolean HasMove = false;
    public static int life =200;
    public static int att =50;
    public static int def =5;
    public static boolean dead = false;
    public static float  stateTime;
    public static int depla = 3;

    public BlueTank(int x,int y){
        super();
        Unity(x,y);
        posx = x+32;
        posy = y+32;
        posxFont = x+32;
        posyFont = y+32;
    }

    public static int MaxInt(int a,int b){
        if (a < b){
            return a;
        }
        else{
            return b;
        }
    }

    public static boolean checkX(){
        return ((RedTank.posx / 64) * 64 != (Gdx.input.getX() / 64) * 64) || RedTank.dead;
    }

    public static boolean checkY(){

        return ((RedTank.posy/64)*64 != ((1025-Gdx.input.getY())/64)*64) || RedTank.dead;
    }

    public static boolean checkXs(){
        return ((RedSoldier.posx / 64) * 64 != (Gdx.input.getX() / 64) * 64) || RedSoldier.dead;
    }

    public static boolean checkYs(){
        return ((RedSoldier.posy/64)*64 != ((1025-Gdx.input.getY())/64)*64) || RedSoldier.dead;
    }

    public static boolean checkXt(){
        return ((BlueSoldier.posx / 64) * 64 != (Gdx.input.getX() / 64) * 64) || BlueSoldier.dead;
    }

    public static boolean checkYt(){
        return ((BlueSoldier.posy/64)*64 != ((1025-Gdx.input.getY())/64)*64) || BlueSoldier.dead;
    }

    public static boolean checkXvr(){
        return ((RedCar.posx / 64) * 64 != (Gdx.input.getX() / 64) * 64) || RedCar.dead;
    }

    public static boolean checkYvr(){
        return ((RedCar.posy/64)*64 != ((1025-Gdx.input.getY())/64)*64) || RedCar.dead;
    }


    public static boolean checkXv(){
        return ((BlueCar.posx / 64) * 64 != (Gdx.input.getX() / 64) * 64) || BlueCar.dead;
    }

    public static boolean checkYv(){
        return ((BlueCar.posy/64)*64 != ((1025-Gdx.input.getY())/64)*64) || BlueCar.dead;
    }

    public static void crea(){
        tex = new Texture(Gdx.files.internal("BlueTankAni.png"));
        TextureRegion[][] tmp = TextureRegion.split(tex,
                tex.getWidth() / FRAME_COLS,
                tex.getHeight() / FRAME_ROWS);
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation<TextureRegion>(0.25f, walkFrames);
        stateTime = 0f;
        sprite = new Sprite(tex);
        sprite.setPosition(posx, posy);
    }

    public static void create(){
        dead();
        if (Moved & (Gdx.input.isButtonPressed(Input.Buttons.LEFT))){
            if ((Tile.map[Gdx.input.getX()/64][(1025-Gdx.input.getY())/64] == 3)  ){
               if((checkX() || checkY()) && (checkXs() || checkYs()) && (checkXt() || checkYt()) && (checkXvr()  || checkYvr()) && (checkXv() || checkYv())  ){
                posx = (Gdx.input.getX() / 64) * 64;
                posy = ((1025 - Gdx.input.getY())/64) * 64;
                Move();
                attackerRedTank();
                attackerRedCar();
                attackerRedSoldier();
                Actif = false;
               }
            }
        }
    }



    public static void attackerRedCar(){
        Random random = new Random();
        int crit = random.nextInt(10) + 1;
        if ((((posx +64)/64)*64) == (RedCar.posx/64)*64 & ((((posy)/64)*64) == (RedCar.posy/64)*64)){
            if(crit == 1 || crit == 2){
                RedCar.life = MaxInt(RedCar.life -(att*2 - RedCar.def) ,RedCar.life-10);
            }
            else{
                RedCar.life = MaxInt(RedCar.life -(att - RedCar.def),RedCar.life-5);
            }

        }
        else if((((posx-64)/64)*64) == (RedCar.posx/64)*64 & ((((posy)/64)*64) == (RedCar.posy/64)*64))  {
            if(crit == 1 || crit == 2){
                RedCar.life = MaxInt(RedCar.life -(att*2 - RedCar.def),RedCar.life-10);
            }
            else{
                RedCar.life = MaxInt(RedCar.life -(att - RedCar.def),RedCar.life-5);
            }
        }
        else if((((posy-64)/64)*64) == (RedCar.posy/64)*64 & (((posx )/64)*64) == (RedCar.posx/64)*64)  {
            if(crit == 1 || crit == 2){
                RedCar.life = MaxInt(RedCar.life -(att*2 - RedCar.def),RedCar.life-10);
            }
            else{
                RedCar.life = MaxInt(RedCar.life -(att - RedCar.def),RedCar.life-5);
            }
        }
        else if((((posy+64)/64)*64) == (RedCar.posy/64)*64 & (((posx )/64)*64) == (RedCar.posx/64)*64) {
            if(crit == 1 || crit == 2){
                RedCar.life = MaxInt(RedCar.life -(att*2 - RedCar.def),RedCar.life-10);
            }
            else{
                RedCar.life = MaxInt(RedCar.life -(att - RedCar.def),RedCar.life-5);
            }
        }
    }

    public static void attackerRedTank(){
        Random random = new Random();
        int crit = random.nextInt(10) + 1;
        if ((((posx +64)/64)*64) == (RedTank.posx/64)*64 & ((((posy)/64)*64) == (RedTank.posy/64)*64)){
            if(crit == 1 || crit == 2){
                RedTank.life = MaxInt(RedTank.life -(att*2 - RedTank.def),RedTank.life -10);
            }
            else{
                RedTank.life = MaxInt(RedTank.life -(att - RedTank.def),RedTank.life -5);
            }

        }
        else if((((posx-64)/64)*64) == (RedTank.posx/64)*64 & ((((posy)/64)*64) == (RedTank.posy/64)*64))  {
            if(crit == 1 || crit == 2){
                RedTank.life = MaxInt(RedTank.life -(att*2 - RedTank.def),RedTank.life -10);
            }
            else{
                RedTank.life = MaxInt(RedTank.life -(att - RedTank.def),RedTank.life -5);
            }
        }
        else if((((posy-64)/64)*64) == (RedTank.posy/64)*64 & (((posx )/64)*64) == (RedTank.posx/64)*64)  {
            if(crit == 1 || crit == 2){
                RedTank.life = MaxInt(RedTank.life -(att*2 - RedTank.def),RedTank.life -10);
            }
            else{
                RedTank.life = MaxInt(RedTank.life -(att - RedTank.def),RedTank.life -5);
            }
        }
        else if((((posy+64)/64)*64) == (RedTank.posy/64)*64 & (((posx )/64)*64) == (RedTank.posx/64)*64) {
            if(crit == 1 || crit == 2){
                RedTank.life = MaxInt(RedTank.life -(att*2 - RedTank.def),RedTank.life -10);
            }
            else{
                RedTank.life = MaxInt(RedTank.life -(att - RedTank.def),RedTank.life -5);
            }
        }
    }

    public static void attackerRedSoldier(){
        Random random = new Random();
        int crit = random.nextInt(10) + 1;
        if ((((posx +64)/64)*64) == (RedSoldier.posx/64)*64 & ((((posy)/64)*64) == (RedSoldier.posy/64)*64)){
            if(crit == 1 || crit == 2){
                RedSoldier.life = MaxInt(RedSoldier.life -(att*2 - RedSoldier.def),RedSoldier.life -10);
            }
            else{
                RedSoldier.life = MaxInt(RedSoldier.life -(att - RedSoldier.def),RedSoldier.life -5);
            }
        }
        else if((((posx-64)/64)*64) == (RedSoldier.posx/64)*64 & ((((posy)/64)*64) == (RedSoldier.posy/64)*64))  {
            if(crit == 1 || crit == 2){
                RedSoldier.life = MaxInt(RedSoldier.life -(att*2 - RedSoldier.def),RedSoldier.life -10);
            }
            else{
                RedSoldier.life = MaxInt(RedSoldier.life -(att - RedSoldier.def),RedSoldier.life -5);
            }
        }
        else if((((posy-64)/64)*64) == (RedSoldier.posy/64)*64 & (((posx )/64)*64) == (RedSoldier.posx/64)*64)  {
            if(crit == 1 || crit == 2){
                RedSoldier.life = MaxInt(RedSoldier.life -(att*2 - RedSoldier.def),RedSoldier.life -10);
            }
            else{
                RedSoldier.life = MaxInt(RedSoldier.life -(att - RedSoldier.def),RedSoldier.life -5);
            }
        }
        else if((((posy+64)/64)*64) == (RedSoldier.posy/64)*64 & (((posx )/64)*64) == (RedSoldier.posx/64)*64) {
            if(crit == 1 || crit == 2){
                RedSoldier.life = MaxInt(RedSoldier.life -(att*2 - RedSoldier.def),RedSoldier.life -10);
            }
            else{
                RedSoldier.life = MaxInt(RedSoldier.life -(att - RedSoldier.def),RedSoldier.life -5);
            }
        }
    }

    public static void DrawUnit(SpriteBatch batch, BitmapFont font){
        font.draw(batch, ""+BlueTank.life +"", posxFont, posyFont);
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, posx, posy);
    }

    public static void selected(){
        if(MyGdxGame.turn){
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                if (Gdx.input.getX() > sprite.getX() && Gdx.input.getX() < sprite.getX() + 64) {
                    if (((1025- Gdx.input.getY())/64)*64 == ((sprite.getY()/64)*64)) {
                        if(!Actif && !HasMove){
                            Actif = true;
                            Moved = true;
                        }
                        else if(HasMove){
                            Actif = false;
                            Moved = false;
                        }
                    }
                    else{
                        Actif = false;
                        Moved = false;
                    }
                }
                else{
                    Actif = false;
                }

            }
            else if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
                Actif = false;
                Moved = false;
            }
        }
        else{
            Actif = false;
            Moved = false;
            HasMove = false;
        }
    }

    public static void Move() {
        if (HasMove == false) {
            posx = (Gdx.input.getX() / 64) * 64;
            posy = ((1025 - Gdx.input.getY()) / 64) * 64;
            sprite.setPosition(posx, posy);
            HasMove = true;
            Actif = false;
            posxFont = posx ;
            posyFont = posy;
        }
    }

    public static void dead() {
        if (life <= 0) {
            dead = true;
            posx = 0;
            posy = 0;
            sprite.setPosition(0, 0);
        }
    }
}