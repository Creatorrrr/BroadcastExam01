package com.example.kosta.broadcastexam01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        String number = null;
        String message = null;

        if(bundle != null) {
            Object[] pdus = (Object[])bundle.get("pdus");
            String format = bundle.getString("format");

            for(int i = 0 ; i < pdus.length ; i++) {
                SmsMessage msg = SmsMessage.createFromPdu((byte[])pdus[i], format);
                number = msg.getOriginatingAddress();
                message = msg.getMessageBody();
            }

            Intent outIntent = new Intent(context, MainActivity.class);
            outIntent.putExtra("phone", number);
            outIntent.putExtra("message", message);
            outIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(outIntent);

        }
    }
}
