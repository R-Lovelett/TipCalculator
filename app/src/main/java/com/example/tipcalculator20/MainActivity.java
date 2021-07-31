package com.example.tipcalculator20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText billTotal;
    RadioButton button15;
    RadioButton button20;
    RadioButton button25;
    RadioGroup groupButtons;
    Button calcButton;
    TextView totalIndv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billTotal = (EditText) findViewById(R.id.inputTotal);
        button15 = (RadioButton) findViewById(R.id.radioButton15);
        button20 = (RadioButton) findViewById(R.id.radioButton20);
        button25 = (RadioButton) findViewById(R.id.radioButton25);
        groupButtons = (RadioGroup) findViewById(R.id.radioGroup);
        calcButton = (Button) findViewById(R.id.calcButton);
        totalIndv = (TextView) findViewById(R.id.totalTipIndv);

    }

    public void onButtonClick(View view) {
        Double totalBill;
        Double totalTip = 0.0;
        //Double tipPerPerson = 0.0;
        Double goodTip = 0.15;
        Double greatTip = 0.2;
        Double amazingTip = 0.25;

        totalBill = Double.parseDouble(billTotal.getText().toString()); //get the entered total decimal amount

        if (button15.isChecked()) {
            totalTip = totalBill * goodTip;
        }
        else if (button20.isChecked()) {
            totalTip = totalBill * greatTip;
        }
        else if(button25.isChecked()){
            totalTip = totalBill * amazingTip;
        }

        /*if(oneButton.isChecked()) {
            tipPerPerson = totalTip / 1;
        }
        else if (twoButton.isChecked()) {
            tipPerPerson = totalTip / 2;
        }
        else if(threeButton.isChecked()) {
            tipPerPerson = totalTip / 3;
        }
        else if(fourButton.isChecked()) {
            tipPerPerson = totalTip / 4;
        }*/

        totalIndv.setVisibility(View.VISIBLE);
        totalIndv.setText("Total Tip: " + totalTip.toString());
        //textViewResult2.setText("Tip Per Person: " + tipPerPerson.toString());
    }

}