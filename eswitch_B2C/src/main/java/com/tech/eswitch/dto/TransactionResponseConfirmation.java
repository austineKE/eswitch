package com.tech.eswitch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TransactionResponseConfirmation implements Serializable {

    @JsonProperty("ResultCode")
    private String resultCode;
    @JsonProperty("ResultDesc")
    private String resultDesc;

    public TransactionResponseConfirmation(String resultCode, String resultDesc) {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
