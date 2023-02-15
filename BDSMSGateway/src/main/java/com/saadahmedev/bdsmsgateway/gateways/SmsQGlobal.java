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

package com.saadahmedev.bdsmsgateway.gateways;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.saadahmedev.bdsmsgateway.api.ApiCall;
import com.saadahmedev.bdsmsgateway.api.RetrofitInstance;
import com.saadahmedev.bdsmsgateway.interfaces.OnSmsSendListener;
import com.saadahmedev.bdsmsgateway.utils.Constants;

public class SmsQGlobal {

    private static SmsQGlobal instance = null;
    private static JsonObject body;
    private boolean isUnicode = true;

    public static SmsQGlobal getInstance() {
        if (instance == null) instance = new SmsQGlobal();
        body = new JsonObject();
        return instance;
    }

    public SmsQGlobal setClientId(String clientId) {
        body.addProperty("ClientId", clientId);
        return this;
    }

    public SmsQGlobal setApiKey(String apiKey) {
        body.addProperty("ApiKey", apiKey);
        return this;
    }

    public SmsQGlobal setSenderId(String senderId) {
        body.addProperty("SenderId", senderId);
        return this;
    }

    public SmsQGlobal isUnicode(boolean isUnicode) {
        this.isUnicode = isUnicode;
        return this;
    }

    public SmsQGlobal setPhone(@NonNull String phone) {
        if (phone.startsWith("+88")) phone = phone.substring(4);
        else if (phone.startsWith("01")) phone = phone.substring(1);
        else if (phone.startsWith("88")) phone = phone.substring(3);

        body.addProperty("MobileNumbers", phone);
        return this;
    }

    public SmsQGlobal setMessage(String message) {
        body.addProperty("Message", message);
        return this;
    }

    public void send(OnSmsSendListener listener) {
        body.addProperty("Is_Unicode", String.valueOf(isUnicode));

        ApiCall.enqueue(RetrofitInstance.getInstance(Constants.SMSQ_GLOBAL_BASE_URL).sendSmsqGlobalMessage(body), listener, data -> {
            if (data.getErrorCode() != 0) {
                listener.onFailed(data.getErrorDescription());
            } else {
                if (data.getData().get(0).getMessageErrorCode() != 0) {
                    listener.onFailed(data.getData().get(0).getMessageErrorDescription());
                } else listener.onSuccess();
            }
        });
    }
}
