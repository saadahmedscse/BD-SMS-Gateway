package com.saadahmedsoft.bdsmsgateway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.saadahmedev.bdsmsgateway.SSLWireless;
import com.saadahmedev.bdsmsgateway.interfaces.OnSmsSendListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SSLWireless.getInstance()
                .setApiToken("lu3htwwy-dzadvo6i-wevhole6-gjumi1fj-trejjdar")
                .setSID("MSOBNON")
                .setPhone("+8801794784643")
                .setMessage("This is test message")
                .setCustomMessageId("sldkflskf")
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