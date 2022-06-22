package com.kienpham.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table(name = "bank_branch")
public class BankBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "branch_id")
    private String branchId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bank_info_id")
    private BankInfo bankInfo;
    @Column(name="branch_name")
    private String branchName;
    @Column(name = "branch_address")
    private String branchAddress;

    @OneToMany(mappedBy = "bankBranch",fetch = FetchType.LAZY)
    private List<AccountInfo> listAccounts;

    public BankBranch(String branchId, BankInfo bankId, String branchName, String branchAddress) {
        this.branchId = branchId;
        this.bankInfo = bankId;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
    }

    public BankBranch() {
    }

    public BankBranch(long id, String branchId, BankInfo bankInfo, String branchName, String branchAddress, List<AccountInfo> listAccounts) {
        this.id = id;
        this.branchId = branchId;
        this.bankInfo = bankInfo;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.listAccounts = listAccounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
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

    public List<AccountInfo> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(List<AccountInfo> listAccounts) {
        this.listAccounts = listAccounts;
    }
}
