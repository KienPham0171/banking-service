package com.kienpham.domain.requestObj;

import lombok.ToString;

import java.util.List;

@ToString
public class PaymentReq {
    private long budgetAccountId;
    private List<SubPayment> listSubPayments;

    public PaymentReq(long budgetAccountId, List<SubPayment> listSubPayments) {
        this.budgetAccountId = budgetAccountId;
        this.listSubPayments = listSubPayments;
    }

    public PaymentReq() {
    }

    public long getBudgetAccountId() {
        return budgetAccountId;
    }

    public void setBudgetAccountId(long budgetAccountId) {
        this.budgetAccountId = budgetAccountId;
    }

    public List<SubPayment> getListSubPayments() {
        return listSubPayments;
    }

    public void setListSubPayments(List<SubPayment> listSubPayments) {
        this.listSubPayments = listSubPayments;
    }

}
