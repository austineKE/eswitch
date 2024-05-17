package com.tech.eswitch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.eswitch.utils.Properties;

public class TransactionStatusRequest {
    @JsonProperty("CommandID")
    private String commandId= Properties.getCommandId();;
    @JsonProperty("PartyA")
    private String partyA= Properties.getPartyA();;
    @JsonProperty("IdentifierType")
    private String identifierType = "4";
    @JsonProperty("Remarks")
    private String remarks = Properties.getRemarks();;
    @JsonProperty("Initiator")
    private String initiator= Properties.getInitiator();;
    @JsonProperty("SecurityCredential")
    private String securityCredential= Properties.getSecurityCredential();;
    @JsonProperty("QueueTimeOutURL")
    private String queueTimeOutUrl = Properties.getQueueTimeOutURL();;
    @JsonProperty("TransactionID")
    private String transactionID;
    @JsonProperty("ResultURL")
    private String resultUrl = Properties.getResultURL();;
    @JsonProperty("OriginatorConversationID")
    private String originatorConversationId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getSecurityCredential() {
        return securityCredential;
    }

    public void setSecurityCredential(String securityCredential) {
        this.securityCredential = securityCredential;
    }

    public String getQueueTimeOutUrl() {
        return queueTimeOutUrl;
    }

    public void setQueueTimeOutUrl(String queueTimeOutUrl) {
        this.queueTimeOutUrl = queueTimeOutUrl;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public String getOriginatorConversationId() {
        return originatorConversationId;
    }

    public void setOriginatorConversationId(String originatorConversationId) {
        this.originatorConversationId = originatorConversationId;
    }
}
