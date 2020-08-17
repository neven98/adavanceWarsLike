package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

import java.util.Random;

public class RedSoldier extends Unity {

    private static final int FRAME_COLS = 6, FRAME_ROWS = 1;
    public static Sprite sprite;
    public static Texture tex;
    public static Animation<TextureRegion> walkAnimation;
    public static Boolean Actif = false;
    public static Boolean Moved = false;
    public static int posx =0;
    public static int posy =0;
    public static int posxFont =0;
    public static int posyFont =0;
    public static boolean HasMove = false;
    public static int life =100;
    public static int att =35;
    public static int def =5;
    public static boolean dead = false;
    public static float  stateTime;
    public static int depla = 4;

    public static int MaxInt(int a,int b){
        if (a < b){
            return a;
        }
        else{
            return b;
        }
    }

    public RedSoldier(int x,int y){
        super();
        Unity(x,y);
        posx = x+32;
        posy = y+32;
        posxFont = x+32;
        posyFont = y+32;
        this.setDeplacement(5);
        this.setTeam("red");
        this.setId(0);
    }

    public static boolean checkX(){
        return ((BlueSoldier.posx / 64) * 64 != (Gdx.input.getX() / 64) * 64) || BlueSoldier.dead;
    }

    public static boolean checkY(){
        return ((BlueSoldier.posy/64)*64 != ((1025-Gdx.input.getY())/64)*64) || BlueSoldier.dead;
    }

    public static boolean checkXt(){
        return ((RedTank.posx / 64) * 64 != (Gdx.input.getX() / 64) * 64)|| RedTank.dead;
    }

    public static boolean checkYt(){
        return ((RedTank.posy/64)*64 != ((1025-Gdx.input.getY())/64)*64) || RedTank.dead;
    }

    public static boolean checkXs(){
        return ((BlueTank.posx / 64) * 64 != (Gdx.input.getX() / 64) * 64) || BlueTank.dead;
    }

