package com.tech.eswitch.dto;

import java.io.Serializable;

public class TransactionResponseValidation implements Serializable {
    private String ResultCode;
    private String ResultDesc;
    private String ThirdPartyTransID;

    public TransactionResponseValidation(String resultCode, String resultDesc) {
        ResultCode = resultCode;
        ResultDesc = resultDesc;
    }

    public TransactionResponseValidation(String resultCode, String resultDesc, String thirdPartyTransID) {
        ResultCode = resultCode;
        ResultDesc = resultDesc;
        ThirdPartyTransID = thirdPartyTransID;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }

    public String getResultDesc() {
        return ResultDesc;
    }

    public void setResultDesc(String resultDesc) {
        ResultDesc = resultDesc;
    }

    public String getThirdPartyTransID() {
        return ThirdPartyTransID;
    }

    public void setThirdPartyTransID(String thirdPartyTransID) {
        ThirdPartyTransID = thirdPartyTransID;
    }

}
