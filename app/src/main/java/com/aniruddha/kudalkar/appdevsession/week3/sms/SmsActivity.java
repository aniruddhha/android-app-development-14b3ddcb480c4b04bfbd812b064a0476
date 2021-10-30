package com.aniruddha.kudalkar.appdevsession.week3.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.aniruddha.kudalkar.appdevsession.R;

import java.util.ArrayList;

public class SmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        final RecyclerView rec = findViewById(R.id.recMsgs);
        final LinearLayoutManager lm = new LinearLayoutManager(this);
        rec.setLayoutManager(lm);

        rec.addItemDecoration(
                new DividerItemDecoration(this, lm.getOrientation())
        );

        final ArrayList<ImpMsg> messages = new ArrayList<>();
        messages.add(
                new ImpMsg(
                        "Police",
                        "There is a situation, Help Me",
                        "896464646"
                )
        );

        messages.add(
                new ImpMsg(
                        "Hospital",
                        "Help Me there is Blood Requirement",
                        "7953131332"
                )
        );

        messages.add(
                new ImpMsg(
                        "Home",
                        "I am needing help in my college",
                        "435678909"
                )
        );

        final SmsHelper helper = new SmsHelper(
                SmsManager.getDefault()
        );

        final MutableLiveData<ImpMsg> clicked = new MutableLiveData<ImpMsg>();
        clicked.observe(this, impMsg -> {
            Toast.makeText(this, impMsg.getNm(), Toast.LENGTH_SHORT).show();
            helper.sendImpMsg(impMsg);

        });

        SmsAdapter adapter = new SmsAdapter(
                this,
                messages,
                clicked
        );
        rec.setAdapter(adapter);
    }
}