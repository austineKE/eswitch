package com.tech.eswitch.dto.sendSuccess;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("ResultType")
    private int resultType;
    @JsonProperty("ResultCode")
    private int resultCode;
    @JsonProperty("ResultDesc")
    private String resultDesc;
    @JsonProperty("OriginatorConversationID")
    private String originatorConversationID;
    @JsonProperty("ConversationID")
    private String conversationID;
    @JsonProperty("TransactionID")
    private String transactionID;
    @JsonProperty("ResultParameters")
    private ResultParameters resultParameters;
    @JsonProperty("ReferenceData")
    private ReferenceData referenceData;

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getOriginatorConversationID() {
        return originatorConversationID;
    }

    public void setOriginatorConversationID(String originatorConversationID) {
        this.originatorConversationID = originatorConversationID;
    }

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public ResultParameters getResultParameters() {
        return resultParameters;
    }

    public void setResultParameters(ResultParameters resultParameters) {
        this.resultParameters = resultParameters;
    }

    public ReferenceData getReferenceData() {
        return referenceData;
    }

    public void setReferenceData(ReferenceData referenceData) {
        this.referenceData = referenceData;
    }
}
