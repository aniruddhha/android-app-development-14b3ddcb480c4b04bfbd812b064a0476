package com.aniruddha.kudalkar.appdevsession.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.CellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.aniruddha.kudalkar.appdevsession.R;

import java.util.List;

public class TelephonyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephony);

        TelephonyManager mgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        phoneState(mgr);
    }

    private void phoneState(TelephonyManager mgr) {

        final PhoneStateListener listener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String phoneNumber) {
                super.onCallStateChanged(state, phoneNumber);

                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING: {
                        Log.i("@ani", "Your Device Is Ringing");
                        break;
                    }
                    case TelephonyManager.CALL_STATE_OFFHOOK: {
                        Log.i("@ani", "Your Device Is Off Hook");
                        break;
                    }
                    case TelephonyManager.CALL_STATE_IDLE: {
                        Log.i("@ani", "Your Device Is IDLE");
                        break;
                    }
                    default: {
                        Log.i("@ani", "Invalid State");
                    }
                }
            }
        };
        mgr.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
    }

    private void softwareInfo(TelephonyManager mgr) {
        Log.i("@ani", "Software - "+mgr.getDeviceSoftwareVersion());
        Log.i("@ani", "Unique Id - "+mgr.getDeviceId());
        Log.i("@ani", "MFG - "+mgr.getManufacturerCode());
    }

    private void cellInfo(TelephonyManager mgr) {
        // Restrictions on android 10 and above
        List<CellInfo> cells =  mgr.getAllCellInfo();
        Log.i("@ani", "Found Cells "+cells.size());
        for(CellInfo cell : cells) {
            Log.i("@ani", ""+cell.toString());
        }
    }

   private void readImei(TelephonyManager mgr) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String imei = ""+System.currentTimeMillis();
            imei = mgr.getDeviceId();
        }else {
            String imei = mgr.getImei();
        }
    }
}