package com.example.user.nouracalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton plusbtn;
    RadioButton minusbtn;
    RadioButton multbtn;
    RadioButton divbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusbtn =this.findViewById(R.id.plusid);
        minusbtn =this.findViewById(R.id.minusid);
        multbtn =this.findViewById(R.id.multid);
        divbtn =this.findViewById(R.id.divid);

        final EditText int1txt =this.findViewById(R.id.int1id);
        final EditText int2txt =this.findViewById(R.id.int2id);
        final TextView resulttxt =this.findViewById(R.id.resultid);

        final Double[] result = {0.0};

        //added comment 1
        int x=0;

        Button calcbtn=this.findViewById(R.id.calcid);


        calcbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final int a=Integer.parseInt(int1txt.getText().toString());
                final int b=Integer.parseInt(int2txt.getText().toString());
                int operation=getOperationNum();
                result[0] =getResult(a,b,operation);
                if(operation==0 || operation==1 || operation==2)
                    resulttxt.setText(result[0].toString());
                else if(operation==3)
                {
                    double quotient=Math.floor(result[0]);
                    double remainder=(result[0] -quotient)*b;
                    resulttxt.setText(quotient+"R"+remainder);
                }
                else
                    resulttxt.setText("please choose an operator");
            }
        });
    }

    private int getOperationNum()
    {
        if(plusbtn.isChecked())
            return 0;
        else if(minusbtn.isChecked())
            return 1;
        else if(multbtn.isChecked())
            return 2;
        else if (divbtn.isChecked())
            return 3;
        else
            return -1;
    }

    private double getResult(double a,double b, int operation)
    {
        double result=0.0;
        switch (operation)
        {
            case 0:
                result= a+b;
                break;
            case 1:
                result= a-b;
                break;
            case 2:
                result= a*b;
                break;
            case 3:
                result= a/b;
                break;
        }
        return result;
    }
}
