package com.gaellan.onectrlgame;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener{

    private GestureDetectorCompat mDetector;

    private ArrayList<Button> buildMap(ArrayList<Button> map)
    {
        // use get identifier in order to not have to enter every identifier
        for(int line=0; line <= 10; line++) {
            for(int col=0; col <= 10; col++) {
                String buttonID = "line_" + line + "_box_" + col;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                Button button;
                button = ((Button) findViewById(resID));
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
    }

    // create the function on press to choose which box to play
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

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
