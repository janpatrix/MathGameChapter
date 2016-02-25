package com.example.patrickgross.mathgamechapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends Activity implements View.OnClickListener {

    int correctAnswer;
    int currentScore = 0;
    int currentLevel = 1;
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectScore;
    TextView textObjectLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Create Objects
        textObjectPartA = (TextView)findViewById(R.id.textPartA);
        textObjectPartB = (TextView)findViewById(R.id.textPartB);
        textObjectScore = (TextView)findViewById(R.id.textScore);
        textObjectLevel = (TextView)findViewById(R.id.textLevel);

        buttonObjectChoice1 = (Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button)findViewById(R.id.buttonChoice3);

        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

        setQuestion();

    }

    @Override
    public void onClick(View view){

        switch (view.getId()) {

            case R.id.buttonChoice1:
                checkAnswer("" + buttonObjectChoice1.getText());
                break;
            case R.id.buttonChoice2:
                checkAnswer("" + buttonObjectChoice2.getText());
                break;
            case R.id.buttonChoice3:
                checkAnswer("" + buttonObjectChoice3.getText());
                break;
        }

    }

    void setQuestion(){

        textObjectScore.setText("Score: " + currentScore);
        textObjectLevel.setText("Level: " + currentLevel);

        Random randInt = new Random();

        int partA = randInt.nextInt(currentLevel*3);
        partA++;

        int partB = randInt.nextInt(currentLevel*3);
        partB++;

        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer-2;
        int wrongAnswer2 = correctAnswer+2;

        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);

        int buttonLayout = randInt.nextInt(3);

        switch (buttonLayout){
            case 0:
                buttonObjectChoice1.setText("" + correctAnswer);
                buttonObjectChoice2.setText("" + wrongAnswer1);
                buttonObjectChoice3.setText("" + wrongAnswer2);
                break;

            case 1:
                buttonObjectChoice2.setText("" + correctAnswer);
                buttonObjectChoice1.setText("" + wrongAnswer1);
                buttonObjectChoice3.setText("" + wrongAnswer2);
                break;

            case 2:
                buttonObjectChoice3.setText("" + correctAnswer);
                buttonObjectChoice2.setText("" + wrongAnswer1);
                buttonObjectChoice1.setText("" + wrongAnswer2);
                break;
        }
    }

    private void checkAnswer(String buttonText)
    {
        int answer = Integer.parseInt(buttonText);
        if (answer == correctAnswer)
        {
            Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_LONG).show();
            currentScore += currentLevel;
            currentLevel += 1;
            setQuestion();

        } else {
            Toast.makeText(getApplicationContext(), "Sorry, that's wrong", Toast.LENGTH_LONG).show();
            currentScore = 0;
            currentLevel = 1;
            setQuestion();
        }
    }
}
