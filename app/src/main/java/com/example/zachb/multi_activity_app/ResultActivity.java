package com.example.zachb.multi_activity_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public double num1, num2, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Button btnAdd = (Button) findViewById(R.id.btnBack);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goBack();
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        TextView result = (TextView) findViewById(R.id.txtResult);

        if (bundle != null) {

            double num1 = Double.parseDouble(bundle.getString("Num One"));
            double num2 = Double.parseDouble(bundle.getString("Num Two"));

            try{
                sum = num1 + num2;
                result.setText("Result = " + Double.toString(sum));
            }
            catch(Exception e) {
                result.setText("Error calculating result!");
            }
        }
    }

    public void goBack() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble("Num 1", num1);
        outState.putDouble("Num 2", num2);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        num1 = savedInstanceState.getDouble("Num 1");
        num2 = savedInstanceState.getDouble("Num 2");
    }
}
