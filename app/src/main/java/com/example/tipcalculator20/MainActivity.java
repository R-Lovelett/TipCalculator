package com.example.tipcalculator20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

        billTotal = findViewById(R.id.inputTotal);
        button15 = findViewById(R.id.radioButton15);
        button20 = findViewById(R.id.radioButton20);
        button25 = findViewById(R.id.radioButton25);
        groupButtons = findViewById(R.id.radioGroup);
        partyNum = findViewById(R.id.spinner);
        calcButton = findViewById(R.id.calcButton);
        totalIndv = findViewById(R.id.totalTipIndv);
        totalGroup = findViewById(R.id.totalTipGroup);
    }

    /**
     * Takes in user input from editText, button group, and spinner to
     * perform percentage math calculation and display results accordingly in text view components.
     * @param view App view
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
            hideKeyboard();
            totalIndv.setVisibility(View.VISIBLE);
            totalIndv.setText("Total Tip: $" + df.format(totalTip));
            totalGroup.setText("Tip Per Person: $" + df.format(tipPerPerson));
        }
    }

    /**
     * Forces the screen keyboard to hide on button-click
     * Source: www.geeksforgeeks.org/how-to-programmatically-hide-android-soft-keyboard/
     */
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}