package com.example.counterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class App3_UnitConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_app3_unit_converter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText valueET = findViewById(R.id.btnValue);
        Button btnConvert = findViewById(R.id.btnConvert);
        TextView textAnswer = findViewById(R.id.textAnswer);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Converting EditText into String
                String answer= valueET.getText().toString();

                // Converting String to double
                double inputValue = Double.parseDouble(answer);

                double poundsValue = convertValue(inputValue);
                textAnswer.setText(""+poundsValue);
            }
        });
    }

    private double convertValue(double Value) {
        // 1 kilo = 2.20462 pounds
        return Value * 2.20462;

    }
}