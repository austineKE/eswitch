package com.tech.eswitch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SendMoneyTransactions {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer initialTransactionId;
    private Integer resultType;
    private Integer resultCode;
    private String resultDesc;
    private String originatorConversationID;
    private String conversationID;
    private String transactionID;
    private String transactionAmount;
    private String transactionReceipt;
    private String recipientIsRegisteredCustomer;
    private String chargesPaidAccountAvailableFunds;
    private String receiverPartyPublicName;
    private String transactionCompletedDateTime;
    private String utilityAccountAvailableFunds;
    private String workingAccountAvailableFunds;
    private String queueTimeoutURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInitialTransactionId() {
        return initialTransactionId;
    }

    public void setInitialTransactionId(Integer initialTransactionId) {
        this.initialTransactionId = initialTransactionId;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
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

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionReceipt() {
        return transactionReceipt;
    }

    public void setTransactionReceipt(String transactionReceipt) {
        this.transactionReceipt = transactionReceipt;
    }

    public String getRecipientIsRegisteredCustomer() {
        return recipientIsRegisteredCustomer;
    }

    public void setRecipientIsRegisteredCustomer(String recipientIsRegisteredCustomer) {
        this.recipientIsRegisteredCustomer = recipientIsRegisteredCustomer;
    }

    public String getChargesPaidAccountAvailableFunds() {
        return chargesPaidAccountAvailableFunds;
    }

    public void setChargesPaidAccountAvailableFunds(String chargesPaidAccountAvailableFunds) {
        this.chargesPaidAccountAvailableFunds = chargesPaidAccountAvailableFunds;
    }

    public String getReceiverPartyPublicName() {
        return receiverPartyPublicName;
    }

    public void setReceiverPartyPublicName(String receiverPartyPublicName) {
        this.receiverPartyPublicName = receiverPartyPublicName;
    }

    public String getTransactionCompletedDateTime() {
        return transactionCompletedDateTime;
    }

    public void setTransactionCompletedDateTime(String transactionCompletedDateTime) {
        this.transactionCompletedDateTime = transactionCompletedDateTime;
    }

    public String getUtilityAccountAvailableFunds() {
        return utilityAccountAvailableFunds;
    }

    public void setUtilityAccountAvailableFunds(String utilityAccountAvailableFunds) {
        this.utilityAccountAvailableFunds = utilityAccountAvailableFunds;
    }

    public String getWorkingAccountAvailableFunds() {
        return workingAccountAvailableFunds;
    }

    public void setWorkingAccountAvailableFunds(String workingAccountAvailableFunds) {
        this.workingAccountAvailableFunds = workingAccountAvailableFunds;
    }

    public String getQueueTimeoutURL() {
        return queueTimeoutURL;
    }

    public void setQueueTimeoutURL(String queueTimeoutURL) {
        this.queueTimeoutURL = queueTimeoutURL;
    }
}
