package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void checkAnswers(View view){

        RadioButton correctAnswer1 = findViewById(R.id.correctAnswer1);
        RadioButton correctAnswer2 = findViewById(R.id.correctAnswer2);
        CheckBox correctAnswer3 = findViewById(R.id.correctAnswer3);
        CheckBox correctAnswer4 = findViewById(R.id.correctAnswer4);
        EditText editTextQuestion = findViewById(R.id.editTextQuestion);
        TextView scoreTextView = findViewById(R.id.scoreTextView);

        if(correctAnswer1.isChecked()) {
            score++;
        }

        if(correctAnswer2.isChecked()) {
            score++;
        }

        if(correctAnswer3.isChecked() && correctAnswer4.isChecked()) {
            score++;
        }

        String answerFromEditText = editTextQuestion.getText().toString().toLowerCase();
        if(answerFromEditText.equals("structured query language")){
            score++;
        }

        if(score<4) {
            scoreTextView.setText("You reached " + score + " out of 4 Points!");
        }
        if(score==4) {
            scoreTextView.setText("Wow, everything correct!");
        }

        score = 0;
    }

}
