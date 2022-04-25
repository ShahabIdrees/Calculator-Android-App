package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected double operand1 = 0;
    protected double operand2 = 0;
    protected double result = 0;
    Boolean dot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* Button button1;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        Button button7;
        Button button8;
        Button button9;
        Button button0;
        Button button_dot;
        Button button_c;
        Button button_plus;
        Button button_minus;
        Button button_divide;
        Button button_multiply;*/
        Button button_c;
        TextView textView;
        Button[] buttonArray = new Button[11];
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
        buttonArray[10] = findViewById(R.id.button23);
        button_c = findViewById(R.id.button21);

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
                textView.setText(null);
            }
        });

    }
    public void custumOnClick(Button button, TextView textView) {
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getValueofButton(button, textView);
            }
        });
    }
    public void operatorOnClick(Button button, TextView textView){

        CharSequence op1 = textView.getText();
        char[] oper1 = new char[op1.length()];
        for(int i = 0; i < op1.length(); i++){
            if(op1.charAt(i) == '.')
            oper1[i] = op1.charAt(i);
        }
        for(int i = 0; i < oper1.length; i++){
            if(oper1[i] == '.'){
                continue;
            }
            operand1 = ((int)oper1[i])  * 10 ^ (oper1.length - i);
        }

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                
                getValueofButton(button, textView);
            }
        });
    }
    public void getValueofButton(Button button, TextView textView){
        textView.append(" " + " " + button.getText());
    }
}