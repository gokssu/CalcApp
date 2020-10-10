package com.example.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resulttext ;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }
    String runningNumber = "";
    String leftValue = "";
    String rightValue = "";
    Operation currentOperation;
    int result = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button onebutton =(Button)findViewById(R.id.button1);
        Button twobutton =(Button)findViewById(R.id.button2);
        Button threebutton =(Button)findViewById(R.id.button3);
        Button fourbutton =(Button)findViewById(R.id.button4);
        Button fivebutton =(Button)findViewById(R.id.button5);
        Button sixbutton =(Button)findViewById(R.id.button6);
        Button sevenbutton =(Button)findViewById(R.id.button7);
        Button eightbutton =(Button)findViewById(R.id.button8);
        Button ninebutton =(Button)findViewById(R.id.button9);
        Button zerobutton =(Button)findViewById(R.id.button0);
        Button clear =(Button)findViewById(R.id.clearbutton);

        ImageButton calcbutton = (ImageButton)findViewById(R.id.equalButton);
        ImageButton addbutton = (ImageButton)findViewById(R.id.plusbutton);
        ImageButton subtractbutton = (ImageButton)findViewById(R.id.minusbutton);
        ImageButton productbutton = (ImageButton)findViewById(R.id.multiplybutton);
        ImageButton dividingbutton = (ImageButton)findViewById(R.id.dividebutton);

        resulttext = (TextView)findViewById(R.id.EntnumText);

        resulttext.setText("0");
        onebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);
            }
        });
        twobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });
        threebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });
        fourbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });
        fivebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });
        sixbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });
        sevenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });
        eightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });
        ninebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });
        zerobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftValue = "";
                rightValue = "";
                result =0;
                runningNumber= "";
                currentOperation =null;
                resulttext.setText("0");
            }
        });
        calcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);


            }
        });
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);
            }
        });
        subtractbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);

            }
        });
        productbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);
            }
        });
        dividingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);
            }
        });
    }
    void  processOperation(Operation opt){
        if (currentOperation != null){
            if(runningNumber != ""){
                rightValue = runningNumber;
                runningNumber ="";
                switch (currentOperation){
                    case ADD:
                         result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                         break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                }

                leftValue = String.valueOf(result);
                resulttext.setText(leftValue);
            }
        }
        else{
            leftValue = runningNumber;
            runningNumber ="";
        }
         currentOperation = opt;
    }
    void numberPressed (int number) {
        runningNumber += String.valueOf(number);
        resulttext.setText(runningNumber);
    }
}