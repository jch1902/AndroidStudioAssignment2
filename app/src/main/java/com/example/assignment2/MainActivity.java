/*
CSE41246 - Android Java Fundamentals
Winter 2019
Assignment #2
Jasper Hoong
 */
package com.example.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int min = 1;
    private int max = 10;

    //Widgets
    private EditText minEditText = null;
    private EditText maxEditText = null;
    private TextView results = null;
    private Button generate = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set the default numbers
        setDefaultMinMax();
       //Initialize
        this.minEditText = (EditText) findViewById(R.id.editMinimum);
        this.maxEditText = (EditText) findViewById(R.id.editMaximum);
        this.results = findViewById(R.id.result);
        this.generate = (Button) findViewById(R.id.button);
        //Generate
        if(this.generate != null){ //prevents crash
            this.generate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fetchValuesFromFields();
                    generateRandomNumber();

                }

            });
        }



    }
    private void setDefaultMinMax(){
        /*String minStr = Integer.toString(min);
        String maxStr = Integer.toString(max);
        this.minEditText.setText(minStr);
        this.maxEditText.setText(maxStr);
        */
    }
    private void fetchValuesFromFields(){
        //Get the numbers from the text boxes
        this.min =  Integer.parseInt(this.minEditText.getText().toString());
        this.max = Integer.parseInt(this.maxEditText.getText().toString());
    }
    private void generateRandomNumber(){
        //Get the random number
        int randomNumber = getRandomInt(min,max);
        String randomString = Integer.toString(randomNumber);
        results.setText(randomString);
    }
    private int getRandomInt(int mini, int maxi){
       //Generate the random number
        Random randomNumber = new Random();
        return randomNumber.nextInt(maxi) + mini;
    }
}
