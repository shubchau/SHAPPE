package com.shappe.shappe;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.shappe.shappe.Model.QuestionLibrary1;

import org.w3c.dom.Text;

import java.util.Random;

public class depq1 extends AppCompatActivity {

    private QuestionLibrary1 mQuestionLibrary= new QuestionLibrary1();

    TextView Score,Question;

    private String mAnswer;
    private int mScore= 0;
    private int mQuestionsLength =mQuestionLibrary.mQuestions.length;
    Button btnTrue,btnFalse;
    int i=0;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depq1);



        Score = (TextView) findViewById(R.id.Score);
        Question = (TextView) findViewById(R.id.question);


        btnTrue = (Button) findViewById(R.id.btnTrue);
        btnFalse = (Button) findViewById(R.id.btnFalse);

        Score.setText("No. of trues recorded:" + " " + mScore);

            r = new Random();
            updateQuestion(r.nextInt(mQuestionsLength));

            btnTrue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (btnTrue.getText() == mAnswer) {
                        mScore = mScore + 1;
                        Score.setText("No. of trues recorded:" + " " + mScore);
                    }
                    updateQuestion(r.nextInt(mQuestionsLength));

                    i++;
                    if (i == 10) {
                        Intent dep = new Intent(depq1.this, resultdep.class);
                        startActivity(dep);

                    }

                }
            });

            btnFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (btnFalse.getText() == mAnswer) {
                        mScore = mScore + 1;
                        Score.setText("No. of trues recorded:" + " " + mScore);

                    }
                    updateQuestion(r.nextInt(mQuestionsLength));
                    i++;
                    if (i == 10) {
                        Intent dep = new Intent(depq1.this, resultdep.class);
                        startActivity(dep);

                    }

                }
            });

        }




    private void updateQuestion(int num)
    {
        Question.setText(mQuestionLibrary.getQuestion(num));
        btnTrue.setText(mQuestionLibrary.getChoice1(num));
        btnFalse.setText(mQuestionLibrary.getChoice2(num));

        mAnswer=mQuestionLibrary.getCorrectAnswer(num);

    }



}
