package com.example.phillipdacosta.mysimplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Declare elements.

    private Button btnAdd, btnSub, btnDiv, btnMul,btnClear;
    private TextView tvresult;
    private EditText etfirst, etsecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons and connect buttons by ID
        btnAdd = (Button) findViewById(R.id.btnAddition);
        btnSub = (Button) findViewById(R.id.btnSubtract);
        btnDiv = (Button) findViewById(R.id.btnDivide);
        btnMul = (Button) findViewById(R.id.btnMultiply);
        btnClear =(Button) findViewById(R.id.btnClear);

        etfirst = (EditText) findViewById(R.id.etNumber1);
        etsecond = (EditText) findViewById(R.id.etnumber2);
        tvresult = (TextView) findViewById(R.id.tvResult);


        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        //Set cursor to start on first edit line;

        etfirst.setFocusableInTouchMode(true);
        etfirst.requestFocus();
    }

    @Override
    public void onClick(View view) {


        String num1 = etfirst.getText().toString();
        String num2 = etsecond.getText().toString();

        switch(view.getId()){
            case R.id.btnAddition:
                double addition =  (Double.parseDouble(num1) + Double.parseDouble(num2));   //add numbers
                tvresult.setText(String.valueOf("Answer: " +  addition));       //print the result
                break;
            case R.id.btnSubtract:
                double subtract = Double.parseDouble(num1) - Double.parseDouble(num2);  //subtract
                tvresult.setText(String.valueOf("Answer: " + subtract));        // print result
                break;
            case R.id.btnDivide:
                try             // if zero is entered as divisor, print this message.
                {
                    double divide = Double.parseDouble(num1) / Double.parseDouble(num2);
                    tvresult.setText(String.valueOf("Answer : " + divide));
                } catch (Exception e){
                    tvresult.setText("Can't divide by zero genius");
                }
                break;
            case R.id.btnMultiply:
                double multiply = Double.parseDouble(num1) *  Double.parseDouble(num2);
                tvresult.setText(String.valueOf("Answer : " + multiply));
                break;
            //Created clear button.
            case R.id.btnClear:
                etfirst.setText("");
                etsecond.setText("");
                break;

        }

    }
}
