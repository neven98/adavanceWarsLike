package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Unity {

    public static Position position;
    private String team;
    private int id;
    public int deplacement;
    private int life;
    private int attack;
    private int def;
    public boolean Actif;

    public static void Unity(int x, int y){
        position = new Position(x,y);
    }

    public  Boolean getActif(){
        return Actif;
    }

    public  void setActif(boolean Actif ){
        this.Actif = Actif;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public static void selected(){

    }

    public static void create(){

    }

    public static void draw(SpriteBatch batch) {
    }


}