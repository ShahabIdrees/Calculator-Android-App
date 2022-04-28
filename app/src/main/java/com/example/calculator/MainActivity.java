package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected double operand1 = 0;
    protected double operand2 = 0;
    protected double result = 0;
    protected char operator;
    Boolean is_OPerator_Clicked = false;
    Boolean is_Dot_Clicked = false;
    Boolean is_Equal_Clicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_c;
        Button button_dot;
        Button button_equal;
        TextView textView;
        Button[] buttonArray = new Button[10];
        buttonArray[0] = findViewById(R.id.button17);
        buttonArray[1] = findViewById(R.id.button18);
        buttonArray[2] = findViewById(R.id.button19);
        buttonArray[3] = findViewById(R.id.button13);
        buttonArray[4] = findViewById(R.id.button14);
        buttonArray[5] = findViewById(R.id.button15);
        buttonArray[6] = findViewById(R.id.button9);
        buttonArray[7] = findViewById(R.id.button10);
        buttonArray[8] = findViewById(R.id.button11);
        buttonArray[9] = findViewById(R.id.button22);
        button_c = findViewById(R.id.button21);
        button_dot = findViewById(R.id.button23);
        button_equal = findViewById(R.id.button25);
        Button[] operatorArray = new Button[4];
        operatorArray[0] = findViewById(R.id.button20);
        operatorArray[1] = findViewById(R.id.button24);
        operatorArray[2] = findViewById(R.id.button12);
        operatorArray[3] = findViewById(R.id.button16);

        textView = findViewById(R.id.textView2);
        for (Button item:buttonArray
             ) {
            custumOnClick(item, textView);
        }
        for (Button item:operatorArray
        ) {
            operatorOnClick(item, textView);
        }
        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_Equal_Clicked = false;
                is_OPerator_Clicked = false;
                is_Dot_Clicked = false;
                textView.setText(null);
                textView.setHint("0");
            }
        });
        button_dot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!is_Dot_Clicked){
                    is_Dot_Clicked = true;
                    getValueofButton(button_dot,textView);
                }

            }
        });
        button_equal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!is_Equal_Clicked){
                    is_Equal_Clicked = true;
                    operand2 = Double.parseDouble(textView.getText().toString());
                    result = calculateResult(operand1,operand2,operator);
                    textView.setText(Double.toString(result));


                    }
                    //result = calculateResult(operand1,operand2,operator);

                }

        });
    }
    public void custumOnClick(Button button, TextView textView) {
        button.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {
                if(!is_Equal_Clicked){

                }
                getValueofButton(button, textView);
            }
        });
    }
    public void operatorOnClick(Button button, TextView textView){


            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(!is_OPerator_Clicked){
                        is_OPerator_Clicked = true;
                        is_Dot_Clicked = false;
                        is_Equal_Clicked = false;
                        operand1 = Double.parseDouble(textView.getText().toString());
                        getOperator(button, textView);
                    }


                }
            });
        }


    public void getOperator(Button button, TextView textView){
        operator = button.getText().charAt(0);
        textView.setText(null);
        

    }
    public void getValueofButton(Button button, TextView textView){
        textView.append(button.getText());
    }
    public double calculateResult(double op1, double op2, char oper){
        if(oper == '/'){
            return op1/op2;
        }
        else if(oper == 'X'){
            return op1*op2;
        }
        else if(oper == '+'){
            return op1+op2;
        }
        else if(oper == '-'){
            return op1-op2;
        }
        return -1;
    }
}