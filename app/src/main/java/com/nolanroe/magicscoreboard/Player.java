package com.nolanroe.magicscoreboard;

/**
 * Created by Danolanater on 12/22/2017.
 */

public class Player {

    private String name;
    private int life;
    private String[] colors;
    private int wins;

    Player(String name, int life) {
        setName(name);
        setLife(life);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
