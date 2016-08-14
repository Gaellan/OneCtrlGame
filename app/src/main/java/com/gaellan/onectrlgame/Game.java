package com.gaellan.onectrlgame;


import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class Game {

    private Player _player1;
    private Player _player2;
    private ArrayList<Button> _map;
    private int _filledBoxes;

    public Game()
    {
        this._player1 = new Player(1);
        this._player2 = new Player(2);
    }

    private int playedBoxBelongTo(Button box)
    {
        if(box.getText() == "X"){
            // box belonged to human player
            return 1;
        }
        else if(box.getText() == "O"){
            // box belonged to IA player
            return 2;
        }
        else if(box.getText() == "?"){
            // box was disputed
            return 3;
        }
        else{
            // box belonged to nobody
            return 0;
        }
    }

    public void update(Player player)
    {
        Button playedBox;
        int boxBelongsTo;

        playedBox = this._map.get(player.get_posY() * 7 + player.get_posX());
        boxBelongsTo = this.playedBoxBelongTo(playedBox);

        if(player.get_type() == 1)
        {
            if(boxBelongsTo == 2) // box becomes disputed
                playedBox.setText("?");
            else if(boxBelongsTo == 3) // box is captured
                playedBox.setText("X");
            else if(boxBelongsTo == 0) // box is captured
                playedBox.setText("X");
        }
        else
        {
            if(boxBelongsTo == 1) // box becomes disputed
                playedBox.setText("?");
            else if(boxBelongsTo == 3) // box is captured
                playedBox.setText("O");
            else if(boxBelongsTo == 0) // box is captured
                playedBox.setText("O");
        }
    }

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
