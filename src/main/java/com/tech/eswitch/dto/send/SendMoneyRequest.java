package com.tech.eswitch.dto.send;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.eswitch.utils.Properties;

public class SendMoneyRequest {
    @JsonProperty("OriginatorConversationID")
    private String originatorConversationID;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("PartyB")
    private String partyB;


    @JsonProperty("InitiatorName")
    private String initiatorName = Properties.getInitiator();
    @JsonProperty("SecurityCredential")
    private String securityCredential = Properties.getSecurityCredential();
    @JsonProperty("CommandID")
    private String commandID = Properties.getCommandId();
    @JsonProperty("PartyA")
    private String partyA=Properties.getPartyA();
    @JsonProperty("Remarks")
    private String remarks = Properties.getRemarks();
    @JsonProperty("QueueTimeOutURL")
    private String queueTimeOutURL = Properties.getQueueTimeOutURL();
    @JsonProperty("ResultURL")
    private String resultURL = Properties.getResultURL();
    @JsonProperty("Occasion")
    private String occasion=Properties.getOccasion();

    public String getOriginatorConversationID() {
        return originatorConversationID;
    }

    public void setOriginatorConversationID(String originatorConversationID) {
        this.originatorConversationID = originatorConversationID;
    }

    public String getInitiatorName() {
        return initiatorName;
    }

    public void setInitiatorName(String initiatorName) {
        this.initiatorName = initiatorName;
    }

    public String getSecurityCredential() {
        return securityCredential;
    }

    public void setSecurityCredential(String securityCredential) {
        this.securityCredential = securityCredential;
    }

    public String getCommandID() {
        return commandID;
    }

    public void setCommandID(String commandID) {
        this.commandID = commandID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getQueueTimeOutURL() {
        return queueTimeOutURL;
    }

    public void setQueueTimeOutURL(String queueTimeOutURL) {
        this.queueTimeOutURL = queueTimeOutURL;
    }

    public String getResultURL() {
        return resultURL;
    }

    public void setResultURL(String resultURL) {
        this.resultURL = resultURL;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }
}
