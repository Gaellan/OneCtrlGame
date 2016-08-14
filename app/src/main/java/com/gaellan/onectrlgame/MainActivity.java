package com.gaellan.onectrlgame;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener{

    private GestureDetectorCompat mDetector;
    private Game _game;

    private ArrayList<Button> buildMap()
    {
        ArrayList<Button> map = new ArrayList<Button>();
        // use get identifier in order to not have to enter every identifier
        for(int line=0; line <= 6; line++) {
            for(int col=0; col <= 6; col++) {
                String buttonID = "line_" + line + "_box_" + col;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                Button button;
                button = ((Button) findViewById(resID));
                button.setTextColor(getResources().getColor(R.color.white));
                button.setTextSize(35);
                map.add(button);
            }
        }
        return map;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this,this);
        this._game = new Game();
        this._game.set_map(buildMap());
        this._game.update(this._game.get_player1());
        this._game.update(this._game.get_player2());
    }

    public void onClickListener(View v)
    {
        int playerSelection;
        Player player;
        int tmp;

        int[] boxes = this._game.get_player1().getAvailableBoxes();
        player = this._game.get_player1();
        playerSelection = player.get_selectedPosY() * 7 + player.get_selectedPosX();

        for (int i = 0; i < boxes.length; i++)
        {
            if(playerSelection == boxes[i])
            {
                if((i + 1) < boxes.length)
                {
                    tmp = boxes[i + 1];

                    this._game.get_player1().set_selectedPosY(tmp / 7);
                    this._game.get_player1().set_selectedPosX(tmp % 7);

                    Log.v("HUMAN PLAYER", "on touch selected x " + this._game.get_player1().get_selectedPosX());
                    Log.v("HUMAN PLAYER", "on touch selected y " + this._game.get_player1().get_selectedPosY());
                    Log.v("HUMAN PLAYER", "on touch selected " + tmp);
                }
                else
                {
                    tmp = boxes[0];

                    this._game.get_player1().set_selectedPosY(tmp / 7);
                    this._game.get_player1().set_selectedPosX(tmp % 7);

                    Log.v("HUMAN PLAYER", "on touch selected x " + this._game.get_player1().get_selectedPosX());
                    Log.v("HUMAN PLAYER", "on touch selected y " + this._game.get_player1().get_selectedPosY());
                    Log.v("HUMAN PLAYER", "on touch selected " + tmp);
                }
            }
        }
        this._game.updateSelected(getResources().getDrawable(R.drawable.square_grid_box), getResources().getDrawable(R.drawable.square_grid_box_light));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){return super.onTouchEvent(event);}

    // create the function on long press to play the currently selected box
    @Override
    public void onLongPress(MotionEvent event) {

    }

    /* Methods that had to be there to implement gesture listener */
    @Override
    public boolean onDown(MotionEvent event) {return true;}

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {return true;}

    @Override
    public void onShowPress(MotionEvent event) {}

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {return true;}

    @Override
    public boolean onSingleTapUp(MotionEvent event) {return true;}
}
