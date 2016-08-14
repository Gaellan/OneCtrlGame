package com.gaellan.onectrlgame;

public class Player {
    private int _posX;
    private int _posY;
    private int _score;
    private int _type; // 1 : human player - 2 computer player

    public Player(int type){
        this._type = type;
        this.init();
    }

    /* Methods for all player types */
    public void init(){
        // human player in central box, bottom line
        if(this._type == 1)
        {
            this._posX = 3;
            this._posY = 6;
        }
        // IA player in central box, top line
        else if(this._type == 2)
        {
            this._posX = 3;
            this._posY = 0;
        }
        else
            throw new IllegalStateException("Player type is neither human nor IA.");
    }

    /* Methods only available to IA players */
    public void play()
    {

    }

    public int get_posX() {
        return _posX;
    }

    public void set_posX(int _posX) {
        this._posX = _posX;
    }

    public int get_posY() {
        return _posY;
    }

    public void set_posY(int _posY) {
        this._posY = _posY;
    }

    public int get_score() {
        return _score;
    }

    public void set_score(int _score) {
        this._score = _score;
    }

    public int get_type() {
        return _type;
    }

    public void set_type(int _type) {
        this._type = _type;
    }
}
