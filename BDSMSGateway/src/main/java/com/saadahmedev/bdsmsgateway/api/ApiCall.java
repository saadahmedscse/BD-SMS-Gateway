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

package com.saadahmedev.bdsmsgateway.api;

import androidx.annotation.NonNull;

import com.saadahmedev.bdsmsgateway.interfaces.OnSmsSendListener;
import com.saadahmedev.bdsmsgateway.utils.ConstructErrorBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class hase been made by Saad Ahmed on 15-Sep-2022
 * The reason behind making this class to simplify api calls
 */

public class ApiCall {

    /**
     * Interface to get successful response
     * @param <T> is response model data
     */

    public interface OnResponseGet<T> {
        void onSuccessful(T data);
    }

    /**
     * The function to call api and get response
     * @param call will be called
     * @param onResponseGetListener to post the body after successful response
     * @param listener to post loading and failed state for sending sms
     * @param <T> is response model data
     */

    public static <T> void enqueue (Call<T> call, OnSmsSendListener listener, OnResponseGet<T> onResponseGetListener) {
        listener.onLoading();

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.code() == 200) {
                    assert response.body() != null;
                    onResponseGetListener.onSuccessful(response.body());
                } else {
                    if (response.errorBody() != null) {
                        listener.onFailed(ConstructErrorBody.getMessage(response.errorBody()));
                    } else listener.onFailed("Unexpected Error Occurred");
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                listener.onFailed(t.getLocalizedMessage());
            }
        });
    }
}
