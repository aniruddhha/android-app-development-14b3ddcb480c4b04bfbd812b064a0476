package com.aniruddha.kudalkar.appdevsession.week3;

import android.telephony.SmsManager;

public class SmsHelper {

    private final SmsManager manager;

    public SmsHelper(
            SmsManager manager
    ) {
        this.manager = manager;
    }

    public void sendImpMsg(ImpMsg msg) {
        manager.sendTextMessage(
                msg.getNum(),
                null,
                msg.getMsg(),
                null,
                null
        );
    }
}
