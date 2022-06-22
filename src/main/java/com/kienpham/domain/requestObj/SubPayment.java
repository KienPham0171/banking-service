package com.kienpham.domain.requestObj;

import lombok.ToString;

@ToString
public class SubPayment {
    private long targetAccountId;
    private double amount;
    private String remark;

    public SubPayment(long targetAccountId, double amount, String remark) {
        this.targetAccountId = targetAccountId;
        this.amount = amount;
        this.remark = remark;
    }

    public SubPayment() {
    }

    public long getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(long targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
