package com.example.tipcalculator20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

/**
 * The Main Activity for the application
 * @author Randi L.
 * @version 2.2
 */
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
    DecimalFormat df = new DecimalFormat("###.##"); //The formatting for the output of the calculations
    Calculation calculate = new Calculation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM); //follow system dark mode settings to update color palette
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

    /**
     * When Calculate button is clicked, take in user input from
     * editText, button group, and spinner to perform percentage math
     * calculation and display results accordingly in text view components.
     * @param view
     */
    @SuppressLint("WrongConstant")
    public void onButtonClick(View view) {
        double totalBill;
        double totalTip = 0.0;
        double tipPerPerson = 0.0;
        int numPeople = partyNum.getSelectedItemPosition() + 1; //spinner index + 1 for math calculations
        double goodTip = 0.15;
        double greatTip = 0.2;
        double amazingTip = 0.25;

        /**
         * In case user enters no amount in edit text field, catch thrown exception and
         * give error message for invalid number entry. Else, perform percentage calculations
         * and display results.
         */
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

            totalGroup.setVisibility(View.INVISIBLE); //Incase user goes from group to individual tip, hide all result text views
            if (numPeople > 1) { //If party is more than one, display group tip along with individual tip
                tipPerPerson = calculate.groupTip(numPeople, totalTip);
                totalGroup.setVisibility(View.VISIBLE);
            }
        } catch(Exception ex) {
            Toast.makeText(this, "Enter Valid Number", 6).show(); //Show toast error message for invalid input
        } finally {
            totalIndv.setVisibility(View.VISIBLE);
            totalIndv.setText("Total Tip: $" + df.format(totalTip));
            totalGroup.setText("Tip Per Person: $" + df.format(tipPerPerson));
        }
    }
}