    public static boolean checkYs(){
        return ((BlueTank.posy/64)*64 != ((1025-Gdx.input.getY())/64)*64) || BlueTank.dead;
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

        tex = new Texture(Gdx.files.internal("SoldatRedAni.png"));
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
            if ((Tile.map[Gdx.input.getX()/64][(1025-Gdx.input.getY())/64] == 3) &  (checkX() || checkY()) && (checkXt() || checkYt()) && (checkXs() || checkYs()) && (checkXvr()  || checkYvr()) && (checkXv() || checkYv())  ){
                posx = (Gdx.input.getX() / 64) * 64;
                posy = ((1025 - Gdx.input.getY())/64) * 64;
                Move();
                attackerBlueCar();
                attackerBlueTank();
                attackerBlueSoldier();
                Actif = false;
            }
        }
    }


    public static void attackerBlueCar(){
        Random random = new Random();
        int crit = random.nextInt(10) + 1;
        if ((((posx +64)/64)*64) == (BlueCar.posx/64)*64 & ((((posy)/64)*64) == (BlueCar.posy/64)*64)){
            if(crit == 1 || crit == 2){
                BlueCar.life = MaxInt(BlueCar.life -(att*2 - BlueCar.def) ,BlueCar.life-10);
            }
            else{
                BlueCar.life = MaxInt(BlueCar.life -(att - BlueCar.def),BlueCar.life-5);
            }

        }
        else if((((posx-64)/64)*64) == (BlueCar.posx/64)*64 & ((((posy)/64)*64) == (BlueCar.posy/64)*64))  {
            if(crit == 1 || crit == 2){
                BlueCar.life = MaxInt(BlueCar.life -(att*2 - BlueCar.def),BlueCar.life-10);
            }
            else{
                BlueCar.life = MaxInt(BlueCar.life -(att - BlueCar.def),BlueCar.life-5);
            }
        }
        else if((((posy-64)/64)*64) == (BlueCar.posy/64)*64 & (((posx )/64)*64) == (BlueCar.posx/64)*64)  {
            if(crit == 1 || crit == 2){
                BlueCar.life = MaxInt(BlueCar.life -(att*2 - BlueCar.def),BlueCar.life-10);
            }
            else{
                BlueCar.life = MaxInt(BlueCar.life -(att - BlueCar.def),BlueCar.life-5);
            }
        }
        else if((((posy+64)/64)*64) == (BlueCar.posy/64)*64 & (((posx )/64)*64) == (BlueCar.posx/64)*64) {
            if(crit == 1 || crit == 2){
                BlueCar.life = MaxInt(BlueCar.life -(att*2 - BlueCar.def),BlueCar.life-10);
            }
            else{
                BlueCar.life = MaxInt(BlueCar.life -(att - BlueCar.def),BlueCar.life-5);
            }
        }
    }

    public static void attackerBlueTank(){
        Random random = new Random();
        int crit = random.nextInt(10) + 1;
        if ((((posx +64)/64)*64) == (BlueTank.posx/64)*64 & ((((posy)/64)*64) == (BlueTank.posy/64)*64)){
            if(crit == 1 || crit == 2){
                BlueTank.life = MaxInt(BlueTank.life -(att*2 - BlueTank.def),BlueTank.life -10);
            }
            else{
                BlueTank.life = MaxInt(BlueTank.life -(att - BlueTank.def),BlueTank.life -5);
            }

        }
        else if((((posx-64)/64)*64) == (BlueTank.posx/64)*64 & ((((posy)/64)*64) == (BlueTank.posy/64)*64))  {
            if(crit == 1 || crit == 2){
                BlueTank.life = MaxInt(BlueTank.life -(att*2 - BlueTank.def),BlueTank.life -10);
            }
            else{
                BlueTank.life = MaxInt(BlueTank.life -(att - BlueTank.def),BlueTank.life -5);
            }
        }
        else if((((posy-64)/64)*64) == (BlueTank.posy/64)*64 & (((posx )/64)*64) == (BlueTank.posx/64)*64)  {
            if(crit == 1 || crit == 2){
                BlueTank.life = MaxInt(BlueTank.life -(att*2 - BlueTank.def),BlueTank.life -10);
            }
            else{
                BlueTank.life = MaxInt(BlueTank.life -(att - BlueTank.def),BlueTank.life -5);
            }
        }
        else if((((posy+64)/64)*64) == (BlueTank.posy/64)*64 & (((posx )/64)*64) == (BlueTank.posx/64)*64) {
            if(crit == 1 || crit == 2){
                BlueTank.life = MaxInt(BlueTank.life -(att*2 - BlueTank.def),BlueTank.life -10);
            }
            else{
                BlueTank.life = MaxInt(BlueTank.life -(att - BlueTank.def),BlueTank.life -5);
            }
        }
    }

    public static void attackerBlueSoldier(){
        Random random = new Random();
        int crit = random.nextInt(10) + 1;
        if ((((posx +64)/64)*64) == (BlueSoldier.posx/64)*64 & ((((posy)/64)*64) == (BlueSoldier.posy/64)*64)){
            if(crit == 1 || crit == 2){
                BlueSoldier.life = MaxInt(BlueSoldier.life -(att*2 - BlueSoldier.def),BlueSoldier.life -10);
            }
            else{
                BlueSoldier.life = MaxInt(BlueSoldier.life -(att - BlueSoldier.def),BlueSoldier.life -5);
            }
        }
        else if((((posx-64)/64)*64) == (BlueSoldier.posx/64)*64 & ((((posy)/64)*64) == (BlueSoldier.posy/64)*64))  {
            if(crit == 1 || crit == 2){
                BlueSoldier.life = MaxInt(BlueSoldier.life -(att*2 - BlueSoldier.def),BlueSoldier.life -10);
            }
            else{
                BlueSoldier.life = MaxInt(BlueSoldier.life -(att - BlueSoldier.def),BlueSoldier.life -5);
            }
        }
        else if((((posy-64)/64)*64) == (BlueSoldier.posy/64)*64 & (((posx )/64)*64) == (BlueSoldier.posx/64)*64)  {
            if(crit == 1 || crit == 2){
                BlueSoldier.life = MaxInt(BlueSoldier.life -(att*2 - BlueSoldier.def),BlueSoldier.life -10);
            }
            else{
                BlueSoldier.life = MaxInt(BlueSoldier.life -(att - BlueSoldier.def),BlueSoldier.life -5);
            }
        }
        else if((((posy+64)/64)*64) == (BlueSoldier.posy/64)*64 & (((posx )/64)*64) == (BlueSoldier.posx/64)*64) {
            if(crit == 1 || crit == 2){
                BlueSoldier.life = MaxInt(BlueSoldier.life -(att*2 - BlueSoldier.def),BlueSoldier.life -10);
            }
            else{
                BlueSoldier.life = MaxInt(BlueSoldier.life -(att - BlueSoldier.def),BlueSoldier.life -5);
            }
        }
    }

    public static void DrawUnit(SpriteBatch batch, BitmapFont font){
        font.draw(batch, ""+RedSoldier.life +"", posxFont, posyFont);
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, posx, posy);
    }

    public static void selected(){
        if(!MyGdxGame.turn){
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
            if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
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
        if (!HasMove) {
            posx = (Gdx.input.getX() / 64) * 64;
            posy = ((1025 - Gdx.input.getY()) / 64) * 64;
            sprite.setPosition(posx, posy);
            HasMove = true;
            Actif = false;
            posxFont = posx;
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