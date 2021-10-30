package com.aniruddha.kudalkar.appdevsession.week3.camera;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.aniruddha.kudalkar.appdevsession.BuildConfig;
import com.aniruddha.kudalkar.appdevsession.R;
import com.aniruddha.kudalkar.appdevsession.week1.MainActivity;

import java.io.File;


// aniruddha.kudalkar@gmail.com
// +919607352625

public class CameraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        final File file = new File(
                getExternalFilesDir(""), "img.png"
        );

        ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Uri uri = FileProvider.getUriForFile(
                            CameraActivity.this,
                            BuildConfig.APPLICATION_ID + ".provider",
                            file
                    );

                    ImageView img = findViewById(R.id.imageView);
                    img.setImageURI(uri);
                }
        );

        findViewById(R.id.btCp).setOnClickListener(v -> {
            capturePhoto(startActivityForResult, file);
        });
    }

    private void capturePhoto(ActivityResultLauncher<Intent> startActivityForResult, File file) {

        Uri uri = FileProvider.getUriForFile(
                CameraActivity.this,
                BuildConfig.APPLICATION_ID + ".provider",
                file
        );

        final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult.launch(intent);
    }
}