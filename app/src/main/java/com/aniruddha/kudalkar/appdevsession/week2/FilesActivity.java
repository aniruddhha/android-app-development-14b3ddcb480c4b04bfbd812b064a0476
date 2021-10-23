package com.aniruddha.kudalkar.appdevsession.week2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aniruddha.kudalkar.appdevsession.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        Log.i("@ani", "Internal Storage Root Directory "+getFilesDir());
        Log.i("@ani", "External Root "+Environment.getExternalStoragePublicDirectory(""));

        findViewById(R.id.btRd).setOnClickListener(v -> {

            final boolean state = isStorageMounted();

            if(state) {
                Log.i("@ani", "You can read and write");
                try {
                    writeExternalStorage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                Log.i("@ani", "Storage Not Mounted");
            }
        });

        findViewById(R.id.btWr).setOnClickListener(v -> {
            try {
                readExternalStorage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private boolean isStorageMounted() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private void readInternal() {
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
    }

    private void writeInternal() {
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
    }

    private void writeExternalStorage() throws IOException {
        File[] extStrgs = ContextCompat.getExternalFilesDirs(this, null );
        File fl = new File(extStrgs[0], "my.txt");

        EditText et = findViewById(R.id.etDt);

        FileOutputStream fos = new FileOutputStream(fl);
        fos.write(et.getText().toString().getBytes());
        fos.close();
    }

    private void readExternalStorage() throws IOException {
        final File[] extStrgs = ContextCompat.getExternalFilesDirs(this, null );
        final File fl = new File(extStrgs[0], "my.txt");

        final TextView txt = findViewById(R.id.txtDt);

        final StringBuilder builder = new StringBuilder();
        final FileInputStream fis = new FileInputStream(fl);
        while(true) {
            int ch = fis.read();
            if(ch == -1) break;
            else builder.append((char)ch);
        }
        txt.setText(builder.toString());
     }
}