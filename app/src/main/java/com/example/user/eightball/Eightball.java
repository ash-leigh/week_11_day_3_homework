package com.example.user.eightball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import java.util.Random;

/**
 * Created by user on 16/08/2016.
 */
public class Eightball extends AppCompatActivity {

    EditText mQuestionEditText;
    Button mShakeButton;
    Answers mAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionEditText = (EditText)findViewById(R.id.question_text);
        mShakeButton = (Button)findViewById(R.id.shake_button);

        mAnswers = new AnswersFromExternalApi();

        mShakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = mQuestionEditText.getText().toString();
                Log.d("Eightball:", "Shake button has been clicked");
                Log.d("Eightball:", "The question asked was '" + question + "'");

//                String answer = randomText();

                String answer = mAnswers.getAnswer();

                Intent intent = new Intent(Eightball.this, AnswerActivity.class);
                intent.putExtra("answer", answer);
                Log.d("Eightball:", "passing through '" + answer + "'");
                startActivity(intent);
            }
//            public String randomText(){
//                String[] options = new String[3];
//
//                options[0] = "One";
//                options[1] = "Two";
//                options[2] = "Three";
//
//                Random rand = new Random();
//                int n = rand.nextInt(3);
//
//                return options[n];
//            }
        });
    }
}
