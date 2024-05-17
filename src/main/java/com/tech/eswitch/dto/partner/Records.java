package com.tech.eswitch.dto.partner;

/**
 * m-pesa receipt
 * bonga amount
 * amount sent to customer
 * amount deducted
 * transaction status
 */
public class Records {
    private String receipt;
    private String bongaAmount;
    private String customerAmount;
    private String amountDeducted;
    private String status;

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getBongaAmount() {
        return bongaAmount;
    }

    public void setBongaAmount(String bongaAmount) {
        this.bongaAmount = bongaAmount;
    }

    public String getCustomerAmount() {
        return customerAmount;
    }

    public void setCustomerAmount(String customerAmount) {
        this.customerAmount = customerAmount;
    }

    public String getAmountDeducted() {
        return amountDeducted;
    }

    public void setAmountDeducted(String amountDeducted) {
        this.amountDeducted = amountDeducted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
