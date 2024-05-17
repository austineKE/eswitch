package com.tech.eswitch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.eswitch.utils.Properties;

public class AccountBalanceRequest {
    @JsonProperty("CommandID")
    private String commandID= Properties.getCommandId();;
    @JsonProperty("PartyA")
    private String partyA=Properties.getPartyA();;
    @JsonProperty("IdentifierType")
    private String identifierType;
    @JsonProperty("Remarks")
    private String remarks= Properties.getRemarks();;
    @JsonProperty("Initiator")
    private String initiator= Properties.getInitiator();;
    @JsonProperty("SecurityCredential")
    private String securityCredential= Properties.getSecurityCredential();;
    @JsonProperty("QueueTimeoutURL")
    private String queueTimeOutUrl= Properties.getQueueTimeOutURL();;
    @JsonProperty("ResultURL")
    private String resultUrl= Properties.getResultURL();;

    public String getCommandID() {
        return commandID;
    }

    public void setCommandID(String commandID) {
        this.commandID = commandID;
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

    public String getQueueTimeOut() {
        return queueTimeOutUrl;
    }

    public void setQueueTimeOut(String queueTimeOutUrl) {
        this.queueTimeOutUrl = queueTimeOutUrl;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }
}
