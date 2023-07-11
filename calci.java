package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btnone,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    Button btnAdd,btnsub,btnmul,btndiv;
    Button btnClear,btnEquals,btnDot;
    EditText txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnone=(Button) findViewById(R.id.btn_1);
        btnone.setOnClickListener(this);
        btn2=(Button) findViewById(R.id.btn_2);
        btn2.setOnClickListener(this);
        btn3=(Button) findViewById(R.id.btn_3);
        btn3.setOnClickListener(this);
        btn4=(Button) findViewById(R.id.btn_4);
        btn4.setOnClickListener(this);
        btn5=(Button) findViewById(R.id.btn_5);
        btn5.setOnClickListener(this);
        btn6=(Button) findViewById(R.id.btn_6);
        btn6.setOnClickListener(this);
        btn7=(Button) findViewById(R.id.btn_7);
        btn7.setOnClickListener(this);
        btn8=(Button) findViewById(R.id.btn_8);
        btn8.setOnClickListener(this);
        btn9=(Button) findViewById(R.id.btn_9);
        btn9.setOnClickListener(this);
        btn0=(Button) findViewById(R.id.btn_0);
        btn0.setOnClickListener(this);

        btnAdd=(Button) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);
        btnsub=(Button) findViewById(R.id.btn_minus);
        btnsub.setOnClickListener(this);
        btnmul=(Button) findViewById(R.id.btn_mul);
        btnmul.setOnClickListener(this);
        btndiv=(Button)
                findViewById(R.id.btn_div);
        btndiv.setOnClickListener(this);
        btnEquals=(Button) findViewById(R.id.btn_equals);
        btnEquals.setOnClickListener(this);
        btnClear=(Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);
        txtResult=(EditText) findViewById(R.id.Edit_txt);
        txtResult.setText("");

    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnone))
            txtResult.append("1");
        if(v.equals(btn2))
            txtResult.append("2");
        if(v.equals(btn3))
            txtResult.append("3");
        if(v.equals(btn4))
            txtResult.append("4");
        if(v.equals(btn5))
            txtResult.append("5");
        if(v.equals(btn6))
            txtResult.append("6");
        if(v.equals(btn7))
            txtResult.append("7");
        if(v.equals(btn8))
            txtResult.append("8");
        if(v.equals(btn9))
            txtResult.append("9");
        if(v.equals(btn0))
            txtResult.append("0");

        if(v.equals(btnAdd))
            txtResult.append("+");
        if(v.equals(btnsub))
            txtResult.append("-");
        if(v.equals(btnmul))
            txtResult.append("*");
        if(v.equals(btndiv))
            txtResult.append("/");

        if(v.equals(btnClear))
            txtResult.setText("");

        if(v.equals(btnEquals))
        {             try {
            String data = txtResult.getText().toString();
            if (data.contains("/")) {
                divide(data);
            }
            else if (data.contains("*"))
            {
                multiplication(data);
            }
            else if (data.contains("+"))
            {
                addition(data);
            }
            else if (data.contains("-"))
            {
                subtraction(data);
            }
        }catch(Exception e) {
            displayinalidmessage("invalid operator");
        }

        }
    }

    private void displayinalidmessage(String mes) {

        Toast.makeText(getBaseContext(),mes,Toast.LENGTH_LONG).show();
    }
    private void subtraction(String data) {
        String[] operands = data.split("	-");
        if(operands.length==2) {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 - operand2;
            txtResult.setText(String.valueOf(result));
        }
        else
        {
            displayinalidmessage("invalid input");
        }

    }
    private void addition(String data) {
        String[] operands = data.split(Pattern.quote("+"));
        if(operands.length==2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 + operand2;
            txtResult.setText(String.valueOf(result));
        }
        else
        {
            displayinalidmessage("invalid input");
        }

    }
    private void multiplication(String data) {
        String[] operands = data.split(Pattern.quote("*"));
        if(operands.length==2)
        {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 * operand2;
            txtResult.setText(String.valueOf(result));
        }
        else
        {
            displayinalidmessage("invalid input");
        }

    }
    private void divide(String data) {
        String[] operands = data.split("	/");
        if(operands.length==2) {
            double operand1 = Double.parseDouble(operands[0]);
            double operand2 = Double.parseDouble(operands[1]);
            double result = operand1 / operand2;
            txtResult.setText(String.valueOf(result));
        }
        else
        {
            displayinalidmessage("invalid input");
        }
    }
}
