package com.example.cunvert;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int pos = 0;
    double lastValue = 0;
    private Button button;
    private TextView textView2;
    private TextView textView3;
    private EditText editText2;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);   //finds button id from XML file, each component in xml is known as view
        editText2 = findViewById(R.id.editText2);
        textView3 = findViewById(R.id.textView3);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(
                    AdapterView<?> parent, View view, int position, long id) {
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

//            String s=spinner.toString();
//            int kg= Integer.parseInt(s);
//            double pound=2.205*kg;
//            textView3.setText("Value in pounds is: "+pound);
                if (editText2.getText().toString().trim().length() > 0) {
                    String textValue = editText2.getText().toString();
                    lastValue = Double.parseDouble(textValue);
                    double grams, farenhite, feet, m, km, miles;
                    int days;

                    if (pos == 1) {
                        grams = lastValue * 1000;
                        textView3.setText(String.format("%.4f",grams) + " Grams");
                    } else if (pos == 0) {
                        farenhite = (lastValue * 9 / 5) + 32;
                        textView3.setText(farenhite + "°F");
                    } else if (pos == 2) {
                        days = (int)lastValue * 365;
                        textView3.setText(days + " days");
                    } else if (pos == 3) {
                        feet = lastValue / 30.48;
                        textView3.setText(String.format("%.4f",feet) + " feet");

                    } else if (pos == 4) {
                        m = lastValue / 3.6;
                        textView3.setText(String.format("%.4f",m) + " m/s");
                    } else if (pos == 5) {
                        km = lastValue * 3.6;
                        textView3.setText(String.format("%.4f",km) + " km/h");
                    } else if (pos == 6) {
                        miles = lastValue / 1.609;
                        textView3.setText(String.format("%.4f",miles) + " miles");
                    } else {
                        textView3.setText("Please enter value");

                    }

                }
            }
        });


    }
}
