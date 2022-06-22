package com.kienpham.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account_info")
public class AccountInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "account_address")
    private String accountAddress;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "account_phone")
    private String accountPhone;
    @Column(name = "account_type")
    private String accountType;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_info_id")
    private BankInfo bankInfo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_branch_id")
    private BankBranch bankBranch;

    @OneToMany(mappedBy = "accountInfo",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Approver> listApprovers;

    public AccountInfo(String accountId, String accountAddress,
                       String accountName, String accountPhone,
                       String accountType, BankInfo bankInfo,
                       BankBranch bankBranch, List<Approver> listApprovers) {
        this.accountId = accountId;
        this.accountAddress = accountAddress;
        this.accountName = accountName;
        this.accountPhone = accountPhone;
        this.accountType = accountType;
        this.bankInfo = bankInfo;
        this.bankBranch = bankBranch;
        this.listApprovers = listApprovers;
    }

    public AccountInfo(long id, String accountId, String accountAddress, String accountName, String accountPhone,
                       String accountType, BankInfo bankInfo, BankBranch bankBranch) {
        this.id = id;
        this.accountId = accountId;
        this.accountAddress = accountAddress;
        this.accountName = accountName;
        this.accountPhone = accountPhone;
        this.accountType = accountType;
        this.bankInfo = bankInfo;
        this.bankBranch = bankBranch;
    }

    public AccountInfo(String accountId, String accountAddress, String accountName,
                       String accountPhone, String accountType, BankInfo bankInfo, BankBranch bankBranch) {
        this.accountId = accountId;
        this.accountAddress = accountAddress;
        this.accountName = accountName;
        this.accountPhone = accountPhone;
        this.accountType = accountType;
        this.bankInfo = bankInfo;
        this.bankBranch = bankBranch;
    }

    public AccountInfo(long id, String accountId, String accountAddress, String accountName, String accountPhone, String accountType, BankInfo bankInfo, BankBranch bankBranch, List<Approver> listApprovers) {
        this.id = id;
        this.accountId = accountId;
        this.accountAddress = accountAddress;
        this.accountName = accountName;
        this.accountPhone = accountPhone;
        this.accountType = accountType;
        this.bankInfo = bankInfo;
        this.bankBranch = bankBranch;
        this.listApprovers = listApprovers;
    }

    public AccountInfo() {
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

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public List<Approver> getListApprovers() {
        return listApprovers;
    }

    public void setListApprovers(List<Approver> listApprovers) {
        this.listApprovers = listApprovers;
    }
}
