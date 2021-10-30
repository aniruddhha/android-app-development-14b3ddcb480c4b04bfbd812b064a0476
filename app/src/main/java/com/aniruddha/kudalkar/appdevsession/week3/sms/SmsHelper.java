package com.aniruddha.kudalkar.appdevsession.week3.sms;

import android.telephony.SmsManager;

import com.aniruddha.kudalkar.appdevsession.week3.sms.ImpMsg;

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
