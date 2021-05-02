package com.example.gradepredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mDisplayText;
    private Button mGradeButton;
    private EditText mEditText1;
    private EditText mEditText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText)findViewById(R.id.editTextNumber);
        mEditText2 = (EditText)findViewById(R.id.editTextNumber2);
        mDisplayText = (TextView)findViewById(R.id.displayText);
        mGradeButton = (Button)findViewById(R.id.gradeButton);
    }


    public void calculateGrade(View view) {
        if ((mEditText1.getText().toString().length() == 0) || (mEditText2.getText().toString().length() == 0)){
            Toast toast = Toast.makeText (this, "Incomplete field(s)", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        int num1 = Integer.parseInt(mEditText1.getText().toString());
        int num2 = Integer.parseInt(mEditText2.getText().toString());
        if ((num1<0) || (num1 > 100) || (num2<0) ||(num2>100))
        {
            Toast toast = Toast.makeText (this, "Invalid value(s)", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        int sum = num1+num2;
        ProgressDialog dialog = ProgressDialog.show(this, "", "Calculating...",
                true);
        dialog.show();

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                // empty??
            }

            public void onFinish() {
                dialog.dismiss();
                if (sum > 180){
                    mDisplayText.setText("S Grade");
                }
                else if (sum > 160){
                    mDisplayText.setText("A Grade");
                }
                else if (sum > 140){
                    mDisplayText.setText("B Grade");
                }
                else if (sum > 120){
                    mDisplayText.setText("C Grade");
                }
                else if (sum > 100){
                    mDisplayText.setText("D Grade");
                }
                else {
                    mDisplayText.setText("F Grade");
                }
            }
        }.start();

    }
}