package com.gaellan.onectrlgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Button> _map;

    private void buildMap()
    {
        this._map = new ArrayList<Button>();

        // use get identifier in order to not have to enter every identifier
        for(int line=0; line <= 10; line++) {
            for(int col=0; col <= 10; col++) {
                String buttonID = "line_" + line + "_box_" + col;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                Button button;
                button = ((Button) findViewById(resID));
                this._map.add(button);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buildMap();

        // initialize player position
    }

    // create the function on press to choose which box to play

    // create the function on long press to play the currently selected box
}
