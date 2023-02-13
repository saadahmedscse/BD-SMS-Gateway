/*
 * Copyright 2018-2023 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saadahmedev.bdsmsgateway;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.saadahmedev.bdsmsgateway.api.ApiCall;
import com.saadahmedev.bdsmsgateway.api.RetrofitInstance;
import com.saadahmedev.bdsmsgateway.interfaces.OnSmsSendListener;
import com.saadahmedev.bdsmsgateway.utils.Constants;

public class SSLWireless {

    private static SSLWireless instance = null;
    private static JsonObject body;

    public static SSLWireless getInstance() {
        if (instance == null) instance = new SSLWireless();
        body = new JsonObject();
        return instance;
    }

    public SSLWireless setApiToken(String apiToken) {
        body.addProperty("api_token", apiToken);
        return this;
    }

    public SSLWireless setSID(String sid) {
        body.addProperty("sid", sid);
        return this;
    }

    public SSLWireless setPhone(@NonNull String phone) {
        if (phone.startsWith("+88")) phone = phone.substring(1);
        else if (phone.startsWith("01")) phone = "88" + phone;

        body.addProperty("msisdn", phone);
        return this;
    }

    public SSLWireless setMessage(String message) {
        body.addProperty("sms", message);
        return this;
    }

    public SSLWireless setCustomMessageId(String messageId) {
        body.addProperty("csms_id", messageId);
        return this;
    }

    public void send(@NonNull OnSmsSendListener listener) {
        ApiCall.enqueue(
                RetrofitInstance.getInstance(Constants.SSL_WIRELESS_BASE_URL).sendSmsWirelessOtp(body),
                listener,
                data -> {
                    if (data.getStatus().equals("SUCCESS")) {
                        listener.onSuccess();
                    } else listener.onFailed(data.getErrorMessage());
                }
        );
    }
}
