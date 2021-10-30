package com.aniruddha.kudalkar.appdevsession.week3.media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.aniruddha.kudalkar.appdevsession.R;

import java.io.File;
import java.io.IOException;

// https://github.com/aniruddhha

//https://stackoverflow.com/questions/41072643/android-studio-build-avd-unknown-error
public class MediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        video();
    }

    private void audio() {
        final MediaPlayer player = MediaPlayer.create(this, R.raw.sm);
//        final MediaPlayer.create(this, Uri.fromFile(new File("/path to your file")));

        findViewById(R.id.btPl).setOnClickListener(v -> {
            player.start();
        });

        findViewById(R.id.btSt).setOnClickListener(v -> {
            player.stop();
            player.release();
        });
    }

    private void video() {

        String path = "android.resource://" + getPackageName() + "/" + R.raw.vv;
        VideoView vv = findViewById(R.id.videoView);
        vv.setMediaController(new MediaController(this));
        vv.setVideoPath(path);
        vv.setSoundEffectsEnabled(true);
        findViewById(R.id.btPl).setOnClickListener( v -> {
            vv.start();
        });

        findViewById(R.id.btSt).setOnClickListener( v -> {
            vv.pause();
        });
    }
}