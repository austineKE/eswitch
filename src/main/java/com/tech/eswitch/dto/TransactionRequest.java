package com.tech.eswitch.dto;

public class TransactionRequest {
    private String transactionType;
    private String transID;
    private String transTime;
    private String transAmount;
    private String businessShortCode;
    private String billRefNumber;
    private String invoiceNumber;
    private String orgAccountBalance;
    private String thirdPartyTransID;
    private String mSISDN;
    private String firstName;
    private String middleName;
    private String lastName;

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

    public String getmSISDN() {
        return mSISDN;
    }

    public void setmSISDN(String mSISDN) {
        this.mSISDN = mSISDN;
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
}
