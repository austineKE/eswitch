package com.tech.eswitch.dto.b2c;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationResult {
    @JsonProperty("ResultCode")
    private String resultCode;
    @JsonProperty("ResultDesc")
    private String resultDesc;

    // Constructor
    public ValidationResult(String resultCode, String resultDesc) {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }

    // Getters and setters
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

    // toString() method to print object details
    @Override
    public String toString() {
        return "ValidationResult{" +
                "resultCode=" + resultCode +
                ", resultDesc='" + resultDesc + '\'' +
                '}';
    }
}
