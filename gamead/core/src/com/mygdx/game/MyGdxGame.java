package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame extends ApplicationAdapter implements ApplicationListener {
    private Texture sol;
    private Texture lave;
    private Texture pointeur;
    private Texture moving;
    private Texture black;
    private SpriteBatch batch;
    public static Integer[][] map;
    public int cell_taille = 64;
    public static int b ;
    public static int v ;
    public static BlueSoldier soldier;
    public static RedSoldier soldier2;
    public static BlueTank tank;
    public static RedTank tank2;
    public static BlueCar car;
    public static RedCar car2;
    public static boolean turn = true;
    private BitmapFont fontRed;
    private BitmapFont fontBlue;
    private BitmapFont fontWhite;




    @Override
    public void create() {
        fontRed = new BitmapFont();
        fontRed.setColor(Color.RED);
        fontBlue = new BitmapFont();
        fontBlue.setColor(Color.BLUE);
        fontWhite = new BitmapFont();
        fontWhite.setColor(Color.WHITE);
        sol = new Texture(Gdx.files.internal("sole.png"));
        lave = new Texture(Gdx.files.internal("Montain.png"));
        pointeur = new Texture(Gdx.files.internal("select.png"));
        moving = new Texture(Gdx.files.internal("tileMove.png"));
        black = new Texture(Gdx.files.internal("black.png"));
        batch = new SpriteBatch();
        soldier = new BlueSoldier(5 * cell_taille +32 ,5 * cell_taille +32 );
        soldier2 = new RedSoldier(6 * cell_taille +32 ,8 * cell_taille +32 );
        tank = new BlueTank(3 * cell_taille +32 ,10 * cell_taille +32 );
        tank2 = new RedTank(6 * cell_taille +32 ,12 * cell_taille +32 );
        car = new BlueCar(7 *cell_taille +32, 3 *cell_taille+32);
        car2 = new RedCar(8*cell_taille+32,4*cell_taille+32);
        BlueSoldier.crea();
        BlueTank.crea();
        RedSoldier.crea();
        RedTank.crea();
        BlueCar.crea();
        RedCar.crea();
    }

    public static int finduniteselectx(){
        if (BlueSoldier.Actif && !BlueSoldier.dead && !BlueSoldier.HasMove){
            return BlueSoldier.posx;
        }
        else if (RedSoldier.Actif && !RedSoldier.dead && !RedSoldier.HasMove){
            return RedSoldier.posx;
        }
        else if (BlueTank.Actif && !BlueTank.dead && !BlueTank.HasMove){
            return BlueTank.posx;
        }
        else if (RedTank.Actif && !RedTank.dead && !RedTank.HasMove){
            return RedTank.posx;
        }
        else if (BlueCar.Actif && !BlueCar.dead && !BlueCar.HasMove){
            return BlueCar.posx;
        }
        else if (RedCar.Actif && !RedCar.dead && !RedCar.HasMove){
            return RedCar.posx;
        }
        return 0;
    }

    public static int finduniteselecty(){
        if (BlueSoldier.Actif && !BlueSoldier.dead && !BlueSoldier.HasMove){
            return BlueSoldier.posy;
        }
         else if (RedSoldier.Actif && !RedSoldier.dead && !RedSoldier.HasMove){
            return RedSoldier.posy;
        }
        else if (BlueTank.Actif && !BlueTank.dead && !BlueTank.HasMove){
            return BlueTank.posy;
        }
        else if (RedTank.Actif && !RedTank.dead && !RedTank.HasMove){
            return RedTank.posy;
        }
        else if (BlueCar.Actif && !BlueCar.dead && !BlueCar.HasMove){
            return BlueCar.posy;
        }
        else if (RedCar.Actif && !RedCar.dead && !RedCar.HasMove){
            return RedCar.posy;
        }
        return 0;
    }

    public static int findUniteDeplacement(){
        if (BlueSoldier.Actif && !BlueSoldier.dead && !BlueSoldier.HasMove){
            return BlueSoldier.depla;
        }
        else if (BlueTank.Actif && !BlueTank.dead && !BlueTank.HasMove){
            return BlueTank.depla;
        }
        else if (RedTank.Actif && !RedTank.dead && !RedTank.HasMove){
            return RedTank.depla;
        }
        else if (RedSoldier.Actif && !RedSoldier.dead && !RedSoldier.HasMove){
            return RedSoldier.depla;
        }
        else if (BlueCar.Actif && !BlueCar.dead && !BlueCar.HasMove){
            return BlueCar.depla;
        }
        else if (RedCar.Actif && !RedCar.dead && !RedCar.HasMove){
            return RedCar.depla;
        }
        return 0;
    }

    public static void UnitInfo(BitmapFont fontWhite,BitmapFont fontBlue ,BitmapFont fontRed ,  SpriteBatch batch){
        if (BlueSoldier.Actif && !BlueSoldier.dead && !BlueSoldier.HasMove){
            fontWhite.draw(batch,"Unit : ",13*64+64,15*64+32);
            fontBlue.draw(batch,"Soldier",14*64+42,15*64+32);
            fontWhite.draw(batch, "Life Unit : ", 15*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueSoldier.life +"", 17*64, 15*64 +32);
            fontWhite.draw(batch, "Attack Unit : ", 18*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueSoldier.att +"", 20*64 +16, 15*64 +32);
            fontWhite.draw(batch, "Defence Unit : ", 21*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueSoldier.def +"", 23*64 +32, 15*64 +32);
        }
        else if (BlueTank.Actif && !BlueTank.dead && !BlueTank.HasMove){
            fontWhite.draw(batch,"Unit : ",13*64+64,15*64+32);
            fontBlue.draw(batch,"Tank",14*64+42,15*64+32);
            fontWhite.draw(batch, "Life Unit : ", 15*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueTank.life +"", 17*64, 15*64 +32);
            fontWhite.draw(batch, "Attack Unit : ", 18*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueTank.att +"", 20*64 +16, 15*64 +32);
            fontWhite.draw(batch, "Defence Unit : ", 21*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueTank.def +"", 23*64 +32, 15*64 +32);
        }
        else if (RedTank.Actif && !RedTank.dead && !RedTank.HasMove){
            fontWhite.draw(batch,"Unit : ",13*64+64,15*64+32);
            fontRed.draw(batch,"Tank",14*64+42,15*64+32);
            fontWhite.draw(batch, "Life Unit : ", 15*64 +64, 15*64 +32);
            fontRed.draw(batch, ""+RedTank.life +"", 17*64, 15*64 +32);
            fontWhite.draw(batch, "Attack Unit : ", 18*64 +64, 15*64 +32);
            fontRed.draw(batch, ""+RedTank.att +"", 20*64 +16, 15*64 +32);
            fontWhite.draw(batch, "Defence Unit : ", 21*64 +64, 15*64 +32);
            fontRed.draw(batch, ""+RedTank.def +"", 23*64 +32, 15*64 +32);
        }
        else if (RedSoldier.Actif && !RedSoldier.dead && !RedSoldier.HasMove){
            fontWhite.draw(batch,"Unit : ",13*64+64,15*64+32);
            fontRed.draw(batch,"Soldier",14*64+42,15*64+32);
            fontWhite.draw(batch, "Life Unit : ", 15*64 +64, 15*64 +32);
            fontRed.draw(batch, ""+RedSoldier.life +"", 17*64, 15*64 +32);
            fontWhite.draw(batch, "Attack Unit : ", 18*64 +64, 15*64 +32);
            fontRed.draw(batch, ""+RedSoldier.att +"", 20*64 +16, 15*64 +32);
            fontWhite.draw(batch, "Defence Unit : ", 21*64 +64, 15*64 +32);
            fontRed.draw(batch, ""+RedSoldier.def +"", 23*64 +32, 15*64 +32);
        }
        else if (RedCar.Actif && !RedCar.dead && !RedCar.HasMove){
            fontWhite.draw(batch,"Unit : ",13*64+64,15*64+32);
            fontRed.draw(batch,"Car",14*64+42,15*64+32);
            fontWhite.draw(batch, "Life Unit : ", 15*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+RedCar.life +"", 17*64, 15*64 +32);
            fontWhite.draw(batch, "Attack Unit : ", 18*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+RedCar.att +"", 20*64 +16, 15*64 +32);
            fontWhite.draw(batch, "Defence Unit : ", 21*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+RedCar.def +"", 23*64 +32, 15*64 +32);
        }
        else if (BlueCar.Actif && !BlueCar.dead && !BlueCar.HasMove){
            fontWhite.draw(batch,"Unit : ",13*64+64,15*64+32);
            fontBlue.draw(batch,"Car",14*64+42,15*64+32);
            fontWhite.draw(batch, "Life Unit : ", 15*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueCar.life +"", 17*64, 15*64 +32);
            fontWhite.draw(batch, "Attack Unit : ", 18*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueCar.att +"", 20*64 +16, 15*64 +32);
            fontWhite.draw(batch, "Defence Unit : ", 21*64 +64, 15*64 +32);
            fontBlue.draw(batch, ""+BlueCar.def +"", 23*64 +32, 15*64 +32);
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        batch.begin();
        checkplayer_turn();
        int z = 0;
        int t = 0;
        map = Tile.tile(finduniteselectx(), finduniteselecty(),findUniteDeplacement());
        for (Integer[] integers : map) {
            for (Integer integer : integers) {
                if (integer == 0) {
                    batch.draw(black, z, t);
                } else if (integer == 1) {
                    batch.draw(lave, z, t);
                } else if (integer == 2) {
                    batch.draw(sol, z, t);
                } else if (integer == 3) {
                    batch.draw(moving, z, t);
                }
                t = t + 64;
            }
            t = 0;
            z = z + 64;
        }
        b = (Gdx.input.getX()/cell_taille)*cell_taille;
        v = ((1025- Gdx.input.getY())/cell_taille)*cell_taille;
        batch.draw(pointeur,b,v);
        fontWhite.draw(batch, "Player Turn :", 6*64 +64, 15*64 +32);
        if (turn){
            fontBlue.draw(batch, "Blue", 8*64 +32, 15*64 +32);
        }
        else{
            fontRed.draw(batch, "Red", 8*64 +32, 15*64 +32);
        }
        if (!BlueTank.dead){
            BlueTank.create();
            BlueTank.selected();
            BlueTank.DrawUnit(batch,fontBlue);
        }
        if (!BlueSoldier.dead){
            BlueSoldier.create();
            BlueSoldier.selected();
            BlueSoldier.DrawUnit(batch,fontBlue);
        }
        if (!RedSoldier.dead){
            RedSoldier.create();
            RedSoldier.selected();
            RedSoldier.DrawUnit(batch,fontRed);
        }
        if (!RedTank.dead){
            RedTank.create();
            RedTank.selected();
            RedTank.DrawUnit(batch,fontRed);
        }
        if (!BlueCar.dead){
            BlueCar.create();
            BlueCar.selected();
            BlueCar.DrawUnit(batch,fontBlue);
        }
        if (!RedCar.dead){
            RedCar.create();
            RedCar.selected();
            RedCar.DrawUnit(batch,fontRed);
        }
        if (teamBlueDead()){
            turn = true;
            fontWhite.draw(batch, "Team", 16*64, 15*64 +32);
            fontRed.draw(batch, "Red", 17*64, 15*64 +32);
            fontWhite.draw(batch, "Win!", 18*64-16, 15*64 +32);
        }
        if (teamRedDead()){
            turn = false;
            fontWhite.draw(batch, "Team", 16*64, 15*64 +32);
            fontBlue.draw(batch, "Blue", 17*64, 15*64 +32);
            fontWhite.draw(batch, "Win!", 18*64-16, 15*64 +32);
        }
        if (!teamBlueDead() && !teamRedDead()){
            UnitInfo(fontWhite, fontBlue, fontRed,batch);
        }

        batch.end();
    }

    @Override
    public void dispose() {
        fontRed.dispose();
        fontBlue.dispose();
        batch.dispose();
        black.dispose();
        moving.dispose();
        sol.dispose();
        lave.dispose();
        moving.dispose();
        pointeur.dispose();
    }

    public static boolean teamRedDead(){
        return RedSoldier.dead && RedTank.dead && RedCar.dead;
    }

    public static boolean teamBlueDead(){
        return BlueSoldier.dead && BlueTank.dead && BlueCar.dead;
    }

    public static boolean turnBluefinish(){
        return((BlueTank.HasMove || BlueTank.dead) && (BlueSoldier.HasMove || BlueSoldier.dead) && (BlueCar.dead || BlueCar.HasMove));
    }

    public static boolean turnRedfinish(){
        return((RedTank.HasMove || RedTank.dead) && (RedSoldier.HasMove || RedSoldier.dead) && (RedCar.dead ||RedCar.HasMove));
    }

    public void checkplayer_turn(){
        if (turn) {
            if (turnBluefinish()) {
                BlueSoldier.Actif = false;
                BlueTank.Actif = false;
                BlueCar.Actif = false;
                RedSoldier.HasMove = false;
                RedTank.HasMove = false;
                RedCar.HasMove = false;
                RedSoldier.Actif = false;
                RedTank.Actif = false;
                RedCar.Actif = false;
                BlueSoldier.HasMove = false;
                BlueTank.HasMove = false;
                BlueCar.HasMove = false;
                turn = false;
            }
        }
        else {
            if (turnRedfinish()) {
                BlueSoldier.Actif = false;
                BlueTank.Actif = false;
                BlueCar.Actif = false;
                RedSoldier.HasMove = false;
                RedTank.HasMove = false;
                RedCar.HasMove = false;
                RedSoldier.Actif = false;
                RedTank.Actif = false;
                RedCar.Actif = false;
                BlueSoldier.HasMove = false;
                BlueTank.HasMove = false;
                BlueCar.HasMove = false;
                turn = true;
            }
        }
    }
}