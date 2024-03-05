package com.tech.eswitch.dto;

import java.io.Serializable;

public class TransactionResponseConfirmation implements Serializable {
    private String ResultCode;
    private String ResultDesc;

    public TransactionResponseConfirmation(String resultCode, String resultDesc) {
        ResultCode = resultCode;
        ResultDesc = resultDesc;
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
}
