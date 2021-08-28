package com.example.tipcalculator20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText billTotal;
    RadioButton button15;
    RadioButton button20;
    RadioButton button25;
    RadioGroup groupButtons;
    Spinner partyNum;
    Button calcButton;
    TextView totalIndv;
    TextView totalGroup;
    DecimalFormat df = new DecimalFormat("###.##");
    Calculation calculate = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        setContentView(R.layout.activity_main);

        billTotal = (EditText) findViewById(R.id.inputTotal);
        button15 = (RadioButton) findViewById(R.id.radioButton15);
        button20 = (RadioButton) findViewById(R.id.radioButton20);
        button25 = (RadioButton) findViewById(R.id.radioButton25);
        groupButtons = (RadioGroup) findViewById(R.id.radioGroup);
        partyNum = (Spinner) findViewById(R.id.spinner);
        calcButton = (Button) findViewById(R.id.calcButton);
        totalIndv = (TextView) findViewById(R.id.totalTipIndv);
        totalGroup = (TextView) findViewById(R.id.totalTipGroup);

    }

    @SuppressLint("WrongConstant")
    public void onButtonClick(View view) {
        double totalBill;
        double totalTip = 0.0;
        int numPeople = partyNum.getSelectedItemPosition() + 1;
        double tipPerPerson = 0.0;
        double goodTip = 0.15;
        double greatTip = 0.2;
        double amazingTip = 0.25;

        try{
            totalBill = Double.parseDouble(billTotal.getText().toString()); //get the entered total decimal amount

            if (button15.isChecked()) {
                totalTip = calculate.individualTip(totalBill, goodTip);
            }
            else if (button20.isChecked()) {
                totalTip = calculate.individualTip(totalBill, greatTip);
            }
            else if(button25.isChecked()){
                totalTip = calculate.individualTip(totalBill, amazingTip);
            }

            totalGroup.setVisibility(View.INVISIBLE);
            if (numPeople > 1) {
                tipPerPerson = calculate.groupTip(numPeople, totalTip);
                totalGroup.setVisibility(View.VISIBLE);
            }
        } catch(Exception ex) {
            Toast.makeText(this, "Enter Valid Number", 6).show();
        } finally {
            totalIndv.setVisibility(View.VISIBLE);
            totalIndv.setText("Total Tip: $" + df.format(totalTip));
            totalGroup.setText("Tip Per Person: $" + df.format(tipPerPerson));
        }
    }
}