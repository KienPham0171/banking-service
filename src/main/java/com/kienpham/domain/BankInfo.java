package com.kienpham.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bank_info")
public class BankInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "bank_id")
    private String bankId;
    @OneToMany(mappedBy = "bankInfo",fetch = FetchType.LAZY)
    private List<BankBranch> bankBranches;

    @OneToMany(mappedBy = "bankInfo",fetch = FetchType.LAZY)
    private List<AccountInfo> listAccounts;

    public BankInfo() {
    }

    public BankInfo(long id, String bankName, String bankId, List<BankBranch> bankBranches, List<AccountInfo> listAccounts) {
        this.id = id;
        this.bankName = bankName;
        this.bankId = bankId;
        this.bankBranches = bankBranches;
        this.listAccounts = listAccounts;
    }

    public BankInfo(String bankName, String bankId) {
        this.bankName = bankName;
        this.bankId = bankId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public List<BankBranch> getBankBranches() {
        return bankBranches;
    }

    public void setBankBranches(List<BankBranch> bankBranches) {
        this.bankBranches = bankBranches;
    }

    public List<AccountInfo> getListAccounts() {
        return listAccounts;
    }

    public void setListAccounts(List<AccountInfo> listAccounts) {
        this.listAccounts = listAccounts;
    }
}
