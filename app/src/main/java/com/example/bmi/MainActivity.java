package com.example.bmi;

import static com.example.bmi.R.string.over;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight,editHeightFt,editHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        editHeightIn = findViewById(R.id.edtHeightIn);
        editHeightFt = findViewById(R.id.edtHeightFt);
        editWeight = findViewById(R.id.edtWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wt= Integer.parseInt(editWeight.getText().toString());
                int ft=Integer.parseInt(editHeightFt.getText().toString());
                int in=Integer.parseInt(editHeightIn.getText().toString());

                int totalIn = ft*12+in;

                double totalCm = totalIn*2.51;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);



                if (bmi>25)
                {
                    txtResult.setText(over);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if (bmi<18)
                {
                    txtResult.setText(R.string.underweight);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else
                {
                    txtResult.setText(R.string.normal);
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }






            }
        });


    }
}