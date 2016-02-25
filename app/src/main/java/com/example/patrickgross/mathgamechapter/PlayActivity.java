package com.example.patrickgross.mathgamechapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        int partA = 2;
        int partB = 2;
        int correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer + 1;
        int wrongAnswer2 = correctAnswer - 1;

        //Create Objects
        TextView textObjectPartA = (TextView)findViewById(R.id.textPartA);
        TextView textObjectPartB = (TextView)findViewById(R.id.textPartB);
        Button buttonObjectChoice1 = (Button)findViewById(R.id.buttonChoice1);
        Button buttonObjectChoice2 = (Button)findViewById(R.id.buttonChoice2);
        Button buttonObjectChoice3 = (Button)findViewById(R.id.buttonChoice3);

        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);

        buttonObjectChoice1.setText("" + correctAnswer);
        buttonObjectChoice2.setText("" + wrongAnswer1);
        buttonObjectChoice3.setText("" + wrongAnswer2);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {

            case R.id.buttonChoice1:
                break;
            case R.id.buttonChoice2:
                break;
            case R.id.buttonChoice3:
                break;
        }

    }
}
