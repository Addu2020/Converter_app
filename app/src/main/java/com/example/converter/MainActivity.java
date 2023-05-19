package com.example.converter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView2;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(MainActivity.this, "Hi! Click Listener worked", Toast.LENGTH_SHORT).show();
//                String s = editText.getText().toString();
//                double kg = Double.parseDouble(s);
//                double pound = 2.205 * kg;
//                textView2.setText("The corresponding value in Pounds is : " + pound);
//            }
//        });
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void cal(View view) {
//        Toast.makeText(MainActivity.this, "Hi! Click Listener worked", Toast.LENGTH_SHORT).show();
        StringBuffer unit = new StringBuffer();
        StringBuffer val = new StringBuffer();
        String s = editText.getText().toString();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                unit.append(s.charAt(i));
            }
            else if (Character.isAlphabetic(s.charAt(i))) {
                val.append(s.charAt(i));
            }
            else {
                Toast.makeText(this, "Error!\nPlease put only kg or pound value", Toast.LENGTH_SHORT).show();
                textView2.setText("");
//                editText.setText("");
            }
        }
//        double kg = Double.parseDouble(s);
//        double pound = 2.205 * kg;
//        DecimalFormat df = new DecimalFormat("#.####");
//        textView2.setText("The corresponding value in Pounds is : " + df.format(pound));
        if (unit.toString() == "kg" || unit.toString() == "Kg" || unit.toString() == " kg" || unit.toString() == " Kg"){
            double kg = Double.parseDouble(val.toString());
            double pound = 2.205 * kg;
            DecimalFormat df = new DecimalFormat("#.####");
            textView2.setText("The corresponding value in Pounds is : " + df.format(pound) + " pounds");
        }
        else if (unit.toString() == "pound" || unit.toString() == "Pound" || unit.toString() == " pound" || unit.toString() == " Pound") {
            double pound = Double.parseDouble(val.toString());
            double kg = pound / 2.205;
            DecimalFormat df = new DecimalFormat("#.####");
            textView2.setText("The corresponding in Kilograms is : " + df.format(kg) + " kg");
        }
//        else {
//            Toast.makeText(this, "Error!\nPlease put only kg or pound value", Toast.LENGTH_SHORT).show();
//            textView2.setText("");
//            editText.setText("");
//        }
    }
}