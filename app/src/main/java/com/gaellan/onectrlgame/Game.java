package com.gaellan.onectrlgame;


import android.widget.Button;

import java.util.ArrayList;

public class Game {

    private Player _player1;
    private Player _player2;
    private ArrayList<Button> _map;
    private int _filledBoxes;



    public Player get_player1() {
        return _player1;
    }

    public void set_player1(Player _player1) {
        this._player1 = _player1;
    }

    public Player get_player2() {
        return _player2;
    }

    public void set_player2(Player _player2) {
        this._player2 = _player2;
    }

    public ArrayList<Button> get_map() {
        return _map;
    }

    public void set_map(ArrayList<Button> _map) {
        this._map = _map;
    }

    public int get_filledBoxes() {
        return _filledBoxes;
    }

    public void set_filledBoxes(int _filledBoxes) {
        this._filledBoxes = _filledBoxes;
    }
}
