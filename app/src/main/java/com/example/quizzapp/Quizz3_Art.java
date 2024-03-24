package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Quizz3_Art extends AppCompatActivity implements View.OnClickListener {

    public static String question[] = {
            "Who painted the Mona Lisa?",
            "Which artist is known for creating the melting clocks in 'The Persistence of Memory'?",
            "Who sculpted the statue 'David'?",
    };

    public static String choises[][] = {
            {"Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh", "Michelangelo"},
            {"Salvador Dali", "Vincent van Gogh", "Claude Monet", "Jackson Pollock"},
            {"Michelangelo", "Pablo Picasso", "Auguste Rodin", "Vincent van Gogh"},
    };

    public static String correctAnswers[] = {
            "Leonardo da Vinci",
            "Salvador Dali",
            "Michelangelo",
    };

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ans_A,ans_B,ans_C,ans_D;
    Button submitBtn;
    int score = 0;
    int totalQuest = Quizz3_Art.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        withoutBar();
        setContentView(R.layout.activity_quizz3_art);
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

        questionTextView.setText(Quizz3_Art.question[currentQuestionIndex]);
        ans_A.setText(Quizz3_Art.choises[currentQuestionIndex][0]);
        ans_B.setText(Quizz3_Art.choises[currentQuestionIndex][1]);
        ans_C.setText(Quizz3_Art.choises[currentQuestionIndex][2]);
        ans_D.setText(Quizz3_Art.choises[currentQuestionIndex][3]);

    }

    private void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    private void withoutBar() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
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
    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        ans_A.setBackgroundColor(R.color.red_light);
        ans_B.setBackgroundColor(R.color.red_light);
        ans_C.setBackgroundColor(R.color.red_light);
        ans_D.setBackgroundColor(R.color.red_light);

        Button clickedButon = (Button) v;
        if(clickedButon.getId() == R.id.submit_btn){
            if(selectedAnswer.equals(Quizz3_Art.correctAnswers[currentQuestionIndex])){
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