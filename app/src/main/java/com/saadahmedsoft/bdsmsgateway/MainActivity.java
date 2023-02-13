package com.saadahmedsoft.bdsmsgateway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.saadahmedev.bdsmsgateway.gateways.SSLWireless;
import com.saadahmedev.bdsmsgateway.gateways.SmsQGlobal;
import com.saadahmedev.bdsmsgateway.interfaces.OnSmsSendListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SmsQGlobal.getInstance()
                .setClientId("196c9aa3-7cce-4c3d-b366-2cd5aef5272e")
                .setApiKey("lYWiNQkhyMR4KwEYkn6jbLcEPeDdW9YHCPgjrNpI7/g=")
                .setSenderId("TopSeba")
                .isUnicode(true)
                .setPhone("+8801794784643")
                .setMessage("Hello")
                .send(new OnSmsSendListener() {
                    @Override
                    public void onLoading() {
                        Log.d("sms_debug_tag", "onLoading: ");
                    }

                    @Override
                    public void onSuccess() {
                        Log.d("sms_debug_tag", "onSuccess: ");
                    }

                    @Override
                    public void onFailed(String message) {
                        Log.d("sms_debug_tag", "onFailed: " + message);
                    }
                });
    }
}