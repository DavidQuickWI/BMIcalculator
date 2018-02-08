package com.example.dquic.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    protected EditText in_weight;
    protected EditText in_height;
    protected Button in_btn;
    protected TextView out_results;
    protected RadioButton in_imperial;
    protected RadioButton in_metric;
    int unitConversion = 703;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in_btn = (Button)findViewById(R.id.button);
        in_btn.setOnClickListener(this);
        in_weight = (EditText) findViewById(R.id.weight);
        in_height = (EditText)findViewById(R.id.height);
        out_results = (TextView)findViewById(R.id.output);
        in_imperial = (RadioButton)findViewById(R.id.imperial);
        in_metric = (RadioButton)findViewById(R.id.metric);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.imperial:
                if (checked) {
                    unitConversion = 703;
                    in_height.setHint("Enter height in inches");
                    in_weight.setHint("Enter weight in pounds");
                }
                break;
            case R.id.metric:
                if (checked) {
                    unitConversion = 1;
                    in_height.setHint("Enter height in meters");
                    in_weight.setHint("Enter weight in kilograms");
                }
                break;
        }
    }

    @Override
    public void onClick(View view){
        String weight = in_weight.getText().toString();
        String height = in_height.getText().toString();
        double bmi = ( Double.parseDouble(weight)  / Math.pow(Double.parseDouble(height), 2) ) * unitConversion;
        String results = "" + bmi;
        out_results.setText(results);
    }
}
