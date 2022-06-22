package com.kienpham.domain.requestObj;



public class BankBranchReq {
    private long bankId;
    private String branchId;
    private String branchName;
    private String branchAddress;

    public BankBranchReq() {
    }

    public BankBranchReq(long bankId, String branchId, String branchName, String branchAddress) {
        this.bankId = bankId;
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
