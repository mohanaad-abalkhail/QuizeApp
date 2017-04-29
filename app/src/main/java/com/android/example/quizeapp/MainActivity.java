package com.android.example.quizeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.android.example.quizeapp.R.id.answer1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
    @BindView(answer1) EditText answered1;
    @BindView(R.id.answer2) RadioButton radioButton1;
    @BindView(R.id.answer3_1) CheckBox chkbx1;
    @BindView(R.id.answer3_2) CheckBox chkbx2;
    @BindView(R.id.answer3_3) CheckBox chkbx3;
    @BindView(R.id.answer3_4) CheckBox chkbx4;
    @BindView(R.id.answer4) RadioButton radioButton2;
    @BindView(R.id.answer5) RadioButton radioButton3;
    @BindView(R.id.answer6) RadioButton radioButton4;
    @BindView(R.id.answer7_1) CheckBox chkbx5;
    @BindView(R.id.answer7_2) CheckBox chkbx6;
    @BindView(R.id.answer7_3) CheckBox chkbx7;
    @BindView(R.id.answer7_4) CheckBox chkbx8;
    @BindString(R.string.answers2) String correctAnswer1;
    /*
    @variable: correctAnswers= counter for number of correct answers
    @variable: correctAnswer1= the correct answer for question 1
    @variable: answer1= to store the users string answer
    @variable: answered1= to get what the user answered
    @variable: radioButton= to check whether the user chose the correct answer
    @variable: chkbx1, chkbx2,chkbx3, chkbx4= to check whether the user chose the correct answers
    *
    */

    public void gradeAnswer(View view) {
        int correctAnswers = 0;

        // check answer for question 1
        String answer1 = answered1.getText().toString();
        if (answer1.equalsIgnoreCase(correctAnswer1)) {
            correctAnswers++;
        }

        // check answer for question 2
        if (radioButton1.isChecked()) {
            correctAnswers++;
        }

        // check answer for question 3
        if (chkbx3.isChecked() && chkbx4.isChecked() && !chkbx1.isChecked() && !chkbx2.isChecked()){
            correctAnswers++;
        }

        // check answer for question 4
        if (radioButton2.isChecked()) {
            correctAnswers++;
        }

        // check answer for question 5
        if (radioButton3.isChecked()) {
            correctAnswers++;
        }

        // check answer for question 6
        if (radioButton4.isChecked()) {
            correctAnswers++;
        }

        // check answer for question 7
        if (chkbx7.isChecked() && !chkbx8.isChecked() && chkbx5.isChecked() && !chkbx6.isChecked()) {
            correctAnswers++;
        }

        // Toast message to display the number of correct answers
        if (correctAnswers == 7) {
            Toast.makeText(this, "You got all the correct answers you are awesome", Toast.LENGTH_LONG).show();
        } else if(correctAnswers < 7){
            Toast.makeText(this, "You got " + correctAnswers + " correct answers ", Toast.LENGTH_LONG).show();
        }
    }
}
