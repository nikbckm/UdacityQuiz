package com.example.android.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void checkAnswers(View view) {

        RadioButton correctAnswer1 = findViewById(R.id.correctAnswer1);
        RadioButton correctAnswer2 = findViewById(R.id.correctAnswer2);
        CheckBox correctAnswer3 = findViewById(R.id.correctAnswer3);
        CheckBox correctAnswer4 = findViewById(R.id.correctAnswer4);
        CheckBox wrongAnswer = findViewById(R.id.wrongAnswer);
        EditText editTextQuestion = findViewById(R.id.editTextQuestion);

        if (correctAnswer1.isChecked()) {
            score++;
        }

        if (correctAnswer2.isChecked()) {
            score++;
        }

        if (correctAnswer3.isChecked() && correctAnswer4.isChecked() && !wrongAnswer.isChecked()) {
            score++;
        }

        String answerFromEditText = editTextQuestion.getText().toString().toLowerCase();
        if (answerFromEditText.equals("structured query language")) {
            score++;
        }


        /*Creates Toast*/
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence allAnswersCorrect = "Great! Everything correct!";
        CharSequence notAllAnswersCorrect = "" + score + " correct answers";

        if (score == 4) {
            Toast toast = Toast.makeText(context, allAnswersCorrect, duration);
            toast.show();
        } else {
            Toast toast = Toast.makeText(context, notAllAnswersCorrect, duration);
            toast.show();
        }

        score = 0;
    }

}
