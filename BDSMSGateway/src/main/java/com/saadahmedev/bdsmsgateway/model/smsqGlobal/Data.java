package com.saadahmedev.bdsmsgateway.model.smsqGlobal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("MessageErrorCode")
    @Expose
    private Integer messageErrorCode;
    @SerializedName("MessageErrorDescription")
    @Expose
    private String messageErrorDescription;
    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("MessageId")
    @Expose
    private String messageId;
    @SerializedName("Custom")
    @Expose
    private String custom;

    public Integer getMessageErrorCode() {
        return messageErrorCode;
    }

    public void setMessageErrorCode(Integer messageErrorCode) {
        this.messageErrorCode = messageErrorCode;
    }

    public String getMessageErrorDescription() {
        return messageErrorDescription;
    }

    public void setMessageErrorDescription(String messageErrorDescription) {
        this.messageErrorDescription = messageErrorDescription;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

}