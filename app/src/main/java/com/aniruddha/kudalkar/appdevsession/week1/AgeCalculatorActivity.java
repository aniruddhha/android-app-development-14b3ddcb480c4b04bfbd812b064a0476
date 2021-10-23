package com.aniruddha.kudalkar.appdevsession.week1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.aniruddha.kudalkar.appdevsession.R;

import java.util.Calendar;

public class AgeCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        final TextView txt = findViewById(R.id.txAg);
        CalendarView cal = findViewById(R.id.calBd);
        cal.setOnDateChangeListener((view, year, month, dayOfMonth) -> {

                    /*val diff = currentMillis - selectedMillis
                    val seconds = diff / 1000
                    val minutes = seconds / 60
                    val hours = minutes / 60
                    val days = hours / 24
                    val years = days / 365 */

            // todays milliseconds - milliseconds of selected date
            long todaysMillis = System.currentTimeMillis();

            Calendar calendar = Calendar.getInstance();
            calendar.set(year, month, dayOfMonth);

            long selectedMillis = calendar.getTimeInMillis();

            long diff = todaysMillis - selectedMillis;

            // 1 millis = 1000
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            long years = days / 365;

            txt.setText("Age "+ years + " years, Days "+days);
        });

        final Button btn = findViewById(R.id.btStkBk);
        btn.setOnClickListener(v -> {

//            Intent intent = new Intent( // providing your intention to the system
//                    this, // source
//                    StockBookActivity.class // target
//            );

            /*Intent intent = new Intent(
                    Intent.ACTION_DIAL // action
            );*/

            Intent intent = new Intent(
                    Intent.ACTION_VIEW // action,

            );
            intent.setData(Uri.parse("https://google.com"));

            // explicit intent: the intent where you specify source and target explicitly
            // implicit intent the intent where you pass action, and source and target are missing

            startActivity(intent);
        });
    }
}