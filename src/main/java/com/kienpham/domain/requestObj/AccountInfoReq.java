package com.kienpham.domain.requestObj;

public class AccountInfoReq {
    private long id;
    private String accountId;
    private String accountAddress;
    private String accountName;
    private String accountPhone;
    private String accountType;
    private long bankInfoId;
    private long bankBranchId;

    public AccountInfoReq() {
    }

    public AccountInfoReq(String accountId, String accountAddress, String accountName, String accountPhone,
                          String accountType, long bankInfoId, long bankBranchId) {
        this.accountId = accountId;
        this.accountAddress = accountAddress;
        this.accountName = accountName;
        this.accountPhone = accountPhone;
        this.accountType = accountType;
        this.bankInfoId = bankInfoId;
        this.bankBranchId = bankBranchId;
    }

    public AccountInfoReq(long id, String accountId, String accountAddress, String accountName, String accountPhone, String accountType, long bankInfoId, long bankBranchId) {
        this.id = id;
        this.accountId = accountId;
        this.accountAddress = accountAddress;
        this.accountName = accountName;
        this.accountPhone = accountPhone;
        this.accountType = accountType;
        this.bankInfoId = bankInfoId;
        this.bankBranchId = bankBranchId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getBankInfoId() {
        return bankInfoId;
    }

    public void setBankInfoId(long bankInfoId) {
        this.bankInfoId = bankInfoId;
    }

    public long getBankBranchId() {
        return bankBranchId;
    }

    public void setBankBranchId(long bankBranchId) {
        this.bankBranchId = bankBranchId;
    }
}
