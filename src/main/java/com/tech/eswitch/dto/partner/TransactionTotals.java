package com.tech.eswitch.dto.partner;

public class TransactionTotals {
    private Integer count;
    private Double totalTransactionsAmount = 0.0;
    private Double totalForPartner;
    private String partnerCode;
    private Integer partnerActualAmount;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotalTransactionsAmount() {
        return totalTransactionsAmount;
    }

    public void setTotalTransactionsAmount(Double totalTransactionsAmount) {
        this.totalTransactionsAmount = totalTransactionsAmount;
    }

    public Double getTotalForPartner() {
        return (0.2 * this.totalTransactionsAmount);
    }

    public void setTotalForPartner(Double totalForPartner) {
        this.totalForPartner = totalForPartner;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getPartnerActualAmount() {
        return (int)Math.ceil(getTotalForPartner());
    }

    public void setPartnerActualAmount(Integer partnerActualAmount) {
        this.partnerActualAmount = partnerActualAmount;
    }
}
