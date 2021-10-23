package com.aniruddha.kudalkar.appdevsession.week2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aniruddha.kudalkar.appdevsession.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        Log.i("@ani", "Root Directory "+getFilesDir());

        findViewById(R.id.btRd).setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput("my.txt");
                StringBuilder sb = new StringBuilder();

                while(true) {
                    int ch = fis.read();
                    if(ch == -1) break;
                    else sb.append((char)ch);
                }

                final TextView txt = findViewById(R.id.txtDt);
                txt.setText(sb.toString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        findViewById(R.id.btWr).setOnClickListener(v -> {

            final EditText et = findViewById(R.id.etDt);

            try {
                FileOutputStream fos = openFileOutput("my.txt", MODE_PRIVATE);
                fos.write(et.getText().toString().getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show();
        });
    }
}