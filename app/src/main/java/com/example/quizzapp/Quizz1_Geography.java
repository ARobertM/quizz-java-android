package com.example.quizzapp;

import static android.graphics.Color.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Quizz1_Geography extends AppCompatActivity implements View.OnClickListener{

    public static String question[] = {
            "What is the capital of Italy?",
            "What country is known as 'The Land of the Rising Sun?'",
            "What is the longest river in the world?"
    };

    public static String choises[][] = {
            {"Bucharest", "Sofia", "Berlin", "Roma"},
            {"Japan", "Russia", "Portugal", "Morocco"},
            {"Seine", "Nile", "Missisipi", "Volga"}
    };

    public static String correctAnswers[] = {
            "Roma",
            "Japan",
            "Nile"
    };
    // initComponents
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_A,ans_B,ans_C,ans_D;
    Button submitBtn;
    int score = 0;
    int totalQuest = Quizz1_Geography.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        withoutBar();
        setContentView(R.layout.activity_quizz1_geography);
        initComponents();
        loadNewQuestion();
    }



    private void initComponents() {
        totalQuestionsTextView = findViewById(R.id.total_quest);
        questionTextView = findViewById(R.id.questions);
        ans_A = findViewById(R.id.ans_A);
        ans_B = findViewById(R.id.ans_B);
        ans_C = findViewById(R.id.ans_C);
        ans_D = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ans_A.setOnClickListener(this);
        ans_B.setOnClickListener(this);
        ans_C.setOnClickListener(this);
        ans_D.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions: "+totalQuest);
    }

    private void loadNewQuestion() {
        if(currentQuestionIndex == totalQuest){
            finishQuiz();
            return;
        }
        
        questionTextView.setText(Quizz1_Geography.question[currentQuestionIndex]);
        ans_A.setText(Quizz1_Geography.choises[currentQuestionIndex][0]);
        ans_B.setText(Quizz1_Geography.choises[currentQuestionIndex][1]);
        ans_C.setText(Quizz1_Geography.choises[currentQuestionIndex][2]);
        ans_D.setText(Quizz1_Geography.choises[currentQuestionIndex][3]);

    }

    private void finishQuiz() {
        String passStatus = "";
        if(score > totalQuest*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+ " out of "+ totalQuest)
                .setPositiveButton("Restart", (dialog, i) -> restartQuiz() )
                        .setCancelable(false)
                        .show();
    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }



    private void withoutBar() {
        getWindow().setFlags(WindowManager .LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {

        ans_A.setBackgroundColor(R.color.red_light);
        ans_B.setBackgroundColor(R.color.red_light);
        ans_C.setBackgroundColor(R.color.red_light);
        ans_D.setBackgroundColor(R.color.red_light);

        Button clickedButon = (Button) v;
        if(clickedButon.getId() == R.id.submit_btn){
            if(selectedAnswer.equals(Quizz1_Geography.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();


        }else{
            selectedAnswer = clickedButon.getText().toString();
            clickedButon.setBackgroundColor(Color.BLUE);
        }
    }
}