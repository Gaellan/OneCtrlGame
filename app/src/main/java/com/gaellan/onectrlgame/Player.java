package com.gaellan.onectrlgame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Player {
    private int _posX;
    private int _posY;
    private int _selectedPosX;
    private int _selectedPosY;
    private int _score;
    private int _type; // 1 : human player - 2 computer player

    public Player(int type){
        this._type = type;
        this.init();
    }


    public void init(){
        // human player in central box, bottom line
        if(this._type == 1)
        {
            this._posX = 3;
            this._posY = 6;
            this._selectedPosX = 3;
            this._selectedPosY = 5;
        }
        // IA player in central box, top line
        else if(this._type == 2)
        {
            this._posX = 3;
            this._posY = 0;
            this._selectedPosX = 4;
            this._selectedPosY = 0;
        }
        else
            throw new IllegalStateException("Player type is neither human nor IA.");
    }

    /* Methods for all player types */
    public int[] getAvailableBoxes(){

        int current = this._posY * 7 + this._posX;

        if(this._posX < 1 && this._posY < 1) // top left corner
        {
            int[] boxes = {1, 8, 7};
            return boxes;
        }
        else if(this._posX > 5 && this._posY < 1) // top right corner
        {
            int[] boxes = {13, 12, 5};
            return boxes;
        }
        else if(this._posX < 1 && this._posY > 5) // bottom left corner
        {
            int[] boxes = {35, 36, 43};
            return boxes;
        }
        else if(this._posX > 5 && this._posY > 5) // bottom right corner
        {
            int[] boxes = {47, 40, 41};
            return boxes;
        }
        else if(this._posX < 1) // left col
        {
            int[] boxes = {current - 7, current - 6, current + 1, current + 8, current + 7};
            return boxes;
        }
        else if(this._posX > 5) // right col
        {
            int[] boxes = {current - 7, current + 7, current + 6, current - 1, current - 8};
            return boxes;
        }
        else if(this._posY < 1) // top line
        {
            int[] boxes = {current + 1, current + 8, current + 7, current + 6, current - 1};
            return boxes;
        }
        else if(this._posY > 5) // bottom line
        {
            int[] boxes = {current - 7, current - 6, current + 1, current - 1, current - 8};
            return boxes;
        }
        else // nothing special
        {
            int[] boxes = {current - 7, current - 6, current + 1, current + 8, current + 7, current + 6, current - 1, current - 8};
            return boxes;
        }
    }

    /* Methods only available to IA players */
    public void play()
    {
        int[] boxes = this.getAvailableBoxes();
        Random generator = new Random();
        int selectedBox = boxes[generator.nextInt(boxes.length)];

        this.set_selectedPosY(selectedBox / 7);
        this.set_selectedPosX(selectedBox % 7);

        this.set_posX(selectedBox % 7);
        this.set_posY(selectedBox / 7);
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

    public int get_selectedPosX() {
        return _selectedPosX;
    }

    public void set_selectedPosX(int _selectedPosX) {
        this._selectedPosX = _selectedPosX;
    }

    public int get_selectedPosY() {
        return _selectedPosY;
    }

    public void set_selectedPosY(int _selectedPosY) {
        this._selectedPosY = _selectedPosY;
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
