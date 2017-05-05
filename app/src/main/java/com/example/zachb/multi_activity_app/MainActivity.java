package com.example.zachb.multi_activity_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/* Zachary Betters
   CIS 282
   4/25/17
   Multi Activity App
*/

public class MainActivity extends AppCompatActivity {

    public double num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    public void sendMessage() {

        EditText numOne = (EditText) findViewById(R.id.numOne);
        EditText numTwo = (EditText) findViewById(R.id.numTwo);

        if (numOne.getText().toString().matches("") || //if no data is entered, show error message
                numTwo.getText().toString().matches("")) {
            Toast.makeText(MainActivity.this, "No data to pass!", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent(this, ResultActivity.class);

            intent.putExtra("Num One", numOne.getText().toString());
            intent.putExtra("Num Two", numTwo.getText().toString());

            startActivity(intent); //begin new activity
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { //handle rotation
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
