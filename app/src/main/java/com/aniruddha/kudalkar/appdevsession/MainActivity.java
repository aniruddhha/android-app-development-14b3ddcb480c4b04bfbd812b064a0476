package com.aniruddha.kudalkar.appdevsession;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btAdd).setOnClickListener(v -> {
            Log.i("@ani", "Button Clicked");

            EditText etNum1 = findViewById(R.id.etNum1);
            EditText etNum2 = findViewById(R.id.etNum2);
            TextView txtRes = findViewById(R.id.txtRes);

            int num1 = Integer.parseInt(etNum1.getText().toString());
            int num2 =  Integer.parseInt(etNum2.getText().toString());

            txtRes.setText(String.valueOf(num1 + num2));

        }); // java8 lambda
    }
}