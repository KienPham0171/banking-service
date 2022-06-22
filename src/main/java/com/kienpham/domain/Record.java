package com.kienpham.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Record {
    private String transId;
    private String approver;
    private String transType;
    private double amount;
    private String recvAcctId;
    private String recvBankId;
    private String recvBranchId;
    private String recvBankName;
    private String recvAcctName;
    private String recvAddr;
    private String recvPhoneNo;
    private String currencyCode;
    private String remark;
    private String senderBankId;
    private String senderBranchId;
    private String senderAddr;
    private String senderAcctName;
    private String senderAcctId;

    public Record(String transId, String approver, String transType, double amount, String recvAcctId,
                  String recvBankId, String recvBranchId, String recvBankName, String recvAcctName, String recvAddr, String recvPhoneNo, String currencyCode, String remark,
                  String senderBankId, String senderBranchId, String senderAddr, String senderAcctName, String senderAcctId) {
        this.transId = transId;
        this.approver = approver;
        this.transType = transType;
        this.amount = amount;
        this.recvAcctId = recvAcctId;
        this.recvBankId = recvBankId;
        this.recvBranchId = recvBranchId;
        this.recvBankName = recvBankName;
        this.recvAcctName = recvAcctName;
        this.recvAddr = recvAddr;
        this.recvPhoneNo = recvPhoneNo;
        this.currencyCode = currencyCode;
        this.remark = remark;
        this.senderBankId = senderBankId;
        this.senderBranchId = senderBranchId;
        this.senderAddr = senderAddr;
        this.senderAcctName = senderAcctName;
        this.senderAcctId = senderAcctId;
    }

    public Record() {
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRecvAcctId() {
        return recvAcctId;
    }

    public void setRecvAcctId(String recvAcctId) {
        this.recvAcctId = recvAcctId;
    }

    public String getRecvBankId() {
        return recvBankId;
    }

    public void setRecvBankId(String recvBankId) {
        this.recvBankId = recvBankId;
    }

    public String getRecvBranchId() {
        return recvBranchId;
    }

    public void setRecvBranchId(String recvBranchId) {
        this.recvBranchId = recvBranchId;
    }

    public String getRecvBankName() {
        return recvBankName;
    }

    public void setRecvBankName(String recvBankName) {
        this.recvBankName = recvBankName;
    }

    public String getRecvAcctName() {
        return recvAcctName;
    }

    public void setRecvAcctName(String recvAcctName) {
        this.recvAcctName = recvAcctName;
    }

    public String getRecvAddr() {
        return recvAddr;
    }

    public void setRecvAddr(String recvAddr) {
        this.recvAddr = recvAddr;
    }

    public String getRecvPhoneNo() {
        return recvPhoneNo;
    }

    public void setRecvPhoneNo(String recvPhoneNo) {
        this.recvPhoneNo = recvPhoneNo;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSenderBankId() {
        return senderBankId;
    }

    public void setSenderBankId(String senderBankId) {
        this.senderBankId = senderBankId;
    }

    public String getSenderBranchId() {
        return senderBranchId;
    }

    public void setSenderBranchId(String senderBranchId) {
        this.senderBranchId = senderBranchId;
    }

    public String getSenderAddr() {
        return senderAddr;
    }

    public void setSenderAddr(String senderAddr) {
        this.senderAddr = senderAddr;
    }

    public String getSenderAcctName() {
        return senderAcctName;
    }

    public void setSenderAcctName(String senderAcctName) {
        this.senderAcctName = senderAcctName;
    }

    public String getSenderAcctId() {
        return senderAcctId;
    }

    public void setSenderAcctId(String senderAcctId) {
        this.senderAcctId = senderAcctId;
    }
}
