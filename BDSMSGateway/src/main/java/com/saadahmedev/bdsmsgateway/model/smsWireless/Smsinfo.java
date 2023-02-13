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

package com.saadahmedev.bdsmsgateway.model.smsWireless;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Smsinfo {

    @SerializedName("sms_status")
    @Expose
    private String smsStatus;
    @SerializedName("status_message")
    @Expose
    private String statusMessage;
    @SerializedName("msisdn")
    @Expose
    private String msisdn;
    @SerializedName("sms_type")
    @Expose
    private String smsType;
    @SerializedName("sms_body")
    @Expose
    private String smsBody;
    @SerializedName("csms_id")
    @Expose
    private String csmsId;
    @SerializedName("reference_id")
    @Expose
    private String referenceId;

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getSmsBody() {
        return smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    public String getCsmsId() {
        return csmsId;
    }

    public void setCsmsId(String csmsId) {
        this.csmsId = csmsId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

}