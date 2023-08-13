package com.codewithharry.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView inputText,outputText;

    private String input,output,newOutput;

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonAdd,buttonMul,buttonDiv,buttonSub,buttonEqual,buttonClear;

    private boolean dotClicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);

        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button3=findViewById(R.id.btn3);
        button4=findViewById(R.id.btn4);
        button5=findViewById(R.id.btn5);
        button6=findViewById(R.id.btn6);
        button7=findViewById(R.id.btn7);
        button8=findViewById(R.id.btn8);
        button9=findViewById(R.id.btn9);
        button0=findViewById(R.id.btn0);
        buttonAdd=findViewById(R.id.addition_btn);
        buttonSub=findViewById(R.id.subtraction_btn);
        buttonMul=findViewById(R.id.multiplybtn);
        buttonDiv=findViewById(R.id.division_btn);
        buttonEqual=findViewById(R.id.equal_btn);
        buttonClear=findViewById(R.id.clear_btn);

    }

    public void onButtonClicked(View view)
    {
        Button button = (Button) view;
        String data = button.getText().toString();

        switch(data){
            case "CE":
                input="";
                output="";
                outputText.setText("");
                dotClicked=false;
                break;
            case "=":
                solve();
                dotClicked=false;
                break;
            case ".":
                if(dotClicked==false)
                {
                    input+='.';
                    dotClicked=true;
                }
                break;
            case "DEL":
                int len = input.length();
                if(len>0)
                {
                    String deletedString = input.substring(0,len-1);
                    input=deletedString;
                }
                break;
            default:
                if(input==null){
                    input="";
                }
                if((data.equals("+") || data.equals("/") || data.equals("-")) || data.equals("*"))
                {
                    solve();
                    dotClicked=false;
                }
                input+=data;
        }
        inputText.setText(input);

    }
    private void solve()
    {
        if(input.split("\\+").length==2)
        {
            String numbers[]=input.split("\\+");
            try{
                double d= Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newOutput=cutDecimal(output);
                outputText.setText(newOutput);
                input=d+"";

            }
            catch(Exception e)
            {
                    ;
            }
        }
        if(input.split("\\*").length==2)
        {
            String numbers[]=input.split("\\*");
            try{
                double d= Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newOutput=cutDecimal(output);
                outputText.setText(newOutput);
                input=d+"";
            }
            catch(Exception e)
            {

                    ;


            }
        }
        if(input.split("\\/").length==2)
        {
            String numbers[]=input.split("\\/");
            try{
                double d= Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newOutput=cutDecimal(output);
                outputText.setText(newOutput);
                input=d+"";
            }
            catch(Exception e)
            {
                    ;
            }
        }
        if(input.split("\\-").length==2)
        {
            String numbers[]=input.split("\\-");
            try{
                if(Double.parseDouble(numbers[0])<Double.parseDouble(numbers[1]))
                {
                    double d= Double.parseDouble(numbers[1])-Double.parseDouble(numbers[0]);
                    output=Double.toString(d);
                    newOutput=cutDecimal(output);
                    outputText.setText(newOutput);
                    input=d+"";

                }
                double d= Double.parseDouble(numbers[0])-Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                outputText.setText(output);
                input=d+"";
            }
            catch(Exception e)
            {

                    ;

            }
        }
    }

    private String cutDecimal(String number)
    {
        String n[]=number.split("\\.");
        if(n.length>1)
        {
            if(n[1].equals("0"))
            {
                number=n[0];
            }
        }
        return number;

    }


}