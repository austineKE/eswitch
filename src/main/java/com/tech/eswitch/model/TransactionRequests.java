package com.tech.eswitch.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String transactionType;
    private String transID;
    private String transTime;
    private String transAmount;
    private String businessShortCode;
    private String billRefNumber;
    private String invoiceNumber;
    private String orgAccountBalance;
    private String thirdPartyTransID;
    private String msisdn;
    private String firstName;
    private String middleName;
    private String lastName;
    private int processed;
    private String amountAwarded;
    private int sendMoneyRetryCount;
    private int sendMoneySuccessful;
    private int transactionReversed;
    private int transactionCompleted;
    private String sendMoneyErrorCode;
    private String sendMoneyRequestId;
    private String sendMoneyErrorMessage;
    private String companyAmount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(String transAmount) {
        this.transAmount = transAmount;
    }

    public String getBusinessShortCode() {
        return businessShortCode;
    }

    public void setBusinessShortCode(String businessShortCode) {
        this.businessShortCode = businessShortCode;
    }

    public String getBillRefNumber() {
        return billRefNumber;
    }

    public void setBillRefNumber(String billRefNumber) {
        this.billRefNumber = billRefNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getOrgAccountBalance() {
        return orgAccountBalance;
    }

    public void setOrgAccountBalance(String orgAccountBalance) {
        this.orgAccountBalance = orgAccountBalance;
    }

    public String getThirdPartyTransID() {
        return thirdPartyTransID;
    }

    public void setThirdPartyTransID(String thirdPartyTransID) {
        this.thirdPartyTransID = thirdPartyTransID;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }

    public String getAmountAwarded() {
        return amountAwarded;
    }

    public void setAmountAwarded(String amountAwarded) {
        this.amountAwarded = amountAwarded;
    }

    public int getSendMoneyRetryCount() {
        return sendMoneyRetryCount;
    }

    public void setSendMoneyRetryCount(int sendMoneyRetryCount) {
        this.sendMoneyRetryCount = sendMoneyRetryCount;
    }

    public int getSendMoneySuccessful() {
        return sendMoneySuccessful;
    }

    public void setSendMoneySuccessful(int sendMoneySuccessful) {
        this.sendMoneySuccessful = sendMoneySuccessful;
    }

    public int getTransactionReversed() {
        return transactionReversed;
    }

    public void setTransactionReversed(int transactionReversed) {
        this.transactionReversed = transactionReversed;
    }

    public int getTransactionCompleted() {
        return transactionCompleted;
    }

    public void setTransactionCompleted(int transactionCompleted) {
        this.transactionCompleted = transactionCompleted;
    }

    public String getSendMoneyErrorCode() {
        return sendMoneyErrorCode;
    }

    public void setSendMoneyErrorCode(String sendMoneyErrorCode) {
        this.sendMoneyErrorCode = sendMoneyErrorCode;
    }

    public String getSendMoneyRequestId() {
        return sendMoneyRequestId;
    }

    public void setSendMoneyRequestId(String sendMoneyRequestId) {
        this.sendMoneyRequestId = sendMoneyRequestId;
    }

    public String getSendMoneyErrorMessage() {
        return sendMoneyErrorMessage;
    }

    public void setSendMoneyErrorMessage(String sendMoneyErrorMessage) {
        this.sendMoneyErrorMessage = sendMoneyErrorMessage;
    }

    public String getCompanyAmount() {
        return companyAmount;
    }

    public void setCompanyAmount(String companyAmount) {
        this.companyAmount = companyAmount;
    }
}
